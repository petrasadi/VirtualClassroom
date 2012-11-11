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

function setupChatFunctionality(userRole) {
	if (userRole == 'student'){
		$('#studentDashboard').show();
	} else
		$('#teacherDashboard').show();
}