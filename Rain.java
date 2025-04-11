import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Angela Wang
 * @version 04.10.25
 */
public class Rain extends EffectItem
{
    private int width, height;
    private static final int PIXEL_WIDTH = 5;
    private static final int PIXEL_HEIGHT = 5;
    private static final Color COLOUR = new Color(222, 239, 245, 120);
    private int speed;
    
    public Rain(int level){
        height = 80;
        width = PIXEL_WIDTH;
        speed = 10;
        
        drawImage();
        
        enableStaticRotation();
        turn(90);
    }
    
    /**
     * Act - do whatever the Rain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(speed);
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
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
}
