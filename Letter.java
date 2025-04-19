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
        
        
        image = new GreenfootImage("cloud.png");
        image.scale(70, 50);
        setImage(image);
        
        this.letterSpeed = speed;
    }
    
    public void act()
    {
        
        setLocation(getX(), getY() + letterSpeed);
        
        //When teh letter is off the screen, remove it
        if(getY() >= getWorld().getHeight()){
            getWorld().removeObject(this);
        }
        
        //When the letter doesn't hit the student and hits the edge of the screen, remove the letter
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        
    }
    
    
    public int getDamage(){
        return dealDamage;
    }
    
    
    
}
