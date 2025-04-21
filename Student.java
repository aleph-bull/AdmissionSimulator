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
    private GreenfootImage[] phoneAnimations = new GreenfootImage[9];
    private int countdown, walkFrame, phoneFrame;

    private ActionState curActionState, prevActionState;
    private boolean takingPhone, puttingPhoneAway;

    public Student(boolean isTop){
        super(isTop);
        gpa = 50;
        productive = true; 

        //bar = new SuperStatBar(100, gpa, this, 10, 20, 2, Color.GREEN, Color.RED);
        //image = new GreenfootImage("Bob_run21.png");
        //image.scale(42, 60);
        //setImage(image);


        happiness = 100;
        
      

        prepareAnimations();
        countdown = 8;
        phoneFrame = 0;
        walkFrame = 0;

        takingPhone = false;
        puttingPhoneAway = false;

    }
    
   

    public void act()
    {
        super.act();
        checkActionState();
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
        //walk animations
        String fileName = "bob_run";
        for (int j = 0; j < walkAnimations.length; j++){
            walkAnimations[j] = new GreenfootImage(fileName + (j + 1) + ".png");
            walkAnimations[j].scale(35, 55);
        }

        //phone animations
        fileName = "bob_phone";
        for (int i = 0; i < phoneAnimations.length; i++){
            phoneAnimations[i] = new GreenfootImage(fileName + i + ".png");
            phoneAnimations[i].scale(35, 55);
        }
        setImage(walkAnimations[0]);
    }

    //updates curActionState and prevActionState to know if change has occurred
    private void checkActionState(){
        curActionState = getActionState();
        if (prevActionState == ActionState.NOTHING && curActionState == ActionState.BRAINROTTING){
            takingPhone = true;
            phoneFrame = 0;
        } else if (prevActionState == ActionState.BRAINROTTING && curActionState == ActionState.NOTHING){
            puttingPhoneAway = true;
        } 
    }

    //change frames
    private void animate(){
        //if Student is doing nothing but walking around, walk animation
        //if (curActionState == ActionState.NOTHING){

        if (curActionState == ActionState.BRAINROTTING){
            if (getY() > 400){
                System.out.println("ActionState: " + curActionState);
                System.out.println("Phone frame: " + phoneFrame);
                System.out.println("Taking phone: " + takingPhone + " Putting Away : " + puttingPhoneAway);

            }
        }
        if (countdown > 0){
            countdown--;
        } else {
            if (takingPhone){
                setImage(phoneAnimations[phoneFrame]);
                phoneFrame++;
                System.out.println(phoneFrame);

                if (phoneFrame > 8){
                    takingPhone = false;
                    phoneFrame = 8;
                }
            } else if (puttingPhoneAway){
                setImage(phoneAnimations[phoneFrame]);
                phoneFrame--;

                if (phoneFrame < 0 ){
                    System.out.println("Reached");
                    puttingPhoneAway = false;
                    phoneFrame = 0;
                }
            } else if (curActionState == ActionState.NOTHING){
                setImage(walkAnimations[walkFrame]);
                walkFrame++;

                if (walkFrame > 5) walkFrame = 0;
            } else {
                walkFrame = 0;
                setImage(walkAnimations[0]);
            }

            countdown = 8;
        }

        prevActionState = curActionState;
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