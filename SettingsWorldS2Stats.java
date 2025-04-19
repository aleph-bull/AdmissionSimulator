import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorldS2Stats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorldS2Stats extends SettingsWorld
{

    /**
     * Constructor for objects of class SettingsWorldS2Stats.
     * 
     */
    private SettingsWorldS2Stats.StatChooseNumber happiness, productivity, gpa; 
    private int happinessNumber, productivityNumber, gpaNumber;

    private SettingsWorldS2Stats.StatChooseImage relative1, relative2, relative3; 
    private int relative1Number, relative2Number, relative3Number; 
    public SettingsWorldS2Stats()
    {
        next = new Button (cursor, false);
        addObject(next, 945, 670);
        back = new Button (cursor, true); 
        addObject(back, 100, 670); 

        background = new GreenfootImage ("SettingsPg3.png"); 
        setBackground(background); 

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
    }

    public void act()
    {
        backWorld();
        nextWorld();
        gpa.choose();
        productivity.choose(); 
        happiness.choose(); 
        relative1.choose("Cat.png", "Alex_run1.png", "Alex_run2.png", "Alex_run3.png"); 
        relative2.choose("Cat.png", "Cat.png", "Cat.png", "Cat.png");
        relative3.choose("Cat.png", "Cat.png", "Cat.png", "Cat.png"); 
    }

    public void backWorld()
    {
        if (Greenfoot.mouseClicked(back))
        {
            Greenfoot.setWorld(new SettingsWorldS1Stats()); 
        }
    }

    public void nextWorld()
    {
        if (Greenfoot.mouseClicked(next))
        {
            Greenfoot.setWorld(new MainWorld()); 
        }
    }

}
