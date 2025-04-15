import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Angela Wang
 * @version 04.10.25
 */
public class Rain extends EffectItem
{
    private int width, height;
    private static final int PIXEL_WIDTH = 3;
    private static final int PIXEL_HEIGHT = 3;
    private static final Color COLOUR = new Color(222, 239, 245, 150);
    
    //to keep rain in bounds of room
    public static final int R1_BORDER_Y = 390;
    private int edge;
    
    public Rain(){
        height = 20;
        width = PIXEL_WIDTH;
                
        enableStaticRotation();
        turn(90);
        
        drawImage();
    }
    
    public void addedToWorld(World w){
        if (getY() < R1_BORDER_Y){
            //if starting above room 1 border, rain is in room 1
            edge = R1_BORDER_Y;
        } else {
            //rain is in room 2 --> disappear at world edge
            edge = getWorld().getHeight();
        }
    }
    
    /**
     * Act - do whatever the Rain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(6);
        checkEdge();
    }
    
    //draw rain image based on width and height
    protected void drawImage(){
        image = new GreenfootImage(width, height);
        image.setColor(COLOUR);
        
        int numRects = width / PIXEL_WIDTH;
        int rectHeight = height / numRects;
        
        int currentY = 0;
        for (int currentX = 0; currentX < width; currentX += PIXEL_WIDTH){
            image.fillRect(currentX, currentY, PIXEL_WIDTH, rectHeight);
            currentY += rectHeight;
        }
        setImage(image);
    }
    
    private void checkEdge(){
        //remove rain at bottom of room
        if (getY() >= edge){
            getWorld().removeObject(this);
        }
    }
}
