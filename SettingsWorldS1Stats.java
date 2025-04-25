import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorldS1Stats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorldS1Stats extends SettingsWorld
{

    /**
     * Constructor for objects of class SettingsWorldS1Stats.
     * 
     */
    private static SettingsWorldS1Stats.StatChooseNumber happiness, productivity, gpa; 
    private int happinessNumber, productivityNumber, gpaNumber;

    private static SettingsWorldS1Stats.StatChooseImage relative1, relative2, relative3; 
    private int relative1Number, relative2Number, relative3Number; 

    public SettingsWorldS1Stats()
    {
        next = new Button (cursor, false);
        addObject(next, 945, 670);
        back = new Button (cursor, true); 
        addObject(back, 100, 670); 

        background = new GreenfootImage ("SettingsPg2.png"); 
        setBackground(background); 

        happinessNumber = 80;
        happiness = new SettingsWorldS1Stats.StatChooseNumber(280, 100, 450, 540, 280, 580, happinessNumber); 

        productivityNumber = 80;
        productivity = new SettingsWorldS1Stats.StatChooseNumber(280, 100, 450, 395, 280, 430, productivityNumber);

        gpaNumber = 80;
        gpa = new SettingsWorldS1Stats.StatChooseNumber(280, 100, 450, 250, 280, 280, productivityNumber);

        relative1Number = 0 ; 
        relative1 = new SettingsWorldS2Stats.StatChooseImage(775, 580, 950, 250, relative1Number); 

        relative2Number = 0;
        relative2 = new SettingsWorldS2Stats.StatChooseImage(775, 580, 950, 395, relative2Number); 

        relative3Number = 0;
        relative3 = new SettingsWorldS2Stats.StatChooseImage(775, 580, 950, 540, relative2Number); 
    }

    public void act()
    {
        backWorld(); 
        nextWorld(); 
        gpa.choose();
        productivity.choose(); 
        happiness.choose(); 
        relative1.choose("Cat.png", "Mom.png", "amongus_run1.png", "minicapy_run1.png", "brother.png", "sister.png"); 
        relative2.choose("Cat.png", "Mom.png", "amongus_run1.png", "minicapy_run1.png", "brother.png", "sister.png");
        relative3.choose("Cat.png", "Mom.png", "amongus_run1.png", "minicapy_run1.png", "brother.png", "sister.png"); 

        showText(relative1.getChoosenImage(), 100, 200); 
    }

    public void backWorld()
    {
        if (Greenfoot.mouseClicked(back))
        {
            Greenfoot.setWorld(new SettingsWorldGeneral()); 
        }
    }

    public void nextWorld()
    {
        if (Greenfoot.mouseClicked(next))
        {
            Greenfoot.setWorld(new SettingsWorldS2Stats()); 
        }
    }
    
    public static int getHappinessNumber()
    {
        return happiness.getNumber(); 
    }

    public static int getGPANumber()
    {
        return gpa.getNumber(); 
    }
    public static int getProductivityNumber()
    {
        return productivity.getNumber(); 
    }

    public static String getRelative1Image() {
        if (relative1 == null) {
            return "./images/Cat.png"; // Default image
        }
        return relative1.getChoosenImage();
    }
    
    public static String getRelative2Image() {
        if (relative2 == null) {
            return "./images/Mom.png"; // Default image
        }
        return relative2.getChoosenImage();
    }
    
    public static String getRelative3Image() {
        if (relative3 == null) {
            return "./images/sister.png"; // Default image
        }
        return relative3.getChoosenImage();
    }
}
