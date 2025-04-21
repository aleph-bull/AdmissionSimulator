import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingWorldGeneral here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorldGeneral extends SettingsWorld
{

    /**
     * Constructor for objects of class SettingWorldGeneral.
     * 
     */
    private SettingsWorld.StatChooseImage student1, student2, university;
    private int student1Number, student2Number, universityNumber; 

    public SettingsWorldGeneral()
    {    
        background = new GreenfootImage("SettingsPg1.png"); 
        setBackground(background); 


        next = new Button (cursor, false);
        addObject(next, 945, 670);

        student1Number = 0;
        student1 = new SettingsWorld.StatChooseImage(250, 100, 400, 290, student1Number); 
        student2Number = 0;
        student2 = new SettingsWorld.StatChooseImage(250, 100, 400, 550, student2Number); 
        universityNumber = 0; 
        university = new SettingsWorld.StatChooseImage(725, 500, 942, 550, 410, universityNumber); 

    }
    public void act()
    {
        student1.choose("bob_run1.png", "Amelia_run1.png", "Alex_run1.png"); 
        student2.choose("bob_run1.png", "Amelia_run1.png", "Alex_run1.png"); 
        university.choose("universityofcatmeme.png", "universityofbigmac.png", "universityofducksong.png", "universityoflebron.png"); 
        backWorld();
        nextWorld();
    }

    public void backWorld()
    {
    }

    public void nextWorld()
    {
        if (Greenfoot.mouseClicked(next))
        {
            Greenfoot.setWorld(new SettingsWorldS1Stats()); 
        }
    }
}
