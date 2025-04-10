import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Computer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computer extends Item
{
    private GreenfootImage image;
    public Computer(Animals animal){
        super(animal);
    }
    
    public void act()
    {
        if (this.getUser() != null){
            if (this.getUser() instanceof Student){
            this.getUser().work();
            }
        }
    }
}
