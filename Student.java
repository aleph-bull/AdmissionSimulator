import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
    private double gpa;
    private double happiness;
    private int nextItem;
    private int nextItemCD;
    private int nextItemMinCD = 1000;
    
    /*
    //SuperStatBar:
    //GPA Bar:
    private SuperStatBar gpaBar; 
    //Happiness Bar:
    private SuperStatBar happyBar;
    */
    
    //Productivity
    boolean productive;

    //Student health that appears when they are avoiding the letters
    int studentHealth;

    public GreenfootImage image; 


    private GreenfootImage[] walkAnimations = new GreenfootImage[6];
    private int countdown, frame;
    
    public Student(){
        super();
        image = new GreenfootImage("bob_run20.png");
        prepareAnimations();
    }

    public Student(boolean isTop){
        super(isTop);
        gpa = 50;
        productive = true; 

        //bar = new SuperStatBar(100, gpa, this, 10, 20, 2, Color.GREEN, Color.RED);
        image = new GreenfootImage("bob_run21.png");
        image.scale(42, 60);
        setImage(image);


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
        

    
      
        
        

        ArrayList<Effect> effects = (ArrayList<Effect>) getIntersectingObjects(Effect.class);
        if (effects.size() != 0){
            if (effects.get(0) instanceof Sickness){
                gpa -= 0.15;
            } else if (effects.get(0) instanceof Depression){
                happiness = 0;
                gpa -= 0.05;
            }
        } else{}
        gpa -= 0.05;

    }

    public double getGpa(){
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
            gpa += 0.4;
        } else{
            gpa +=0.2;
        }
        happiness -= 0.25;
    }
    public void usePhone(){
        gpa -= 0.2;
        happiness += 1.5;
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
    
    public double getHappiness(){
        return happiness;
    }

    //The methods below are for students to dodge the letters during the battle phase of the simulation
    
    public void avoidLetters() {
        int detectionHeight = 100; // how high to scan above
        int detectionWidth = 30;   // how wide to scan on both sides
        int moveSpeed = 4;

        boolean dangerDetected = false;

        for (int dx = -detectionWidth; dx <= detectionWidth; dx += 7) {
            for (int dy = -detectionHeight; dy < 0; dy += 5) {
                Actor letter = getOneObjectAtOffset(dx, dy, Letter.class);
                if (letter != null) {
                    dangerDetected = true;
                    break;
                }
            }
            if (dangerDetected) break;
        }

        if (dangerDetected) {
            // Try to move away from the falling letter
            if (canMove(moveSpeed)) {
                setLocation(getX() + moveSpeed, getY());
            } else if (canMove(-moveSpeed)) {
                setLocation(getX() - moveSpeed, getY());
            }
        }
    }
    
    
    public boolean canMove(int dx) {
        int newX = getX() + dx;
        return newX >= 0 && newX < getWorld().getWidth();
    }

}