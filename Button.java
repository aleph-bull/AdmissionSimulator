import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Buttons darken when the cursor hovers over them, and may do things when clicked.
 * 
 * @author Angela Wang
 * @version 04.09.25 
 */
public class Button extends Actor
{
    private GreenfootImage image, hoverImage;
    private GreenfootSound[] clicks;
    private String text;
    private Font font = new Font(40);
    private Cursor cursor;
    private int curIndex;
    
    //pass the mouse to buttons to know if mouse is hovering
    public Button(Cursor cursor){
        //placeholder images
        image = new GreenfootImage(50, 50);
        image.setColor(Color.BLUE);
        image.fill();
        setImage(image);
        
        hoverImage = new GreenfootImage(50, 50);
        hoverImage.setColor(Color.RED);
        hoverImage.fill();
        
        this.cursor = cursor;
        
        //array of click sounds --> can click quickly
        clicks = new GreenfootSound[10];
        for (int i = 0; i < 10; i++){
            clicks[i] = new GreenfootSound("click.mp3");
        }
        
        curIndex = 0;
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //if the cursor is hovering over the button, change the image
        if (cursor.getHoveredActors().contains(this)){
            setImage(hoverImage);
            
            //if button is clicked, play sound
            if (Greenfoot.mouseClicked(this)){
                curIndex++;
                //if current index exceeds maximum possible index, reset to 0
                if (curIndex > clicks.length - 1){
                    curIndex = 0;
                }
                clicks[curIndex].play();
            }
        } else {
            //if not hovered over, normal image
            setImage(image);
        }
    }
    
}
