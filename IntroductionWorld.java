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
    private Computer computer;
    private Bed bed;

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

        //string array for dialogue 
        dialogue = new String[]{
            "It's almost time to apply to universities... Are you ready?",
            "Not really... there's so much to consider. GPA, extracurriculars...",
            "We can do this! Lock in.",
            "You're right. May the best person be accepted!"
        };

        curIndex = 0;

        actNum = 1;

        duration = dialogue[curIndex].length() * 5;
        
        SuperTextBox text = new SuperTextBox(dialogue[curIndex], Color.BLACK, Color.WHITE, new Font(20), true, 1024, 3, Color.YELLOW);
        addObject(text, 512, 738);
        
        computer = new Computer();
        bed = new Bed();
    }

    public void act(){
        //every duration interval, update TextBox with new line
        if (actNum % duration == 0){
            //if curIndex exceeds highest index, go to SettingsWorldGeneral
            if (curIndex == dialogue.length){
                Greenfoot.setWorld(new SettingsWorldGeneral());

                //don't know why but setting the world wasn't immediately going to SettingsWorldGeneral + was causing errors
                return;
            }

            if (curIndex % 2 == 0){
                //student 1 speaking
                addObject(computer, 92, 608);
                if (bed.getWorld() != null){
                    //acount for 1st time student 1 speaks (student 2 has not yet been added)
                    removeObject(bed);
                }
            } else {
                addObject(bed, 900, 608);
                removeObject(computer);
            }

            //new TextBox for next line in dialogue array
            SuperTextBox text = new SuperTextBox(dialogue[curIndex], Color.BLACK, Color.WHITE, new Font(20), true, 1024, 3, Color.YELLOW);
            addObject(text, 512, 738);
            
            duration = dialogue[curIndex].length() * 5;
            
            curIndex++;

            actNum = 0;
        }

        actNum++;
    }
}
