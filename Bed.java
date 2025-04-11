import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bed extends Item
{
    private GreenfootImage image;
    
    public Bed(){
        super();
        image = new GreenfootImage("bed.png");
        setImage(image);
    }

    public void act()
    {
        if (user != null){
            if (user instanceof Student){
                ((Student)user).rest();
            }
        }
        super.act();
    }
    
    
    @Override
    public void stopUsing() {
        // push off the user and send them toward a random direction away from the bed
        user.setLocation(getX() + 80, getY());
        user.setDirection(0);
        user.setRandomDirection(60);
        
        System.out.println("stopped");
        super.stopUsing();
    }
}
