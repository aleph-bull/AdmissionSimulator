import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingWorld here.
 * 
 * @author Stephanie Xia
 */
public class SettingsWorldGeneral extends World
{

    /**
     * Constructor for objects of class SettingWorld.
     * 
     */
    private Button student1Left; 
    private Button student1Right;
    private int student1ImageNumber; 
    private SettingsImages student1; 

    private Button student2Left; 
    private Button student2Right;
    private int student2ImageNumber; 
    private SettingsImages student2; 

    private Button universityLeft; 
    private Button universityRight;
    private int universityImageNumber; 
    private SettingsImages university; 

    private Cursor cursor;
    private GreenfootImage background;
    
    private Button next; 
    private Button back;

    public SettingsWorldGeneral()
    {    
        super(1024, 800, 1); 
        background = new GreenfootImage("SettingsPg1.png"); 
        setBackground(background); 

        //cursor object for hoverable buttons
        cursor = new Cursor();
        addObject(cursor, 0, 0);
        //button
        student1 = new SettingsImages(); 
        student1.setImageFile("Cat.png"); 
        addObject(student1, 505, 250); 
        student1Left = new Button(cursor, true); 
        student1Right = new Button(cursor, false);
        addObject(student1Left, 310, 250); 
        addObject(student1Right, 700, 250); 

        student2 = new SettingsImages();
        student2.setImageFile("mirror.png"); 
        addObject(student2, 505, 450); 
        student2Left = new Button(cursor, true); 
        student2Right = new Button(cursor, false);
        addObject(student2Left, 310, 450); 
        addObject(student2Right, 700, 450); 

        university = new SettingsImages();
        university.setImageFile("germ1.png"); 
        addObject(university, 505, 650); 
        universityLeft = new Button(cursor, true); 
        universityRight = new Button(cursor, false);
        addObject(universityLeft, 310, 650); 
        addObject(universityRight, 700, 650); 
        
        next = new Button (cursor, false);
        addObject(next, 945, 670);
        back = new Button (cursor, true); 
        addObject(back, 100, 670); 
        

        setBackground(background); 
    }

    public void act()
    {
        student1Choose(); 
        student2Choose(); 
        universityChoose(); 
        backWorld();
        nextWorld();
        showText(String.valueOf(-9%3), 329, 100); 
        showText(String.valueOf(student2ImageNumber), 200, 100); 

    }
    
    public void backWorld()
    {
        if (Greenfoot.mouseClicked(back))
        {
            Greenfoot.setWorld(new IntroductionWorld()); 
        }
    }
    public void nextWorld()
    {
        if (Greenfoot.mouseClicked(next))
        {
            Greenfoot.setWorld(new SettingsWorldS1Stats()); 
        }
    }

    public void student1Choose()
    {
        if (Greenfoot.mouseClicked(student1Right))
        {
            student1ImageNumber++;    
        }
        else if (Greenfoot.mouseClicked(student1Left))
        {
            student1ImageNumber--; 
        }
        if(student1ImageNumber%3==0)
        {
            student1.setImageFile("Cat.png"); 
        }
        else if (student1ImageNumber%3==1 || student1ImageNumber%3==-1)
        {
            student1.setImageFile("mirror.png"); 
        }
        else if (student1ImageNumber%3 == 2 || student1ImageNumber%3==-2)
        {
            student1.setImageFile("germ1.png"); 
        }

    }

    public void student2Choose()
    {
        if (Greenfoot.mouseClicked(student2Right))
        {
            student2ImageNumber++;    
        }
        else if (Greenfoot.mouseClicked(student2Left))
        {
            student2ImageNumber--; 
        }
        if(student2ImageNumber%3==0)
        {
            student2.setImageFile("Cat.png"); 
        }
        else if (student2ImageNumber%3==1 || student2ImageNumber%3==-1)
        {
            student2.setImageFile("mirror.png"); 
        }
        else if (student2ImageNumber%3 == 2 || student2ImageNumber%3==-2)
        {
            student2.setImageFile("germ1.png"); 
        }

    }

    public void universityChoose()
    {
        if (Greenfoot.mouseClicked(universityRight))
        {
            universityImageNumber++;    
        }
        else if (Greenfoot.mouseClicked(universityLeft))
        {
            universityImageNumber--; 
        }
        if(universityImageNumber%4==0)
        {
            university.setImageFile("Cat.png"); 
        }
        else if (universityImageNumber%4==1 || universityImageNumber%4==-1)
        {
            university.setImageFile("mirror.png"); 
        }
        else if (universityImageNumber%4 == 2 || universityImageNumber%4==-2)
        {
            university.setImageFile("germ1.png"); 
        }
        else if (universityImageNumber%4 == 3 || universityImageNumber%4==-3)
        {
            university.setImageFile("germ1.png"); 
        }

    }
}