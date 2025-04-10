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
        Animals usr = this.getUser();
        if (usr != null){
            if (usr instanceof Student){
                ((Student)usr).work();
            }
        }
    }
}
