import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**

 * The final screen that decides admission status, handles the entire animated cutscene

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
    private boolean firstSequenceFinished;
    private boolean secondSequenceFinished;
    private boolean alreadyTalked;
    private int randomNumberRollTop;
    private int randomNumberRollBot;
    private int randomNumber;
    private Font title;
    private Font heading;
    private Font numbers;
    private Font normalText;
    private BasicText titleText;
    private BasicText studentHeading;
    private BasicText randomNumberDisplay;
    private BasicText instructions;
    private BasicText comment;
    private BasicText gpa;
    private int actCount;
    private int actsSinceStartingRoller;
    private int actCountWhenBeganTalking;
    private int changingNumberCooldown;
    private boolean isPlaying;
    private DisplayStudent characterTop;
    private DisplayStudent characterBot;
    private Textbox speech;
    
    /**
     * Constructor for objects of class EndingWorld.
     * @Zachary Zhao
     */

    public AdmissionsWorld() { //World with no parameters for debugging
        this(new Student(true), new Student(false));
    }
    
    public AdmissionsWorld(Student studentTop, Student studentBot)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        

        this.gpaTop = studentTop.getGpa();
        this.gpaBot = studentBot.getGpa();
        
        actCountWhenBeganTalking = 999999999; // a really big number as to not affect when the cutscene changes to reveal what happens to the other chracters
        
        characterTop = new DisplayStudent(studentTop);
        characterBot = new DisplayStudent(studentBot);
        
        changingNumberCooldown = 2;
        
        title = new Font("Times New Roman", true, false, 60); 
        heading = new Font("Times New Roman", false, true, 45); 
        numbers = new Font("Times New Roman", true, false, 100);
        normalText = new Font("Times New Roman", false, false, 40);

        
        titleText = new BasicText("Admission Lottery™", title, Color.BLACK);
        studentHeading = new BasicText("Top Student", heading, Color.BLACK);
        randomNumberDisplay = new BasicText("", numbers, Color.BLACK);

        instructions = new BasicText("If the random number is below " + (int)gpaTop + ", you're admitted!", normalText, Color.BLACK);
        
        // Random number roll
        randomNumberRollTop = Greenfoot.getRandomNumber(101);
        randomNumberRollBot = Greenfoot.getRandomNumber(101);
        // Max gpa is 100 fyi
        studentTopAdmitted = randomNumberRollTop <= gpaTop; //random number 0-100
        studentBotAdmitted = randomNumberRollBot <= gpaBot;

        playingStudentTopSequence = true;
        
        addObject(titleText, 585, 130);
        addObject(studentHeading, 560, 200);
        addObject(randomNumberDisplay, 540, 440);
        addObject(instructions, 660, 765);
        addObject(characterTop, 260, 445);
    }
    
    public void act() {
        if(actCount == 120) {
            isPlaying = true; // plays both sequences
        }
        
        simulateRolling(); // plays both sequences
        
        // dialog for the first roll
        if(firstSequenceFinished && playingStudentTopSequence && !alreadyTalked) {
            if(studentTopAdmitted) {
                speech = new Textbox("YESS!! I got in! My chances of homelessness marginally decreased!", characterTop);
            } else {
                speech = new Textbox("WHAT!? But I worked so hard. . . Where did my life go wrong :(", characterTop);
            }
            beginSpeech();
        }
        
        // update everything to prepare for the second student
        if(actCount == actCountWhenBeganTalking + 500 && playingStudentTopSequence) {
            removeObject(speech);
            addObject(characterBot, characterTop.getX(), characterTop.getY());
            removeObject(characterTop);
            studentHeading.updateText("Bottom Student");
            randomNumberDisplay.updateText("");
            instructions.updateText("If the random number is below " + (int)gpaBot + ", you're admitted!");
            alreadyTalked = false; 
            playingStudentTopSequence = false;
            actCount = 0;
            actCountWhenBeganTalking = 999999999; 
        }
        
        // dialog for the second roll, different dialog for variation
        if(secondSequenceFinished && !playingStudentTopSequence && !alreadyTalked) {
            if(studentBotAdmitted) {
                speech = new Textbox("HORAAY! I did it! Perhaps I can even have financial security in the future!", characterBot);
            } else {
                speech = new Textbox("Dang! This junk is all luck anyway. Boo!", characterBot);
            }
            beginSpeech();
        }
        
        if(actCount == actCountWhenBeganTalking + 500 && !playingStudentTopSequence) {
            //change to ending world
        }
        
        actCount++;
    }
    
    public void beginSpeech() {
        addObject(speech, getWidth()/2, 610);
        alreadyTalked = true;
        actCountWhenBeganTalking = actCount;
    }
    
    public void simulateRolling() {
        if(isPlaying) {

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

                        firstSequenceFinished = true;

                    }else{
                        String botRollString = Integer.toString(randomNumberRollBot);
                        if(studentBotAdmitted) {
                            randomNumberDisplay.updateText(botRollString, Color.GREEN);
                        } else {
                            randomNumberDisplay.updateText(botRollString, Color.RED);
                        }

                        secondSequenceFinished = true;
                    }
                    
                    actsSinceStartingRoller = 0;
                    changingNumberCooldown = 2;

                }
            }
            actsSinceStartingRoller++;
        }
    }
}
