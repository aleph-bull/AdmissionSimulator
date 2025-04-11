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
        Animals usr = this.getUser();
        if (usr != null){
            if (usr instanceof Student){
                ((Student)usr).usePhone();
            }
        }
        super.act();
    }
}
