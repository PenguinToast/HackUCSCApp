<?php 
	ob_start(); 
	include('config.php');
	session_start();
	$islog; 
	if (isset($_GET['x1']))
		$x1 = $_GET['x1'];
	if (isset($_GET['x2']))
		$x2 = $_GET['x2'];
	if (isset($_GET['x3']))
		$x3 = $_GET['x3'];
	if (isset($_GET['x4']))
		$x4 = $_GET['x4'];
	if (isset($_GET['x5']))
		$x5 = $_GET['x5'];
	$email = $_SESSION['User'];
	mysql_query("UPDATE user SET Pref1 = '$x1', Pref2 ='$x2', Pref3 = '$x3', Pref4 = '$x4', Pref5 = '$x5' WHERE Email = '$email'");
		
	
?>
	