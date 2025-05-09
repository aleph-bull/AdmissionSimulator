import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Basic text creator, no box, no typewriter. Useful for custom fonts and when background
 * is not needed.
 * 
 * @author Zachary Zhao
 */
public class BasicText extends Actor
{
    private GreenfootImage image; 
    private Font font;
    private Color color;
    
    /**
     * BasicText constructor 
     * @param text  Text to display
     * @param font  Font of drawn text
     * @param color Text color
     */
    public BasicText (String text, Font font, Color color) {
         this.font = font;
         this.color = color;
         updateText(text);
    }
    
    /**
     * Simple updateText method - only specify text to update with
     * @param text  New text
     * @return void
     */
    public void updateText(String text) {
         updateText(text, color);
    }
    
    /**
     * Recreates the text image with color and string options.
     * @param text  New text
     * @param color Color of new text
     * @return void
     */
    public void updateText(String text, Color color) {
         int imageWidth;
         int imageHeight;
         image = new GreenfootImage(text, font.getSize(), Color.BLACK, new Color(0,0,0,0)); //temporary object to get the approx. height and width
         imageWidth = (int)(image.getWidth() * 1.5); 
         imageHeight = (int)(image.getHeight() * 1.5);
         image = new GreenfootImage(imageWidth, imageHeight);
         image.setFont(font);
         image.setColor(color);
         image.drawString(text, 0, font.getSize());
         setImage(image);
    }
}
