import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student extends Animals
{
    /**
     * Act - do whatever the Student wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int gpa;
    private int happiness;
    private int nextItem;
    private int nextItemCD;
    private int nextItemMinCD = 1000;
    
    public Student(){
        super();
        gpa = 50;
        happiness = 100;
    }
    
    public void act()
    {
        super.act();
        // Add your action code here.
        nextItem = Greenfoot.getRandomNumber(3);
        
    }
    
    public void rest(){
        happiness ++;
    }
    
    public void work(){
        gpa ++;
        happiness --;
    }
    
    public void usePhone(){
        gpa --;
        happiness += 2;
    }
    
    public int getGPA(){
        return gpa;
    }
}
