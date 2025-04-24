import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * StartingWorld begins the simulation with bland welcome text and a cool gif!? 
 * 
 * @author Angela Wang
 * @version 04.09.25
 */
public class StartingWorld extends World
{
    private GifImage background;
    private GreenfootSound music;
    private SuperTextBox title, startText;
    private Button button;
    private Cursor cursor;

    /**
     * Constructor for objects of class StartingWorld.
     * 
     */
    public StartingWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        
        background = new GifImage("bg.gif");
        background.getCurrentImage().scale(1024, 800);
        setBackground(background.getCurrentImage());

        music = new GreenfootSound("startmusic.mp3");
        music.setVolume(70);

        //title + start texts
        title = new SuperTextBox("College Admissions Simulator", new Color(0, 0, 0, 0), Color.BLACK, new Font(40), true, 800, 0, new Color(0, 0, 0, 0));
        addObject(title, getWidth() / 2, 400);

        startText = new SuperTextBox("Press [e] to start", new Color(0, 0, 0, 0), Color.BLACK, new Font(30), true, 500, 0, new Color(0, 0, 0, 0));
        addObject(startText, getWidth() / 2, 600);
    }
    
    /**
     * Continue playing music when execution started
     * @return void
     */
    public void started(){
        music.playLoop();
    }

    /**
     * Pause music when execution stopped
     */
    public void stopped(){
        music.pause();
    }

    /**
     * Animate gif 
     * @return void
     */
    public void act(){
        animate();
        if (Greenfoot.isKeyDown("e")){
            music.stop();
            Greenfoot.setWorld(new IntroductionWorld());
        }
    }
    
    private void animate(){
        background.getCurrentImage().scale(1024, 800);
        setBackground(background.getCurrentImage());
    }
}
