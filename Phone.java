import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Phone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Phone extends Item
{
    private GreenfootImage image;
    public Phone(){
        super();
        image  = new GreenfootImage("phone.png");
    }
    
    public void act()
    {
        if (this.getUser() != null){
            if (this.getUser() instanceof Student){
            this.getUser().usePhone();
            }
        }
    }
}
