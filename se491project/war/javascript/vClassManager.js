function initializeCommunication(userId, classId) {
	//TODO - refactor so that userData is retrieved before the call to getSessionInfo
	//TODO - move initChat here (currently is in getSessionInfo)
	
	//initialize OpenTok
	getSessionInfo(userId, classId);
	
	//initialize chat
	//initChat(userId, classId);
}