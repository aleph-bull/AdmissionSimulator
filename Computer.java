import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Computer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computer extends Item
{
    private GreenfootImage image;
    private GreenfootImage onImage;
    
    public Computer () {
        super();
        image = new GreenfootImage("pc.png");
        onImage = new GreenfootImage("pcon.png");
        setImage(image);
    }
    
    public void act()
    {
        super.act();
        
        ArrayList<Animals> animals = (ArrayList<Animals>) getObjectsInRange(100, Animals.class);
        
        if (animals.size() > 0){
            if (animals.get(0).getCurrentAction() == ActionState.WORKING) {
                setImage(onImage);
            } else {
                setImage(image);
            }
        }
    }
}
