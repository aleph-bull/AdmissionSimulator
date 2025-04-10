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
    
    
    //SuperStatBar:
    //GPA Bar:
    private SuperStatBar bar1; 
    //Happiness Bar:
    private SuperStatBar bar2;
    //Productivity
    boolean productive;
    
    //Student health that appears when they are avoiding the letters
    int studentHealth;
    
    
    public Student(){
        super();
        gpa = 50;
        productive = true; 
        //bar = new SuperStatBar(100, gpa, this, 10, 20, 2, Color.GREEN, Color.RED);
    }
    
    public void act()
    {
        super.act();
        
    }
    
    public int getGpa(){
        return this.gpa;
    }
    
    public void setGpa(int updatedGpa){
        this.gpa = updatedGpa;
    }
    
    public void reduceHealth(int amount){
        this.studentHealth-=amount;
    }
    
}
