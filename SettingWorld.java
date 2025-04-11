import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingWorld extends World
{

    /**
     * Constructor for objects of class SettingWorld.
     * 
     */
    private SettingsArrow settingsArrow; 
    private GreenfootImage background;
    public SettingWorld()
    {    
        super(1024, 800, 1); 
        background = new GreenfootImage("Settings.png"); 
        setBackground(background); 
        settingsArrow = new SettingsArrow(); 
        addObject(settingsArrow, 100, 100); 
    }

    public void act()
    {

    }

}
