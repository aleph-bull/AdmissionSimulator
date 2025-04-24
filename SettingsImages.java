import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Useful methods for all images in settings worlds
 * 
 * @author Stephanie Xia
 * @version 04.17.2025
 */
public class SettingsImages extends Actor
{
    //a wild class with useful methods for all images in the settings world
    private GreenfootImage image; 
    //transparent color
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage text; 

    private int maxmiumMinimumReachedGraphicCountdown; 

    /**
     * Constructor?
     */
    public SettingsImages ()
    {       
        maxmiumMinimumReachedGraphicCountdown = -1; 
    }

    public void act()
    {   
        //remove the graphic after 2 seconds
        if(maxmiumMinimumReachedGraphicCountdown > 0)
        {
            maxmiumMinimumReachedGraphicCountdown--; 
        }
        else if(maxmiumMinimumReachedGraphicCountdown == 0)
        {
            getWorld().removeObject(this); 
        }
    }

    /**
     * Scaling for the relative images
     * @param imageFile     Relative file to be scaled
     * @return void
     */
    public void setImageFile(String imageFile)
    {
        image = new GreenfootImage(imageFile); 
        image.scale(50, 60); 
        setImage(image); 
    }

    /**
     * Scaling for the university images
     * @param imageFile     University file to be scaled
     * @param isUniversity  ?
     * @return void
     */
    public void setImageFile(String imageFile, boolean isUniversity)
    {
        image = new GreenfootImage(imageFile); 
        if(isUniversity == false)
        {
            image.scale(50, 65); 
        }
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
