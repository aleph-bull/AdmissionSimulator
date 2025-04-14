import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public Animals getUser(){
        return this.user;
    }
    
    public void setUser(Animals a){
        isBeingUsed = true;
        user = a;
        usageBar = new SuperStatBar (useActCountDuration, beingUsedActCount, a, 70, 10, -a.getImage().getHeight(),  new Color(50,84,168), Color.BLACK, false, new Color(30,38,59), 3);
        getWorld().addObject(usageBar, a.getX(), a.getY());
    }
    
    public void stopUsing(){
        isBeingUsed = false;
        user.setAction(ActionState.NOTHING);
        beingUsedActCount = 0;
        getWorld().removeObject(usageBar);
        user = null;
    }
}
