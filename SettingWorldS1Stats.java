import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingWorldS1Stats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorldS1Stats extends SettingWorld
{

    /**
     * Constructor for objects of class SettingWorldS1Stats.
     * 
     */
    private int maxmiumReachedGraphicCountdown; 
    private int maxmiumReachedGraphicMinCountdown; 

    private SettingsImages maximumValueReachedGraphic;
    private SettingsImages minimumValueReachedGraphic;

    /*
    private Button productivityLeft; 
    private Button productivityRight;
    private int productivityNumber; 
    private SettingImages productivity;

    /*
    private Button happinessLeft; 
    private Button happinessRight;
    private int happinessNumber; 
    private SettingImages happiness;
     */

    private SettingsWorld.StatChooseNumber happiness, productivity, gpa; 
    private int happinessNumber, productivityNumber, gpaNumber;

    private SettingsWorld.StatChooseImage relative1, relative2, relative3; 
    private int relative1Number, relative2Number, relative3Number; 
    
    public SettingsWorldS1Stats()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        next = new Button (cursor, false);
        addObject(next, 945, 670);
        back = new Button (cursor, true); 
        addObject(back, 100, 670); 

        background = new GreenfootImage ("SettingPg2.png"); 
        setBackground(background); 

        /*
        gpa = new SettingImages(); 
        gpaNumber = 5; 
        gpa.numberDisplay(gpaNumber); 
        addObject(gpa, 280, 250); 
        gpaLeft = new Button(cursor, true); 
        gpaRight = new Button(cursor, false);
        addObject(gpaLeft, 100, 250); 
        addObject(gpaRight, 450, 250); 

        /*
        productivity = new SettingImages(); 
        productivityNumber = 5; 
        productivity.numberDisplay(productivityNumber); 
        addObject(productivity, 280, 395); 
        productivityLeft = new Button(cursor, true); 
        productivityRight = new Button(cursor, false);
        addObject(productivityLeft, 100, 395); 
        addObject(productivityRight, 450, 395);

        /*
        happiness = new SettingImages(); 
        happinessNumber = 5; 
        happiness.numberDisplay(happinessNumber); 
        addObject(happiness, 280, 395); 
        happinessLeft = new Button(cursor, true); 
        happinessRight = new Button(cursor, false);
        addObject(happinessLeft, 100, 395); 
        addObject(happinessRight, 450, 395);
         */

        maximumValueReachedGraphic = new SettingsImages();
        maximumValueReachedGraphic.maxMinDisplayText("Maximum Value Reached");

        minimumValueReachedGraphic = new SettingsImages();
        minimumValueReachedGraphic.maxMinDisplayText("Minimum Value Reached"); 
        happinessNumber = 80;
        happiness = new SettingWorldS1Stats.StatChooseNumber(280, 100, 450, 540, 280, 580, happinessNumber); 

        productivityNumber = 90;
        productivity = new SettingWorldS1Stats.StatChooseNumber(280, 100, 450, 395, 280, 430, productivityNumber);

        gpaNumber = 90;
        gpa = new SettingWorldS1Stats.StatChooseNumber(280, 100, 450, 250, 280, 280, productivityNumber);

        relative1Number = 0 ; 
        relative1 = new SettingWorldS1Stats.StatChooseImage(775, 580, 950, 250, relative1Number); 

        relative2Number = 0;
        relative2 = new SettingWorldS1Stats.StatChooseImage(775, 580, 950, 395, relative2Number); 

        relative3Number = 0;
        relative3 = new SettingWorldS1Stats.StatChooseImage(775, 580, 950, 540, relative2Number); 

    }

    public void act()
    {
        backWorld(); 
        nextWorld(); 
        //productivityChoose(); 
        gpa.choose();
        productivity.choose(); 
        happiness.choose(); 
        relative1.choose(); 
        relative2.choose();
        relative3.choose(); 
    }

    /*
    public void happinessChoose()
    {

    }

    /*
    public void productivityChoose()
    {
    if (Greenfoot.mouseClicked(happinessRight))
    {
    if(happinessNumber == 100)
    {
    addObject(maximumValueReachedGraphic, 280, 580); 
    }
    else
    {
    happinessNumber+=5;
    happiness.numberDisplay(happinessNumber); 
    }

    }
    else if (Greenfoot.mouseClicked(happinessLeft))
    {

    if(happinessNumber ==0)
    {
    addObject(minimumValueReachedGraphic, 280, 580); 
    }
    else
    {
    happinessNumber-=5; 
    happiness.numberDisplay(happinessNumber); 
    }
    }

    }
     */

    /*
    public void gpaChoose()
    {
    if (Greenfoot.mouseClicked(gpaRight))
    {
    if(gpaNumber == 100)
    {
    addObject(maximumValueReachedGraphic, 280, 280); 
    }
    else
    {
    gpaNumber+=5;
    gpa.numberDisplay(gpaNumber); 
    }

    }
    else if (Greenfoot.mouseClicked(gpaLeft))
    {

    if(gpaNumber ==0)
    {
    addObject(minimumValueReachedGraphic, 280, 280); 
    }
    else
    {
    gpaNumber-=5; 
    gpa.numberDisplay(gpaNumber); 
    }
    }
    }
     */ 

    public void backWorld()
    {
        if (Greenfoot.mouseClicked(back))
        {
            Greenfoot.setWorld(new SettingWorldGeneral()); 
        }
    }

    public void nextWorld()
    {
        if (Greenfoot.mouseClicked(next))
        {
            Greenfoot.setWorld(new SettingWorldS2Stats()); 
        }
    }


    private class StatChooseNumber{
        private Button left; 
        private Button right;
        private int number;
        private SettingImages object;
        private int graphicLocationX; 
        private int graphicLocationY;

        public StatChooseNumber(int objectLocationX, int leftLocationX, int rightLocationX, int locationY, int graphicLocationX, int graphicLocationY, int number)
        {
            this.number = number;
            object = new SettingImages(); 
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
