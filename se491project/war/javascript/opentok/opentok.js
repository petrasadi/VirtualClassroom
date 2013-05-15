function endOpenTokSession() {
    $.post('opentok', {param: 'forget'},
        function () {
            //TODO - fix me
            $("#myPublisherDiv").html();
        }
    );
}

function getSessionInfo(userOpenId, classOpenTokId) {
    $.post('opentok', {classId: classOpenTokId, user: userOpenId},
        function (data) {
            handleOpenTok(data);
        },
        'json'
    );
}

function generateUserDashBoard(userRole) {
    //FIXME - this implem uses more bandwidth than necessary
    if (userRole == 'student') {
        $('#teacherDashboard').remove();
    } else
        $('#studentDashboard').remove();
    $('#userDashboard').fadeIn("slow");
}