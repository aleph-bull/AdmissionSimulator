import greenfoot.*;  

/**
 * Write a description of class Letter here.
 * 
 * @Daniel Wang
 * @1.1.1
 */
public class Letter extends Actor
{
    private GreenfootImage image;
    private int letterSpeed;
    private int dealDamage;
    public Letter(int speed){
        //Letter:
        /*
        image = new GreenfootImage("");
        setImage(image);
        */
        letterSpeed = speed;
    }
    
    public void act()
    {
        //When the letter doesn't hit the student and hits the edge of the screen, remove the letter
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        
    }
    
    
    public int getDamage(){
        return dealDamage;
    }
    
    
    
}
