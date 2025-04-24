import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Honestly Desk is pretty much for decoration and could have been an Image
 * 
 * @author Ethan Ren
 * @version April 2025
 */
public class Desk extends Item
{
    private GreenfootImage image;
    /**
     * Desk constructor
     */
    public Desk () {
        super();
        image = new GreenfootImage("desk.png");
        setImage(image);
    }
    
    public void act()
    {
        super.act();
    }
}
