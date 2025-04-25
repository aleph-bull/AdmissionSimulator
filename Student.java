import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Student posseses GPA, happiness, and productivity, the last 2 impacting GPA? It 
 * wanders around the room and can be sleeping (bed), working (on computer), brainrotting 
 * (on phone). 
 * 
 * @author Daniel Wang, Zachary Zhao, Ethan Ren, Angela Wang
 * @version April 2025
 */
public class Student extends Animals
{
    private double gpa;
    private double happiness;
    private double productivity;
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

    /**
     * Student constructor - specify if Student is in top or bottom room
     * @param isTop     if true, student is in top room, otherwise in bottom room
     */
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

    }

    /**
     * When added to world, add animation frames to an array
     * @return void
     */
    public void addedToWorld(World w){
        prepareAnimations();
    }

    /**
     * Act - wander around room/use items, alter gpa/happiness/productivity, and potentially 
     * suffer disease or depression
     * @return void
     */
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

    /**
     * Get Student GPA
     * @return double   Student gpa
     */
    public double getGpa(){
        return this.gpa;
    }

    /**
     * Set GPA to int
     * @param updatedGpa       integer new gpa
     * @return void
     */
    public void setGpa(int updatedGpa){
        this.gpa = updatedGpa;
        // Add your action code here.
        nextItem = Greenfoot.getRandomNumber(3);
    }

    /**
     * Increase happiness by 0.6
     * @return void
     */
    public void rest(){
        happiness += 0.6;
    }

    /**
     * Increase gpa (more if productive) and decrease happiness
     * @return void
     */
    public void work(){
        if (productive){
            gpa += 0.4;
        } else{
            gpa +=0.2;
        }
        happiness -= 0.25;
    }

    /**
     * Decrease gpa and increase happiness
     * @return void
     */
    public void usePhone(){
        gpa -= 0.2;
        happiness += 1.5;
    }

    /**
     * Subtract amount from health
     * @param amount    int health to be subtracted
     * @return void
     */
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

    /**
     * Return health of student
     * @return boolean  True if Student is currently under Sickness effect
     */
    public boolean isSick() {
        return sick;
    }

    //manage animations
    private void animate(){
        //change frames every 8 acts
        if (countdown > 0){
            countdown--;
        } else {
            //if at phone, phone image
            if (getCurrentAction() == ActionState.BRAINROTTING){
                setImage(phoneImg);
            } else if (getCurrentAction() == ActionState.NOTHING){
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

    /**
     * Return student happiness
     * @return double   Happiness (happiest = 100)
     */
    public double getHappiness(){
        return happiness;
    }
    
    /**
     * Return student productivity
     * @return int Productivity level, impacting how long student is at computer
     */
    public int getProductivity() {
        return productivity;
    }
    
    /**
     * Return if student can move??
     * @param dx
     * @return boolean
     */
    public boolean canMove(int dx) {
        int newX = getX() + dx;
        return newX >= 0 && newX < getWorld().getWidth();
    }
    
    /**
     * Set student productivity value to new int
     * @param productivity
     * @return void
     */
    public void setProductivityValue(int productivity)
    {
        this.productivity = productivity; 
    }
    
    /**
     * Set happiness to new double
     * @param happiness
     * @return void
     */
    public void setHappinessValue(double happiness)
    {
        this.happiness = happiness; 
    }
    
    /**
     * Set gpa to new double
     * @param gpa
     * @return void
     */
    public void setGpaValue(double gpa)
    {
        this.gpa = gpa; 
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