import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

//identify if the computer, phone, bed is taken, if not take it

public class Relative extends Animals
{
    private boolean takeSpot;
    //private GreenfootImage image; 
    private String image; 
    private GreenfootImage[] amongusAnimations = new GreenfootImage[3];
    private GreenfootImage[] capybaraAnimations = new GreenfootImage[5];
    private int capybaraFrame, amongusFrame;

    private ActionState curActionState, prevActionState;

    public void act()
    {
        super.act();
        determineRelative(); 
        animate(); 
    }

    public Relative(){
        super();
    }

    public Relative(String image, boolean isTop)
    {
        super(isTop); 
        this.image = image; 
        //setImage(image); 
        capybaraFrame = 0;
        amongusFrame =0; 
    }

    public void determineRelative()
    {
        //anmong us walk animations
        if(image == "amongus")
        {
            String fileName = "amongus";
            for (int j = 0; j < amongusAnimations.length; j++){
                amongusAnimations[j] = new GreenfootImage(fileName + (j + 1) + ".png");
                amongusAnimations[j].scale(35, 55);
                setImage(amongusAnimations[j]);
            }
            setImage(amongusAnimations[0]);

        }

    }

    public void animate()
    {
        if (curActionState == ActionState.NOTHING){
            setImage(capybaraAnimations[capybaraFrame]);
            capybaraFrame++;

            if (capybaraFrame > 3) capybaraFrame = 0;
        } else {
            capybaraFrame = 0;
            setImage(capybaraAnimations[0]);
        }
    }

    public void takeSpot()
    {
        if (takeSpot == true)
        {
            //turn towards other object else go back
        }
    }
}
