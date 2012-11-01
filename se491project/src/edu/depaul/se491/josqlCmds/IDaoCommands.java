package edu.depaul.se491.josqlCmds;

interface IDaoCommands {
	/**
	 * Executes a command on dao layer
	 */
	public void execute();
	
	/**
	 * Executes a command to check if an object matches on dao layer
	 * @return boolean
	 */
	public boolean isExecute();
	
	/**
	 * Executes a command to obtain data from the dao layer
	 * @return Object
	 */
	public Object getExecute();
}
