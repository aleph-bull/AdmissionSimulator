import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Student here.
 * 
 * @author
 */
public class Student extends Animals {
    /**
     * Act - do whatever the Student wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Basic variables
    private int gpa;
    private int happiness;
    private int nextItem;
    private int nextItemCD;
    private int nextItemMinCD = 1000;
    
    //Text
    

    // SuperStatBar:
    // GPA Bar:
    private SuperStatBar bar1;
    // Happiness Bar:
    private SuperStatBar bar2;
    // Productivity
    boolean productive;

    // Student health that appears when they are avoiding the letters
    int studentHealth;


    private GreenfootImage image;


    //animation variables
    private GreenfootImage[] walkAnimations = new GreenfootImage[6];
    private int countdown, frame;


    public Student(boolean isTop){
        super(isTop);
        gpa = 50;
        productive = true;
        
        // GPA Bar:
        bar1 = new SuperStatBar(100, gpa, null, 100, 30, -32, Color.GREEN, Color.RED, true, Color.BLACK, 5);
        
        //Text for the simulation
        

        // Happiness Bar:`
        happiness = 100;

        bar2 = new SuperStatBar(100, happiness, null, 100, 30, -32, Color.YELLOW, Color.RED, true, Color.BLACK, 5);
        
        
        
        
    }
    
    public void addedToWorld(World w){
        w.addObject(bar1, 950, 120);
        bar1.update(gpa);
        
        
        w.addObject(bar2, 700, 100);
        bar2.update(happiness);
        


        prepareAnimations();

        countdown = 5;

        frame = 0;

    }

    public void act() {
        super.act();

        


        animate();

    }

    public int getGpa() {
        return this.gpa;
    }

    public void setGpa(int updatedGpa) {
        this.gpa = updatedGpa;

    }

    public void rest() {
        happiness++;
    }

    public void work() {

        gpa++;
        happiness--;

        if (productive) {
            gpa += 4;
        } else {
            gpa++;
        }
        happiness--;

    }

    public void usePhone() {
        gpa--;
        happiness += 2;

    }

    public void reduceHealth(int amount) {
        this.studentHealth -= amount;
    }
    
    public void studentSick(){
        MainWorld w = new MainWorld();
        if(w.isSick()){
            gpa-=10;
            happiness-=10;
        }
        
        
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

}
