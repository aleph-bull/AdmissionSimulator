import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.ArrayList;

/**
 * A box that detects for collision. Used when relatives enter/exit the world.
 * 
 * @author Zachary Zhao
 */
public class CollisionBox extends Item
{
    GreenfootImage image;
    ArrayList<Animals> touchingAnimals;
    
    /**
     * Detailed CollisionBox constructor - customizable size
     * @param sizeX
     * @param sizeY
     * @param transparent   True if invisible 
     */
    public CollisionBox (int sizeX, int sizeY, boolean transparent) {
        image = new GreenfootImage(sizeX, sizeY); 
        image.setColor(Color.RED);
        image.fill();
        if(transparent)
            image.setTransparency(0);
        setImage(image);
    }
    
    /**
     * Simple CollisionBox constructor
     * @param transparent True if invisible
     */
    public CollisionBox(boolean transparent) {
        this (35, 100, transparent);
    }
    
    public void act()
    {
        getAndRemoveTouchingAnimals();
    }
    
    /**
     * Return intersecting animals
     * @return List<Animals>    Intersecting objects of Animal.class
     */
    public List<Animals> getTouchingAnimals() {
        return getIntersectingObjects(Animals.class);
    }
    
    /**
     * Retrieve and remove intersecting animals
     * @return void
     */
    public void getAndRemoveTouchingAnimals() {
        touchingAnimals = (ArrayList<Animals>)getTouchingAnimals();
        for(Animals a : touchingAnimals) {
            if(!(a instanceof Student))
                getWorld().removeObject(a);
        }
    }
}
