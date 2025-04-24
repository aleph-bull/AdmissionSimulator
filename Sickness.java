import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sickness is another Effect screen that prepares Germs for visual effect. The screen 
 * may fade out slightly before/after the germs finish moving across the screen 
 * just because of some random time generation stuff with germ movement?
 * 
 * @author Angela Wang
 * @version April 2025
 */
public class Sickness extends Effect
{            
    private int actNum;
    private Germ[][] germs;
    private int curIndex, wave;
    
    /**
     * Sickness - specify which room Effect is happening in
     * @param room  1 = top, 2 = bottom
     */
    public Sickness(int room){
        super(room, new Color(20, 100, 20, 70));

        germs = new Germ[4][3];
        curIndex = 0;

        actNum = 0;
        wave = 0;

        duration = 60 * 7; 
    }

    /**
     * Once added to the world, prepares a 2D array of germs. This is so you can 
     * launch one column of germs at a time to create the effect of different waves/just 
     * separate the germs from one another a bit without resorting to random y coordinates
     * @param w     World added to
     * @return void
     */
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
