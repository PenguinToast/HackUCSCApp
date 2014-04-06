<?php ob_start(); ?>
<?php include('config.php') ?>
<?php
	session_start();

	if(!isset($_COOKIE['loggedin'])){
		header("location:index.php");
	}
	
	
	$username = $_SESSION['user'];
	$query = "SELECT * FROM user WHERE Email='$username'";
		$result = mysql_query($query);
	global $row;
	$row  = mysql_fetch_array($result);
		
	if(isset($_POST['x1']) && isset($_POST['x2']) && isset($_POST['x3']) && isset($_POST['x4']) && isset($_POST['x5'])){
		$x1 = $_POST['x1'];
		$x2 = $_POST['x2'];
		$x3 = $_POST['x3'];
		$x4 = $_POST['x4'];
		$x5 = $_POST['x5'];
		mysql_query("UPDATE user SET Pref1 = '$x1', Pref2 ='$x2', Pref3 = '$x3', Pref4 = '$x4', Pref5 = '$x5' WHERE Email = '$username'");
	}
?>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
</head>
<body>

<div data-role="page">
  <div data-role="header">
   
  <h1>Surfing Preferences</h1>
  </div>
<?php 
		global $row;
echo("<div data-role='main' class='ui-content'>
    <form method='post' action='login_success.php'>
      <label for='points'>X1:</label>
      <input type='range' name='x1' id='x1' value='".$row[4]."' min='0' max='100'>
	   <label for='points'>X2:</label>
      <input type='range' name='x2' id='x2' value='".$row[5]."' min='0' max='100'>
	  <label for='points'>X3:</label>
      <input type='range' name='x3' id='x3' value='".$row[6]."' min='0' max='100'>
	  <label for='points'>X4:</label>
      <input type='range' name='x4' id='x4' value='".$row[7]."' min='0' max='100'>
	  <label for='points'>X5:</label>
      <input type='range' name='x5' id='x5'value='".$row[8]."' min='0' max='100'>
      <input type='submit' data-inline='true' value='Update Prefences'>
    </form>
  </div>
</div>");
		
?>
  

</body>
</html>
