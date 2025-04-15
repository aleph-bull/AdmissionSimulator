import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorldS2Stats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorldS2Stats extends World
{

    /**
     * Constructor for objects of class SettingsWorldS2Stats.
     * 
     */

    private GreenfootImage background; 
    private Button next;
    private Button back; 
    private Cursor cursor; 

    /*
    private Button gpaLeft; 
    private Button gpaRight;
    private int gpaNumber; 
    private SettingsImages gpa;
     */

    private int maxmiumReachedGraphicCountdown; 
    private int maxmiumReachedGraphicMinCountdown; 

    private SettingsImages maximumValueReachedGraphic;
    private SettingsImages minimumValueReachedGraphic;

    /*
    private Button productivityLeft; 
    private Button productivityRight;
    private int productivityNumber; 
    private SettingsImages productivity;

    /*
    private Button happinessLeft; 
    private Button happinessRight;
    private int happinessNumber; 
    private SettingsImages happiness;
     */

    private SettingsWorldS2Stats.StatChooseNumber happiness, productivity, gpa; 
    private int happinessNumber, productivityNumber, gpaNumber;

    private SettingsWorldS2Stats.StatChooseImage relative1, relative2, relative3; 
    private int relative1Number, relative2Number, relative3Number; 
    public SettingsWorldS2Stats()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        cursor = new Cursor();
        addObject(cursor, 0, 0);

        next = new Button (cursor, false);
        addObject(next, 945, 670);
        back = new Button (cursor, true); 
        addObject(back, 100, 670); 

        background = new GreenfootImage ("SettingsPg3.png"); 
        setBackground(background); 

        maximumValueReachedGraphic = new SettingsImages();
        maximumValueReachedGraphic.maxMinDisplayText("Maximum Value Reached");

        minimumValueReachedGraphic = new SettingsImages();
        minimumValueReachedGraphic.maxMinDisplayText("Minimum Value Reached"); 
        happinessNumber = 80;
        happiness = new SettingsWorldS2Stats.StatChooseNumber(280, 100, 450, 540, 280, 580, happinessNumber); 

        productivityNumber = 90;
        productivity = new SettingsWorldS2Stats.StatChooseNumber(280, 100, 450, 395, 280, 430, productivityNumber);

        gpaNumber = 90;
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
        gpa.choose();
        productivity.choose(); 
        happiness.choose(); 
        relative1.choose(); 
        relative2.choose();
        relative3.choose(); 
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
            Greenfoot.setWorld(new SettingsWorldS2Stats()); 
        }
    }


    private class StatChooseNumber{
        private Button left; 
        private Button right;
        private int number;
        private SettingsImages object;
        private int graphicLocationX; 
        private int graphicLocationY;

        public StatChooseNumber(int objectLocationX, int leftLocationX, int rightLocationX, int locationY, int graphicLocationX, int graphicLocationY, int number)
        {
            this.number = number;
            object = new SettingsImages(); 
            object.numberDisplay(number); 
            addObject(object, objectLocationX, locationY); 
            left = new Button(cursor, true); 
            right = new Button(cursor, false);
            addObject(left, leftLocationX, locationY); 
            addObject(right, rightLocationX, locationY);

            this.graphicLocationX = graphicLocationX;
            this.graphicLocationY = graphicLocationY; 
        }

        public void choose()
        {
            if (Greenfoot.mouseClicked(right))
            {
                if(number == 100)
                {
                    addObject(maximumValueReachedGraphic, graphicLocationX, graphicLocationY); 
                }
                else
                {
                    number+=5;
                    object.numberDisplay(number); 
                }

            }
            else if (Greenfoot.mouseClicked(left))
            {

                if(number ==0)
                {
                    addObject(minimumValueReachedGraphic, graphicLocationX, graphicLocationY); 
                }
                else
                {
                    number-=5; 
                    object.numberDisplay(number); 
                }
            }
        }
    }

    public class StatChooseImage
    {
        private Button left; 
        private Button right;
        private int number; 
        private SettingsImages object; 

        public StatChooseImage(int objectLocationX, int leftLocationX, int rightLocationX, int locationY, int number)
        {
            this.number = number; 
            object = new SettingsImages(); 
            object.setImageFile("Cat.png"); 
            addObject(object, objectLocationX, locationY); 
            left = new Button(cursor, true); 
            right = new Button(cursor, false);
            addObject(left, leftLocationX, locationY); 
            addObject(right, rightLocationX, locationY); 
        }

        public void choose()
        {
            if (Greenfoot.mouseClicked(right))
            {
                number++;    
            }
            else if (Greenfoot.mouseClicked(left))
            {
                number--; 
            }
            if(number%4==0)
            {
                object.setImageFile("Cat.png"); 
            }
            else if (number%4==1 || number%4==-1)
            {
                object.setImageFile("universityofbigmac.png"); 
            }
            else if (number%4 == 2 || number%4==-2)
            {
                object.setImageFile("universityofducksong.png"); 
            }
            else if (number%4 == 3 || number%4==-3)
            {
                object.setImageFile("universityoflebron.png"); 
            }

        }
    }
}
