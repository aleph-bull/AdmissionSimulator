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
    
    public Item(){
        beingUsedActCount = 0;
        isBeingUsed = false;
        useActCountDuration = 100; // default, but can be overridden
    }
    
    public void act()
    {
        if(isBeingUsed) {
            beingUsedActCount++;
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
    }
    
    public void stopUsing(){
        isBeingUsed = false;
        user.setAction(ActionState.NOTHING);
        beingUsedActCount = 0;
        user = null;
    }
    
    public boolean isOccupied(){
        return this.isBeingUsed;
    }
}
