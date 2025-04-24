import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** 
 * 
 * EndingWorld rejection/acception images
 * Also probably could have been Image but it's too late to change now </3
 * 
 * @author Stephanie Xia
 * @version 4.23.2025
 */
public class DecisionImage extends Actor
{
    private GreenfootImage decisionImage; 
    private GreenfootImage decisionTextImage;

    /**
     * DecisionImage constructor - if the get accepted show acceptedImage; 
     * if they are rejected get rejectedImage
     * 
     * @param isAccepted    True if accepted into university
     */
    public DecisionImage(boolean isAccepted)
    {
        if(isAccepted == true)
        {
            decisionImage = new GreenfootImage("AcceptedImage.png");
            setImage(decisionImage);
        }
        else
        {
            decisionImage = new GreenfootImage("RejectedImage.png");
            setImage(decisionImage); 
        }
    }
}
