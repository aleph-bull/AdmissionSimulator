import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Depression is a translucent screen that creates Cloud and Shadow objects for visual 
 * effect. It also plays a rain sound?
 * 
 * @author Angela Wang
 * @version April 2025
 */
public class Depression extends Effect
{
    private Student student; 
    private Cloud cloud;
    private Shadow shadow;
    private GreenfootSound sound;
    
    /**
     * Depression constructor - specify room, which Student it is effecting 
     * @param room      1 = top, 2 = bottom
     * @param student   Pass in Student for Cloud + Shadow to follow
     */
    public Depression(int room, Student student){
        super(room, new Color(20, 10, 100, 70));
        this.student = student;
        
        sound = new GreenfootSound("rain.wav");
        sound.setVolume(60);
        
        duration = 60 * 6;
    }
    
    /**
     * Add Cloud and Shadow + start rain sfx when added to world
     * @param w     World Depression is added to
     * @return void
     */
    public void addedToWorld(World w){
        cloud = new Cloud(student);
        shadow = new Shadow(student);
        getWorld().addObject(cloud, 0, 0);
        getWorld().addObject(shadow, 0, 0);
        sound.play();
    }

    /**
     * Act - do whatever the Depression wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
        if (fadingOut){
            cloud.fade(10);
            shadow.fade(10);
            
            //once screen is pretty much faded, stop sound
            if (image.getTransparency() < 20){
                sound.stop();
            }
        }
    }
    
    /**
     * Called in World to pause sound when execution is paused
     * @return void
     */
    public void pauseSound(){
        sound.pause();
    }
    
    /**
     * Called in World to continue playing sound when execution is started again
     * @return void
     */
    public void startSound(){
        sound.play();
    }
}
