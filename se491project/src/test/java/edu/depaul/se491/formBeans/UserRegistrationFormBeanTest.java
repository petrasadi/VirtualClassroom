package edu.depaul.se491.formBeans;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: James Raitsev
 * Date: 2/11/13
 */
public class UserRegistrationFormBeanTest
{

    @Test
    public void testSetters()
    {
        UserRegistrationFormBean bean = new UserRegistrationFormBean();

        bean.setAddress("the address");
        assertTrue(bean.getAddress().equals("the address"));


        bean.setAddress2("the address2");
        assertTrue(bean.getAddress2().equals("the address2"));

        bean.setCity("Boston");
        assertTrue(bean.getCity().equals("Boston"));

        bean.setCountry("USA");
        assertTrue(bean.getCountry().equals("USA"));

        bean.setEmail("id@domain.com");
        assertTrue(bean.getEmail().equals("id@domain.com"));

        bean.setUserDescription("user description");
        assertTrue(bean.getUserDescription().equals("user description"));

        bean.setFirstName("Mike");
        assertTrue(bean.getFirstName().equals("Mike"));

        bean.setLastName("Jones");
        assertTrue(bean.getLastName().equals("Jones"));

        bean.setPhone("12-444-555");
        assertTrue(bean.getPhone().equals("12-444-555"));

        bean.setZip("60606");
        assertTrue(bean.getZip().equals("60606"));

        bean.setState("IL");
        assertTrue(bean.getState().equals("IL"));

        bean.setTeacher(true);
        assertTrue(bean.isTeacher());

        bean.setStudent(true);
        assertTrue(bean.isStudent());

        bean.setOpenid("open id");
        assertTrue(bean.getOpenid().equals("open id"));

        bean.setPhone2("312-555-1234");
        assertTrue(bean.getPhone2().equals("312-555-1234"));

        bean.setMiddleName("-");
        assertTrue(bean.getMiddleName().equals("-"));


    }

}
