import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Buttons darken when the cursor hovers over them, and may do things when clicked.
 * 
 * @author Angela Wang
 * @version 04.09.25 
 */
public class Button extends Actor
{
    private GreenfootImage image, hoverImage;
    private String text;
    private Font font = new Font(40);
    private Cursor cursor;
    
    //pass the mouse to buttons to know if mouse is hovering
    public Button(Cursor cursor){
        //placeholder images
        image = new GreenfootImage(50, 50);
        image.setColor(Color.BLUE);
        image.fill();
        setImage(image);
        
        hoverImage = new GreenfootImage(50, 50);
        hoverImage.setColor(Color.RED);
        hoverImage.fill();
        
        this.cursor = cursor;
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //if the cursor is hovering over the button, change the image
        if (cursor.getHoveredActors().contains(this)){
            setImage(hoverImage);
        } else {
            setImage(image);
        }
    }
    
}
