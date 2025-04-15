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
    
    private GreenfootImage[][] walkAnimations = new GreenfootImage[4][6];
    private int countdown, frame;
    
    public Student(){
        super();
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
        
        
        //direction test
        
        
        animate();
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
    
    private void prepareAnimations(){
        String fileName = "bob_run";
        int fileNumber = 0;
        for (int i = 0; i < walkAnimations.length; i++){
            for (int j = 0; j < walkAnimations[0].length; j++){
                walkAnimations[i][j] = new GreenfootImage(fileName + fileNumber + ".png");
                walkAnimations[i][j].scale(35, 55);
                fileNumber++;
            }
        }
    }
    
    private void animate(){
        if (getActionState() == ActionState.NOTHING){
            if (countdown > 0){
                countdown--;
            } else {
                setImage(walkAnimations[3][frame]);
                frame++;
                if (frame > 5){
                    frame = 0;
                }
                countdown = 5;
            }
        }
    }
    
}
