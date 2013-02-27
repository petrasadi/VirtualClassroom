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
	  //TODO - create/show the chat divs like below 
	  /*
	  var commentForm = "<div id=\"formDiv\" style='margin:0px 10px 5px 5px;'> " +
	  "<input type='text' name=\"MessageInput\" id=\"MessageInput\" value='Write a comment...' />" +
	"</div>";
	  */
	
	//if the ENTER key is pressed - validate data and persist to db
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

function getChatToken(data){
	token = data.token;
	channel = new goog.appengine.Channel(token);
	socket = channel.open();
	socket.onopen = onOpened;
	socket.onmessage = onMessage;

	//TODO - onError and onClose;
    socket.onerror = function() {alert("Error");};
    socket.onclose = function() {
    	token = null;
    	alert("Close");
    	//TODO remove user from server's user list
	};
}