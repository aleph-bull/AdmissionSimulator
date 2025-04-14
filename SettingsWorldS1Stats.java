import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorldS1Stats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorldS1Stats extends World
{

    /**
     * Constructor for objects of class SettingsWorldS1Stats.
     * 
     */

    private GreenfootImage background; 
    private Button next;
    private Button back; 
    private Cursor cursor; 
    public SettingsWorldS1Stats()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        cursor = new Cursor();
        addObject(cursor, 0, 0);

        next = new Button (cursor, false);
        addObject(next, 945, 670);
        back = new Button (cursor, true); 
        addObject(back, 100, 670); 

        background = new GreenfootImage ("SettingsPg2.png"); 
        setBackground(background); 
    }

    public void act()
    {
        backWorld(); 
    }

    public void backWorld()
    {
        if (Greenfoot.mouseClicked(back))
        {
            Greenfoot.setWorld(new SettingsWorldGeneral()); 
        }
    }
}
