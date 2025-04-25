import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * MainWorld is where the GPA farming simulation takes place.
 * @author Zachary Zhao, Daniel Wang, Ethan Ren, Stephanie Xia, Angela Wang
 * @version 04-23-2025
 */

public class MainWorld extends World {

    public static final boolean SHOW_BARS = true;
    public final int GAME_LENGTH = 90; // the length of the game, in seconds.
    private GreenfootImage background;

    private int relativeCountdown;
    private int relativeMinCountdown;
    private Relative r;

    private Relative relative;
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

    private SuperWindow card;
    private Student s;

    public static Counter counter = new Counter();
    SimpleTimer st = new SimpleTimer();
    Counter counter2 = new Counter();

    private SuperStatBar countdownBar;
    private GreenfootSound music;

    /**
     * Constructor for MainWorld, called by IntroductionWorld 
     */
    public MainWorld() {
        super(1024, 800, 1);

        background = new GreenfootImage("background.png");
        setBackground(background);

        music = new GreenfootSound("mainmusic.mp3");
        music.setVolume(50);

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
        addObject(phoneTop, 600, 300);
        addObject(computerTop, 400, 120);
        addObject(displayTop, 855, 145);
        addObject(moodTop, 960, 150);

        addObject(studentBot, 400, 600);
        addObject(bedBot, 90 + studentTop.getImage().getWidth() / 2, 620);
        addObject(chairBot, 400, 620);
        addObject(deskBot, 400, 580);
        addObject(mirrorBot, 600, 550);
        addObject(phoneBot, 600, 700);
        addObject(computerBot, 400, 520);
        addObject(displayBot, 855, 545);
        addObject(moodBot, 960, 550);
        relativeCountdown = 10;
        relativeMinCountdown = 500;         

        topExit = new CollisionBox(true);
        botExit = new CollisionBox(true);
        addObject(topExit, 750, 280);
        addObject(botExit, 750, 640);

        relativeMinCountdown = 500;

        addObject(new Walls(), getWidth() / 2, getHeight() / 2);
        addObject(new Sidebar(), 898, 400);

        addObject(new StudentStatBar(50, studentTop, 200, 30, Color.GREEN, Color.WHITE, Color.BLACK, 10, true, true), 898, 275);
        addObject(new StudentStatBar(50, studentTop, 200, 30, Color.BLUE, Color.WHITE, Color.BLACK, 10, true, false), 898, 350);
        addObject(new StudentStatBar(50, studentBot, 200, 30, Color.GREEN, Color.WHITE, Color.BLACK, 10, true, true), 898, 675);
        addObject(new StudentStatBar(50, studentBot, 200, 30, Color.BLUE, Color.WHITE, Color.BLACK, 10, true, false), 898, 750);

        //addObject(new StudentStatBar(100, 50, studentTop, 200, 30, Color.GREEN, Color.WHITE, Color.BLACK, 10, true, true), 898, 100);

        actNum = 0;

        countdownBar = new SuperStatBar(GAME_LENGTH*60, 0, null, 600, 25, 0, new Color(227, 145, 224), Color.WHITE, false, Color.BLACK, 3);
        addObject(countdownBar, 400, 401);
        setPaintOrder(Counter.class, DisplayStudent.class, DisplayMood.class, SuperStatBar.class, Sidebar.class, Walls.class, Cloud.class, Student.class, Shadow.class, Effect.class);

        //actNum = 0;

        prepare();

        card = new SuperWindow (250, 370, 24,2, "Student 1", studentTop, new boolean[]{true, false, true, true, false}, Color.BLACK, Color.WHITE);
        addObject (card, 900, 200);
        //Timer
        counter.setValue(0);
        counter2.setValue(GAME_LENGTH);
        st.mark();

        //Adding the timer: Showing the timer (how much time left till they submtit their application)
        // showText("Timer", 978, 42);
        counter2.setPrefix("Time Left: ");
        addObject(counter2, 950, 12);

        studentTop.setProductivityValue(SettingsWorldS1Stats.getProductivityNumber()); 
        studentTop.setHappinessValue(SettingsWorldS1Stats.getHappinessNumber()); 
        studentTop.setGpaValue(SettingsWorldS1Stats.getGpaNumber()); 

        studentBot.setProductivityValue(SettingsWorldS1Stats.getProductivityNumber()); 
        studentBot.setHappinessValue(SettingsWorldS1Stats.getHappinessNumber()); 
        studentBot.setGpaValue(SettingsWorldS1Stats.getGpaNumber()); 

        music.playLoop();
    }

