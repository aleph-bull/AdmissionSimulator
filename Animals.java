import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animals here.
 * 
 * @author Daniel Wang
 * @version 1.1.1
 */
public abstract class Animals extends SuperSmoothMover
{
    GreenfootImage image = new GreenfootImage(35, 35); // temp placeholder, remove later
    double dy, dx; 
    double maxSpeed;
    double speed;
    
    public Animals () {
        image.setColor(Color.RED);
        image.fill();
        setImage(image);
        maxSpeed = 1;
        speed = maxSpeed;
        movementDirection = Greenfoot.getRandomNumber(360+1);
        updateDyDx ();
    }
    
    public void act()
    {
        moveToward(speed, getPreciseX() + dx, getPreciseY() - dy);
        hitEdge();
    }
    
    public boolean hitEdge(int rangeX, int rangeY, int xOffset, int yOffset) {
        // rangeX and rangeY is the area of the space considered to be the edge
        boolean bounced = false;
    
        if (getPreciseX() - image.getWidth()/2 <= xOffset || getPreciseX() + image.getWidth()/2 >= rangeX) {
            movementDirection = 180 - movementDirection;
            bounced = true;
        }
    
        if (getPreciseY() - image.getHeight()/2 <= yOffset || getPreciseY() + image.getHeight()/2 >= rangeY) {
            movementDirection = 360 - movementDirection;
            bounced = true;
        }
    
        if (bounced) {
            getRandomDirection(60); // add randomness
            movementDirectionInRadians = Math.toRadians(movementDirection);
            updateDyDx();
    
            // nudge inward slightly to prevent sticking
            setLocation(getPreciseX() + dx * 0.01, getPreciseY() - dy * 0.01);
        }
    
        return bounced;
    }
    
    //generic version of hit edge, gets the range of the world
    public boolean hitEdge() {
        return hitEdge(getWorld().getWidth() - 244, getWorld().getHeight(), 0, 0);
    }
    
    // changes direction completely randomly
    public void getRandomDirection (int range) {
        movementDirection += Greenfoot.getRandomNumber(range+1) - (range/2);
        if(movementDirection>=360) {
            movementDirection -= 360;
        }
        movementDirectionInRadians = (double)movementDirection * (Math.PI/180);
        updateDyDx ();
    }
    
    public void updateDyDx () {
        dx = Math.cos(movementDirectionInRadians) * 100;
        dy = Math.sin(movementDirectionInRadians) * 100;
    }
}
