import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EffectItem here.
 * 
 * @author Angela Wang 
 * @version (a version number or a date)
 */
public class EffectItem extends SuperSmoothMover
{
    protected GreenfootImage image;
    private int newTransparency;
    
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
    
    public void fade(int fadeAmt){
        newTransparency = image.getTransparency() - fadeAmt;
        if (newTransparency >= 0){
            image.setTransparency(newTransparency);
        } else {
            getWorld().removeObject(this);
        }
    }
}
