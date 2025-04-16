import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Animals here.
 * 
 * @author Daniel Wang, Zachary Zhao
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
    
    public Animals (boolean isTop) {
        image.setColor(Color.RED);
        image.fill();
        setImage(image);
        maxSpeed = 5;
        speed = maxSpeed;
        setRandomCooldown (); // random number from 200-500
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
    
    // changes direction completely randomly
    public void setRandomDirection (int range) {
        int randomDirection = movementDirection + Greenfoot.getRandomNumber(range+1) - (range/2);
        setDirection(randomDirection);
    }
    
    public void setDirection(int direction) {
        movementDirection = direction;
        if(movementDirection >= 360) {
            movementDirection -= 360; //keeps within the 360 degree unit circle
        } else if(movementDirection < 0) {
            movementDirection += 360;
        }
        movementDirectionInRadians = (double)movementDirection * (Math.PI/180);
        updateDyDx (); // updates the actual direction values to match
    }
    
    public void setRandomCooldown () {
        changeDirectionCooldown = Greenfoot.getRandomNumber(1001) + 500; // random number from 500-1000
    }
    
    public void setAction(ActionState action) {
        currentAction = action;
    }
    
    protected void checkHitObject() {
        ArrayList<Item> items = (ArrayList<Item>) getIntersectingObjects(Item.class);
    
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
    
    public void updateDyDx () {
        dx = Math.cos(movementDirectionInRadians) * 100;
        dy = Math.sin(movementDirectionInRadians) * 100;
    }

    /**
     * Get the current x direction
     * @return double dx 
     */
    public double getDx(){
        return dx;
    }

    /**
     * Get current y direction
     * @return double dy
     */
    public double getDy(){
        return dy;
    }

    /**
     * Get current ActionState 
     * @return ActionState currentAction
     */
    public ActionState getActionState(){
        return currentAction;
    }
}