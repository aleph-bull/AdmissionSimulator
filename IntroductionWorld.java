import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroductionWorld extends World
{
    private GreenfootImage image;
    private String[] dialogue;
    private int curIndex;
    //private int actNum, duration;

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

        dialogue = new String[]{
            "It's almost time to apply to universities... Are you ready?",
            "Not really... there's so much to consider. GPA, extracurriculars...",
            "We can do this! Lock in.",
            "You're right. May the best person be accepted!"
        };
        
        //SuperTextBox test = new SuperTextBox("Hi!", Color.BLACK, Color.WHITE, new Font(40), true, 1024, 3, Color.YELLOW);
        //addObject(test, 512, 738);
        
        curIndex = 0;
        
        //actNum = 0;
        
        //duration = 90;
    }
    
    public void act(){
        //if (actNum % 90 == 0){
            SuperTextBox text = new SuperTextBox(dialogue[curIndex], Color.BLACK, Color.WHITE, new Font(20), true, 1024, 3, Color.YELLOW);
            addObject(text, 512, 738);
        //}
    }
}
