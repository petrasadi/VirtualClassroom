onOpened = function() {
  connected = true;
  //TODO - create/show the chat divs
  
  //send message to chat server
  sendMessage('onOpened succesfully called');
  
  //TODO - update the message board
};

//TODO - onMessage;
//TODO - onError;
//TODO - onClose;

function sendMessage (message) {
	$.post('chat', {user: userId, classId: classId, message: message},
	    function (data) {
	        getChatToken(data);
	    },
	    'json'
	);
}

function getMessage (data){
	alert(data);
}