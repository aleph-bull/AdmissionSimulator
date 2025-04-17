import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StudentStatBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StudentStatBar extends SuperStatBar
{
    boolean top;
    Student owner;
    boolean isGpa;
    public StudentStatBar(int currVal, Student theOwner, int width, int height, Color filledColor, Color missingColor, Color borderColor, int borderThickness, boolean isTop, boolean isGPA){
        super(10000, currVal*100, null, width, height, 0, filledColor, missingColor, false, borderColor, borderThickness);
        top = isTop;
        owner = theOwner;
        isGpa = isGPA;
    }
    
    public void act()
    {
        if (isGpa){update((int)owner.getGpa()*100);}
        else {update((int)owner.getHappiness()*100);}
    }
}
