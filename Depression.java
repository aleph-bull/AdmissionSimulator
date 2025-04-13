import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Depression here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Depression extends Effect
{
    private Student student; 
    private Cloud cloud;
    private Shadow shadow;
    
    public Depression(int room, Student student){
        super(room, new Color(20, 10, 100, 70));
        this.student = student;
    }
    
    public void addedToWorld(World w){
        cloud = new Cloud(student);
        shadow = new Shadow(student);
        getWorld().addObject(cloud, 0, 0);
        getWorld().addObject(shadow, 0, 0);
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
        }
    }
}
