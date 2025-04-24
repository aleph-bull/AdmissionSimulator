import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**

 * Chair occupation determines if a Student/Relative is using the Computer.
 * 
 * @author Ethan Ren, Angela Wang 
 * @version April 2025

 */
public class Chair extends FunctionalItem
{
    private GreenfootImage image;
    /**
     * Chair constructor
     */
    public Chair () {
        super();
        image = new GreenfootImage("chair.png");
        setImage(image);
        sound = new GreenfootSound("typing.wav");

    }

    /**
     * Act - if someone is using the computer, play typing sounds. If it is a student,
     * increase gpa/decrease happiness?
     */
    public void act()
    {
        super.act();
        Animals usr = this.getUser();
        if (usr != null){
            if (!sound.isPlaying()){
                sound.play();
            } 
            if (usr instanceof Student){
                ((Student)usr).work();
            }
        } else {
            //stop sound if no user
            sound.stop();
        }
    }

    @Override
    /**
     * @param a
     * @return void
     */
    public void setUser(Animals a) {
        isBeingUsed = true;
        user = a;
        if(a instanceof Student) {
            Student student = (Student) a;
            useActCountDuration = (int)(student.getProductivity()*2.0);
        }
        if(a.getImage() != null)
            usageBar = new SuperStatBar (useActCountDuration, beingUsedActCount, a, 70, 10, -a.getImage().getHeight(),  new Color(50,84,168), Color.BLACK, false, new Color(30,38,59), 3);

        getWorld().addObject(usageBar, a.getX(), a.getY());
    }
}
