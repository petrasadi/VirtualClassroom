package edu.depaul.se491.formBeans;

import com.google.appengine.api.datastore.Key;

public class ClassRegistrationListBean {
	private Key id;
	
	private String name;
	
	private String category;
	
	private String startDate;
	
	private String endDate;
	
	private String registration;
	
	public ClassRegistrationListBean() {
		
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}
}
