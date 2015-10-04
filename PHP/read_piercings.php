<?php
	$servername = "localhost";
	$username1 = "root";
	$password1 = "";

	$con=mysqli_connect($servername,$username1,$password1,"joni_ink_db");

	if (mysqli_connect_errno($con))
	{
   		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	

	$statement = "";
	if(isset($_GET['area']) && isset($_GET['material'])){
		$area = $_GET['area'];
		$material = $_GET['material'];

		$statement = "SELECT * FROM piercing_table where usable=1 and area_id = $area and material_id = $material";
	}else{
		$statement = "SELECT * FROM piercing_table where usable=1";
	}

	

	//$result = mysqli_query($con,"SELECT * FROM piercing_table where usable=1");
	$result = mysqli_query($con, $statement);
	
	$rows = array();
	while($r = mysqli_fetch_assoc($result)) {
		$row[] = $r;
	}
	echo json_encode($row);

	mysqli_close($con);

	exit();
?>