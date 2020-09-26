<?php

	require('connect.php');

	// $name = "Parnavi";
	// $uemail = "pari0101@gmail.in";
	// $pass = "parna123";

	$number = $_GET['unumber'];

	$name = $_GET['uname'];
	$uemail = $_GET['useremail'];
	$pass = $_GET['userpass'];
	
	$sql = "SELECT * FROM `user` WHERE useremail = '$uemail' OR unumber = '$number'";

	$result = mysqli_query($conn, $sql);

	if(mysqli_num_rows($result) > 0) {
		
		$status = "exists";
	}
	else {

		$sql = "INSERT INTO user (uname,unumber,useremail,userpass) VALUES ('$name','$number','$uemail', '$pass');";
		
		if(mysqli_query($conn, $sql)) {
			$status = "okk";
		}
		else {
			$status = "error";
		}
	}

	echo json_encode(array("response"=>$status));

	mysqli_close($conn);

?>