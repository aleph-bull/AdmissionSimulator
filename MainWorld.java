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
    Student studentTop;
    Bed bedTop;
    Chair chairTop;
    Computer computerTop;
    Desk deskTop;
    Mirror mirrorTop;

    public MainWorld()
    {    
        super(1024, 800, 1); 
        setPaintOrder(Computer.class, Desk.class, Student.class, Chair.class);
        
        background = new GreenfootImage("emptyBackground.png");
        setBackground (background);
        
        studentTop = new Student();
        bedTop = new Bed(studentTop);
        chairTop = new Chair(studentTop);
        computerTop = new Computer(studentTop);
        deskTop = new Desk(studentTop);
        mirrorTop = new Mirror(studentTop);
        
        addObject(studentTop, 400, 200);
        addObject(bedTop, 90 + studentTop.getImage().getWidth()/2, 220);
        addObject(chairTop, 400, 220);
        addObject(computerTop, 400, 120);
        addObject(deskTop, 400, 180);
        addObject(mirrorTop, 600, 150);
        
        relativeCountdown = 10;
        relativeMinCountdown = 500;         
        cat = "Cat.png"; 
    }

    public void addedToWorld() {
            
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
