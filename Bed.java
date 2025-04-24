import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bed. Used when a player comes in contact with a bed, increases happiness on student class
 * 
 * @Zachary Zhao, Ethan Ren
 */
public class Bed extends FunctionalItem
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
        
        super.stopUsing();
    }
}
