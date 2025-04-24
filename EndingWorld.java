import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Stephanie Xia
 * @version 4.23.2025
 */
public class EndingWorld extends World
{
    private GreenfootImage background;
    private GreenfootImage rejectionImage;
    private boolean student1Win, student2Win; 
    private DecisionImage acceptedImage;
    private DecisionImage rejectedImage; 
    
    private GreenfootSound music;

    private CharacterImage student1, student2;

    public EndingWorld(boolean student1Admitted, boolean student2Admitted)
    {    
        super(1024, 800, 1);
        //parameters passed in from admission world for whether or not the students were admitted
        student1Win = student1Admitted;
        student2Win = student2Admitted;
        //set background image
        background = new GreenfootImage("EndingWorld.png");
        setBackground(background);

        //creating the two student images
        student1 = new CharacterImage(true); 
        addObject(student1, 620, 320); 
        student2 = new CharacterImage(false); 
        addObject(student2, 620, 590); 
        
        //if the boolean that they get admitted is true, accepted image is displayed
        if(student1Win == true)
        {
            acceptedImage = new DecisionImage(true); 
            addObject(acceptedImage, 526, 288); 
        }
        //if they are rejected, rejected image is displayed
        else
        {
            rejectedImage = new DecisionImage(false);
            addObject(rejectedImage, 526, 286); 
        }

        if(student2Win == true)
        {
            acceptedImage = new DecisionImage(true); 
            addObject(acceptedImage, 532, 557);
        }
        else
        {
            rejectedImage = new DecisionImage(false);
            addObject(rejectedImage, 532, 557);
        }
        
        //set music based on acceptaince/rejections --> only play sad music if both
        //are rejected
        if (student1Win == false && student2Win == false){
            music = new GreenfootSound("sadending.mp3");
        } else {
            music = new GreenfootSound("yayending.mp3");
        }
        
        music.playLoop();
    }
    
    public void started(){
        music.playLoop();
    }
    
    public void stopped(){
        music.pause();
    }
}
