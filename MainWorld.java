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

    Student studentTop;
    Bed bedTop;
    Chair chairTop;
    Computer computerTop;
    Desk deskTop;
    Mirror mirrorTop;
    Phone phoneTop;

    Student studentBot;
    Bed bedBot;
    Chair chairBot;
    Computer computerBot;
    Desk deskBot;
    Mirror mirrorBot;
    Phone phoneBot;

    private int actNum;

    private boolean sickness;

    public MainWorld() {
        super(1024, 800, 1);
        setPaintOrder(SuperStatBar.class, Computer.class, Desk.class, Student.class, Chair.class);

        background = new GreenfootImage("emptyBackground.png");
        setBackground(background);

        studentTop = new Student(true);
        bedTop = new Bed();
        chairTop = new Chair();
        computerTop = new Computer();
        deskTop = new Desk();
        mirrorTop = new Mirror();
        phoneTop = new Phone();

        studentBot = new Student(false);
        bedBot = new Bed();
        chairBot = new Chair();
        computerBot = new Computer();
        deskBot = new Desk();
        mirrorBot = new Mirror();
        phoneBot = new Phone();

        addObject(studentTop, 400, 200);
        addObject(bedTop, 90 + studentTop.getImage().getWidth() / 2, 220);
        addObject(chairTop, 400, 220);
        addObject(deskTop, 400, 180);
        addObject(mirrorTop, 600, 150);
        addObject(phoneTop, 300, 300);
        addObject(computerTop, 400, 120);

        setPaintOrder(Computer.class, Desk.class, Student.class, Chair.class);

        addObject(studentBot, 400, 600);
        addObject(bedBot, 90 + studentTop.getImage().getWidth() / 2, 620);
        addObject(chairBot, 400, 620);
        addObject(deskBot, 400, 580);
        addObject(mirrorBot, 600, 550);
        addObject(phoneBot, 300, 700);
        addObject(computerBot, 400, 520);

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

    public void act() {
        spawnRelative();
        actNum++;

        // every 15, can change as needed
        if (actNum % (60 * 10) == 0) {
            int random = Greenfoot.getRandomNumber(2);
            if (random == 0)
                spawnDisease();
            else
                spawnDepression();
        }
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
     * Spawn Sickness in random room
     */
    public void spawnDisease() {
        int y;
        int room = Greenfoot.getRandomNumber(2);
        if (room == 1)
            y = Effect.ROOM_1_Y;
        else
            y = Effect.ROOM_2_Y;

        addObject(new Sickness(room), Effect.ROOM_X, y);
        sickness = true;
    }

    public boolean isSick() {
        return sickness;
    }

    // currently only spawning in top room as test (can change to be spawned only
    // when
    // student happiness is low
    public void spawnDepression() {
        addObject(new Depression(1, studentTop), Effect.ROOM_X, Effect.ROOM_1_Y);
    }
}
