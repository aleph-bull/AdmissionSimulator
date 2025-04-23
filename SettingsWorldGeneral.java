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
    private static SettingsWorld.StatChooseImage student1, student2, university;
    private static int student1Number, student2Number, universityNumber; 
    private static int count; 

    public SettingsWorldGeneral()
    {    
        background = new GreenfootImage("SettingsPg1.png"); 
        setBackground(background); 

        next = new Button (cursor, false);
        addObject(next, 945, 670);

        student1 = new SettingsWorld.StatChooseImage(250, 100, 400, 290, data.getStudent1Number()); 
        student2Number = data.getStudent2Number();
        student2 = new SettingsWorld.StatChooseImage(250, 100, 400, 550, student2Number); 
        universityNumber = data.getUniversityNumber(); 
        university = new SettingsWorld.StatChooseImage(725, 500, 942, 550, 410, universityNumber); 
        count++; 
    }

    public void act()
    {
        student1.choose("bob_run1.png", "Amelia_run1.png", "Alex_run1.png", "Adam_run1.png", false); 
        student2.choose("bob_run1.png", "Amelia_run1.png", "Alex_run1.png", "Adam_run1.png", false); 
        university.choose("universityofcatmeme.png", "universityofbigmac.png", "universityofducksong.png", "universityoflebron.png", true); 
        backWorld();
        nextWorld();
        showText(String.valueOf(data.getStudent1Number()), 100, 200); 
        
        
        showText(String.valueOf(student1Number), 200, 300); 
        
        student1Number = data.getStudent1Number();

        setStudent1Data();
        setStudent2Data();
        setUniversityNumber(); 
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

    public static String getUniversityImage()
    {
        return university.getChoosenImage(); 
    }

    public static String getStudent1Image()
    {
        return student1.getChoosenImage(); 
    }

    public static String getStudent2Image()
    {
        return student2.getChoosenImage(); 
    }

    public static void setStudent1Data()
    {
        data.setStudent1Number(student1.getNumber());
    }

    public static void setStudent2Data()
    {
        data.setStudent2Number(student2Number); 
    }

    public static void setUniversityNumber()
    {
        data.setUniversityNumber(universityNumber); 
    }    

    public static int getCount()
    {
        return count; 
    }

}
