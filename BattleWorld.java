import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Battle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleWorld extends World
{
    private GreenfootImage background;
    
    Student student1;
    Student student2;
    
    //Spawn timer for the letters
    private int spawnTimer = 0;
    
    public BattleWorld()
    {    
        //Background:
        super(1024, 800, 1);
        background = new GreenfootImage("battleGround.png");
        setBackground(background);
        
        //Students:
        student1 = new Student(true);
        
        addObject(student1, 206, 726);
        
        
        
    }
    
    public void act(){
        
        //Spawning letters
        spawnTimer++;
        if(spawnTimer >= 50){ //lower value means faster rate of letters going down
            spawnLetter();
            spawnTimer = 0;
        }
        
        student1.avoidLetters();
        
    }
    
    public void spawnLetter(){
        int x = Greenfoot.getRandomNumber(getWidth());
        //Spawn at random x value at the top of the screen
        addObject(new Letter(3), x , 0); 
    }
    
    
}
