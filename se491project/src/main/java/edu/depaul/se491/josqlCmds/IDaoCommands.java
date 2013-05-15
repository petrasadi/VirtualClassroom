package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Key;

interface IDaoCommands
{
    /**
     * Executes a command on dao layer
     */
    public Key execute();

    /**
     * Executes a command to check if an object matches on dao layer
     *
     * @return boolean
     */
    public boolean isExecute();

    /**
     * Executes a command to obtain data from the dao layer
     *
     * @return Object
     */
    public Object getExecute();
}
