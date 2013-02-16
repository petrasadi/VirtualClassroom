package edu.depaul.se491.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: James Raitsev
 * Date: 2/16/13
 */
public class CategoryTest
{
    @Test
    public void testGettersAndSetters() throws Exception
    {
        Category c = new Category();
        c.setName("name");
        c.setDescription("description");
        assertTrue(c.getDescription().equals("description"));
        assertTrue(c.getName().equals("name"));

    }


}
