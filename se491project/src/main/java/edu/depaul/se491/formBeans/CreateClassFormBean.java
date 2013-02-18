package edu.depaul.se491.formBeans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class CreateClassFormBean
{

    @NotEmpty
    private String classTitle;
    @Pattern(regexp = "[0-9]+")
    private String minStudents;
    @Pattern(regexp = "[0-9]+")
    private String maxStudents;
    @NotEmpty
    private String classDate;
    @NotEmpty
    private String classDescription;
    @NotEmpty
    private String classCategory;  
    @NotEmpty
    private String classLevel;
    @Pattern(regexp = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)")
    private String classStartTime;
    @Pattern(regexp = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)")
    private String classEndTime;

    public String getClassTitle()
    {
        return classTitle;
    }

    public void setClassTitle(String classTitle)
    {
        this.classTitle = classTitle;
    }

    public String getMinStudents()
    {
        return minStudents;
    }

    public void setMinStudents(String minStudents)
    {
        this.minStudents = minStudents;
    }

    public String getMaxStudents()
    {
        return maxStudents;
    }

    public void setMaxStudents(String maxStudents)
    {
        this.maxStudents = maxStudents;
    }

    public String getClassDate()
    {
        return classDate;
    }

    public void setClassDate(String classDate)
    {
        this.classDate = classDate;
    }

    public String getClassDescription()
    {
        return classDescription;
    }

    public void setClassDescription(String classDescription)
    {
        this.classDescription = classDescription;
    }

    public String getClassCategory()
    {
        return classCategory;
    }

    public void setClassCategory(String classCategory)
    {
        this.classCategory = classCategory;
    }

    public String getClassLevel()
    {
        return classLevel;
    }

    public void setClassLevel(String classLevel)
    {
        this.classLevel = classLevel;
    }

    public String getClassEndTime()
    {
        return classEndTime;
    }

    public void setClassEndTime(String classDuration)
    {
        this.classEndTime = classDuration;
    }

    public String getClassStartTime()
    {
        return classStartTime;
    }

    public void setClassStartTime(String classStartTime)
    {
        this.classStartTime = classStartTime;
    }

}
