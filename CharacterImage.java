import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CharacterImage sets Images for ending worlds?
 * To be honest this could have just been Image
 * 
 * @author Stephanie Xia
 * @version 4.22.2025
 */
public class CharacterImage extends Actor
{
    /**
     * Images for the Ending World
     */
    private GreenfootImage studentImage;

    public void act()
    {  

    }

    /**
     * CharacterImage constructor - specify which student image should be of
     * @param isStudent1 
     */
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
