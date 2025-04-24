import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Yet another still Image that could have been part of Image.class
 * 
 * @author Ethan Ren
 * @version April 2025
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
