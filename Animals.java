import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animals here.
 * 
 * @author Daniel Wang, Zachary Zhao
 * @version 1.1.1
 */
public abstract class Animals extends SuperSmoothMover
{
GreenfootImage image = new GreenfootImage(35, 35); // temp placeholder, remove later
    double dy, dx; 
    double maxSpeed;
    double speed;
    int actCount;
    int changeDirectionCooldown;
    boolean justHitX, justHitY;
    boolean isInTopRoom;    // coordinates of top room are top left (36, 168) and bottom right (736, 382) 
                            // coordinates of bottom room are top left (36, 551) and bottom right (736, 763)
    public Animals () {
        image.setColor(Color.RED);
        image.fill();
        setImage(image);
        maxSpeed = 1;
        speed = maxSpeed;
        setRandomCooldown (); // random number from 200-500
        setRandomDirection(360);
    }
    
    public void act()
    {
        moveToward(speed, getPreciseX() + dx, getPreciseY() - dy);
        if(actCount % changeDirectionCooldown == 0) {
            setRandomCooldown ();
            setRandomDirection(100);
        }
        hitEdge(new int[] {36, 168}, new int[] {736, 382});
        actCount++;
    }
    
    public boolean hitEdge(int rangeX, int rangeY, int xOffset, int yOffset) {
        // rangeX and rangeY is the area of the space considered to be the edge
        boolean bounced = false;
        
        if (getPreciseX() - image.getWidth()/2 <= xOffset || getPreciseX() + image.getWidth()/2 >= rangeX + xOffset) {
            //movementDirection = 180 - movementDirection;
            dx *= -1;
            bounced = true;
        }
    
        if (getPreciseY() - image.getHeight()/2 <= yOffset || getPreciseY() + image.getHeight()/2 >= rangeY + yOffset) {
            //movementDirection = 360 - movementDirection;
            dy *= -1;
            bounced = true;
        }
    
        if (bounced) {          
            //movementDirectionInRadians = Math.toRadians(movementDirection);
            //updateDyDx();
    
            // nudge inward slightly to prevent sticking
            setLocation(getPreciseX() + dx * 0.01, getPreciseY() - dy * 0.01);
        }
    
        return bounced;
    }
    
    //a version of hit edge that takes in 2D coordinates (x, y) instead of that range stuff
    public boolean hitEdge(int[] topLeft, int[] bottomRight) {
        if(topLeft.length != 2 || bottomRight.length != 2) {
            System.out.println("ERROR! hitEdge(int[] topLeft, int[] bottomRight) can only take in arrays with size of 2!\n(x, y) format");
            System.exit(0);
            return false;
        }
        int xOffset = topLeft[0], yOffset = topLeft[1];
        int rangeX = bottomRight[0] - xOffset, rangeY = bottomRight[1] - yOffset;
        return hitEdge(rangeX, rangeY, xOffset, yOffset);
        
    }
    
    // changes direction completely randomly
    public void setRandomDirection (int range) {
        movementDirection += Greenfoot.getRandomNumber(range+1) - (range/2);
        if(movementDirection >= 360) {
            movementDirection -= 360;
        } else if(movementDirection < 0) {
            movementDirection += 360;
        }
        movementDirectionInRadians = (double)movementDirection * (Math.PI/180);
        updateDyDx ();
    }
    
    public void setRandomCooldown () {
        changeDirectionCooldown = Greenfoot.getRandomNumber(1001) + 500; // random number from 500-1000
    }
    
    public void updateDyDx () {
        dx = Math.cos(movementDirectionInRadians) * 100;
        dy = Math.sin(movementDirectionInRadians) * 100;
    }
}
