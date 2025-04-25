import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Relatives try to hinder/encourage Student progress by taking over their 
 * bed/computer/phone. May??? collide with wall and briefly oscillate before escaping
 * 
 * @author Angela Wang
 * @version April 2025
 * 
 */

public class Relative extends Animals
{
    private GreenfootImage[][] walkAnimations;
    private GreenfootImage rightFacingImg, leftFacingImg;
    private String fileName;
    private int frames;
    private int curIndex;
    private int countdown;

    private int prevDir, curDir;

    /**
     * Relative constructor - specify file Image (selected in MainWorld based on user selections 
     * in setting worlds) and room
     * @param file      Image file
     * @param isTop     True if student is in top room, false if otherwise
     */
    public Relative(String file, boolean isTop)
    {
        super(isTop); 

        prevDir = 1;
        curDir = 1;

        frames = 0;
        curIndex = 0;
        countdown = 8;

        //since things with animation have _run1, _run2 etc check if file contains
        //some base name
        fileName = "";
        if (file.contains("minicapy")){
            fileName = "minicapy";
            frames = 5;
        } else if (file.contains("sister")){
            fileName = file;
        } else if (file.equals("Mom.png")){
            fileName = file;
        } else if (file.contains("amongus")){
            fileName = "amongus";
            frames = 3;
        } else if (file.equals("Cat.png")){
            fileName = "Cat.png";
        }

        //prep animations if there are multiple other frames, otherwise set the image
        if (frames > 0) {
            prepareAnimations();
        } else {
            rightFacingImg = new GreenfootImage(fileName);
            leftFacingImg = new GreenfootImage(fileName);
            leftFacingImg.mirrorHorizontally();
            if (!fileName.equals("Cat.png")){
                rightFacingImg.scale(45, 55);
                leftFacingImg.scale(45, 56);
            }
            setImage(rightFacingImg);
        }
    }

    //fill in animation frames
    private void prepareAnimations(){
        walkAnimations = new GreenfootImage[2][frames];

        for (int j = 0; j < 2; j++){
            for (int i = 0; i < frames; i++){
                walkAnimations[j][i] = new GreenfootImage(fileName + "_run" + (i + 1) + ".png");
                walkAnimations[j][i].scale(50, 50);
                //0th row: right-facing animation
                //1st row: left-facing animation
                if (j == 0){
                    walkAnimations[j][i].mirrorHorizontally();
                }
            }
        }

        setImage(walkAnimations[0][0]);
        curIndex++;
    }

    /**
     * Act - wander room, change frames 
     * @return void
     */
    public void act()
    {
        super.act();

        //if curDir 1: going right, else going left
        if (Math.cos(getDirectionInRadians()) >= 0){
            curDir = 1;
        } else {
            curDir = -1;
        }

        if (frames > 0){
            animate();
        } else {
            //going right: set right img
            if (curDir == 1 && curDir != prevDir){
                setImage(rightFacingImg);
            } else if (prevDir != curDir){
                //going left: set left img
                setImage(leftFacingImg);
            }
        }

        prevDir = curDir;
    }

    //change frame when countdown is finished
    private void animate()
    {
        if (countdown > 0){
            countdown--;
        } else {
            int row = curDir == 1 ? 0 : 1;

            if (getCurrentAction() == ActionState.NOTHING){
                setImage(walkAnimations[row][curIndex]);
                curIndex++;
                if (curIndex == frames) curIndex = 0;

                countdown = 8;
            } else {
                curIndex = 0;
                setImage(walkAnimations[row][curIndex]);
            }

        }
    }
}
