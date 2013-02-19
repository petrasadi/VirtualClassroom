function initChat(userOpenId, classOpenTokId) {
    $.post('initChat', {user: userOpenId, classId: classOpenTokId},
        function (data) {
            getChatToken(data);
        },
        'json'
    );
    
	//TODO - create and open the chat div
}

function getChatToken(data){
	//TODO - persist the token in the session?
	alert(data.chatToken);
}