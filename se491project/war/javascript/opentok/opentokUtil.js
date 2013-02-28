var session;
var speakRequestsSet = { };
var data;
var stateManager;

function handleOpenTok(dt){
	data = dt;
	var publisher;

	var apiKey = data.apiKey;
	var sessionId = data.sessionId;
	var token = data.token;
	var userRole = data.role;

	//TODO - this should change in production
	TB.setLogLevel(TB.DEBUG);

	session = TB.initSession(sessionId);      
	session.addEventListener('sessionConnected', sessionConnectedHandler);
	session.addEventListener('streamCreated', streamCreatedHandler);
	//session.addEventListener("signalReceived", raiseHandHandler);
	session.connect(apiKey, token);	
}









function raisehand(){
	var connectionId = session.connection.connectionId;
	stateManager.set("raiseHand", connectionId);
}

//TODO - fix raiseHand event
function raiseHandHandler(event){
	var connectionId = event.changedValues["raiseHand"];

	//ignore request if already registered
	if (!(connectionId in speakRequestsSet) ||
			(speakRequestsSet[connectionId] === false)){
		speakRequestsSet[connectionId] = true;

		var rqstParams = "'" + data.role + "', '" + connectionId + "'";
		var btnId = "requestButton" + connectionId;
		var element = '<input class="dashboardButton" ';
		element += 'id="' + btnId + '"';
		element += 'type="image" src="images/opentok/face.png" title="student speak request"';
		element += 'onclick="switchPublishingUser(' + rqstParams + ')"';
		element += '>';
		$('#speakRequests').append(element);
	}
}











function switchPublishingUser(userRole, connectionId){
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
		//TODO -  add user name
		var publisherProperties = {rememberDeviceAccess:"true"};
		publisher = TB.initPublisher(data.apiKey, div, publisherProperties);

		//TODO - only add publisher if camera and mic detected
		publisher.addEventListener('accessAllowed', accessAllowedHandler);
	}
	//$("#conferenceContainer").width(1000);
}







function unsubscribeAll() {
	stateManager.set("moderator_forceUnpublish", session.connection.connectionId);
}

function forceUnpublishHandler(event) {
	var connectionId = event.changedValues["moderator_forceUnpublish"];
	if (data.role != "teacher"){
		session.unpublish(publisher);
	}
}









function sessionConnectedHandler(event) {
	stateManager = session.getStateManager();
	stateManager.addEventListener("changed:raiseHand", raiseHandHandler);
	stateManager.addEventListener("changed:moderator_switchUser", switchPublishingUserHandler);
	stateManager.addEventListener("changed:moderator_forceUnpublish", forceUnpublishHandler);

	//only a teacher can publish when connecting to the session
	if(data.role == "teacher"){
		var div = document.createElement('div');
		div.setAttribute('id', 'publisher');
		$('#myPublisherDiv').append(div);
		
		//TODO - get the profs name fromt the db and set here, or hide
		
		var publisherProperties = {name:"Instructor", rememberDeviceAccess:"true",
				style:{nameDisplayMode:"off"}
		};
		publisher = TB.initPublisher(data.apiKey, div, publisherProperties);

		//TODO - only add publisher if camera and mic detected

		publisher.addEventListener('accessAllowed', accessAllowedHandler);
	}

	// Subscribe to streams that were in the session when we connected
	subscribeToStreams(event.streams);
}

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
			var subscriber=null;
			
			if (streams[i].name=="Instructor") {
				// Create the div to put the subscriber element in to
				var div = document.createElement('div');
				div.setAttribute('id', 'stream' + streams[i].streamId);
				$('#teacherVideo').append(div);

				// Subscribe to the stream
				var subscribeProps = {width: 400, height: 225};
				subscriber = session.subscribe(streams[i], div.id, subscribeProps);
			} else {
				// Create the div to put the subscriber element in to
				var div = document.createElement('div');
				div.setAttribute('id', 'stream' + streams[i].streamId);
				$('#studentsVideo').append(div);

				// Subscribe to the stream
				var subscribeProps = {width: 150, height: 84};
				var subscriber = session.subscribe(streams[i], div.id, subscribeProps);
			}


			if (streams[i].connection.connectionId == session.connection.connectionId) {
				subscriber.subscribeToAudio(false);
			}
		}
		generateUserDashBoard(data.role);
	}
}


function accessAllowedHandler(event){

	//make the publisher img invisible after receiving access
	$("#myPublisherDiv").addClass("invisible");
	session.publish(publisher);
}