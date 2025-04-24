import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bed extends FunctionalItem
{
    private GreenfootImage image;

    public Bed(){
        super();
        image = new GreenfootImage("bed.png");
        setImage(image);
        sound = new GreenfootSound("snore.mp3");
        sound.setVolume(60);
    }

    public void act()
    {
        if (user != null){
            //play sleep sound
            if (!sound.isPlaying()){
                sound.play();
            }

            if (user instanceof Student){
                ((Student)user).rest();
            }
        } else {
            sound.stop();
        }
        super.act();
    }

    @Override
    public void stopUsing() {
        // push off the user and send them toward a random direction away from the bed
        user.setLocation(getX() + 80, getY());
        user.setDirection(0);
        user.setRandomDirection(60);

        super.stopUsing();
    }
}
