import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Class of all animals, students, relatives alike. Random movement and ability to use 
 * objects.
 * 
 * @author Daniel Wang, Zachary Zhao, Ethan Ren
 * @version 1.1.1
 */
public abstract class Animals extends SuperSmoothMover
{
    private GreenfootImage image = new GreenfootImage(35, 35); // temp placeholder, remove later
    private double dy, dx; //direction values involved with movement
    protected double maxSpeed;
    protected double speed;
    protected int actCount;
    private int changeDirectionCooldown;
    private boolean justHitX, justHitY;
    private boolean isInTopRoom;    // coordinates of top room are top left (36, 168) and bottom right (736, 382) 
                                    // coordinates of bottom room are top left (36, 551) and bottom right (736, 763)
    private int []  topRoomTopLeft = {36, 168},
                    topRoomBottomRight = {736, 382},
                    BottomRoomTopLeft = {36, 551},
                    BottomRoomBottomRight = {736, 763};
    
    protected Item itemInUse;
    protected ActionState lastAction;
    
    protected ActionState currentAction = ActionState.NOTHING;
    
    //boolean needed for battle
    protected boolean inBattle = false;
    
    /**
     * Animals constructor 
     */
    public Animals(){
        setImage(image);
        maxSpeed = 5;
        speed = maxSpeed;
        inBattle = true;
    }
    
    /**
     * Main Animals constructor - specify what room Animal is in
     * @param isTop     True if in top room
     */
    public Animals (boolean isTop) {
        maxSpeed = 5;
        speed = maxSpeed;
        setRandomCooldown(); // random number from 200-500
        setRandomDirection(360);
        isInTopRoom = isTop;
    }
    
    public void act()
    {   
        if(currentAction == ActionState.NOTHING) {
            moveToward(speed, getPreciseX() + dx, getPreciseY() - dy);
            if(actCount % changeDirectionCooldown == 0) {
                setRandomCooldown ();
                setRandomDirection(100);
            }
            if (isInTopRoom){
                hitEdge(topRoomTopLeft, topRoomBottomRight);
            } else {
                hitEdge(BottomRoomTopLeft, BottomRoomBottomRight);
            }
        } else {
             if (itemInUse != null){
                if (itemInUse.getUser() == null) {
                    setLocation(itemInUse.getX(), itemInUse.getY());
                    itemInUse.setUser(this);
                }
            }
        }
        checkHitObject();
        actCount++;
    }
    
    /**
     * Checks if the character has hit an edge between a set of coordinates
     * @param rangeX
     * @param rangeY
     * @param xOffset
     * @param yOffset
     */
    public boolean hitEdge(int rangeX, int rangeY, int xOffset, int yOffset) {
        // rangeX and rangeY is the area of the space considered to be the edge
        boolean bounced = false;
        
        if (getPreciseX() - image.getWidth()/2 <= xOffset || getPreciseX() + image.getWidth()/2 >= rangeX + xOffset) {
            movementDirection = 180 - movementDirection;
            //reflect horizontally
            bounced = true;
        }
    
        if (getPreciseY() - image.getHeight()/2 <= yOffset || getPreciseY() + image.getHeight()/2 >= rangeY + yOffset) {
            movementDirection = 360 - movementDirection;
            //reflect vertically
            bounced = true;
        }
    
        if (bounced) {          
            movementDirectionInRadians = Math.toRadians(movementDirection); // java trig is in radians so
            updateDyDx();
    
            // nudge inward slightly to prevent sticking
            setLocation(getPreciseX() + dx * 0.01, getPreciseY() - dy * 0.01);
        }
    
        return bounced;
    }
    
    /**
     * Version of hit edge that takes 2D coordinates for easier use.
     * @param topLeft       
     * @param bottomRight
     * @return boolean
     */
    //a version of hit edge that takes in 2D coordinates (x, y) instead of that range stuff
    public boolean hitEdge(int[] topLeft, int[] bottomRight) {
        if(topLeft.length != 2 || bottomRight.length != 2) {
            System.out.println("ERROR! hitEdge(int[] topLeft, int[] bottomRight) can only take in arrays with size of 2!\n(x, y) format");
            System.exit(0);
            return false;
        }
        int xOffset = topLeft[0], yOffset = topLeft[1];
        int rangeX = bottomRight[0] - xOffset, rangeY = bottomRight[1] - yOffset;
        return hitEdge(rangeX, rangeY, xOffset, yOffset);
        
    }
    
