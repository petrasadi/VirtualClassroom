var counter=1;

onOpened = function() {
  connected = true;
  sendMessage('I joind the class');
};

onMessage = function(aMessage){
    var li = document.createElement('li');
    li.setAttribute('class', 'message');
    li.textContent = aMessage.data;
    $('#messageList').append(li);
};

function sendMessage (message) {
	message = data.userData.firstName + ' says: ' + message;
	$.post('chat', 
		{user: userId, classId: classId, message: message},
		function (mess) { }, 'json'
	);
}