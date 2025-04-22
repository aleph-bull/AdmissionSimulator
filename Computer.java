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
        
        ArrayList<Student> students = (ArrayList<Student>) getObjectsInRange(100, Student.class);
        
        if (students.size() > 0){
            if (students.get(0).getActionState() == ActionState.WORKING) {
                setImage(onImage);
            } else {
                setImage(image);
            }
        }
    }
}
