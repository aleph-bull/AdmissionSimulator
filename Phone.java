import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Phone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Phone extends FunctionalItem
{
    private GreenfootImage image;
    private boolean soundPlayed = false;
    
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
