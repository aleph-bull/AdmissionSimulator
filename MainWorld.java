import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hi guys!
 * Asonfin
 * hello walalalal bardilo crocodilo crocodilo
 */
public class MainWorld extends World
{

    /**
     * Construct the world!
     * 
     */
    private GreenfootImage background;
    
    public MainWorld()
    {    
        super(1024, 800, 1); 
        background = new GreenfootImage("emptyBackground.png");
        setBackground (background);
        
    }
}
