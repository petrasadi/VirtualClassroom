package edu.depaul.se491.formBeans;


public class ClassRegistrationListBean {
	private long id;
	
	private String name;
	
	private String category;
	
	private String startDate;
	
	private String endDate;
	
	private String registration;
	
	private String classEndTime;
	
	private String classStartTime;
	
	private String classStartDay;
	
	private String classEndDay;
	
	public String getClassEndTime() {
		return classEndTime;
	}

	public void setClassEndTime(String classEndTime) {
		this.classEndTime = classEndTime;
	}

	public String getClassStartTime() {
		return classStartTime;
	}

	public void setClassStartTime(String classStartTime) {
		this.classStartTime = classStartTime;
	}

	public String getClassStartDay() {
		return classStartDay;
	}

	public void setClassStartDay(String classStartDay) {
		this.classStartDay = classStartDay;
	}

	public String getClassEndDay() {
		return classEndDay;
	}

	public void setClassEndDay(String classEndDay) {
		this.classEndDay = classEndDay;
	}

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
