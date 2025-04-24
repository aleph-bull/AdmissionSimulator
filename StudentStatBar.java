import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Stat Bar for Student's GPA and Happiness, updates to reflect values
 * 
 * @author Ethan Ren
 * @version April 2025
 */
public class StudentStatBar extends SuperStatBar
{
    boolean top;
    Student owner;
    boolean isGpa;
    /**
     * Constructor 
     * @param currVal
     * @param theOwner      Student bar belongs to
     * @param width
     * @param height
     * @param filledColor
     * @param missingColor
     * @param borderColor
     * @param borderThickness
     * @param isTop         True if Student bar belongs to is in top room
     * @param isGPA         Determines if bar is for GPA or happiness
     */
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
