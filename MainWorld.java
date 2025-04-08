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

    private int relativeCountdown;
    private int relativeMinCountdown; 
    private Relative r;


    private Relative relative;


    public MainWorld()
    {    
        super(1024, 800, 1); 
        background = new GreenfootImage("emptyBackground.png");
        setBackground (background);

        relativeCountdown = 500;
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
            addObject(relative, 100, 200); 
            relativeCountdown = relativeMinCountdown + Greenfoot.getRandomNumber(200); 
        }


            relative = new Relative();
            addObject(relative, 100, 200); 
            relativeCountdown = relativeMinCountdown + Greenfoot.getRandomNumber(200); 
    }

}
