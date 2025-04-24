import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The card that displays the image of the current image of student on the card.
 * Updates with the student's animations.
 * 
 * @author Zachary Zhao
 */
public class DisplayStudent extends Actor
{
    Student student;
    GreenfootImage image;
    /**
     * A constructor for the class.
     * @param student   Student whose image is being updated
     */
    public DisplayStudent(Student student) {
        this.student = student;
        updateImage();
    }
    
    public void act () {
        updateImage();
    }
    
    /**
     * Updates the image to match the one that is playing on the actual student. 
     * Scales it larger each time to improve visibility
     * @return void
     */
    public void updateImage() {
        if(student.getImage() != null) {
            image = new GreenfootImage(student.getImage()); // makes a new image to avoid changing details of student.getImage()
            image.scale((int)(image.getWidth()*1.7), (int)(image.getHeight()*1.7));
            setImage(image);
        }
    }
}
