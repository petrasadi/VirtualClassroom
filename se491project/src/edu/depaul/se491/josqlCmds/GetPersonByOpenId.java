package edu.depaul.se491.josqlCmds;

import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;
import edu.depaul.se491.model.Person;

class GetPersonByOpenId implements IDaoCommands {
	String openId;
	
	public GetPersonByOpenId(String openId) {
		this.openId = openId;
	}
	public void execute() {
		return;
	}
	public boolean isExecute() {
		return false;
	}
	public Person getExecute() {
		IPersonDAO p = new PersonDAO();
		try {
			return p.getPersonByOpenId(this.openId);
		} catch (PersonException e) {
			e.printStackTrace();
			return null;
		}
	}
}
