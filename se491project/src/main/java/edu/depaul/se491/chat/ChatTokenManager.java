package edu.depaul.se491.chat;

import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.gson.Gson;

public class ChatTokenManager {
	public String getTokenAsJson(String userId, long classId){
		String token = generateToken(userId, classId);
		
		ChatSessionData chatSessionData = new ChatSessionData();
		chatSessionData.setToken(token);
        String gson = new Gson().toJson(chatSessionData);
        return gson;
	}
	
	/**
	 * Generates a unique token for a user in a particular class
	 * If a user would be able to join multiple classes in the same time, this will allow that
	 * @param userId
	 * @param classId
	 * @return the token
	 */
	private String generateToken(String userId, long classId){
		//part of appengine - creates a unique token to use by the requesting user
		ChannelService channelService = ChannelServiceFactory.getChannelService();
		String token = channelService.createChannel(userId);
		return token;
	}
	
	private class ChatSessionData {
		private String token;
		String getToken() {
			return token;
		}
		void setToken(String token) {
			this.token = token;
		}
	}
}
