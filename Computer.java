import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Computer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computer extends Item
{
    private GreenfootImage image;
    public Computer () {
        super();
        image = new GreenfootImage("pc.png");
        setImage(image);
    }
    
    public void act()
    {
        super.act();
    }
}
