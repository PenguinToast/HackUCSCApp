<?php 
	ob_start(); 
	include('config.php');
	session_start();
	$islog; 
	if (isset($_GET['email']))
		$email = $_GET['email'];
	if (isset($_GET['pass']))
		$pass = $_GET['pass'];
	$query = "SELECT * FROM user WHERE Email='$email' and Password='$pass'";
	$result = mysql_query($query);
	$count = mysql_num_rows($result);
	$row  = mysql_fetch_array($result);
	if(is_array($row)) {
		$islog = true;
	} 
	else {
		$islog = false;
	}
	
	echo(json_encode($islog));
?>
	