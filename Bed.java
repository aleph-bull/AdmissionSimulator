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
    public Bed(Animals animal){
        super(animal);
        image = new GreenfootImage("bed.png");
        setImage(image);
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
