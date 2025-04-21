import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

//identify if the computer, phone, bed is taken, if not take it

public class Relative extends Animals
{
    private boolean takeSpot;
    public GreenfootImage image; 

    public void act()
    {
        super.act();
    }
    
    public Relative(){
        super();
    }

    public Relative(String image, boolean isTop)
    {
        super(isTop); 
        this.image = new GreenfootImage (image); 
        setImage(image); 
    }

    public void takeSpot()
    {
        if (takeSpot == true)
        {
            //turn towards other object else go back
        }
    }
}
