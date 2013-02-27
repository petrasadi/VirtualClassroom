var channel;
var socket;
var userId;
var classId;
var token=null;

function initChat(userOpenId, classOpenTokId) {
	if (token == null) {
		userId = userOpenId; classId = classOpenTokId; 
	    $.post('initChat', {user: userId, classId: classId},
	        function (data) {
	            getChatToken(data);
	        },
	        'json'
	    );
	}
    
	//TODO - create and open the chat div
}

function getChatToken(data){
	token = data.token;
	channel = new goog.appengine.Channel(token);
	socket = channel.open();
	socket.onopen = onOpened;
	socket.onmessage = onMessage;
    socket.onerror = function() {alert("Error");}; //onError;
    socket.onclose = function() {
    	token = null;
    	alert("Close");
	}; //onClose;
}