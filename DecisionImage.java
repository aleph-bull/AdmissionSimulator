import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** 
 * @Stephanie Xia
 * @ 4.23.2025
 */
public class DecisionImage extends Actor
{
    private GreenfootImage decisionImage; 
    private GreenfootImage decisionTextImage;

    //if the get accepted show acceptedImage; if they are rejected get rejectedImage
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
