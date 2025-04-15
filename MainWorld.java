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
    
    
    public static final boolean SHOW_BARS = true;
    
    
    private GreenfootImage background;

    private int relativeCountdown;
    private int relativeMinCountdown; 
    private Relative r;


    private Relative relative;
    private String cat;
    private String mom;
    private GreenfootImage image;
    private Student studentTop;
    private Bed bedTop;
    private Chair chairTop;
    private Computer computerTop;
    private Desk deskTop;
    private Mirror mirrorTop;
    private Phone phoneTop;

    private int actNum;
    
    private boolean sickness;
    
    public MainWorld()
    {    
        super(1024, 800, 1); 

        background = new GreenfootImage("emptyBackground.png");
        setBackground (background);

        studentTop = new Student();
        bedTop = new Bed();
        chairTop = new Chair();
        computerTop = new Computer();
        deskTop = new Desk();
        mirrorTop = new Mirror();
        phoneTop = new Phone();

        addObject(studentTop, 400, 200);
        addObject(bedTop, 90 + studentTop.getImage().getWidth()/2, 220);
        addObject(chairTop, 400, 220);
        addObject(deskTop, 400, 180);
        addObject(mirrorTop, 600, 150);
        addObject(phoneTop, 300, 300);
        addObject(computerTop, 400, 120);
        


        relativeCountdown = 10;
        relativeMinCountdown = 500;         
        cat = "LeftButton.png";
        mom = "Mom.png";
        

        setPaintOrder(SuperStatBar.class, Walls.class, Cloud.class, Student.class, Shadow.class, Effect.class);
        addObject(new Walls(), getWidth() / 2, getHeight() / 2);
        
        actNum = 0;
        
        sickness = false;
    }

    public void addedToWorld() {

    }

    public void act()
    {
        spawnRelative();
        actNum++;

        //every 10, can change as needed
        if (actNum % (60 * 10) == 0){
            spawnDisease();
        }
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

    /**
     * Spawn Sickness in random room
     */
    public void spawnDisease(){
        int y;
        int room = Greenfoot.getRandomNumber(1) + 1;
        if (room == 1) y = Effect.ROOM_1_Y;
        else y = Effect.ROOM_2_Y;

        addObject(new Sickness(room), Effect.ROOM_X, y);
        sickness = true;
    }
    
    public boolean isSick(){
        return sickness;
    }
}
