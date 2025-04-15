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

    public Student() {
        super();
        // the student begins with a 50
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
        
    }

    public void act() {
        super.act();
        
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
}
