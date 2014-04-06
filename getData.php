<?php 
	ob_start(); 
	include('config.php');
	session_start();
	$islog; 
	$email = $_SESSION['User'];
	$query = "SELECT * FROM user WHERE Email='$email'";
	$result = mysql_query($query);
	$row  = mysql_fetch_array($result);
	echo(json_encode($row));
?>
	