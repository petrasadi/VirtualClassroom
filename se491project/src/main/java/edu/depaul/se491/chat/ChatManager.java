package edu.depaul.se491.chat;

public class ChatManager {
	MessageList messageList = new MessageList();
	UserList userList = new UserList();

	public boolean isUserInClass(String userId, long classId) {
		return userList.isUserInClass(userId, classId);
	}

}
