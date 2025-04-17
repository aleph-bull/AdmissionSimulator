import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Student here.
 * 
 * @author 
 */
public class Student extends Animals
{
    /**
     * Act - do whatever the Student wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int gpa;
    private int happiness;
    private int nextItem;
    private int nextItemCD;
    private int nextItemMinCD = 1000;
    //SuperStatBar:
    //GPA Bar:
    private SuperStatBar bar1; 
    //Happiness Bar:
    private SuperStatBar bar2;
    //Productivity
    boolean productive;

    //Student health that appears when they are avoiding the letters
    int studentHealth;

    public GreenfootImage image; 


    private GreenfootImage[] walkAnimations = new GreenfootImage[6];
    private int countdown, frame;

    public Student(boolean isTop){
        super(isTop);
        gpa = 50;
        productive = true; 
        //bar = new SuperStatBar(100, gpa, this, 10, 20, 2, Color.GREEN, Color.RED);

        happiness = 100;


        prepareAnimations();

        countdown = 5;
    }

    public void act()
    {
        super.act();
        animate();
        
        if (gpa >= 100){gpa = 100;}
        else if (gpa <= 0){gpa = 0;}
        
        if (happiness >= 100){happiness = 100;}
        else if (happiness <= 0){happiness = 0;}
    }

    public int getGpa(){
        return this.gpa;
    }
    public void setGpa(int updatedGpa){
        this.gpa = updatedGpa;
        // Add your action code here.
        nextItem = Greenfoot.getRandomNumber(3);
    }
    public void rest(){
        happiness ++;
    }
    public void work(){
        if (productive){
            gpa += 4;
        } else{
            gpa ++;
        }
        happiness --;
    }
    public void usePhone(){
        gpa --;
        happiness += 2;
    }
    public void reduceHealth(int amount){
        this.studentHealth-=amount;
    }

    //add animation frames
    private void prepareAnimations(){
        String fileName = "bob_run";
        int fileNumber = 18;
        for (int j = 0; j < walkAnimations.length; j++){
            walkAnimations[j] = new GreenfootImage(fileName + fileNumber + ".png");
            walkAnimations[j].scale(35, 55);
            fileNumber++;
        }

        setImage(walkAnimations[0]);
    }


    //change frames
    private void animate(){
        //if Student is doing nothing but walking around, walk animation
        if (getActionState() == ActionState.NOTHING){
            if (countdown > 0){
                countdown--;
            } else {
                setImage(walkAnimations[frame]);
                frame++;
                //return to 0th frame once all frames have been displayed
                if (frame > 5){
                    frame = 0;
                }
                countdown = 5;
            }
        } else {
            //if Student is not moving, set to still frame
            frame = 0;
            setImage(walkAnimations[frame]);
        }
    }
    
    public int getHappiness(){
        return happiness;
    }

}