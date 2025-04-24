import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * THINGS TO CHANGE
 * - bar blocking cloud
 * - phone placement
 * - adding computer/phone graphics
 * 
 * ============CREDITS============
 * - Button sfx: https://www.youtube.com/watch?v=BZvS2Bno8R4
 * - Cloud image: https://www.freepik.com/premium-vector/pixel-art-cartoon-crying-rainy-cloud-character_214146407.htm
 * - Germ image: https://www.freepik.com/premium-vector/bacteria-virus-pixel-art-set-germ-microbe-collection-infectious-pathogen-8-bit-sprite_33822375.htm
 * - Rain sfx: Light rain loop, https://mixkit.co/free-sound-effects/rain/
 * - SettingWorld music: Run Amok by Kevin MacLeod, https://www.chosic.com/download-audio/39324/
 * - StartingWorld gif: https://www.artstation.com/artwork/182Z4L
 * - StartingWorld music: Colorful Flowers by Tokyo Music Walker, https://www.chosic.com/download-audio/45508/
 * - IntroductionWorld bg: https://ibispaint.com/art/707595372/
 * - IntroductionWorld music: https://www.chosic.com/download-audio/27131/ 
 * - MainWorld music: https://www.chosic.com/download-audio/29282/
 * - Honk mimimimi: https://www.youtube.com/watch?v=dNr7nXvntO8 
 * - Typing: https://mixkit.co/free-sound-effects/discover/typing/
 * 
 * 
 * =====KNOWN BUGS====
 * - Slight slight chance that Animal may hit a wall and oscillate briefly 
 * - Settings do not save when going back a setting world? or maybe it's just visuals
 * - 
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
            Greenfoot.setWorld(new IntroductionWorld());
        }
    }
    
    public void animate(){
        background.getCurrentImage().scale(1024, 800);
        setBackground(background.getCurrentImage());
    }
}
