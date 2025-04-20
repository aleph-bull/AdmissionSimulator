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
    private Speaker speaker1, speaker2;
    private GreenfootSound music;

    /**
     * Constructor for objects of class IntroductionWorld.
     * 
     */
    public IntroductionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 

        image = new GreenfootImage("introbg.jpg");
        setBackground(image);
        
        music = new GreenfootSound("intromusic.mp3");
        music.setVolume(50);
        //music.play();

        //string array for dialogue 
        dialogue = new String[]{
            "Wow, look at the date!",
            "September 24th... the year is nearly over already.",
            "Uni-application time! Are you ready?",
            "Not really... my grades fluctuate wildly.",
            "Same here. There are so many distractions...",
            "We can do this! Lock in.",
            "You're right. May the best person be accepted!"
        };

        curIndex = 0;

        actNum = 1;

        //duration = dialogue[curIndex].length() * 5;
        
        SuperTextBox text = new SuperTextBox(dialogue[curIndex], Color.BLACK, Color.WHITE, new Font(20), true, 1024, 3, Color.YELLOW);
        addObject(text, 512, 717);
        curIndex++;
        
        speaker1 = new Speaker(0);
        speaker2 = new Speaker(1);
        
        addObject(speaker1, 92, 717);
        
        duration = 200;
    }
    
    public void started(){
        music.playLoop();
    }
    
    public void stopped(){
        music.pause();
    }

    public void act(){
        //every duration interval, update TextBox with new line
        if (actNum % duration == 0){
            //if curIndex exceeds highest index, go to SettingsWorldGeneral
            if (curIndex == dialogue.length){
                music.stop();
                Greenfoot.setWorld(new SettingsWorldGeneral());

                //don't know why but setting the world wasn't immediately going to SettingsWorldGeneral + was causing errors
                return;
            }

            //new TextBox for next line in dialogue array
            SuperTextBox text = new SuperTextBox(dialogue[curIndex], Color.BLACK, Color.WHITE, new Font(20), true, 1024, 3, Color.YELLOW);
            addObject(text, 512, 717);
            
            //duration = dialogue[curIndex].length() * 5;
            
            if (curIndex % 2 == 0){
                //student 1 speaking
                addObject(speaker1, 92, 717);
                removeObject(speaker2);
            } else {
                addObject(speaker2, 900, 717);
                removeObject(speaker1);
            }
            
            curIndex++;

            actNum = 0;
        }

        actNum++;
    }
}
