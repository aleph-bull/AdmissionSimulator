import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * EffectItems are mostly cool visual stuff for Effects, managed by their Effect screen 
 * (Depression/Sickness class).
 * 
 * @author Angela Wang 
 * @version April 2025
 */
public class EffectItem extends SuperSmoothMover
{
    protected GreenfootImage image;
    private int newTransparency;
    
    /**
     * EffectItem constructor
     */
    public EffectItem(){
    }
    
    /**
     * Act - do whatever the EffectItem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    /**
     * Fade by fadeAmt, should be called each act
     * @param fadeAmt   Amount to fade per act
     * @return void
     */
    public void fade(int fadeAmt){
        newTransparency = image.getTransparency() - fadeAmt;
        if (newTransparency >= 0){
            image.setTransparency(newTransparency);
        } else {
            getWorld().removeObject(this);
        }
    }
}
