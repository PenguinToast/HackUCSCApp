<?php ob_start(); ?>
<?php include('config.php') ?>
<?php
	session_start();

	$myusername = $_POST['user'];
	$mypassword = $_POST['pass'];
	
	$myusername = stripslashes($myusername);
	$mypassword = stripslashes($mypassword);
	
	$query = "SELECT * FROM user WHERE Email='$myusername' and Password='$mypassword'";
	$result = mysql_query($query);
	$count = mysql_num_rows($result);
	$row  = mysql_fetch_array($result);
	if(is_array($row)) {
		$_SESSION["user"] = $myusername;
	} 
	
	mysql_close();
	
	if(isset($_SESSION["user"])){
		$seconds = 1800 + time();
		setcookie(loggedin, date("F jS - g:i a"), $seconds);
		header("location:login_success.php");
	}else{
		header("location:bad_index.php");
	}
?>
<?  ob_flush(); ?>
