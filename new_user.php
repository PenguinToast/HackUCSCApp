<?php 
	ob_start(); 
	include('config.php');
	session_start();
	$islog; 
	if (isset($_GET['email']))
		$email = $_GET['email'];
	if (isset($_GET['pass']))
		$pass = $_GET['pass'];
	if (isset($_GET['name']))
		$pass = $_GET['name'];
	
	$query = mysql_query("SELECT * FROM user WHERE Email='$email'");
	$m = mysql_query("ALTER TABLE user ADD $email text NOT NULL");
	$l = mysql_query("ALTER TABLE user ALTER $email SET DEFAULT '0'");
	if(mysql_num_rows($query) > 0 ) { 
		$islog = false;
	}else{
		$islog = true;
		mysql_query("INSERT INTO user (Name, Email, Password) VALUES ('$name', '$email', '$pass')"); header('Location: index.php');
	}
	
	
	
	echo(json_encode($islog));
?>
	

		
