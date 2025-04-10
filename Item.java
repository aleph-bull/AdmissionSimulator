import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends Actor
{
    private boolean isBeingUsed;
    private Animals user;
    private int posX;
    private int posY;
    public Item(){
        isBeingUsed = false;
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public Animals getUser(){
        return this.user;
    }
    
    public void use(Animals a){
        isBeingUsed = true;
        user = a;
    }
    
    public void stopUsing(){
        isBeingUsed = false;
        user = null;
    }
}
