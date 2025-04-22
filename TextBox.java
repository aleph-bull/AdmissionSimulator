import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Textbox extends Actor
{
    private GreenfootImage image;
    private Font font = new Font(40);
    
    public Textbox (String text, Color color){
        image = new GreenfootImage(800, 500);
        image.setColor(color);
        image.setFont(font);
        image.drawString(text, 100, 100);
    }
    
    private String dialog;
    private int textIndex = 0;
    private int frameCount = 0;
    private int speed = 3; 
    private int spacePauseDuration = 2; 
    private int lineHeight = 75;
    private int margin = 40; 
    private int maxWidth = 290; 
    private int letterCount = 0; // count of letters typed, used for animation
    private Actor speaker;
    private Color opaqueWhite = new Color(255, 255, 255, 200);
    private boolean isSpacePause = false;
    
    private GreenfootSound dialogueSounds[];
    private int curIndex;

    public Textbox(String dialog, Actor speaker) {
        this.speaker = speaker;
        this.dialog = dialog;
        GreenfootImage image = new GreenfootImage(800, 150);
        image.setColor(opaqueWhite);
        image.fill();
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, image.getWidth()-1, image.getHeight()-1);
        setImage(image);
        
        dialogueSounds = new GreenfootSound[10];
        for (int i = 0; i < dialogueSounds.length; i++){
            dialogueSounds[i] = new GreenfootSound("dialogue.wav");
        }
        
        curIndex = 0;
    }

    public void act()
    {
        if (isSpacePause) {
            if (frameCount >= spacePauseDuration) {
                isSpacePause = false;
                frameCount = 0;
            }
        } else {
            if (frameCount % speed == 0 && textIndex < dialog.length()) {
                char currentChar = dialog.charAt(textIndex);
                typeWrite(currentChar);
                textIndex++;
                if (currentChar == ' ') {
                    isSpacePause = true;
                    frameCount = 0;
                }
            } else if(textIndex >= dialog.length() /*&& !alreadyChangedSpeaking*/) {
                //speaker.changeIsSpeaking(false);
                //alreadyChangedSpeaking = true;
            }
        }
        
        frameCount++;
    }

    private void typeWrite(char letter) {
        GreenfootImage image = getImage();
        String currentText = dialog.substring(0, textIndex + 1);

        image.clear();
        image.setColor(opaqueWhite);
        image.fill();
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, image.getWidth()-1, image.getHeight()-1);

        image.setFont(new Font(20));
        
        // Wrap text
        String[] words = currentText.split(" ");
        String line = "";
        int y = 4 + lineHeight;
        
        for (String word : words) {
            if (getTextWidth(line + word) < maxWidth) {
                line += word + " ";                 // Add word to line if fit
            } else {
                image.drawString(line, margin, y);  // Draw the current line
                y += lineHeight;                    // Move to next line
                line = word + " ";                  // Start new line
            }
        }
        image.drawString(line, margin, y); // writes last line
        
        if(letter != ' ') {
            animateSpeaker(letterCount);
            letterCount++;
        }

        setImage(image);
    }

    // Approximate text width by creating a temporary image
    private int getTextWidth(String text) {
        GreenfootImage tempImage = new GreenfootImage(text, 1, Color.BLACK, null);
        return tempImage.getWidth();
    }
    
    //moves customer up and down
    private void animateSpeaker(int count) {
        if(count % 2 == 0) {
            speaker.setLocation(speaker.getX(), speaker.getY()-10);
        } else {
            speaker.setLocation(speaker.getX(), speaker.getY()+10);
        }
        dialogueSounds[curIndex].play();
        curIndex++;
        if (curIndex == dialogueSounds.length) curIndex = 0;
    }
}