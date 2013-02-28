var counter=1;

onOpened = function() {
  connected = true;
  //TODO - customize the message sent to chat server
  sendMessage(userId + ' joind the class');
};

onMessage = function(aMessage){
	//alert(aMessage.data);
    var li = document.createElement('li');
    li.setAttribute('class', 'message');
    li.textContent = aMessage.data;
    $('#messageList').append(li);
};

function sendMessage (message) {
	$.post('chat', 
		{user: userId, classId: classId, message: message},
		function (mess) { }, 'json'
	);
}