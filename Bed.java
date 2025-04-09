import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bed extends Item
{
    private GreenfootImage image;
    public Bed(){
        super();
        image = new GreenfootImage("computer.png");
       }
    
    public void act()
    {
        if (this.getUser() != null){
            if (this.getUser() instanceof Student){
            this.getUser().rest();
            }
        }
    }
}
