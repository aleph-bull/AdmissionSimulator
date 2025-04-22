import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * IntroductionWorld briefly introduces the theme of the simulation through a dialogue
 * between two students.
 * 
 * @author Angela Wang
 * @version 04-15-25
 */
public class IntroductionWorld extends World
{
    private GreenfootImage image;
    private String[] dialogue;
    private int curIndex;
    private int actNum, duration;
    private Image speaker1, speaker2, bg;
    private GreenfootSound music;
    private Textbox[] texts;

    //private Textbox text;

    private int speaker1X, speaker2X;
    /**
     * Constructor for objects of class IntroductionWorld.
     * 
     */
    public IntroductionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 

        image = new GreenfootImage("introbg.png");
        setBackground(image);

        music = new GreenfootSound("intromusic.mp3");
        music.setVolume(50);
        music.play();

        //string array for dialogue 
        dialogue = new String[]{
            "Wow, look at the date!",
            "September! The year is nearly over already.",
            "Uni-application time! Are you ready?",
            "Not really... my grades are everywhere.",
            "Same here. So many distractions...",
            "We can do this! Lock in."
        };

        speaker1 = new Image("Amelia_run1.png", 90, 120);
        speaker2 = new Image("Alex_run1.png", 90, 120);

        speaker1X = 512 - 200;
        speaker2X = 512 + 200;

        curIndex = 0;

        actNum = 1;

        texts = new Textbox[dialogue.length];
        //SuperTextBox text = new SuperTextBox(dialogue[curIndex], Color.BLACK, Color.WHITE, new Font(30), true, 1024, 3, Color.YELLOW);
        for (int i = 0; i < dialogue.length; i++){
            if (i % 2 == 0){
                texts[i] = new Textbox(dialogue[i], speaker1);
            } else {
                texts[i] = new Textbox(dialogue[i], speaker2);
            }
        }

        addObject(texts[curIndex], 512, 700);

        //addObject(text, 512, 703);
        addObject(speaker1, speaker1X, 560);
        addObject(speaker2, speaker2X, 560);

        duration = 200;

        //text = new Textbox(dialogue[curIndex], speaker1);
        //addObject(text, 500, 700);
    }

    public void started(){
        music.playLoop();
    }

    public void stopped(){
        music.pause();
    }

    public void act(){
        //every duration interval, update TextBox with new line
        //if (actNum % duration == 0){
        //if curIndex exceeds highest index, go to SettingsWorldGeneral

        //if (text.isFinished()){
            
        if (actNum % duration == 0){            
            curIndex++;
            if (curIndex == dialogue.length){
                music.stop();
                Greenfoot.setWorld(new SettingsWorldGeneral());
    
                //don't know why but setting the world wasn't immediately going to SettingsWorldGeneral + was causing errors
                return;
            }
    
            //new TextBox for next line in dialogue array
            //SuperTextBox text = new SuperTextBox(dialogue[curIndex], Color.BLACK, Color.WHITE, new Font(20), true, 1024, 3, Color.YELLOW);
            //addObject(text, 512, 717);
            
            removeObject(texts[curIndex - 1]);
                
            addObject(texts[curIndex], 512, 700);
            
            //prevent speaker from moving too far if text animation ends at a different y than start
            speaker1.setLocation(speaker1X, 560);
            speaker2.setLocation(speaker2X, 560);
        }
        
        actNum++;
    }
}
