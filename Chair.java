import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chair extends FunctionalItem
{
    private GreenfootImage image;
    public Chair () {
        super();
        image = new GreenfootImage("chair.png");
        setImage(image);
    }
    public void act()
    {
        super.act();
        Animals usr = this.getUser();
        if (usr != null){
            if (usr instanceof Student){
                ((Student)usr).work();
            }
        }
    }
}
