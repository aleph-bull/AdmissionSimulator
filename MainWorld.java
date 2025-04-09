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
    private String cat;
    private GreenfootImage image;


    public MainWorld()
    {    
        super(1024, 800, 1); 
        background = new GreenfootImage("emptyBackground.png");
        setBackground (background);

        addObject(new Student(), 400, 200);

        relativeCountdown = 10;
        relativeMinCountdown = 500;         
        cat = "Cat.png"; 
    }

    public void act()
    {
    }

    public void spawnRelative()
    {
        if(relativeCountdown>0)
        {
            relativeCountdown --;
        }
        else
        {
            relative = new Relative(cat);
            addObject(relative, 50, 200); 
            relativeCountdown = relativeMinCountdown + Greenfoot.getRandomNumber(200); 
        }
    }

}
