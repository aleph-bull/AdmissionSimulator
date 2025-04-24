import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Just to make Effects look prettier (so Effect screens/EffectItems don't go outside 
 * room boundaries). Probably could have been an Image, but may have messed with SetPaintOrder?
 * 
 * @author Angela Wang
 * @version April 2025
 */
public class Walls extends Actor
{
    private GreenfootImage image;
    
    /**
     * Walls constructor - sets walls image
     */
    public Walls(){
        image = new GreenfootImage("walls.png");
        setImage(image);
    }
}
