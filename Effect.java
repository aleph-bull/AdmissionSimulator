import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Effect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Effect extends Actor
{   
    protected GreenfootImage image;
    private int newTransparency;
    protected Color colour;

    //know room, screen coordinates
    private int y;
    public static final int ROOM_1_Y = 208;
    public static final int ROOM_X = 395;
    public static final int ROOM_2_Y = 586;
    protected int room;
    protected int duration;

    private int acts;

    protected boolean fadingIn, fadingOut;

    public Effect(int room, Color colour){
        this.colour = colour;
        drawImage();

        this.room = room;
        
        y = room == 1? ROOM_1_Y : ROOM_2_Y;

        acts = 0;

        fadingIn = true;
        fadingOut = false;
    }

    /**
     * Act - do whatever the Effect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        acts++;
        if (acts >= duration){
            fadingOut = true;
        }

        if (fadingIn){
            fadeIn();
        } else if (fadingOut){
            fadeOut();
        }
    }

    private void fadeIn(){
        newTransparency = image.getTransparency() + 10;
        if (newTransparency > 255){
            newTransparency = 255;
            fadingIn = false;
        }

        image.setTransparency(newTransparency);
        setImage(image);
    }

    private void fadeOut(){
        newTransparency = image.getTransparency() - 10;
        if (newTransparency <= 0){
            getWorld().removeObject(this);
            return;
        }
        image.setTransparency(newTransparency);
        setImage(image);
    }

    protected void drawImage(){
        image = new GreenfootImage(750, 365);
        image.setColor(colour);
        image.fill();
        image.setTransparency(0);
        setImage(image);
    }
}
