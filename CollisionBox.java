import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.ArrayList;

/**
 * A box that detects for collision
 * 
 * @author Zachary Zhao
 * @version (a version number or a date)
 */
public class CollisionBox extends Item
{
    GreenfootImage image;
    ArrayList<Animals> touchingAnimals;
    
    public CollisionBox (int sizeX, int sizeY, boolean transparent) {
        image = new GreenfootImage(sizeX, sizeY); 
        image.setColor(Color.RED);
        image.fill();
        if(transparent)
            image.setTransparency(0);
        setImage(image);
    }
    
    public CollisionBox(boolean transparent) {
        this (35, 100, transparent);
    }
    
    public void act()
    {
        getAndRemoveTouchingAnimals();
    }
    
    public List<Animals> getTouchingAnimals() {
        return getIntersectingObjects(Animals.class);
    }
    
    public void getAndRemoveTouchingAnimals() {
        touchingAnimals = (ArrayList<Animals>)getTouchingAnimals();
        for(Animals a : touchingAnimals) {
            if(!(a instanceof Student))
                getWorld().removeObject(a);
        }
    }
}
