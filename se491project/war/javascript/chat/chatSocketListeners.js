onOpened = function() {
  connected = true;
  //TODO - create/show the chat divs
  
  //TODO - customize the message sent to chat server
  sendMessage('onOpened succesfully called');
};

onMessage = function(aMessage){
	alert(aMessage.data);
};
//TODO - onError;
//TODO - onClose;

function sendMessage (message) {
	$.post('chat', 
		{user: userId, classId: classId, message: message},
		function (mess) { }, 'json'
	);
}