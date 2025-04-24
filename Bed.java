import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bed. Used when a player comes in contact with a bed, increases happiness on student class
 * 

 * @author Zachary Zhao, Ethan Ren, Angela Wang
 */
public class Bed extends FunctionalItem
{
    private GreenfootImage image;

    /**
     * Bed constructor
     */
    public Bed(){
        super();
        image = new GreenfootImage("bed.png");
        setImage(image);
        sound = new GreenfootSound("snore.mp3");
        sound.setVolume(40);
    }

    /**
     * Act - if someone is on the bed, play sleeping sound. If it is a student, they 
     * gain happiness.
     */
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

    /**
     * Sets location to specific area when kicking off animals
     */

    @Override
    /**
     * Relative kicks Student out
     * @return void
     */
    public void stopUsing() {
        // push off the user and send them toward a random direction away from the bed
        user.setLocation(getX() + 80, getY());
        user.setDirection(0);
        user.setRandomDirection(60);

        super.stopUsing();
    }
}
