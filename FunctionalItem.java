import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class functionalItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FunctionalItem extends Item
{
    protected GreenfootSound sound;
    
    public void stopSound(){
        sound.stop();
    }
}
