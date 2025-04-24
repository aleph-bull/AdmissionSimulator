import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * FunctionalItem apparently groups the Items that actually do something? Items all have 
 * unique sound
 * 
 * @author Ethan Ren, Angela Wang
 * @version April 2025
 */
public class FunctionalItem extends Item
{
    protected GreenfootSound sound;
    
    /**
     * Called by the world when execution is stopped to stop all sfx
     */
    public void stopSound(){
        sound.stop();
    }
}
