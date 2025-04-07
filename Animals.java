import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animals here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        getRandomDirection ();
    }
    
    public void act()
    {
        moveToward(speed, getPreciseX() + dx, getPreciseY() - dy);
    }
    
    public boolean hitEdge(int rangeX, int rangeY, int offset) {
        if(getPreciseX() <= offset || getPreciseX() >= rangeX)
            return true;
        return false;
    }
    
    public void getRandomDirection () {
        movementDirection += Greenfoot.getRandomNumber(180+1);
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
