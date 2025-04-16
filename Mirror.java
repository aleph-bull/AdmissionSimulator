import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mirror here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mirror extends Item
{
    private GreenfootImage image;
    public Mirror () {
        super();
        image = new GreenfootImage("mirror.png");
        setImage(image);
    }
    
    public void act()
    {
        super.act();
    }
}
