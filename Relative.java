import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

//identify if the computer, phone, bed is taken, if not take it

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
    private GreenfootImage[] walkAnimations;
    private String fileName;
    private int frames;
    private int curIndex;
    private int countdown;

    /**
     * Relative constructor - specify file Image (selected in MainWorld based on user selections 
     * in setting worlds) and room
     * @param file      Image file
     * @param isTop     True if student is in top room, false if otherwise
     */
    public Relative(String file, boolean isTop)
    {
        super(isTop); 

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
            fileName = "sister.png";
        } else if (file.equals("Mom.png")){
            fileName = "Mom.png";
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
            GreenfootImage stillImage = new GreenfootImage(fileName);
            if (!fileName.equals("Cat.png")){
                stillImage.scale(50, 60);
            }
            setImage(stillImage);
        }
    }

    //fill in animation frames
    private void prepareAnimations(){
        walkAnimations = new GreenfootImage[frames];

        for (int i = 0; i < frames; i++){
            walkAnimations[i] = new GreenfootImage(fileName + "_run" + (i + 1) + ".png");
            walkAnimations[i].scale(50, 50);
        }

        setImage(walkAnimations[0]);
        curIndex++;
    }

    /**
     * Act - wander room, change frames 
     * @return void
     */
    public void act()
    {
        super.act();

        if (frames > 0){
            animate();
        }
    }

    //change frame when countdown is finished
    private void animate()
    {
        if (countdown > 0){
            countdown--;
        } else {
            setImage(walkAnimations[curIndex]);
            curIndex++;
            if (curIndex == frames) curIndex = 0;

            countdown = 8;
        }
    }
}
