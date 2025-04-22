import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

//identify if the computer, phone, bed is taken, if not take it

public class Relative extends Animals
{
    private boolean takeSpot;
    private GreenfootImage[] walkAnimations;
    private String fileName;
    private int frames;
    private int curIndex;
    private int direction;
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
        } else if (file.contains("brother")){
            fileName = "brother.png";
        } else if (file.contains("amongus")){
            fileName = "amongus";
            frames = 3;
        } else {
            fileName = "Cat.png";
        }
        
        if (frames > 0) prepareAnimations(); else setImage(fileName);
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
