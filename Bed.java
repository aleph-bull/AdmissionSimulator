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
        Animals usr = this.getUser();
        if (usr != null){
            if (usr instanceof Student){
                ((Student)usr).rest();
            }
        }
    }
}
