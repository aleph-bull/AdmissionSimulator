import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sickness here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sickness extends Effect
{            
    private int actNum;
    private Germ[][] germs;
    private int curIndex, wave;

    public Sickness(int room){
        super(room, new Color(20, 100, 20, 70));

        germs = new Germ[4][3];
        curIndex = 0;

        actNum = 0;
        wave = 0;
    }

    public void addedToWorld(World w){
        for (int col = 0; col < germs[0].length; col++){
            for (int row = 0; row < germs.length; row++){
                int y = 0;
                if (room == 1) y = 90 + 80 * row;
                else y = 480 + 80 * row;
                
                Germ germ = new Germ(y, Greenfoot.getRandomNumber(60) + 90 * col);
                getWorld().addObject(germ, 0, y);
                germs[row][col] = germ;
            }
        }
    }

    /**
     * Act - do whatever the Sickness wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }
}
