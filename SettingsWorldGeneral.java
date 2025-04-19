import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingWorldGeneral here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorldGeneral extends SettingsWorld
{

    /**
     * Constructor for objects of class SettingWorldGeneral.
     * 
     */
    private SettingsWorld.StatChooseImage student1, student2, university;
    private int student1Number, student2Number, universityNumber; 

    public SettingsWorldGeneral()
    {    
        background = new GreenfootImage("SettingsPg1.png"); 
        setBackground(background); 

        //cursor object for hoverable buttons
        cursor = new Cursor();
        addObject(cursor, 0, 0);
        //button
        student1 = new SettingsImages(); 
        student1.setImageFile("bob_run1.png"); 
        addObject(student1, 250, 290); 
        student1Left = new Button(cursor, true); 
        student1Right = new Button(cursor, false);
        addObject(student1Left, 100, 290); 
        addObject(student1Right, 400, 290); 

        student2 = new SettingsImages();
        student2.setImageFile("bob_run1.png"); 
        addObject(student2, 250, 550); 
        student2Left = new Button(cursor, true); 
        student2Right = new Button(cursor, false);
        addObject(student2Left, 100, 550); 
        addObject(student2Right, 400, 550); 

        university = new SettingsImages();
        university.setImageFile("universityofcatmeme.png"); 
        addObject(university, 725, 410); 
        universityLeft = new Button(cursor, true); 
        universityRight = new Button(cursor, false);
        addObject(universityLeft, 500, 550); 
        addObject(universityRight, 942, 550); 
        
        next = new Button (cursor, false);
        addObject(next, 945, 670);
        back = new Button (cursor, true); 
        addObject(back, 100, 670); 

        student1Number = 0;
        student1 = new SettingsWorld.StatChooseImage(250, 100, 400, 290, student1Number); 
        student2Number = 0;
        student2 = new SettingsWorld.StatChooseImage(250, 100, 400, 550, student2Number); 
        universityNumber = 0; 
        university = new SettingsWorld.StatChooseImage(725, 500, 942, 550, 410, universityNumber); 

    }
    public void act()
    {
        student1.choose("bob_run18.png", "Amelia_run1.png", "Alex_run1.png"); 
        student2.choose("bob_run18.png", "Amelia_run1.png", "Alex_run1.png"); 
        university.choose("universityofcatmeme.png", "universityofbigmac.png", "universityofducksong.png", "universityoflebron.png"); 
        backWorld();
        nextWorld();
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
            student1.setImageFile("bob_run1.png"); 
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
            student2.setImageFile("bob_run1.png"); 
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
            university.setImageFile("universityofcatmeme.png"); 
        }
        else if (universityImageNumber%4==1 || universityImageNumber%4==-1)
        {
            university.setImageFile("universityofbigmac.png"); 
        }
        else if (universityImageNumber%4 == 2 || universityImageNumber%4==-2)
        {
            university.setImageFile("universityofducksong.png"); 
        }
        else if (universityImageNumber%4 == 3 || universityImageNumber%4==-3)
        {
            university.setImageFile("universityoflebron.png"); 
        }

    }
}
