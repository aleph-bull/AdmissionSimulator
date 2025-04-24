import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Phone causes Brainrotting, dropping Student Gpa but increasing their happiness. It 
 * can also be used by Relatives.
 * 
 * @author Ethan Ren, Angela Wang
 * @version April 2025
 */
public class Phone extends FunctionalItem
{
    private GreenfootImage image;
    private boolean soundPlayed = false;
    
    /**
     * Phone constructor
     */
    public Phone () {
        super();
        image = new GreenfootImage("phone.png");
        setImage(image);
        sound = new GreenfootSound("phone.wav");
    }
    
    public void act()
    {
        Animals usr = this.getUser();
        if (usr != null){
    
            if (usr instanceof Student){
                ((Student)usr).usePhone();
            }
            
            //only play sound once, when someone first uses phone
            if (!soundPlayed){
                sound.play();
            }
        } else {
            //reset soundplayed when there is no user
            soundPlayed = false;
        }
        super.act();
    }
}
