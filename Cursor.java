import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Tracks cursor movement, used in SettingsWorld to create visual effects with buttons.
 * 
 * @author Angela Wang, Neelan Thurairajah
 * @version 04.09.25
 */
public class Cursor extends Actor
{
    private MouseInfo mouse;
    private GreenfootImage image;
    private boolean showCursor = true;
    
    public Cursor(){
        image = new GreenfootImage(50, 50);
        image.setColor(Color.GREEN);
        image.fill();
        
        if (showCursor)setImage(image);
    }
    
    /**
     * Act - do whatever the Cursor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
