package edu.depaul.se491.chat;

import java.util.List;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

public class ChatManager {
	MessageList messageList = new MessageList();
	UserList userList = new UserList();

	public boolean isUserInClass(String userId, long classId) {
		return userList.isUserInClass(userId, classId);
	}

	public void updateClients(long classId, String userId, String message) {
		//TODO - rethink how messages are stored
		ChannelMessage cMessage = new ChannelMessage(userId, message);
		messageList.addMessage(classId, cMessage);
		userList.addUser(classId, userId);
		
		List<String>users = userList.getUsersForClass(classId);
				
		for (String user : users){
			cMessage = new ChannelMessage(user, message);
			updateClient(user, cMessage);
		}

		//TODO - IF NEW USER - add to userList, then send all message history
	}

	private void updateClient(String user, ChannelMessage cMessage) {
	    if (user != null) {
	        ChannelService channelService = ChannelServiceFactory.getChannelService();
	        channelService.sendMessage(cMessage);
      }
	}
}
