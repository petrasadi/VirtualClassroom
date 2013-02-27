var counter=1;

onOpened = function() {
  connected = true;
  //TODO - create/show the chat divs
  
  //TODO - customize the message sent to chat server
  sendMessage((counter++) + ' joind the class');
};

//FIXME - function called multiple times for same message
onMessage = function(aMessage){
	alert(aMessage.data);
    var li = document.createElement('li');
    li.setAttribute('class', 'message');
    li.textContent = aMessage.data;
    $('#messageList').append(li);
};
//TODO - onError;
//TODO - onClose;

function sendMessage (message) {
	$.post('chat', 
		{user: userId, classId: classId, message: message},
		function (mess) { }, 'json'
	);
}