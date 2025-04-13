import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cloud here.
 * 
 * @author Angela Wang
 * @version 04.10.25
 */
public class Cloud extends EffectItem
{
    private Student student; 
    private int yOffset;
    
    public Cloud(Student student){
        image = new GreenfootImage("cloud.png");
        image.scale(70, 50);
        setImage(image);
        
        yOffset = 70;
        
        this.student = student;
    }
    
    /**
     * Act - do whatever the Cloud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(student.getX(), student.getY() - yOffset);
    }
}
