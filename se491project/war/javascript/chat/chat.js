var channel;
var socket;
var userId;
var classId;

function initChat(userOpenId, classOpenTokId) {
	userId = userOpenId; classId = classOpenTokId; 
    $.post('initChat', {user: userId, classId: classId},
        function (data) {
            getChatToken(data);
        },
        'json'
    );
    
	//TODO - create and open the chat div
}

function getChatToken(data){
	channel = new goog.appengine.Channel(data.token);
	socket = channel.open();
	socket.onopen = onOpened;
	socket.onmessage = onMessage;
    socket.onerror = function() {alert("Error");}; //onError;
    socket.onclose = function() {alert("Close");}; //onClose;
}