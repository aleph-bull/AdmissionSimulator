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
    public Item(Animals animal){
        isBeingUsed = false;
        user = animal;
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public Animals getUser(){
        return this.user;
    }
}
