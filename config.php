<?php
// Connection's Parameters
$db_host="localhost";
$db_name="hackathon";
$username="root";
$password="earth2412";

$db_con=mysql_connect($db_host,$username,$password);
$connection_string=mysql_select_db($db_name);
// Connection
$dbhandle = mysql_connect($db_host,$username,$password) or die("Could not connect to database");
$selected = mysql_select_db($db_name);
?>