<?php

	require('connect.php');

	 $useremail = "daradesagar74@gmail.com";
	 $userpass = "sagar4215";

	//$useremail = $_GET['useremail'];
	//$userpass = $_GET['userpass'];

	$sql = "SELECT uname FROM user WHERE useremail = '$useremail' AND userpass = '$userpass';";

	$result = mysqli_query($conn, $sql);

	if(!mysqli_num_rows($result) > 0) {
		$status = 'failed';
		echo json_encode(array("response"=>$status));
	}

	else {
		$row = mysqli_fetch_assoc($result);
		$name = $row['uname'];
		$status = "ok";
		echo json_encode(array("response"=>$status,"name"=>$name));
	}

	mysqli_close($conn);

?>