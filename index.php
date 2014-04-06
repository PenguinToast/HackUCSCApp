<?php 
	ob_start(); 
	session_start();
	if (isset($_SESSION["user"]) && isset($_COOKIE['loggedin']))
		header('location: login_success.php');
?>

		
		
<img src="Hot.png" height="100%" width="100%" style="z-index:-1;position:absolute;top:0;left:0;">
<img src="New Layout.png" height="100%" width="100%" style="z-index:-1;position:absolute;top:0;left:0;">
<style>
input
{
  -moz-border-radius: 15px;
 border-radius: 15px;
    border:solid 1px black;
    padding:5px;
	height:4%;
	width:36%;
}
</style>
<form action="login.php" method="post">
<input style="position:absolute;top:38%;left:33%;"type="text" name="user" id="user" placeholder="Username" value="">
<input style="position:absolute;top:48%;left:33%; type="password" name="pass" id="pass" placeholder="Password" value="">
<button style="z-index:500;top:52%;position:absolute;left:24%;width:50%;" class="ui-btn ui-corner-all" type="submit"><img height="30" width="100%" src="loginbutton.png"></button>

<a style="top:53.25%; height: 1%;; left:30%;width:10%; position:absolute;"type="button" href="new_user.php" class="ui-btn ui-corner-all" type="submit"><img src="register.png"></button>
		</form>
		
		<style>
		button {

    background: transparent;
    border: none !important;
}
</style>

	<table style="position:fixed; bottom:0;right:0;" border="0"  cellspacing="0" cellpadding="0">
		<tr>
			<td><a href="http:/www.google.com" id="email" ><img src="http://imgur.com/JOiuxC4.png" height="40%" width="100%" onMouseOver="this.src='http://i.imgur.com/xedSdTz.png'" onMouseOut="this.src='http://imgur.com/JOiuxC4.png'"></a></td>
		
			<td><a href="#" id="skull"><img src="http://imgur.com/F82M1lr.png" height="40%" width="100%" onMouseOver="this.src='http://i.imgur.com/FDLG9I3.png'" onMouseOut="this.src='http://imgur.com/F82M1lr.png'"></a></td>
		
			<td><a href="#" id="chat" ><img src="http://imgur.com/cMRXS8B.png" height="40%" width="100%" onMouseOver="this.src='http://i.imgur.com/TkJ1Xzc.png'" onMouseOut=		"this.src='http://imgur.com/cMRXS8B.png'"></a></td>
		</tr>
	</table>

