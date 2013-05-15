<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="/javascript/bootstrap.js"></script>
<script>
		$(".collapse").collapse();
		$('.badge').tooltip('toggle');
		$('#myModal').modal('toggle');
</script>
<div class="container">

<h2>User Instructions</h2>


<div style="text-align:left">
    <ol>
        <li>User
            <ol type="a">
                <li><a href="#login">Logging In</a></li>
                <li><a href="#registration">Registration</a></li>
                <li><a href="#editaccountinformation">Edit Account Information</a></li>
            </ol>
        <li>Teacher
            <ol type="a">
                <li><a href="#createclass">Create a class</a></li>
                <li><a href="#viewclassteaching">View all classes that you are teaching</a></li>
                <li><a href="#joinclassteacher">Join the class as the teacher</a></li>
            </ol>
        <li>Students
            <ol type="a">
                <li><a href="#listclassregistration">List all available classes for registration</a></li>
                <li><a href="#registerclass">Register for the class</a></li>
                <li><a href="#joinclassstudent">Join the class as the student</a></li>
            </ol>
        <li><a href="#contactus">Contact Us</a>
    </ol>
</div>


<a name="login"></a>

<button type="button" class="btn btn-warning" data-toggle="collapse" data-target="#login">Logging In</button>
<div id="login" class="collapse">
<h2>Logging In </h2>
<br/>

<div style="text-align:left">
    Select the login button in the top right hand corner.  You will be redirected to use your Google account to loggin.
</div>
<br/>
<img align="left" src="./images/userinstructions/logintab.PNG" alt="login">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<a name="registration"></a>
</div>
<br/>
<button type="button" class="btn btn-warning" data-toggle="collapse" data-target="#register">Registration</button>
<div id="register" class="collapse">
<h2>Registration</h2>

<div style="text-align:left">
    The first time you login using your Google user account, you will be required to fill out the virtual class room registration
    information.
    <br/>
    <br />
    Fill out the form and submit the form by clicking on the register button.
    <br/>
    <br/>
    Below is an example of the registration form. Be sure to sign up to become either a teacher, a student or both.
</div>
<br/><br/><br/>
<img align="left" src="./images/userinstructions/registration.PNG" alt="registration">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<a name="editaccountinformation"></a>
<br/><br/><br/><br/>
</div>
<br/>
<button type="button" class="btn btn-warning" data-toggle="collapse" data-target="#accountInfo">Edit Account Information</button>
<img src="#" class="icon-film" data-toggle="modal" data-target="#editInformationModal"></img>
<!-- Modal -->
<div id="editInformationModal" class="modal hide fade">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>Update User Information</h3>
  </div>
  <div class="modal-body">
    <OBJECT classid='clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B' width="1000"
        height="800" codebase='http://www.apple.com/qtactivex/qtplugin.cab'>
        <param name='src' value="/video/editInformation.mov">
        <param name='autoplay' value="true">
        <param name='controller' value="true">
        <param name='loop' value="false">
        <EMBED src="/video/editInformation.mov" width="600" height="400" autoplay="true" 
        controller="true" loop="false" pluginspage='http://www.apple.com/quicktime/download/' scale="tofit">
        </EMBED>
        </OBJECT>
  </div>
</div>
<!-- End Modal -->
<div id="accountInfo" class="collapse">
<h2>Edit Account Information</h2>
<br/>

<div style="text-align:left">
    To edit your account information, select the Account Infromation and Edit.
    <br> Here you can change all of your account information to include your roles as a teacher and/or student.
</div>
<br/><br/>
<img align="left" src="./images/userinstructions/editaccount.PNG" alt="editaccount">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<a name=createclass></a>
</div><br/>
<button type="button" class="btn btn-warning" data-toggle="collapse" data-target="#createClass">Create a class</button>
<img src="#" class="icon-film" data-toggle="modal" data-target="#createClassModal"></img>
<!-- Modal -->
<div id="createClassModal" class="modal hide fade">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>Create Class Demo</h3>
  </div>
  <div class="modal-body">
    <OBJECT classid='clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B' width="1000"
        height="800" codebase='http://www.apple.com/qtactivex/qtplugin.cab'>
        <param name='src' value="/video/createClass.mov">
        <param name='autoplay' value="true">
        <param name='controller' value="true">
        <param name='loop' value="false">
        <EMBED src="/video/createClass.mov" width="600" height="400" autoplay="true" 
        controller="true" loop="false" pluginspage='http://www.apple.com/quicktime/download/' scale="tofit">
        </EMBED>
        </OBJECT>
  </div>
