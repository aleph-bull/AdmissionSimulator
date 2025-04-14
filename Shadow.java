import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shadow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shadow extends EffectItem
{
    private Student student;
    private int yOffset;
    
    public Shadow(Student student){
        this.student = student;
        yOffset = 20;
        
        drawImage();
    }
    
    /**
     * Act - do whatever the Shadow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(student.getX(), student.getY() + yOffset);
    }
    
    private void drawImage(){
        image = new GreenfootImage(80, 40);
        image.setColor(new Color(0, 0, 0, 100));
        image.fillOval(0, 0, 80, 40);
        setImage(image);
    }
}
