import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shadow trails the Student affected by Depression.
 * 
 * @author Angela Wang
 * @version April 2025
 */
public class Shadow extends EffectItem
{
    private Student student;
    private int yOffset;
    
    /**
     * Shadow constructor - specify Student Shadow should follow
     * @param student       Student to follow
     */
    public Shadow(Student student){
        this.student = student;
        yOffset = 20;
        
        drawImage();
    }
    
    /**
     * Act - stalk Student. This method is called whenever
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
