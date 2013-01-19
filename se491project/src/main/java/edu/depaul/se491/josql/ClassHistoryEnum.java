package main.java.edu.depaul.se491.josql;

public enum ClassHistoryEnum {
	TAUGHT("taught"), ATTENDED("attended"), UNATTENDED("unattended"), UNTAUGHT("untaught");
	private String eventType;
	
	private ClassHistoryEnum(String eventType) {
		this.eventType = eventType;
	}
	
	public String getEventType() {
		return this.eventType;
	}
}
