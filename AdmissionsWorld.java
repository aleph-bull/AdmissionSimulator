import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The final screen that decides admission status
 * 
 * @Zachary Zhao
 */
public class AdmissionsWorld extends World
{
    private double gpaTop;
    private double gpaBot;
    private boolean playingStudentTopSequence;
    private boolean studentTopAdmitted;
    private boolean studentBotAdmitted;
    private int randomNumberRollTop;
    private int randomNumberRollBot;
    private int randomNumber;
    private Font title;
    private Font heading;
    private Font numbers;
    private BasicText titleText;
    private BasicText studentHeading;
    private BasicText randomNumberDisplay;
    private int actCount;
    private int actsSinceStartingRoller;
    private int changingNumberCooldown;
    private boolean isPlaying;
    
    /**
     * Constructor for objects of class EndingWorld.
     * @Zachary Zhao
     */
    public AdmissionsWorld() {
        this(50, 50);
    }
    
    public AdmissionsWorld(double gpaTop, double gpaBot)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        
        this.gpaTop = gpaTop;
        this.gpaBot = gpaBot;
        
        changingNumberCooldown = 2;
        
        title = new Font("Times New Roman", true, false, 60); 
        heading = new Font("Times New Roman", false, true, 45); 
        numbers = new Font("Times New Roman", true, false, 100);
        
        titleText = new BasicText("Admission Lottery™", title, Color.BLACK);
        studentHeading = new BasicText("Top Student", heading, Color.BLACK);
        randomNumberDisplay = new BasicText("", numbers, Color.BLACK);
        
        // Random number roll
        randomNumberRollTop = Greenfoot.getRandomNumber(101);
        randomNumberRollBot = Greenfoot.getRandomNumber(101);
        // Max gpa is 100 fyi
        studentTopAdmitted = randomNumberRollTop <= gpaTop; //random number 0-100
        studentBotAdmitted = randomNumberRollBot <= gpaBot;
        
        addObject(titleText, 585, 130);
        addObject(studentHeading, 560, 200);
        addObject(randomNumberDisplay, 540, 440);
    }
    
    public void act() {
        if(actCount == 120) {
            isPlaying = true;
        }
        
        if(actCount > 120 && isPlaying) {
            if(actsSinceStartingRoller % changingNumberCooldown == 0) {
                randomNumber = Greenfoot.getRandomNumber(101);
                String numberString = Integer.toString(randomNumber);
                if(randomNumber <= gpaTop) {
                    randomNumberDisplay.updateText(numberString, Color.GREEN);
                } else {
                    randomNumberDisplay.updateText(numberString, Color.BLACK);
                }
            }
            if(actsSinceStartingRoller % 60 == 0) {
                changingNumberCooldown++;
                if(changingNumberCooldown == 18) {
                    isPlaying = false;
                    if(playingStudentTopSequence){
                        String topRollString = Integer.toString(randomNumberRollTop);
                        if(studentTopAdmitted) {
                            randomNumberDisplay.updateText(topRollString, Color.GREEN);
                        } else {
                            randomNumberDisplay.updateText(topRollString, Color.RED);
                        }
                    }else{
                        String botRollString = Integer.toString(randomNumberRollBot);
                        if(studentBotAdmitted) {
                            randomNumberDisplay.updateText(botRollString, Color.GREEN);
                        } else {
                            randomNumberDisplay.updateText(botRollString, Color.RED);
                        }
                    }
                    
                    changingNumberCooldown = 0;
                }
            }
            actsSinceStartingRoller++;
        }
        actCount++;
    }
}
