import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndingWorld extends World
{

    /**
     * Constructor for objects of class EndingWorld.
     * 
     */
    private GreenfootImage background;
    private GreenfootImage rejectionImage;
    private boolean student1Win, student2Win; 
    private DecisionImage acceptedImage;
    private DecisionImage rejectedImage; 

    private CharacterImage student1, student2;

    public EndingWorld(boolean student1Admitted, boolean student2Admitted)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        student1Win = student1Admitted;
        student2Win = student2Admitted;
        background = new GreenfootImage("EndingWorld.png");
        setBackground(background); 

        student1Win = true; 
        student2Win = false; 

        student1 = new CharacterImage(true); 
        addObject(student1, 620, 320); 
        student2 = new CharacterImage(false); 
        addObject(student2, 620, 590); 
        
        if(student1Win == student1Admitted)
        {
            acceptedImage = new DecisionImage(true); 
            addObject(acceptedImage, 526, 288); 
        }
        else
        {
            rejectedImage = new DecisionImage(false);
            addObject(rejectedImage, 526, 286); 
        }

        if(student2Win == student2Admitted)
        {
            acceptedImage = new DecisionImage(true); 
            addObject(acceptedImage, 532, 557);
        }
        else
        {
            rejectedImage = new DecisionImage(false);
            addObject(rejectedImage, 532, 557);
        }
    }

    public void act()
    {
    }
}
