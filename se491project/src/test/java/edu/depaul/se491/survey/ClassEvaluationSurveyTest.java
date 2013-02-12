package edu.depaul.se491.survey;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * User: James Raitsev
 * Date: 2/11/13
 */
public class ClassEvaluationSurveyTest
{
    @Test
    public void testGetQuestions() throws Exception
    {
        ClassEvaluationSurvey survey = new ClassEvaluationSurvey();
        assertTrue(survey.getAnswers().isEmpty());

        assertTrue(survey.setAnswerEE("Course objectives were clearly defined"));
        assertFalse(survey.setAnswerME("Course objectives were clearly defined"));
        assertFalse(survey.setAnswerDNME("Course objectives were clearly defined"));
    }

}
