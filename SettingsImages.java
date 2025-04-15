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
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage text; 

    private int maxmiumMinimumReachedGraphicCountdown; 

    /**
     * Act - do whatever the SettingsImages wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SettingsImages ()
    {       
        maxmiumMinimumReachedGraphicCountdown = -1; 
    }

    public void act()
    {   
        if(maxmiumMinimumReachedGraphicCountdown > 0)
        {
            maxmiumMinimumReachedGraphicCountdown--; 
        }
        else if(maxmiumMinimumReachedGraphicCountdown == 0)
        {
            getWorld().removeObject(this); 
        }
    }

    public void setImageFile(String imageFile)
    {
        image = new GreenfootImage(imageFile); 
        setImage(image); 
    }

    public void numberDisplay(int gpa)
    {
        text = new GreenfootImage(String.valueOf(gpa), 40, Color.BLACK, transparent);
        setImage(text); 
    }

    public void maxMinDisplayText(String str)
    {
        text = new GreenfootImage(String.valueOf(str), 22, Color.BLACK, transparent);
        setImage(text); 
        maxmiumMinimumReachedGraphicCountdown = 120; 
    }
}
