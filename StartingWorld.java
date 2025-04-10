import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartingWorld here.
 * 
 * @author Angela Wang
 * @version 04.09.25
 */
public class StartingWorld extends World
{
    private GreenfootImage image;
    private TextBox title;
    private Button button;
    private Cursor cursor;

    /**
     * Constructor for objects of class StartingWorld.
     * 
     */
    public StartingWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        
        //random placeholder image
        image = new GreenfootImage("emptyBackground.png");
        setBackground(image);

        //title + start
        //OBVIOUSLY VERY SCUFFED but this was mostly to test TextBox
        title = new TextBox("College Admissions Simulator", Color.BLACK);
        addObject(title, getWidth() / 2, 400);

        TextBox startText = new TextBox("Press [e] to start", Color.BLACK);
        addObject(startText, 660, 750);
    }

    public void act(){
        if (Greenfoot.isKeyDown("e")){
            Greenfoot.setWorld(new SettingsWorld());
            //end music
        }
    }
}
