import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

//identify if the computer, phone, bed is taken, if not take it

public class Relative extends Animals
{
    private GreenfootImage[] walkAnimations;
    private String fileName;
    private int frames;
    private int curIndex;
    private int countdown;

    public Relative(String file, boolean isTop)
    {
        super(isTop); 

        frames = 0;
        curIndex = 0;
        countdown = 8;

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

    private void prepareAnimations(){
        walkAnimations = new GreenfootImage[frames];

        for (int i = 0; i < frames; i++){
            walkAnimations[i] = new GreenfootImage(fileName + "_run" + (i + 1) + ".png");
            walkAnimations[i].scale(50, 50);
        }

        setImage(walkAnimations[0]);
        curIndex++;
    }

    public void act()
    {
        super.act();

        if (frames > 0){
            animate();
        }
    }

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
