import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays a mood on the character depending on action and student stats. Appears in Main World
 * 
 * @Zachary Zhao
 */
public class DisplayMood extends Actor
{
    Student student;
    ActionState currentAction;
    String mood; // possible moods: {"Neutral", "Happy", "Overjoyed", "Silly", "Stupid", "Sad", "Depressed", "Sick", "Tired", "Sleeping", "Focused"};
    
    public DisplayMood (Student student) {
        this.student = student;
        mood = "Neutral";
        updateImage();
    }
    
    public void act()
    {
        updateCurrentAction();
        updateMood();
        updateImage();
    }
    
    /**
     * Updates mood depending on gpa, happiness, and current action.
     */
    public void updateMood() {
        //if sick, ignore all other moods
        if(student.isSick()) {
            mood = "Sick";
            return;
        }
        
        //if not doing nothing, ignore other moods unless you dont meet happiness threshold in WORKING or BRAINROTTING
        if(currentAction != ActionState.NOTHING) {
            if(currentAction == ActionState.WORKING) {
                if(student.getHappiness() <= 25) {
                    mood = "Tired";
                    return;
                } else if (student.getHappiness() <= 65) {
                    mood = "Focused";
                    return;
                }
            } else if (currentAction == ActionState.SLEEPING) {
                mood = "Sleeping";
                return;
            } else if (currentAction == ActionState.BRAINROTTING) {
                if(student.getHappiness() >= 90) {
                    mood = "Stupid";
                    return;
                } else if (student.getHappiness() >= 70) {
                    mood = "Silly";
                    return;
                }
            }
        }
        
        //if not yet reached a return statement, or doing nothing, return mood based on happiness and gpa
        if(student.getHappiness() >= 90) {
            if(student.getGpa() <= 40) {
                mood = "Stupid";
            } else {
                mood = "Overjoyed";
            }
        } else if (student.getHappiness() >= 70) {
            mood = "Happy";
        } else if (student.getHappiness() >= 40) {
            mood = "Neutral";
        } else if (student.getHappiness() >= 20) {
            mood = "Sad";
        } else {
            mood = "Depressed";
        }
    }
    
    public void updateCurrentAction() {
        currentAction = student.getCurrentAction();
    }
    
    public void updateImage() {
        if(mood != null) {
            setImage("face" + mood + ".png");
        }
    }
}