    /**
     * Changes direction to a random location within a range.
     * @param range
     * @return void
     */
    public void setRandomDirection (int range) {
        int randomDirection = movementDirection + Greenfoot.getRandomNumber(range+1) - (range/2);
        setDirection(randomDirection);
    }
    
    /**
     * Sets to a specific direction
     * @param direction      
     * @return void
     */
    public void setDirection(int direction) {
        movementDirection = direction;
        if(movementDirection >= 360) {
            movementDirection -= 360; //keeps within the 360 degree unit circle
        } else if(movementDirection < 0) {
            movementDirection += 360;
        }
        
        if (movementDirection <= 95 && movementDirection >= 85){
            int random = Greenfoot.getRandomNumber(2);
            if (random == 0) movementDirection = 95; else movementDirection = 85;
        } else if (movementDirection <= 280 && movementDirection >= 265){
            int random = Greenfoot.getRandomNumber(2);
            if (random == 0) movementDirection = 280; else movementDirection = 260;
        }
        
        movementDirectionInRadians = (double)movementDirection * (Math.PI/180);
        updateDyDx (); // updates the actual direction values to match
    }
    
    /**
     * Generate random cooldown
     * @return void
     */
    public void setRandomCooldown () {
        changeDirectionCooldown = Greenfoot.getRandomNumber(1001) + 500; // random number from 500-1000
    }
    
    /**
     * Set ActionState
     * @param action        new ActionState
     * @return void
     */
    public void setAction(ActionState action) {
        currentAction = action;
    }
    
    /**
     * Freezes Animal 
     * @return void
     */
    public void stopMoving() {
        speed = 0;
    }
    
    /**
     * Moves Animal again (speed = max)
     * @return void
     */
    public void resumeMoving() {
        speed = maxSpeed;
    }
    
    protected void checkHitObject() {
        ArrayList<FunctionalItem> items = (ArrayList<FunctionalItem>) getIntersectingObjects(FunctionalItem.class);
    
        if (items.size() == 0) {
            currentAction = ActionState.NOTHING;
            itemInUse = null;
            return;
        }
    
        Item hitItem = items.get(0); // Only consider the first intersecting item
    
        // If this is a different item than the one we used before, and someone else is using it, just pass through
        if (hitItem != itemInUse && hitItem.getUser() != null && hitItem.getUser() != this) {
            currentAction = ActionState.NOTHING;
            itemInUse = null;
            return;
        }
        if(hitItem instanceof Bed){
            if(itemInUse != hitItem){
                if (lastAction != ActionState.SLEEPING){
                    currentAction = ActionState.SLEEPING;
                    lastAction = ActionState.SLEEPING;
                    itemInUse = hitItem;
                }
            }
        } else if(hitItem instanceof Chair){
            if(itemInUse != hitItem){
                if (lastAction != ActionState.WORKING){
                    currentAction = ActionState.WORKING;
                    lastAction = ActionState.WORKING;
                    itemInUse = hitItem;
                }
            }
        } else if (hitItem instanceof Phone){
            if (itemInUse != hitItem){
                if (lastAction != ActionState.BRAINROTTING){
                    currentAction = ActionState.BRAINROTTING;
                    lastAction = ActionState.BRAINROTTING;
                    itemInUse = hitItem;
                }
            }
        }
    }
    
    /**
     * Get current action state
     * @return ActionState currentAction
     */
    public ActionState getCurrentAction() {
        return currentAction;
    }
    
    /**
     * Update dx dy?
     * @return void
     */
    public void updateDyDx () {
        dx = Math.cos(movementDirectionInRadians) * 100;
        dy = Math.sin(movementDirectionInRadians) * 100;
    }

    /**
     * Return direction in radians
     * @return double
     */
    public double getDirectionInRadians(){
        return movementDirectionInRadians;
    }
}