import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Student can farm gpa and Relatives can take over Computers
 * 
 * @author Ethan Ren, Angela Wang 
 * @version April 2025
 */
public class Computer extends Item
{
    private GreenfootImage image;
    private GreenfootImage onImage;
    
    /**
     * Computer constructor
     */
    public Computer () {
        super();
        image = new GreenfootImage("pc.png");
        onImage = new GreenfootImage("pcon.png");
        setImage(image);
    }
    
    /**
     * Act - checks for users that are working on computer and sets computer image to on 
     * if yes
     */
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
