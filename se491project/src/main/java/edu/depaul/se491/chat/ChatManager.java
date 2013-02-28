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
		ChannelMessage cMessage = new ChannelMessage(userId, message);
		messageList.addMessage(classId, cMessage);
		boolean newUser = userList.addUser(classId, userId);
		
		List<String>users = userList.getUsersForClass(classId);
				
		for (String user : users){
			if(!newUser){
				cMessage = new ChannelMessage(user, message);
				updateClient(user, cMessage);
			} else
				if (user.equals(userId)) {
					for (ChannelMessage oldMessage : messageList.getMessages(classId)){
						cMessage = new ChannelMessage(user, oldMessage.getMessage());
						updateClient(user, cMessage);
					}
				}
		}

	}

	private void updateClient(String user, ChannelMessage cMessage) {
	    if (user != null) {
	        ChannelService channelService = ChannelServiceFactory.getChannelService();
	        channelService.sendMessage(cMessage);
      }
	}
}
