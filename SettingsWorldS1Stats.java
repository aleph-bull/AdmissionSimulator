import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorldS1Stats here.
 * 
 * @author Stephanie Xia
 * @version 4.23.2025
 */
public class SettingsWorldS1Stats extends SettingsWorld
{
    private static SettingsWorldS1Stats.StatChooseNumber happiness, productivity, gpa; 
    private static int happinessNumber, productivityNumber, gpaNumber;

    private static SettingsWorldS1Stats.StatChooseImage relative1, relative2, relative3; 
    private static int relative1Number, relative2Number, relative3Number; 
    private GreenfootImage background;

    private SettingsWorldGeneral worldGeneral;
    private SettingsWorldS2Stats world2;

    public SettingsWorldS1Stats(SettingsWorldGeneral worldGeneral)
    {
        //creating the buttons for back and forth; passing the cursor into the button constructor so it can deduct mouse clicking
        next = new Button (cursor, false);
        addObject(next, 945, 670);
        back = new Button (cursor, true); 
        addObject(back, 100, 670); 

        //setting the intial valeus of the variables as well creating the object from fresh
        happinessNumber = 80;
        happiness = new SettingsWorldS1Stats.StatChooseNumber(280, 100, 450, 540, 280, 580, happinessNumber); 

        productivityNumber = 80;
        productivity = new SettingsWorldS1Stats.StatChooseNumber(280, 100, 450, 395, 280, 430, productivityNumber);

        gpaNumber = 80;
        gpa = new SettingsWorldS1Stats.StatChooseNumber(280, 100, 450, 250, 280, 280, productivityNumber);

        relative1Number = 0; 
        relative1 = new SettingsWorldS2Stats.StatChooseImage(775, 580, 950, 250, relative1Number); 

        relative2Number = 0;
        relative2 = new SettingsWorldS2Stats.StatChooseImage(775, 580, 950, 395, relative2Number); 

        relative3Number = 0;
        relative3 = new SettingsWorldS2Stats.StatChooseImage(775, 580, 950, 540, relative2Number); 
        background = new GreenfootImage("SettingsPg2.png"); 

        //setting background imags
        setBackground(background); 

        //the constructor being passed from the previous world to make sure the changes are saved 
        this.worldGeneral = worldGeneral;
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

    //going back to the previous world that is saved
    public void backWorld()
    {
        if (Greenfoot.mouseClicked(back))
        {
            Greenfoot.setWorld(worldGeneral); 
        }
    }

    //going to the next world, creating one if the next world has not been created yet
    public void nextWorld()
    {
        if (Greenfoot.mouseClicked(next))
        {
            if (world2 == null) {
                world2 = new SettingsWorldS2Stats(this);
            }
            Greenfoot.setWorld(world2);
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
