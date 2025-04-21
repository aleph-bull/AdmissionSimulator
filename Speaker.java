import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Doesn't do much, just to display graphics for IntroductionWorld Dialogue (behaviour 
 * was too unlike Student)
 * 
 * @author Angela Wang 
 * @version 04-17-25
 */
public class Speaker extends Actor
{
    private GreenfootImage[] images = new GreenfootImage[2];
    
    public Speaker(int index){
        String fileName;
        if (index == 0){
            fileName = "Amelia_run1.png";
        } else {
            fileName = "Alex_run1.png";
        }
        
        for (int i = 0; i < 2; i++){
            images[i] = new GreenfootImage(fileName);
            images[i].scale(95, 120);
        }
        
        setImage(images[index]);
    }
    
    public void act(){
        
    }
}