    /**
     * Act - spawn relatives + effects, update timer
     * @return void
     */
    public void act() {
        spawnRelative();
        actNum++;

        // every 15, can change as needed
        if (actNum % (60 * 10) == 0) {
            ArrayList<Effect> effects = (ArrayList<Effect>) getObjects(Effect.class);
            if (effects.size() == 2){
                //if already 2 effects --> maximum, don't spawn anything
            } else if (effects.size() == 1){
                if (effects.get(0).getY() < 400){
                    spawnEffect(2, Effect.ROOM_2_Y, studentBot);
                } else if (effects.get(0).getY() > 400){
                    spawnEffect(1, Effect.ROOM_1_Y, studentTop);
                } 
            } else {
                int random = Greenfoot.getRandomNumber(2);
                if (random == 0){
                    spawnEffect(1, Effect.ROOM_1_Y, studentTop);
                } else {
                    spawnEffect(2, Effect.ROOM_2_Y, studentBot);
                }
            }
        }
        // counter2.setValue(120 - st.millisElapsed()/1000);
        if (actNum % 60 == 0) counter2.add(-1); // Decrement the counter by 1
        countdownBar.update(actNum);

        if(counter2.getValue() == 0){ // If the timer is over, switch to AdmissionsWorld
            //stop all sfx
            ArrayList<FunctionalItem> functionalItems = (ArrayList<FunctionalItem>) getObjects(FunctionalItem.class);
            for (FunctionalItem f: functionalItems){
                f.stopSound();
            }

            ArrayList<Depression> depressions = (ArrayList<Depression>) getObjects(Depression.class);
            if (depressions.size() > 0){
                for (Depression d : depressions){
                    d.pauseSound();
                }
            }

            music.stop();
            Greenfoot.setWorld(new AdmissionsWorld(studentTop, studentBot));
        }
    }

    /**
     * Execution started --> play music (item sfx are not played bc assumption is that they are 
     * short enough to need to be played again)
     * @return void
     */
    public void started(){
        // counter2.setValue(120);
        music.playLoop();
        ArrayList<Depression> depressions = (ArrayList<Depression>) getObjects(Depression.class);
        if (depressions.size() > 0){
            for (Depression d : depressions){
                d.pauseSound();
            }
        }
    }

    public void stopped(){
        //stop all sound effects + music
        ArrayList<FunctionalItem> functionalItems = (ArrayList<FunctionalItem>) getObjects(FunctionalItem.class);
        for (FunctionalItem f: functionalItems){
            f.stopSound();
        }

        ArrayList<Depression> depression = (ArrayList<Depression>) getObjects(Depression.class);
        if (depression.size() > 0){
            depression.get(0).pauseSound();
        }

        music.pause();
    }

    /**
     * Spawn a relative in either room, with any of the 3 associated selected images.
     * @return void
     */
    public void spawnRelative() {
        if (relativeCountdown > 0) {
            relativeCountdown--;
        } else {
            boolean isTop = Greenfoot.getRandomNumber(2) == 0;
            String fileName = "";
            int random = Greenfoot.getRandomNumber(3);

            //if top student
            if (isTop) {
                //set relative image based on what user selected in settings
                if (random == 0){
                    fileName = SettingsWorldS1Stats.getRelative1Image();
                } else if (random == 1){
                    fileName = SettingsWorldS1Stats.getRelative2Image();
                } else {
                    fileName = SettingsWorldS1Stats.getRelative3Image();
                }

                relative = new Relative(fileName, isTop);
                addObject(relative, 80, 200);
            } else {
                //if bottom student
                //set img based on user selection
                if (random == 0){
                    fileName = SettingsWorldS2Stats.getRelative1Image();
                } else if (random == 1){
                    fileName = SettingsWorldS2Stats.getRelative2Image();
                } else {
                    fileName = SettingsWorldS2Stats.getRelative3Image();
                }
                relative = new Relative(fileName, isTop);
                addObject(relative, 80, 600);
            }
            relativeCountdown = relativeMinCountdown + Greenfoot.getRandomNumber(200);
        }
    }

    //Spawn either Sickness or Depression in random room
    private void spawnEffect(int roomNum, int y, Student student){
        int random = Greenfoot.getRandomNumber(2);
        if (random == 0){
            //half chance of adding sickness
            addObject(new Sickness(roomNum), Effect.ROOM_X, y);
        } else {
            //half chance of adding depression
            addObject(new Depression(roomNum, student), Effect.ROOM_X, y);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}