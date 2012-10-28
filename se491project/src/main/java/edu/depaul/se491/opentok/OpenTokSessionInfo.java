package edu.depaul.se491.opentok;

class OpenTokSessionInfo {
	private int apiKey;
	private String sessionId;
	private String token;

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
	
	
}