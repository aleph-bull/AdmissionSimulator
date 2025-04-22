import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author Angela Wang
 * @version 04.09.25
 */
public class TextBox extends Actor
{
<<<<<<< Updated upstream
    private GreenfootImage image;
    private Font font = new Font(40);
    
    public TextBox(String text, Color color){
        image = new GreenfootImage(800, 500);
        image.setColor(color);
        image.setFont(font);
        image.drawString(text, 100, 100);
=======
    private String dialog;
    private int textIndex = 0;
    private int frameCount = 0;
    private int speed = 3; 
    private int spacePauseDuration = 2; 
    private int lineHeight = 75;
    private int margin = 40; 
    private int maxWidth = 290; 
    private int letterCount = 0; // count of letters typed, used for animation
    private Actor speaker;
    private Color opaqueWhite = new Color(255, 255, 255, 200);
    private boolean isSpacePause = false;
    
    private GreenfootSound dialogueSounds[];
    private int curIndex;

    public Textbox(String dialog, Actor speaker) {
        this.speaker = speaker;
        this.dialog = dialog;
        GreenfootImage image = new GreenfootImage(800, 150);
        image.setColor(opaqueWhite);
        image.fill();
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, image.getWidth()-1, image.getHeight()-1);
>>>>>>> Stashed changes
        setImage(image);
    }
    
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
