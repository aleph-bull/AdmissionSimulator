import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Admin here.
 * 
 * @ Daniel Wang
 * @ 1.1.1
 */
public class Admin extends Animals {
    /**
     * Act - do whatever the Admin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private int requirement;
    private boolean mood;
    private String uni;
    private int acceptanceR;
  
    public Admin(int requirement,int acceptanceR,boolean mood, String uni, boolean isTop){
        super(isTop);
        this.requirement = requirement;
        this.acceptanceR = acceptanceR;
        this.mood = mood;
        this.uni = uni;
        if (!mood) {
            requirement += 2;
            acceptanceR -= 5;
        }

    }

    public void act() {
        
    }

    // A method for shooting letters to the students
    public void sendLetter() {
        Letter l = new Letter(10);
        getWorld().addObject(l, getX(), getY() - 20);
        l.setRotation(getRotation());
    }

    // When the student hit by a letter
    public void hurtByStudent() {
        Student student = (Student) getOneIntersectingObject(Student.class);
        if (student != null) {
            student.reduceHealth(10);
        }
    }

    public boolean compareStats(Student student) {
        boolean result = false;
        // Compares the university standards and the student's stats to consider if
        // the student should be acceped or rejected

        if (student.getGpa() >= this.requirement) {

            if (student.getGpa() >= this.requirement) {
                result = true;
            }
        }
        return result;
    }
}
