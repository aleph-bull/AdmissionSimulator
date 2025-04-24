/**
 * Write a description of class SimData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimData  
{
    // instance variables - replace the example below with your own
    private int student1Number, student2Number, universityNumber, productivityNumber, happinessNumber, gpaNumber;
    private int s1Relative1Number, s1Relative2Number, s1Relative3Number, s2Relative1Number, s2Relative2Number, s2Relative3Number;

    /**
     * Constructor for objects of class SimData
     */
    public SimData()
    {
        student1Number = 3;
        student2Number = 0; 
        universityNumber = 0; 
        productivityNumber = 80; 
        happinessNumber = 80;
        gpaNumber = 0;
        s1Relative1Number = 0;
        s1Relative2Number = 0;
        s1Relative3Number = 0;
        s2Relative1Number = 0;
        s2Relative2Number = 0; 
        s2Relative3Number = 0;

    }

    public void setStudent1Number(int student1Number)
    {
        this.student1Number = student1Number; 
    }

    public void setStudent2Number(int student2Number)
    {
        this.student2Number = student2Number; 
    }

    public void setUniversityNumber(int universityNumber)
    {
        this.universityNumber = universityNumber; 
    }

    public void setProductivityNumber(int productivityNumber)
    {
        this.productivityNumber = productivityNumber; 
    }

    public void setHappinessNumber(int happinessNumber)
    {
        this.happinessNumber = happinessNumber; 
    }

    public void setGpaNumber(int gpaNumber)
    {
        this.gpaNumber = gpaNumber; 
    }

    public void setS1Relative1Number(int s1Relative1Number)
    {
        this.s1Relative1Number = s1Relative1Number; 
    }

    public void setS1Relative2Number(int s1Relative2Number)
    {
        this.s1Relative2Number = s1Relative2Number;
    }

    public void setS1Relative3Number(int s1Relative3Number)
    {
        this.s1Relative3Number = s1Relative3Number;
    }

    public void setS2Relative1Number(int s2Relative1Number)
    {
        this.s2Relative1Number = s2Relative1Number; 
    }

    public void setS2Relative2Number(int s2Relative2Number)
    {
        this.s2Relative2Number = s2Relative2Number;
    }

    public void setS2Relative3Number(int s2Relative3Number)
    {
        this.s2Relative3Number = s2Relative3Number;
    }

    public int getStudent1Number()
    {
        return student1Number;
    }

    public int getStudent2Number()
    {
        return student2Number;
    }

    public int getUniversityNumber()
    {
        return universityNumber;
    }

    public int getS1ProductivityNumber()
    {
        return productivityNumber;
    }

    public int getS1HappinessNumber()
    {
        return happinessNumber;
    }

    public int getGpaNumber()
    {
        return gpaNumber;
    }

    public int getS1Relative1Number()
    {
        return s1Relative1Number; 
    }

    public int getS1Relative2Number()
    {
        return s1Relative1Number; 
    }

    public int getS1Relative3Number()
    {
        return s1Relative1Number; 
    }

    public int getS2Relative1Number()
    {
        return s2Relative1Number; 
    }

    public int getS2Relative2Number()
    {
        return s2Relative2Number; 
    }

    public int getS2Relative3Number()
    {
        return s2Relative3Number; 
    }
}
