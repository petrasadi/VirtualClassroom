package edu.depaul.se491.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class UserList {
	HashMap<Long, List<String>> userList = new HashMap<Long, List<String>>();
	
	boolean addUser(long classId, String userId){
		List<String> classUserList = userList.get(classId);
		if (classUserList == null)
			userList.put(classId, 
					classUserList = new ArrayList<String>());
		
		if (!classUserList.contains(userId)) {
			classUserList.add(userId);
			return true;
		}
		return false;
	}
	
	List<String> getUsersForClass(long classId) {
		return userList.get(classId);
	}
	
	boolean isUserInClass(String userId, long classId){
		List<String> classUserList = userList.get(classId);
		if (classUserList != null &&
				classUserList.contains(userId))
			return true;
		else
			return false;
	}
}