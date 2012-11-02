package edu.depaul.se491.josqlCmds;

class CmdController {
	private IDaoCommands cmd;
	
	protected void setCommand(IDaoCommands cmd) {
		this.cmd = cmd;
	}
	protected void execute() {
		cmd.execute();
	}
	protected boolean isExecute() {
		return cmd.isExecute();
	}
	protected Object getExecute() {
		return cmd.getExecute();
	}
}
