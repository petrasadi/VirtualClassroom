package edu.depaul.se491.formBeans;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: James Raitsev
 * Date: 2/11/13
 */
public class ClassRegistrationListBeanTest
{

    @Test
    public void testSetters()
    {
        ClassRegistrationListBean bean = new ClassRegistrationListBean();

        bean.setCategory("category");
        assertTrue(bean.getCategory().equals("category"));

        bean.setClassEndDay("class end day");
        assertTrue(bean.getClassEndDay().equals("class end day"));

        bean.setClassEndTime("12:45");
        assertTrue(bean.getClassEndTime().equals("12:45"));

        bean.setClassStartDay("Monday");
        assertTrue(bean.getClassStartDay().equals("Monday"));

        bean.setId(123L);
        assertTrue(bean.getId() == 123L);

        bean.setRegistration("registration stuff");
        assertTrue(bean.getRegistration().equals("registration stuff"));

        bean.setTeacherName("teacher name");
        assertTrue(bean.getTeacherName().equals("teacher name"));

        bean.setEndDate("Sunday");
        assertTrue(bean.getEndDate().equals("Sunday"));

        bean.setName("name");
        assertTrue(bean.getName().equals("name"));

        bean.setStartDate("Sunday");
        assertTrue(bean.getStartDate().equals("Sunday"));

        bean.setClassStartTime("14:55");
        assertTrue(bean.getClassStartTime().equals("14:55"));

        bean.setNumberOfRegisteredStudents(12);
        assertTrue(bean.getNumberOfRegisteredStudents() == 12);
    }
}
