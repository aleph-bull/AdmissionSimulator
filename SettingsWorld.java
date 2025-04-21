import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class SettingsWorld extends World
{

    /**
     * Constructor for objects of class SettingsWorld.
     * 
     */
    protected Cursor cursor;
    protected GreenfootImage background;
    protected Button next; 
    protected Button back;
    protected SettingsImages maximumValueReachedGraphic;
    protected SettingsImages minimumValueReachedGraphic;
    
    protected static GreenfootSound music = new GreenfootSound("settingsmusic.mp3");

    protected abstract void backWorld();

    protected abstract void nextWorld();

    public SettingsWorld()
    {    
        super(1024, 800, 1); 
        cursor = new Cursor();
        addObject(cursor, 0, 0);
        maximumValueReachedGraphic = new SettingsImages();
        maximumValueReachedGraphic.maxMinDisplayText("Maximum Value Reached");

        minimumValueReachedGraphic = new SettingsImages();
        minimumValueReachedGraphic.maxMinDisplayText("Minimum Value Reached"); 
        
        music.playLoop();
    }
    
    public void started(){
        music.playLoop();
    }
    
    public void stopped(){
        music.stop();
    }

    protected class StatChooseImage
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

        public StatChooseImage(int objectLocationX, int leftLocationX, int rightLocationX, int locationYButton, int locationYObject, int number)
        {
            this.number = number; 
            object = new SettingsImages(); 
            object.setImageFile("Cat.png"); 
            addObject(object, objectLocationX, locationYObject); 
            left = new Button(cursor, true); 
            right = new Button(cursor, false);
            addObject(left, leftLocationX, locationYButton); 
            addObject(right, rightLocationX, locationYButton); 
        }

        protected void choose(String image1, String image2, String image3)
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
                object.setImageFile(image1); 
            }
            else if (number%4==1 || number%4==-1)
            {
                object.setImageFile(image2); 
            }
            else if (number%4 == 2 || number%4==-2)
            {
                object.setImageFile(image3); 
            }
        }

        protected void choose(String image1, String image2, String image3, String image4)
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
                object.setImageFile(image1); 
            }
            else if (number%4==1 || number%4==-1)
            {
                object.setImageFile(image2); 
            }
            else if (number%4 == 2 || number%4==-2)
            {
                object.setImageFile(image3); 
            }
            else if (number%4 == 3 || number%4==-3)
            {
                object.setImageFile(image4); 
            }

        }
    }
    protected class StatChooseNumber{
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

        protected void choose()
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
}
