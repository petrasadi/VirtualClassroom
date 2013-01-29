package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;

class GetPersonById implements IDaoCommands {
	Key personId;
	
	public GetPersonById(Key personId) {
		this.personId = personId;
	}
	public Key execute() {
		return null;
	}
	public boolean isExecute() {
		return false;
	}
	public Entity getExecute() {
		IPersonDAO p = new PersonDAO();
		try {
			return p.getPersonById(this.personId);
		} catch (PersonException e) {
			e.printStackTrace();
			return null;
		}
	}
}
