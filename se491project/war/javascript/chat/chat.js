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
}

function getChatToken(data){
	token = data.token;
	channel = new goog.appengine.Channel(token);
	socket = channel.open();
	
	socket.onopen = onOpened;
	socket.onmessage = onMessage;
	socket.onerror = onError;
	socket.onclose = onClose;
}

function openChat() {
	//slide the conferenceContainer to the left
	$('#conferenceContainer').addClass('slideLeft');
	//show the chat div
	$('#chat').show();
	//hide the Open Chat button
	$('#openChatBtn').hide();
	

	//if the ENTER key is pressed - send message
	$('#messageInputDiv > #messageInput').keypress(function (k) {
		if (k.which == 13) {
			k.preventDefault();
			var newMessage = $('#messageInputDiv > #messageInput').val();
			if ((newMessage == "Write a comment...") || (newMessage == "")) {
				//do nothing
			} else {
				//TODO - security validation()
				sendMessage(newMessage);

				//reset the input field to the initial state
				$('#messageInputDiv > #messageInput').blur().val("Write a comment...");
			}
		}
	});

	//functionality for the Messages form
	//change the default value of the input field on focus
	$('#messageInputDiv > #messageInput').focus(function () {
		if ($(this).val() == "Write a comment...") {
			$(this).val("");
		}
	});
	//change the default value of the input field on blur
	$('#messageInputDiv > #messageInput').blur(function () {
		if ($(this).val() == "") {
			$(this).val("Write a comment...");
		}
	});
}

function closeChat() {
	
	//show the chat div
	$('#chat').hide();
	$('#openChatBtn').show();
	//slide the conferenceContainer back in the midle of page
	$('#conferenceContainer').removeClass('slideLeft');
}