<?php ob_start(); ?>
<?php
session_start();
	
	$seconds = -1000 + time();
	setcookie(loggedin, date("F jS - g:i a"), $seconds);

		session_destroy(); 
			header("location:index.php");
		


?>
<meta http-equiv="refresh" content="0">
<?  ob_flush(); ?>
