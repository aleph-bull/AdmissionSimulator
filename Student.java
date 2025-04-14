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
    private int gpa;
    private int happiness;
    private int nextItem;
    private int nextItemCD;
    private int nextItemMinCD = 1000;

    // SuperStatBar:
    // GPA Bar:
    private SuperStatBar bar1;
    // Happiness Bar:
    private SuperStatBar bar2;
    // Productivity
    boolean productive;

    // Student health that appears when they are avoiding the letters
    int studentHealth;

    public GreenfootImage image;

    public Student() {
        super();
        // the student begins with a 50
        gpa = 50;
        productive = true;
        // GPA Bar:
        bar1 = new SuperStatBar(100, gpa, this, 10, 20, 2, Color.GREEN, Color.RED);

        // Happiness Bar:
        bar2 = new SuperStatBar(100, gpa, this, 10, 20, 2, Color.GREEN, Color.RED);
        happiness = 100;

    }

    public void act() {
        super.act();

        nextItem = Greenfoot.getRandomNumber(3);

    }

    public int getGpa() {
        return this.gpa;
    }

    public void setGpa(int updatedGpa) {
        this.gpa = updatedGpa;

        // Add your action code here.
        nextItem = Greenfoot.getRandomNumber(3);

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
}
