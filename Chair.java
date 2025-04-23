import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chair extends FunctionalItem
{
    private GreenfootImage image;
    public Chair () {
        super();
        image = new GreenfootImage("chair.png");
        setImage(image);
    }
    public void act()
    {
        super.act();
        Animals usr = this.getUser();
        if (usr != null){
            if (usr instanceof Student){
                ((Student)usr).work();
            }
        }
    }
    
    @Override
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
