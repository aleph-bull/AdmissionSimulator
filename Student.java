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
    int productivity; // a different stat that affects how long computer can be used, set in settings world

    boolean sick;

    //Student health that appears when they are avoiding the letters
    int studentHealth;

    public GreenfootImage image; 

    private GreenfootImage[] walkAnimations = new GreenfootImage[6];
    private GreenfootImage phoneImg;
    private int countdown, walkFrame, phoneFrame;

    private ActionState curActionState, prevActionState;
    private boolean takingPhone, puttingPhoneAway;

    public Student(boolean isTop){
        super(isTop);
        gpa = 50;
        productive = true; 
        productivity = 50;

        //bar = new SuperStatBar(100, gpa, this, 10, 20, 2, Color.GREEN, Color.RED);
        //image = new GreenfootImage("Bob_run21.png");
        //image.scale(42, 60);
        //setImage(image);

        happiness = 100;

        countdown = 8;
        phoneFrame = 0;
        walkFrame = 0;

        takingPhone = false;
        puttingPhoneAway = false;

    }

    public void addedToWorld(World w){
        prepareAnimations();
    }

    public void act()
    {
        super.act();
        animate();

        if (gpa >= 100){gpa = 100;}
        else if (gpa <= 0){gpa = 0;}

        if (happiness >= 100){happiness = 100;}
        else if (happiness <= 0){happiness = 0;}
        
        productive = happiness >= 50;
        
        ArrayList<Effect> effects = (ArrayList<Effect>) getIntersectingObjects(Effect.class);
        if (effects.size() != 0){
            if (effects.get(0) instanceof Sickness){
                sick = true;
                gpa -= 0.15;
                happiness -= 0.35;
            } else if (effects.get(0) instanceof Depression){
                happiness = 0;
                gpa -= 0.05;
                sick = false;
            }
        } else{ sick = false; }
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
        happiness += 0.6;
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

        //get chosen file name based on what user picked in SettingsWorldGeneral
        String fileName;
        if (getY() < 400){
            fileName = SettingsWorldGeneral.getStudent1Image();
        } else {
            fileName = SettingsWorldGeneral.getStudent2Image();
        }

        if (fileName.contains("bob")){
            fileName = "bob";
        } else if (fileName.contains("Amelia")){
            fileName = "Amelia";
        } else if (fileName.contains("Alex")){
            fileName = "Alex";
        }
        else{
            fileName = "Adam"; 
        }

        //fill array with correct walk animations
        for (int j = 0; j < walkAnimations.length; j++){
            walkAnimations[j] = new GreenfootImage(fileName + "_run" + (j + 1) + ".png");
            walkAnimations[j].scale(40, 55);
        }
        
        phoneImg = new GreenfootImage(fileName + "_phone4.png");
        phoneImg.scale(40, 55);
        
        setImage(walkAnimations[0]);
    }

    public boolean isSick() {
        return sick;
    }

    private void animate(){
        //change frames every 8 acts
        if (countdown > 0){
            countdown--;
        } else {
            //if at phone, phone image
            if (getActionState() == ActionState.BRAINROTTING){
                setImage(phoneImg);
            } else if (getActionState() == ActionState.NOTHING){
                //if doing nothing but walking, walk animation
                setImage(walkAnimations[walkFrame]);
                walkFrame++;
                if (walkFrame > 5) walkFrame = 0; //reset
            } else {
                //if working/bedrotting, still image
                walkFrame = 0;
                setImage(walkAnimations[walkFrame]);
            }
            
            countdown = 8;
        }
    }

    public double getHappiness(){
        return happiness;
    }
    
    public int getProductivity() {
        return productivity;
    }
    public boolean canMove(int dx) {
        int newX = getX() + dx;
        return newX >= 0 && newX < getWorld().getWidth();
    }
    public void setProductivityValue(int productivity)
    {
        this.productivity = productivity; 
    }
    
    public void setHappinessValue(double happiness)
    {
        this.happiness = happiness; 
    }
    public void setGpaValue(double gpa)
    {
        this.gpa = gpa; 
    }

}