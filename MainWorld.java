import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */
public class MainWorld extends World {

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
    private CollisionBox topExit;
    private CollisionBox botExit;
    private Student studentTop;
    private Bed bedTop;
    private Chair chairTop;
    private Computer computerTop;
    private Desk deskTop;
    private Mirror mirrorTop;
    private Phone phoneTop;
    private DisplayStudent displayTop;
    private DisplayMood moodTop;

    private Student studentBot;
    private Bed bedBot;
    private Chair chairBot;
    private Computer computerBot;
    private Desk deskBot;
    private Mirror mirrorBot;
    private Phone phoneBot;
    private DisplayStudent displayBot;
    private DisplayMood moodBot;

    private int actNum;

    private boolean sickness;

    public MainWorld() {
        super(1024, 800, 1);
        setPaintOrder(SuperStatBar.class, Computer.class, Desk.class, Student.class, Chair.class);

        background = new GreenfootImage("background.png");
        setBackground(background);

        studentTop = new Student(true);
        bedTop = new Bed();
        chairTop = new Chair();
        computerTop = new Computer();
        deskTop = new Desk();
        mirrorTop = new Mirror();
        phoneTop = new Phone();
        displayTop = new DisplayStudent(studentTop);
        moodTop = new DisplayMood(studentTop);

        studentBot = new Student(false);
        bedBot = new Bed();
        chairBot = new Chair();
        computerBot = new Computer();
        deskBot = new Desk();
        mirrorBot = new Mirror();
        phoneBot = new Phone();
        displayBot = new DisplayStudent(studentBot);
        moodBot = new DisplayMood(studentBot);

        addObject(studentTop, 400, 200);
        addObject(bedTop, 90 + studentTop.getImage().getWidth() / 2, 220);
        addObject(chairTop, 400, 220);
        addObject(deskTop, 400, 180);
        addObject(mirrorTop, 600, 150);
        addObject(phoneTop, 300, 300);
        addObject(computerTop, 400, 120);
        addObject(displayTop, 855, 145);
        addObject(moodTop, 960, 150);
    

        setPaintOrder(Computer.class, Desk.class, Student.class, Chair.class);

        addObject(studentBot, 400, 600);
        addObject(bedBot, 90 + studentTop.getImage().getWidth() / 2, 620);
        addObject(chairBot, 400, 620);
        addObject(deskBot, 400, 580);
        addObject(mirrorBot, 600, 550);
        addObject(phoneBot, 300, 700);
        addObject(computerBot, 400, 520);
<<<<<<< Updated upstream
<<<<<<< Updated upstream

=======
=======
>>>>>>> Stashed changes
        addObject(displayBot, 855, 545);
        addObject(moodBot, 960, 550);
        
        
>>>>>>> Stashed changes
        relativeCountdown = 10;
        relativeMinCountdown = 500;         
        cat = "Cat.png";
        mom = "Mom.png";
        topExit = new CollisionBox(true);
        botExit = new CollisionBox(true);
        addObject(topExit, 750, 280);
        addObject(botExit, 750, 640);


        relativeMinCountdown = 500;
        
        setPaintOrder(SuperStatBar.class, Sidebar.class, Walls.class, Cloud.class, Student.class, Shadow.class, Effect.class);
        addObject(new Walls(), getWidth() / 2, getHeight() / 2);
        addObject(new Sidebar(), 898, 400);
        
<<<<<<< Updated upstream
        addObject(new StudentStatBar(100, 50, studentTop, 200, 30, Color.GREEN, Color.WHITE, Color.BLACK, 10, true, true), 898, 100);
        
        
=======
        countdownBar = new SuperStatBar(7200, 0, null, 600, 25, 0, Color.BLACK, Color.WHITE, false, Color.BLACK, 5);
        addObject(countdownBar, 400, 401);
        setPaintOrder(DisplayStudent.class, DisplayMood.class, SuperStatBar.class, Sidebar.class, Walls.class, Cloud.class, Student.class, Computer.class, Shadow.class, Effect.class);


>>>>>>> Stashed changes
        actNum = 0;


        sickness = false;

        prepare();

    }

    public void addedToWorld() {

    }

    public void act() {
        spawnRelative();
        actNum++;


        // every 15, can change as needed
        if (actNum % (60 * 10) == 0) {
            int random = Greenfoot.getRandomNumber(2);
<<<<<<< Updated upstream
<<<<<<< Updated upstream
            if (random == 0)
                spawnDisease();
            else
                spawnDepression();
            }
    
=======
=======
>>>>>>> Stashed changes
            //if (random == 0)
                //spawnDisease();
            //else
                //spawnDepression();
        }
        
        countdownBar.update(actNum);
        
>>>>>>> Stashed changes
    }

    public void spawnRelative() {
        if (relativeCountdown > 0) {
            relativeCountdown--;
        } else {
            boolean isTop = Greenfoot.getRandomNumber(2) == 0;
            relative = new Relative(cat, isTop);
            if (isTop) {
                addObject(relative, 50, 200);
            } else {
                addObject(relative, 50, 600);
            }
            relativeCountdown = relativeMinCountdown + Greenfoot.getRandomNumber(200);
        }
    }

    /**
     * Spawn either Sickness or Depression in random room
     */

    private void spawnEffect(){
        //get random room number + assign y coordinate of effect accordingly

        int y;
        int room = Greenfoot.getRandomNumber(2);
        if (room == 1)
            y = Effect.ROOM_1_Y;
        else
            y = Effect.ROOM_2_Y;


        addObject(new Sickness(room), Effect.ROOM_X, y);
        sickness = true;
    }

    public void spawnDisease(){
        int y;
        int room = Greenfoot.getRandomNumber(2) + 1;
        if (room == 1) y = Effect.ROOM_1_Y;
        else y = Effect.ROOM_2_Y;

        addObject(new Sickness(room), Effect.ROOM_X, y);
    }
    

    //currently only spawning in top room as test (can change to be spawned only when 
    //student happiness is low
    public void spawnDepression(){
        addObject(new Depression(1, studentTop), Effect.ROOM_X, Effect.ROOM_1_Y);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
    }
