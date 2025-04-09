import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Admin here.
 * 
 * @ Daniel Wang
 * @ 1.1.1
 */
public class Admin extends Animals
{
    /**
     * Act - do whatever the Admin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int requirement;
    private boolean mood;
    private String uni;
    private int acceptanceR;
    
    
    public Admin(int requirement,int acceptanceR,boolean mood, String uni){
        this.requirement = requirement;
        this.acceptanceR = acceptanceR;
        this.mood = mood;
        this.uni = uni;
        if(!mood){
            requirement+=2;
            acceptanceR-=5;
        }
        
    }
    
    public void act()
    {
        
    }
    
    /*
    public void sendLetter(){
        
    }
    */
    
    public boolean compareStats(Student student1){
        boolean result = false;
        //Compares the university standards and the student's stats to consider if 
        //the student should be acceped or rejected
        if(student1.getGpa() >= this.requirement){
            result = true;
        }
        return result; 
    }
    
}