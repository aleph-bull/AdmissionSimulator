import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * First Setting screen - student images, university
 * 
 * @author Stephanie Xia
 * @version 4.23.2025
 */
public class SettingsWorldGeneral extends SettingsWorld
{
    private static SettingsWorld.StatChooseImage student1, student2, university;
    private static int student1Number, student2Number, universityNumber;     
    private SettingsWorldS1Stats world1;

    /**
     * SettingsWorldGeneral constructor 
     */
    public SettingsWorldGeneral()
    {    
        //settings the background
        background = new GreenfootImage("SettingsPg1.png"); 
        setBackground(background); 

        //making a next button
        next = new Button (cursor, false);
        addObject(next, 945, 670);

        //creating objects to call to create the images
        student1Number = 0;
        student1 = new SettingsWorld.StatChooseImage(250, 100, 400, 290, student1Number); 
        student2Number = 0;
        student2 = new SettingsWorld.StatChooseImage(250, 100, 400, 550, student2Number); 
        universityNumber = 0; 
        university = new SettingsWorld.StatChooseImage(725, 500, 942, 550, 410, universityNumber); 
    }

    public void act()
    {
        //calling the methods from SettingsWorld in order to display the images while the program is running
        student1.choose("bob_run1.png", "Amelia_run1.png", "Alex_run1.png", "Adam_run1.png", false); 
        student2.choose("bob_run1.png", "Amelia_run1.png", "Alex_run1.png", "Adam_run1.png", false); 
        university.choose("universityofcatmeme.png", "universityofbigmac.png", "universityofducksong.png", "universityoflebron.png", true); 
        //going to the next world
        nextWorld();    
    }

    /**
     * Not used??
     */
    public void backWorld()
    {
    }

    /**
     * Go to the next Setting screen when next button is clicked
     * @return void
     */
    public void nextWorld()
    {
        //if the mouse clicks on the next button, it will take me to the next pages of the settings
        if (Greenfoot.mouseClicked(next))
        {
            //if the world has never been created before, create a new world
            if (world1 == null) {
                world1 = new SettingsWorldS1Stats(this);
            }
            //if it has been created before, go to the one that was created
            Greenfoot.setWorld(world1);
        }
    }
    //getter methods for getting the specific file name of the image the user selected
    
    /**
     * Get chosen university image
     * @return String   university img file name
     */
    public static String getUniversityImage()
    {
        return university.getChoosenImage(); 
    }

    /**
     * Get chosen student1 image
     * @return String   student1 img file name
     */
    public static String getStudent1Image()
    {
        return student1.getChoosenImage(); 
    }

    /**
     * Get chosen student 2 image
     * @return String   student2 img file name
     */
    public static String getStudent2Image()
    {
        return student2.getChoosenImage(); 
    }
}
