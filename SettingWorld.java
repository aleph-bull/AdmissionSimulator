import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingWorld here.
 * 
 * @author Stephanie Xia
 */
public class SettingWorld extends World
{

    /**
     * Constructor for objects of class SettingWorld.
     * 
     */
    private Button student1Left; 
    private Button student1Right;
    private Cursor cursor;
    private GreenfootImage background;
    public SettingWorld()
    {    
        super(1024, 800, 1); 
        background = new GreenfootImage("SettingsPg1.png"); 
        setBackground(background); 
        
        //cursor object for hoverable buttons
        cursor = new Cursor();
        addObject(cursor, 0, 0);
        //button
        student1Left = new Button(cursor); 
        student1Right = new Button(cursor);
        addObject(student1Left, 700, 230); 
        addObject(student1Right, 350, 230); 
    }

    public void act()
    {

    }

}
