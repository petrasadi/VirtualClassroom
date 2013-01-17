package main.java.edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Key;

class CmdController {
	private IDaoCommands cmd;
	
	protected void setCommand(IDaoCommands cmd) {
		this.cmd = cmd;
	}
	protected Key execute() {
		return cmd.execute();
	}
	protected boolean isExecute() {
		return cmd.isExecute();
	}
	protected Object getExecute() {
		return cmd.getExecute();
	}
}
