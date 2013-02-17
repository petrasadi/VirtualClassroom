package edu.depaul.se491.opentok;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: James Raitsev
 * Date: 2/11/13
 */
public class OpenTokSessionInfoTest
{

    @Test
    public void testGettersAndSetters() throws Exception
    {
        OpenTokSessionInfo o = new OpenTokSessionInfo();
        o.setRole("role");
        o.setSessionId("session id");
        o.setToken("token");

        assertTrue(o.getRole().equals("role"));
        assertTrue(o.getSessionId().equals("session id"));
        assertTrue(o.getToken().equals("token"));

    }
}
