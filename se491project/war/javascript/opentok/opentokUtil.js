function handleOpenTok(data){
	var apiKey = data.apiKey;
	var sessionId = data.sessionId;
	var token = data.token;
	var userRole = data.role;

	//TODO - this should change in production
	TB.setLogLevel(TB.DEBUG);

	var session = TB.initSession(sessionId);      
	session.addEventListener('sessionConnected', sessionConnectedHandler);
	session.addEventListener('streamCreated', streamCreatedHandler);
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
		}
	}

	function accessAllowedHandler(event){
		//make the publisher img invisible after receiving access
		$("#myPublisherDiv").addClass("invisible");
	}
}