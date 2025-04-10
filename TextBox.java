import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author Angela Wang
 * @version 04.09.25
 */
public class TextBox extends Actor
{
    private GreenfootImage image;
    private Font font = new Font(40);
    
    public TextBox(String text, Color color){
        image = new GreenfootImage(800, 500);
        image.setColor(color);
        image.setFont(font);
        image.drawString(text, 100, 100);
        setImage(image);
    }
    
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
