import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartingWorld here.
 * 
 * ============CREDITS============
 * - Button sfx: https://youtu.be/PA2PsADo11E?feature=shared
 * - Cloud image: https://www.freepik.com/premium-vector/pixel-art-cartoon-crying-rainy-cloud-character_214146407.htm
 * - Germ image: https://www.freepik.com/premium-vector/bacteria-virus-pixel-art-set-germ-microbe-collection-infectious-pathogen-8-bit-sprite_33822375.htm
 * - Rain sfx: Light rain loop, https://mixkit.co/free-sound-effects/rain/
 * - SettingWorld music: Run Amok by Kevin MacLeod, https://www.chosic.com/download-audio/39324/
 * - StartingWorld gif: https://www.artstation.com/artwork/182Z4L
 * - StartingWorld music: Colorful Flowers by Tokyo Music Walker, https://www.chosic.com/download-audio/45508/
 * 
 * @author Angela Wang
 * @version 04.09.25
 */
public class StartingWorld extends World
{
    private GifImage background;
    private GreenfootSound music;
    private TextBox title;
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
        music.setVolume(50);

        //title + start
        //OBVIOUSLY VERY SCUFFED but this was mostly to test TextBox
        title = new TextBox("College Admissions Simulator", Color.BLACK);
        addObject(title, getWidth() / 2, 400);

        TextBox startText = new TextBox("Press [e] to start", Color.BLACK);
        addObject(startText, 660, 750);
    }
    
    public void started(){
        music.playLoop();
    }

    public void stopped(){
        music.pause();
    }

    public void act(){
        animate();
        if (Greenfoot.isKeyDown("e")){
            music.stop();
            Greenfoot.setWorld(new SettingsWorldGeneral());
        }
    }
    
    public void animate(){
        background.getCurrentImage().scale(1024, 800);
        setBackground(background.getCurrentImage());
    }
}
