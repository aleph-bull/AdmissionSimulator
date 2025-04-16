import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MaxmiumValueReachedGraphic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MaximumValueReachedGraphic extends Actor
{
    /**
     * Act - do whatever the MaxmiumValueReachedGraphic wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int maxmiumReachedGraphicCountdown; 

    public MaximumValueReachedGraphic(int x, int y)
    {
        maxmiumReachedGraphicCountdown = 120; 
    }

    public void act()
    {
        if(maxmiumReachedGraphicCountdown > 0)
        {
            maxmiumReachedGraphicCountdown--; 
        }
        else
        {
            getWorld().removeObject(this); 
            maxmiumReachedGraphicCountdown = 120; 
        }
    }

}
