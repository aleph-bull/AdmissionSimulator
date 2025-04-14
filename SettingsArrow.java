import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsArrow extends Actor
{
    private GreenfootImage image;
    private GreenfootImage imageHover;
    /**
     * Act - do whatever the SettingsArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        hoverChange(); 
    }

    public SettingsArrow(boolean isLeft)
    {
        if (isLeft == true)
        {
            image = new GreenfootImage ("SettingsArrowL.png"); 
            setImage(image);
            imageHover = new GreenfootImage("SettingsArrowHoverL.png"); 
        }
        else 
        {
            image = new GreenfootImage ("SettingsArrowR.png"); 
            setImage(image);
            imageHover = new GreenfootImage("SettingsArrowHoverR.png"); 
        }
    }

    public void hoverChange()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo(); 
        if(mouse != null && mouse.getActor() == this)
        {
            setImage(imageHover); 
        }
        else if(mouse!= null && mouse.getActor() != this)
        {
            setImage(image); 
        }
    }
}
