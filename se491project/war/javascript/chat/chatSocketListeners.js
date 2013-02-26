onOpened = function() {
  connected = true;
  //TODO - create/show the chat divs
  
  //send message to chat server
  sendMessage('opened');
  
  //TODO - update the message board
};

//TODO - onMessage;
//TODO - onError;
//TODO - onClose;

function sendMessage (message) {
	alert("onOpened succesfully called");
}