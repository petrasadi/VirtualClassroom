var session;
<<<<<<< HEAD
=======
var speakRequestsSet = { };
var data;
var stateManager;
>>>>>>> 139cf0c6116614d19146b9fdd78206bba7ea04ce

function handleOpenTok(data){
	var apiKey = data.apiKey;
	var sessionId = data.sessionId;
	var token = data.token;
	var userRole = data.role;

	//TODO - this should change in production
	TB.setLogLevel(TB.DEBUG);

	session = TB.initSession(sessionId);      
	session.addEventListener('sessionConnected', sessionConnectedHandler);
	session.addEventListener('streamCreated', streamCreatedHandler);
<<<<<<< HEAD
	session.addEventListener("signalReceived", raiseHandHandler);
	session.connect(apiKey, token);

	var publisher;

	function sessionConnectedHandler(event) {
		//only a teacher can publish when connecting to the session
		if(userRole == "teacher"){
			var div = document.createElement('div');
			div.setAttribute('id', 'publisher');
			$('#myPublisherDiv').append(div);
			publisher = TB.initPublisher(apiKey, div);
	
			//TODO - only add publisher if camera and mic detected
	
			publisher.addEventListener('accessAllowed', accessAllowedHandler);
			session.publish(publisher);
		}
=======
	//session.addEventListener("signalReceived", raiseHandHandler);
	session.connect(apiKey, token);	
}


function switchPublishingUser(userRole, connectionId){
/*	if (userRole === 'teacher') {
		//remove from set so that the student can ask other questions
		speakRequestsSet[connectionId] = false;
		var btnId = "#requestButton" + connectionId;
		$(btnId).remove();
		alert("done");
	}*/
	
	stateManager.set("moderator_switchUser", connectionId);
}

function switchPublishingUserHandler(event){
	var connectionId = event.changedValues["moderator_switchUser"];
	speakRequestsSet[connectionId] = false;
	var btnId = "#requestButton" + connectionId;
	$(btnId).remove();
	//TODO - switch the viewable user
	forcePublish(connectionId);
}

function forcePublish(connectionId){
	if (connectionId === session.connection.connectionId){
		//alert("it's me");
		//TODO - REFACTOR
		var div = document.createElement('div');
		div.setAttribute('id', 'publisher');
		$('#myPublisherDiv').append(div);
		publisher = TB.initPublisher(data.apiKey, div);

		//TODO - only add publisher if camera and mic detected
		publisher.addEventListener('accessAllowed', accessAllowedHandler);

		$("#conferenceContainer").width(1000);
	}
}

function raisehand(){
	//session.signal();
	var connectionId = session.connection.connectionId;
	stateManager.set("raiseHand", connectionId);
}

//TODO - fix raiseHand event
function raiseHandHandler(event){
	//var connectionId = event.fromConnection.connectionId;
	var connectionId = event.changedValues["raiseHand"];
	
	//ignore request if already registered
	if (!(connectionId in speakRequestsSet) ||
			(speakRequestsSet[connectionId] === false)){
		speakRequestsSet[connectionId] = true;
>>>>>>> 139cf0c6116614d19146b9fdd78206bba7ea04ce

		// Subscribe to streams that were in the session when we connected
		subscribeToStreams(event.streams);
	}
<<<<<<< HEAD

	function streamCreatedHandler(event) {
		// Subscribe to any new streams that are created
		subscribeToStreams(event.streams);
	}

	function subscribeToStreams(streams) {
		//display a generic message if professor is not connected yet
		if (streams.length == 0 &&
				userRole != "teacher"){
			$('#subscribers').append("<h4 id=\"noSession\">Waiting for instructor to start the session.</h4>");
		} else {
			$('#noSession').remove();
			for (var i = 0; i < streams.length; i++) {
				// Create the div to put the subscriber element in to
				var div = document.createElement('div');
				div.setAttribute('id', 'stream' + streams[i].streamId);
				$('#subscribers').append(div);

				// Subscribe to the stream
				var subscribeProps = {width:400, height:225};
				session.subscribe(streams[i], div.id, subscribeProps);
			}
			setupChatFunctionality(data.role);
		}
	}
	
	//TODO - fix raiseHand event
	function raiseHandHandler(event){
		alert("hand raised");
=======
}

function accessAllowedHandler(event){
	
/*	for (var i = 0; i < session.streams.length; i++) {
		forceUnpublishStream(session.streams[i].streamId);
	}*/

	//make the publisher img invisible after receiving access
	$("#myPublisherDiv").addClass("invisible");
	session.publish(publisher);
}

function forceUnpublishStream(streamId) {
    session.forceUnpublish(subscribers[streamId].stream);
}

function sessionConnectedHandler(event) {
	stateManager = session.getStateManager();
	stateManager.addEventListener("changed:raiseHand", raiseHandHandler);
	stateManager.addEventListener("changed:moderator_switchUser", switchPublishingUserHandler);
	
	//only a teacher can publish when connecting to the session
	if(data.role == "teacher"){
		var div = document.createElement('div');
		div.setAttribute('id', 'publisher');
		$('#myPublisherDiv').append(div);
		publisher = TB.initPublisher(data.apiKey, div);

		//TODO - only add publisher if camera and mic detected

		publisher.addEventListener('accessAllowed', accessAllowedHandler);
>>>>>>> 139cf0c6116614d19146b9fdd78206bba7ea04ce
	}

	function accessAllowedHandler(event){
		//make the publisher img invisible after receiving access
		$("#myPublisherDiv").addClass("invisible");
	}
}

<<<<<<< HEAD
function raisehand(){
	session.signal();
=======
function streamCreatedHandler(event) {
	// Subscribe to any new streams that are created
	subscribeToStreams(event.streams);
}

function subscribeToStreams(streams) {
	//display a generic message if professor is not connected yet
	if (streams.length == 0 &&
			data.role != "teacher"){
		$('#subscribers').append("<h4 id=\"noSession\">Waiting for instructor to start the session.</h4>");
	} else {
		$('#noSession').remove();
		for (var i = 0; i < streams.length; i++) {
			// Create the div to put the subscriber element in to
			var div = document.createElement('div');
			div.setAttribute('id', 'stream' + streams[i].streamId);
			$('#subscribers').append(div);

			// Subscribe to the stream
			var subscribeProps = {width:400, height:225};
			session.subscribe(streams[i], div.id, subscribeProps);
		}
		generateUserDashBoard(data.role);
	}
>>>>>>> 139cf0c6116614d19146b9fdd78206bba7ea04ce
}