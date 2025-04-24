import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent class, handles Item usage. Unique stats to each funcitonalitem.
 * 
 * @author Zachary Zhao, Ethen Ren
 */
public class Item extends Actor
{
    protected boolean isBeingUsed;
    protected Animals user;
    protected int posX;
    protected int posY;
    protected int beingUsedActCount;
    protected int useActCountDuration;
    protected SuperStatBar usageBar;
    
    /**
     * Item constructor
     */
    public Item(){
        beingUsedActCount = 0;
        isBeingUsed = false;
        useActCountDuration = 100; // default, but can be overridden
    }
    
    public void act()
    {
        if(isBeingUsed) {
            beingUsedActCount++;
            usageBar.update(beingUsedActCount);
            // when the act count exceeds duration, get off
            if(beingUsedActCount >= useActCountDuration) {
                beingUsedActCount = 0;
                stopUsing();
            }
        }
    }
    
    /**
     * Returns a user of Item
     * @return Animals  Item user
     */
    public Animals getUser(){
        return this.user;
    }
    
    /**
     * Sets an animal as a user and creates a stat bar
     * @param a     Animal to be set as User
     * @return void
     */
    public void setUser(Animals a){
        isBeingUsed = true;
        user = a;
        if(a.getImage() != null)
            usageBar = new SuperStatBar (useActCountDuration, beingUsedActCount, a, 70, 10, -a.getImage().getHeight(),  new Color(50,84,168), Color.BLACK, false, new Color(30,38,59), 3);
        
        getWorld().addObject(usageBar, a.getX(), a.getY());
    }
    
    /**
     * Kicks off the animal that is using the bar
     * @return void
     */
    public void stopUsing(){
        isBeingUsed = false;
        user.setAction(ActionState.NOTHING);
        beingUsedActCount = 0;
        getWorld().removeObject(usageBar);
        user = null;
    }
    
    /**
     * Returns a boolean value to prevent simultaneous usage
     * @return boolean      True if Item is being used
     */
    public boolean isOccupied(){
        return this.isBeingUsed;
    }
}
