package edu.depaul.se491.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.appengine.api.channel.ChannelMessage;

class MessageList {
	HashMap<Long, List<ChannelMessage>> messageList = new HashMap<Long, List<ChannelMessage>>();
	
	void addMessage(long classId, ChannelMessage message){
		List<ChannelMessage> classMessageList = messageList.get(classId);
		if (classMessageList == null)
			messageList.put(classId, 
					classMessageList = new ArrayList<ChannelMessage>());
		classMessageList.add(message);
	}
	
	List<ChannelMessage> getMessages(long classId) {
		return messageList.get(classId);
	}
}
