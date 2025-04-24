import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorldS2Stats here.
 * 
 * @author Stephanie Xia
 * @version 4.23.2025
 */
public class SettingsWorldS2Stats extends SettingsWorld
{
    private static SettingsWorldS2Stats.StatChooseNumber happiness, productivity, gpa; 
    private static int happinessNumber, productivityNumber, gpaNumber;

    private static SettingsWorldS2Stats.StatChooseImage relative1, relative2, relative3; 
    private static int relative1Number, relative2Number, relative3Number; 
    
    private SettingsWorldS1Stats world1;

    public SettingsWorldS2Stats(SettingsWorldS1Stats world1)
    {
        next = new Button (cursor, false);
        addObject(next, 945, 670);
        back = new Button (cursor, true); 
        addObject(back, 100, 670); 

        //setting background
        background = new GreenfootImage ("SettingsPg3.png"); 
        setBackground(background); 
        
        //same as S1World -- setting intial number
        happinessNumber = 80;
        happiness = new SettingsWorldS2Stats.StatChooseNumber(280, 100, 450, 540, 280, 580, happinessNumber); 

        productivityNumber = 80;
        productivity = new SettingsWorldS2Stats.StatChooseNumber(280, 100, 450, 395, 280, 430, productivityNumber);

        gpaNumber = 80;
        gpa = new SettingsWorldS2Stats.StatChooseNumber(280, 100, 450, 250, 280, 280, productivityNumber);

        relative1Number = 0 ; 
        relative1 = new SettingsWorldS2Stats.StatChooseImage(775, 580, 950, 250, relative1Number); 

        relative2Number = 0;
        relative2 = new SettingsWorldS2Stats.StatChooseImage(775, 580, 950, 395, relative2Number); 

        relative3Number = 0;
        relative3 = new SettingsWorldS2Stats.StatChooseImage(775, 580, 950, 540, relative2Number); 
        
        this.world1 = world1;
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
    }

    //going back to the previous world
    public void backWorld(){
        if (Greenfoot.mouseClicked(back))
        {
            Greenfoot.setWorld(world1); 
        }
    }

    //going to the main world
    public void nextWorld()
    {
        if (Greenfoot.mouseClicked(next))
        {
            music.stop();
            Greenfoot.setWorld(new MainWorld()); 
        }
    }

    public static int getHappinessNumber()
    {
        return happiness.getNumber(); 
    }

    public static int getGpaNumber()
    {
        return gpa.getNumber(); 
    }

    public static int getProductivityNumber()
    {
        return productivity.getNumber(); 
    }

    public static String getRelative1Image()
    {
        return relative1.getChoosenImage();
    }

    public static String getRelative2Image()
    {
        return relative2.getChoosenImage();
    }

    public static String getRelative3Image()
    {
        return relative3.getChoosenImage();
    }
}
