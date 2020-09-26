<?php
	
	require_once('connect.php');

	$query = "SELECT * FROM project;";

	$result = mysqli_query($conn, $query);

	if($result)
	{
		$row = array();
		while($res = mysqli_fetch_assoc($result)){
			$row[] = $res;
		}
		echo json_encode($row);
	}

	else{
		echo "No data found";
	}

	mysqli_close($conn);

?>
