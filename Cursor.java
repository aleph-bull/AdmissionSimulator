import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Tracks cursor movement, used in setting worlds to create visual effects with buttons.
 * 
 * @author Angela Wang
 * @version 04.09.25
 */
public class Cursor extends Actor
{
    private MouseInfo mouse;
    private GreenfootImage image;
    private boolean showCursor = false;
    
    /**
     * Cursor constructor - all this really does is create a cursor + set an image if you want
     * to show the cursor
     */
    public Cursor(){
        image = new GreenfootImage(50, 50);
        image.setColor(Color.GREEN);
        if (showCursor) image.fill();
        
        setImage(image);
    }
    
    /**
     * Act - get mouse information, accounting for if mouse goes out of world. This 
     * method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //get mouse information
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        //if mouse is in world bounds, set cursor to location
        if (mouse != null){
            setLocation(mouse.getX(), mouse.getY());
        }
    }
    
    /**
     * Returns ArrayList of Actors the cursor is hovering over. Code by Neelan Thurairajah
     * @return ArrayList<Actor> Hovered actors if available, null if not
     */
    public ArrayList<Actor> getHoveredActors() {
        return (ArrayList<Actor>) getObjectsAtOffset(0, 0, Actor.class);
    }
}
