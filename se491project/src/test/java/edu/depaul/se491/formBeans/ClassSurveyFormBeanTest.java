package edu.depaul.se491.formBeans;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: James Raitsev
 * Date: 2/16/13
 */
public class ClassSurveyFormBeanTest
{
    @Test
    public void testGetQuestions() throws Exception
    {
        ClassSurveyFormBean c = new ClassSurveyFormBean();
        assertTrue(c.getQ1().equals("Course objectives were clearly defined"));
        assertTrue(c.getQ2().equals("Information presented can be applied"));
        assertTrue(c.getQ3().equals("The content met my expectations"));
        assertTrue(c.getQ4().equals("This course was an appropriate length to cover the stated objectives"));
        assertTrue(c.getQ5().equals("The material was logically organized"));
        assertTrue(c.getQ6().equals("The instructor created an engaging learning environment"));
        assertTrue(c.getQ7().equals("The instructor was knowledgeable of the course content"));
        assertTrue(c.getQ8().equals("The instructor presented materials in an organized manner"));
        assertTrue(c.getQ9().equals("The instructor responded to questions thoroughly and carefully"));
    }

    @Test
    public void testGetAnswers() throws Exception
    {
        ClassSurveyFormBean c = new ClassSurveyFormBean();
        assertTrue(c.getA1().equals("Exceeds Expectations"));
        assertTrue(c.getA2().equals("Meets Expectations"));
        assertTrue(c.getA3().equals("Does NOT Meet Expectations"));
    }

    @Test
    public void testGetQuestions2() throws Exception
    {
        ClassSurveyFormBean c = new ClassSurveyFormBean();
        assertTrue(c.getAnswers().size() == 3);
        assertTrue(c.getQuestions().size() == 9);
    }
}
