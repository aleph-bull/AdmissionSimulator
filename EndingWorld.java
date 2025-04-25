import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * EndingWorld Screen to show acceptance/rejections
 * 
 * @author Stephanie Xia, Angela Wang
 * @version 4.23.2025
 */
public class EndingWorld extends World
{
    private GreenfootImage background;
    private GreenfootImage rejectionImage;
    private boolean student1Win, student2Win; 
    //private DecisionImage acceptedImage;
    //private DecisionImage rejectedImage; 

    private GreenfootSound music;

    //private CharacterImage student1, student2;

    private Image student1, student2, admissionImg1, admissionImg2;

    /**
     * Ending world - specify admission status of students
     * @param student1Admitted  True if accepted
     * @param student2Admitted  True if accepted
     */
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
        student1 = new Image(SettingsWorldGeneral.getStudent1Image(), 100, 140); 
        addObject(student1, 620, 320); 
        student2 = new Image(SettingsWorldGeneral.getStudent2Image(), 100, 140); 
        addObject(student2, 620, 590); 

        //if the boolean that they get admitted is true, accepted image is displayed
        if(student1Win == true)
        {
            //acceptedImage = new DecisionImage(true); 
            //addObject(acceptedImage, 526, 288); 
            admissionImg1 = new Image("AcceptedImage.png");
        }
        //if they are rejected, rejected image is displayed
        else
        {
            //rejectedImage = new DecisionImage(false);
            //addObject(rejectedImage, 526, 286); 
            admissionImg1 = new Image("RejectedImage.png");
        }
        addObject(admissionImg1, 526, 286);

        if(student2Win == true)
        {
            //acceptedImage = new DecisionImage(true); 
            //addObject(acceptedImage, 532, 557);
            admissionImg2 = new Image("AcceptedImage.png");
        }
        else
        {
            //rejectedImage = new DecisionImage(false);
            //addObject(rejectedImage, 532, 557);
            admissionImg2 = new Image("RejectedImage.png");
        }
        addObject(admissionImg2, 532, 557);

        //set music based on acceptaince/rejections --> only play sad music if both
        //are rejected
        if (student1Win == false && student2Win == false){
            music = new GreenfootSound("sadending.mp3");
        } else {
            music = new GreenfootSound("yayending.mp3");
        }

        music.play();
    }

    /**
     * Continue music when started
     * @return void
     */
    public void started(){
        music.play();
    }

    /**
     * Pause music when execution stopped
     * @return void
     */
    public void stopped(){
        music.pause();
    }
}
