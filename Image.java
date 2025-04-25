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

    /**
     * Customizable Image constructor
     * @param fileName  image file name
     * @param width     desired image width
     * @param height    desired image height
     */ 
    public Image(String fileName, int width, int height){
        image = new GreenfootImage(fileName);
        image.scale(width, height);
        setImage(image);
    }
    
    /**
     * Simple Image constructor with only image file name
     * @param fileName
     */
    public Image(String fileName) {
        image = new GreenfootImage(fileName);
        setImage(image);
    }

    public void act(){}

}