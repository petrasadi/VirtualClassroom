function endOpenTokSession() {
	$.post('opentok', {param: 'forget'},
		function () {
			//TODO - fix me
			$("#myPublisherDiv").html();
		}
	);
}

function getSessionInfo(userOpenId) {
	//TODO - read classId from request params
	var classOpenTokId = 0;
	$.post('opentok', {classId: classOpenTokId, user: userOpenId} ,
		function (data) {
			handleOpenTok(data);
			setupChatFunctionality(data.role);
		},
		'json'
	);
}

<<<<<<< HEAD
function setupChatFunctionality(userRole) {
	if (userRole == 'student'){
		$('#studentDashboard').show();
	} else
		$('#teacherDashboard').show();
=======
function handleOpenTok(data){
	var apiKey = data.apiKey;
	var sessionId = data.sessionId;
	var token = data.token;

	//TODO - this should change in production
	TB.setLogLevel(TB.DEBUG);

	var session = TB.initSession(sessionId);      
	session.addEventListener('sessionConnected', sessionConnectedHandler);
	session.addEventListener('streamCreated', streamCreatedHandler);      
	session.connect(apiKey, token);

	var publisher;

	function sessionConnectedHandler(event) {
		var div = document.createElement('div');
		div.setAttribute('id', 'publisher');
		$('#myPublisherDiv').append(div);
		publisher = TB.initPublisher(apiKey, div);
		session.publish(publisher);

		// Subscribe to streams that were in the session when we connected
		subscribeToStreams(event.streams);
	}

	function streamCreatedHandler(event) {
		// Subscribe to any new streams that are created
		subscribeToStreams(event.streams);
	}

	function subscribeToStreams(streams) {
		for (var i = 0; i < streams.length; i++) {
			// Make sure we don't subscribe to ourself
/*			if (streams[i].connection.connectionId == session.connection.connectionId) {
				return;
			}*/

			// Create the div to put the subscriber element in to
			var div = document.createElement('div');
			div.setAttribute('id', 'stream' + streams[i].streamId);
			$('#subscribers').append(div);

			// Subscribe to the stream
			var subscribeProps = {width:400, height:225};
			session.subscribe(streams[i], div.id, subscribeProps);

			//$('#myPublisherDiv').hide();
		}
	}
>>>>>>> refs/remotes/origin/rel1
}
