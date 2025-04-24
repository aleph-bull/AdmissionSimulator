import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Stephanie Xia
 * @ 4.23.2025
 */
public abstract class SettingsWorld extends World
{
    protected Cursor cursor;
    protected GreenfootImage background;
    protected Button next; 
    protected Button back;
    protected SettingsImages maximumValueReachedGraphic;
    protected SettingsImages minimumValueReachedGraphic;
    protected GreenfootImage image;
    protected static GreenfootSound music = new GreenfootSound("settingsmusic.mp3");

    //repeated method for most of the subclasses
    protected abstract void backWorld();

    protected abstract void nextWorld();

    public SettingsWorld()
    {    
        super(1024, 800, 1); 
        cursor = new Cursor();
        addObject(cursor, 0, 0);
        //creates the 'Maxmium Value Reached' and 'Minimum Value Reached' Graphic for the settings with number classes
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

    //nested class (taught by Mr. Poon)
    protected class StatChooseImage
    {
        private Button left; 
        private Button right;
        private int number; 
        private SettingsImages object; 
        private String choosenImage; 

        //several constructors used for different purposes within the world

        //used buttons
        public StatChooseImage(int objectLocationX, int leftLocationX, int rightLocationX, int locationY, int number)
        {
            this.number = number; 
            object = new SettingsImages(); 
            addObject(object, objectLocationX, locationY); 
            left = new Button(cursor, true); 
            right = new Button(cursor, false);
            addObject(left, leftLocationX, locationY); 
            addObject(right, rightLocationX, locationY); 
        }

        //used for image displays
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

        //used for selecting a settings placement of four images, the boolean to indicate whether or not it is for the university image
        // in order to choose scaling

        protected void choose(String image1, String image2, String image3, String image4, boolean isUniversity)
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
                object.setImageFile(image1, isUniversity);
                choosenImage = image1;
            }
            else if (number%4==1 || number%4==-1)
            {
                object.setImageFile(image2, isUniversity); 
                choosenImage = image2;
            }
            else if (number%4 == 2 || number%4==-2)
            {
                object.setImageFile(image3, isUniversity); 
                choosenImage = image3;
            }
            else if(number%4 == 3 || number%4==-3)
            {
                object.setImageFile(image4, isUniversity); 
                choosenImage = image4;
            }
        }

        //used for selecting settings placement for 6 images
        protected void choose(String image1, String image2, String image3, String image4, String image5, String image6)
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
                choosenImage = image1;
            }
            else if (number%6==1 || number%6==-1)
            {
                object.setImageFile(image2); 
                choosenImage = image2;
            }
            else if (number%6 == 2 || number%6==-2)
            {
                object.setImageFile(image3); 
                choosenImage = image3;
            }
            else if (number%6 == 3 || number%6==-3)
            {
                object.setImageFile(image4); 
                choosenImage = image4; 
            }
            else if (number%6 == 4 || number%6==-4)
            {
                object.setImageFile(image5); 
                choosenImage = image5;
            }
            else if (number%6 == 5 || number%6==-5)
            {
                object.setImageFile(image6); 
                choosenImage = image6;
            }
        }

        protected int getNumber()
        {
            return number; 
        }

        protected String getChoosenImage()
        {
            return choosenImage; 
        }
    }
    //another nested loop for numbers instead of images
    protected class StatChooseNumber{
        private Button left; 
        private Button right;
        private int number;
        private SettingsImages object;
        private int graphicLocationX; 
        private int graphicLocationY;

        //constructor for buttons
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

        //choosing the numbers on a 100 scale
        protected void choose()
        {
            if (Greenfoot.mouseClicked(right))
            {
                //if the user trys to add more at 100, it will show a graphic indicating maximum value
                if(number == 100)
                {
                    showMaximumValue();
                }
                else
                {
                    //add 5 for each click and display the number
                    number+=5;
                    object.numberDisplay(number); 
                }

            }
            else if (Greenfoot.mouseClicked(left))
            {

                if(number ==0)
                {
                    //if the user trys to minus less at 0, it will show a graphic indicating minimum value

                    showMinimumValue(); 
                }
                else
                {
                    //minus 5 for each decrease and display number
                    number-=5; 
                    object.numberDisplay(number); 
                }
            }
        }

        //creating the graphics for maxmium value and minimuum value
        public void showMaximumValue()
        {
            maximumValueReachedGraphic = new SettingsImages();
            maximumValueReachedGraphic.maxMinDisplayText("Maximum Value Reached");
            addObject(maximumValueReachedGraphic, graphicLocationX, graphicLocationY); 
        }

        public void showMinimumValue()
        {
            minimumValueReachedGraphic = new SettingsImages();
            minimumValueReachedGraphic.maxMinDisplayText("Minimum Value Reached"); 
            addObject(minimumValueReachedGraphic, graphicLocationX, graphicLocationY); 
        }

        public int getNumber()
        {
            return number; 
        }
    }
}
