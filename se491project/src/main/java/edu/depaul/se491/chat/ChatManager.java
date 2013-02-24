package edu.depaul.se491.chat;

import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

public class ChatManager {
	public String getTokenAsJson(String userId, long classId){
		String token = generateToken(userId, classId);

		//TODO - transform this to json
		
		return token;
	}
	
	/**
	 * Generates a unique token for a user in a particular class
	 * If a user would be able to join multiple classes in the same time, this will allow that
	 * @param userId
	 * @param classId
	 * @return the token
	 */
	private String generateToken(String userId, long classId){
		StringBuilder tokenBuilder = new StringBuilder();
		tokenBuilder.append(userId);
		tokenBuilder.append(classId);
		int uniq = tokenBuilder.toString().hashCode();
		
		//part of appengine - creates a unique token to use by the requesting user
		ChannelService channelService = ChannelServiceFactory.getChannelService();
		String token = channelService.createChannel(String.valueOf(uniq));
		return token;
	}
}