</div>
<!-- End Modal -->
<div id="createClass" class="collapse">
<h2>Create a class</h2>

<div style="text-align:left">
    To create a class select the create class under the teacher tab.
    <br/>If you do not have the teacher tab, don't worry, you can give yourself the teacher role by editing the your <a
        href="#editaccountinformation">account information</a>.
</div>
<br/><br/><br/>
<img align="left" src="./images/userinstructions/createclass.PNG" alt="editaccount">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<br/>

<div style="text-align:left">
    Below is an example of the create class form.
    <br/>Fill out the form and select create class to submit the form and the class will be created.
</div>
<br/><br/><br/>
<img align="left" src="./images/userinstructions/createclassform.PNG" alt="createclass">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<br/>
<a name="viewclassteaching"></a>
</div><br/>
<button type="button" class="btn btn-warning" data-toggle="collapse" data-target="#viewTeacherClasses">View all classes that you are teaching</button>
<img src="#" class="icon-film" data-toggle="modal" data-target="#teacherViewClassesModal"></img>
<!-- Modal -->
<div id="teacherViewClassesModal" class="modal hide fade">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>View Class List to Teach</h3>
  </div>
  <div class="modal-body">
    <OBJECT classid='clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B' width="1000"
        height="800" codebase='http://www.apple.com/qtactivex/qtplugin.cab'>
        <param name='src' value="/video/teachViewClasses.mov">
        <param name='autoplay' value="true">
        <param name='controller' value="true">
        <param name='loop' value="false">
        <EMBED src="/video/teachViewClasses.mov" width="600" height="400" autoplay="true" 
        controller="true" loop="false" pluginspage='http://www.apple.com/quicktime/download/' scale="tofit">
        </EMBED>
        </OBJECT>
  </div>
</div>
<!-- End Modal -->
<div id="viewTeacherClasses" class="collapse">
<h2>View all classes that you are teaching</h2>
<br/>

<div style="text-align:left">
    To view all the classes that you are teaching, select the Scheduled Classes under the teacher tab.
    <br/>If you have not created any classes, <a href="#createclass"> learn how to create a class</a>.
</div>
<br/><br/><br/>
<img align="left" src="./images/userinstructions/createclass.PNG" alt="scheduledclasses">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

<div style="text-align:left">
    Your scheduled class will be will listed.
</div>
<img align="left" src="./images/userinstructions/scheduledclasses.PNG" alt="scheduledclasses">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<br/>
<a name="joinclassteacher"></a>
</div><br/>
<button type="button" class="btn btn-warning" data-toggle="collapse" data-target="#teacherJoin">Join the class as the teacher</button>
<img src="#" class="icon-film" data-toggle="modal" data-target="#teacherStartClassesModal"></img>
<!-- Modal -->
<div id="teacherStartClassesModal" class="modal hide fade">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>Start a class as a teacher</h3>
  </div>
  <div class="modal-body">
    <OBJECT classid='clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B' width="1000"
        height="800" codebase='http://www.apple.com/qtactivex/qtplugin.cab'>
        <param name='src' value="/video/startClassTeacher.mov">
        <param name='autoplay' value="true">
        <param name='controller' value="true">
        <param name='loop' value="false">
        <EMBED src="/video/startClassTeacher.mov" width="600" height="400" autoplay="true" 
        controller="true" loop="false" pluginspage='http://www.apple.com/quicktime/download/' scale="tofit">
        </EMBED>
        </OBJECT>
  </div>
</div>
<!-- End Modal -->
<div id="teacherJoin" class="collapse">
<h2>Join the class as the teacher</h2>
<br/>

<div style="text-align:left">
    When it becomes time to teach the class, you as the teacher must start the class. To start the class,
    <br/> select the Start Class for the class the is about to start from your class schedule list.  The Start Class button will show up 30 minutes prior to the start of the class.
    <a href="#viewclassteaching"> Click here to learn how to list your schedule</a>.
