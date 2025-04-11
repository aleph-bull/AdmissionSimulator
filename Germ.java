import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Germ here.
 * 
 * @author Angela Wang
 * @version 04.10.25
 */
public class Germ extends EffectItem

{   
    private int vertStretch, vertShift, newX;
    private double horiComp;
    private int delay, acts;

    public Germ(int vertShift, int delay){
        //String fileName = "germ" + (Greenfoot.getRandomNumber(4) + 1) + ".png";
        //image = new GreenfootImage(fileName);
        image = new GreenfootImage("germ1.png");
        image.scale(100, 100);
        image.setTransparency(200);
        setImage(image);

        vertStretch = 15;
        horiComp = 0.02;
        this.vertShift = vertShift;
        acts = 0;
        this.delay = delay;
    }

    /**
     * Act - do whatever the Germ wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        acts++;
        if (acts > delay){
            turn(3);
            newX = getX() + 3;
            setLocation(newX, (int) (vertStretch * (Math.sin(horiComp * (newX))) + vertShift));   

            if (isAtEdge()){
                getWorld().removeObject(this);
            }
        }
    }
}
