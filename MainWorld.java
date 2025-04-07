import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
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
<<<<<<< Updated upstream
        
=======

        relativeCountdown = 10;
        relativeMinCountdown = 500; 

    }

    public void act()
    {
        spawnRelative(); 
    }

    public void spawnRelative()
    {
        if(relativeCountdown>0)
        {
            relativeCountdown --;
        }
        else
        {
            relative = new Relative();
            addObject(relative, 50, 200); 
            relativeCountdown = relativeMinCountdown + Greenfoot.getRandomNumber(200); 
        }
>>>>>>> Stashed changes
    }
}
