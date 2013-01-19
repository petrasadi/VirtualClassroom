package edu.depaul.se491.opentok;

/** 
 * 
 * Used as a placeholder for the session info of a specific user 
 * for a specific class
 * 
 * apiKey - unique for the application
 * sessionId - unique for a class
 * token - unique for a user in a class
 * 
 * @author petrasadi
 * 
 */
class OpenTokSessionInfo {
	private int apiKey;
	private String sessionId;
	private String token;
	private String role;

	int getApiKey() {
		return apiKey;
	}

	void setApiKey(int apiKey) {
		this.apiKey = apiKey;
	}

	String getSessionId() {
		return sessionId;
	}

	void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	String getToken() {
		return token;
	}

	void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}