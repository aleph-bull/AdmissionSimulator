import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsImages here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsImages extends Actor
{
    private GreenfootImage image; 
    /**
     * Act - do whatever the SettingsImages wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SettingsImages ()
    {       
    }

    public void act()
    {

    }
    public void setImageFile(String imageFile)
    {
        image = new GreenfootImage(imageFile); 
        setImage(image); 
    }
}
