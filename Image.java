import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Just a class to add misc images that don't do much to Greenfoot
 * 
 * @author Angela Wang 
 * @version 04-17-25
 */
public class Image extends SuperSmoothMover
{
    private GreenfootImage image;

    public Image(String fileName, int width, int height){
        image = new GreenfootImage(fileName);
        image.scale(width, height);
        setImage(image);
    }
    
    public Image(String fileName) {
        image = new GreenfootImage(fileName);
        setImage(image);
    }

    public void act(){
    }

}
