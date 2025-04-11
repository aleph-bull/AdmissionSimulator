import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorld extends World
{
    private GreenfootImage image;
    private GreenfootSound music;
    
    /**
     * Constructor for objects of class SettingsWorld.
     * 
     */
    public SettingsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        
        music = new GreenfootSound("settingsmusic.mp3");
        music.setVolume(30);
        music.playLoop();
        
        //testing buttons
        Cursor cursor = new Cursor();
        addObject(cursor, 0, 0);
        Button button = new Button(cursor);
        addObject(button, 512, 400);
    }
    
    public void started(){
        music.playLoop();
    }
    
    public void stopped(){
        music.pause();
    }
}