</div>
<br/><br/><br/>
<img align="left" src="./images/userinstructions/teacherjoin.PNG" alt="scheduledclasses">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<br/>
<a name="listclassregistration"></a>
</div><br/>
<button type="button" class="btn btn-warning" data-toggle="collapse" data-target="#listAllClasses">List all available classes for registration</button>
<img src="#" class="icon-film" data-toggle="modal" data-target="#studentViewClassesModal"></img>
<!-- Modal -->
<div id="studentViewClassesModal" class="modal hide fade">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>Start a class as a teacher</h3>
  </div>
  <div class="modal-body">
    <OBJECT classid='clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B' width="1000"
        height="800" codebase='http://www.apple.com/qtactivex/qtplugin.cab'>
        <param name='src' value="/video/registerForClass.mov">
        <param name='autoplay' value="true">
        <param name='controller' value="true">
        <param name='loop' value="false">
        <EMBED src="/video/registerForClass.mov" width="600" height="400" autoplay="true" 
        controller="true" loop="false" pluginspage='http://www.apple.com/quicktime/download/' scale="tofit">
        </EMBED>
        </OBJECT>
  </div>
</div>
<!-- End Modal -->
<div id="listAllClasses" class="collapse">
<h2>List all available classes for registration</h2>
<br/>

<div style="text-align:left">
    To list all available classes to register for, click the student tab and select Register for a class.
    <br/>If you do not have the student tab, don't worry, you can give yourself the student role by editing the your <a
        href="#editaccountinformation">account information</a>.
    <br/><br/><br/>
    <img align="left" src="./images/userinstructions/studenttab.PNG" alt="studenttab">
</div>
<br/><br/><br/><br/><br/><br/><br/><br/>
<a name="registerclass"></a>
<button type="button" class="btn btn-warning" data-toggle="collapse" data-target="#registerForClass">Register for the class</button>
<div id="registerForClass" class="collapse">
<h2>Register for the class</h2>
<br/>

<div style="text-align:left">
    To register for a class, <a href="#listclassregistration">list all available classes to register for</a>, click the
    Register button for the class you wish to register for.
    <br/><br/><br/>
    <img align="left" src="./images/userinstructions/register.PNG" alt="register">
</div>
<br/><br/>
</div><br/>
<a name="joinclassstudent"></a>
</div><br/>
<button type="button" class="btn btn-warning" data-toggle="collapse" data-target="#joinAsStudent">Join the class as the student</button>
<img src="#" class="icon-film" data-toggle="modal" data-target="#studentStartClassesModal"></img>
<!-- Modal -->
<div id="studentStartClassesModal" class="modal hide fade">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>Start a class as a teacher</h3>
  </div>
  <div class="modal-body">
    <OBJECT classid='clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B' width="1000"
        height="800" codebase='http://www.apple.com/qtactivex/qtplugin.cab'>
        <param name='src' value="/video/studentStartClass.mov">
        <param name='autoplay' value="true">
        <param name='controller' value="true">
        <param name='loop' value="false">
        <EMBED src="/video/studentStartClass.mov" width="600" height="400" autoplay="true" 
        controller="true" loop="false" pluginspage='http://www.apple.com/quicktime/download/' scale="tofit">
        </EMBED>
        </OBJECT>
  </div>
</div>
<!-- End Modal -->
<div id="joinAsStudent" class="collapse">
<h2>Join the class as the student</h2>

<div style="text-align:left">
    When it comes time to take the class, join the class to start learning.
    Once you have <a href="#registerclass"> registered </a> for the class, <a href="#listclassregistration">list all
    available classes to register for </a>, click the Join button for the class you wish to join. The join button will only appear 30 minutes prior to the start of the class.
    <br/><br/><br/>
    <img align="left" src="./images/userinstructions/studentjoin.PNG" alt="register">
</div>
<br/><br/><br/><br/><br/><br/><br/><br/>
<a name="contactus"></a>
</div><br/>
<h2>Contact Us</h2>

<div style="text-align:left">
    Feel free to contact us for comments, help, or information by emailing us at <a
        href="mailto:se_491virtualclassroom@googlegroups.com">se_491virtualclassroom@googlegroups.com </a>.
    <br/>One of our team members will get with you as soon as posible.
</div><br/><br/>
</div>
