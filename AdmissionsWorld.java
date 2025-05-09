import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**

 * The final screen that decides admission status, handles the entire animated cutscene
 * as well as the decision itself. Features a randomizer that visually swaps between numbers
 * and has dialogue for the students.

 * 
 * @author Zachary Zhao
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
    private Image university;
    private Textbox speech;
    private GreenfootSound music, acceptedSound, rejectedSound;
    
    /**
     * Constructor for objects of class AdmissionsWorld
     * @param studentTop    Student from top room
     * @param studentBot    Student from bottom room
     * @author Zachary Zhao
     */

    //public AdmissionsWorld() { //World with no parameters for debugging
    //    this(new Student(true), new Student(false));
    //}
    
    public AdmissionsWorld(Student studentTop, Student studentBot)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        
        //sound effects
        music = new GreenfootSound("suspense.mp3");
        acceptedSound = new GreenfootSound("accepted.wav");
        rejectedSound = new GreenfootSound("rejected.wav");

        this.gpaTop = studentTop.getGpa();
        this.gpaBot = studentBot.getGpa();
        
        actCountWhenBeganTalking = 999999999; // a really big number as to not affect when the cutscene changes to reveal what happens to the other chracters
        
        university = new Image(SettingsWorldGeneral.getUniversityImage());
        
        characterTop = new DisplayStudent(studentTop);
        characterBot = new DisplayStudent(studentBot);
        
        changingNumberCooldown = 2;
        
        title = new Font("Times New Roman", true, false, 60); 
        heading = new Font("Times New Roman", false, true, 45); 
        numbers = new Font("Times New Roman", true, false, 100);
        normalText = new Font("Times New Roman", false, false, 40);

        
        titleText = new BasicText("Admission Lottery™", title, Color.BLACK);
        studentHeading = new BasicText("Student 1", heading, Color.BLACK);
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
        addObject(university, 830, 445);
    }
    
    /**
     * Continue music if it was playing before execution pause
     * @return void
     */
    public void started(){
        if (isPlaying){
            music.play();
        }
        //assuming sfx are too short + insignificant to continue playing </3
    }
    
    /**
     * Pause music if execution stopped
     * @return void
     */
    public void stopped(){
        music.pause();
        acceptedSound.pause();
        rejectedSound.pause();
    }
    
    /**
     * Act
     * @return void
     */
    public void act() {
        if(actCount == 120) {
            isPlaying = true; // plays both sequences
        }
        
        simulateRolling(); // plays both sequences
        
        // dialog for the first roll
        if(firstSequenceFinished && playingStudentTopSequence && !alreadyTalked) {
            music.stop();
            if(studentTopAdmitted) {
                speech = new Textbox("YESS!! I got in! My chances of homelessness marginally decreased!", characterTop);
                acceptedSound.play();
            } else {
                speech = new Textbox("WHAT!? But I worked so hard. . . Where did my life go wrong :(", characterTop);
                rejectedSound.play();
            }
            beginSpeech();
        }
        
        // update everything to prepare for the second student
        if(actCount == actCountWhenBeganTalking + 500 && playingStudentTopSequence) {
            removeObject(speech);
            addObject(characterBot, characterTop.getX(), characterTop.getY());
            removeObject(characterTop);
            studentHeading.updateText("Student 2");
            randomNumberDisplay.updateText("");
            instructions.updateText("If the random number is below " + (int)gpaBot + ", you're admitted!");
            alreadyTalked = false; 
            playingStudentTopSequence = false;
            actCount = 0;
            actCountWhenBeganTalking = 999999999; 
        }
        
        // dialog for the second roll, different dialog for variation
        if(secondSequenceFinished && !playingStudentTopSequence && !alreadyTalked) {
            music.stop();
            if(studentBotAdmitted) {
                speech = new Textbox("HORAAY! I did it! Perhaps I can even have financial security in the future!", characterBot);
                acceptedSound.play();
            } else {
                speech = new Textbox("Dang! This junk is all luck anyway. Boo!", characterBot);
                rejectedSound.play();
            }
            beginSpeech();
        }
        
        if(actCount == actCountWhenBeganTalking + 500 && !playingStudentTopSequence) {
            music.stop();
            acceptedSound.stop();
            rejectedSound.stop();
            //pausing all sfx just in case?
            Greenfoot.setWorld(new EndingWorld(studentTopAdmitted, studentBotAdmitted)); 
        }
        
        actCount++;
    }
    
    /**
     * Code that adds speech object and resets some stats
     * @return void
     */
    public void beginSpeech() {
        addObject(speech, getWidth()/2, 610);
        alreadyTalked = true;
        actCountWhenBeganTalking = actCount;
    }
    
    /**
     * Quickly alternates the number for the rolling sequence
     * @return void
     */
    public void simulateRolling() {
        if(isPlaying) {
            //play suspense music sfx
            if (!music.isPlaying()){
                music.play();
            }
            if(actsSinceStartingRoller % changingNumberCooldown == 0) {
                randomNumber = Greenfoot.getRandomNumber(101);
                String numberString = Integer.toString(randomNumber);
                if((randomNumber <= gpaTop && !firstSequenceFinished) || (randomNumber <= gpaBot && firstSequenceFinished)) {
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
