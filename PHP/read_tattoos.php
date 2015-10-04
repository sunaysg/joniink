<?php
	$servername = "localhost";
	$username1 = "root";
	$password1 = "";

	$con=mysqli_connect($servername,$username1,$password1,"joni_ink_db");

	if (mysqli_connect_errno($con))
	{
   		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
	$result = mysqli_query($con,"SELECT * FROM tattoo_table where usable=1");

	$rows = array();
	while($r = mysqli_fetch_assoc($result)) {
		$row[] = $r;
	}
	echo json_encode($row);

	mysqli_close($con);

	exit();
?>