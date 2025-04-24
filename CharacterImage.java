import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterImage extends Actor
{
    /**
     * Act - do whatever the CharacterImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage studentImage;

    public void act()
    {  

    }

    public CharacterImage(boolean isStudent1)
    {

        if(isStudent1 == true)
        {
            studentImage = new GreenfootImage(SettingsWorldGeneral.getStudent1Image()); 
            studentImage.scale(100, 140); 
            setImage(studentImage);
        }
        else
        {
            studentImage = new GreenfootImage(SettingsWorldGeneral.getStudent2Image()); 
            studentImage.scale(100, 140); 
            setImage(studentImage); 
        }
    }
}
