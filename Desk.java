import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Desk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Desk extends Item
{
    private GreenfootImage image;
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
