<?php
	$servername = "localhost";
	$username1 = "root";
	$password1 = "";

	$con= new mysqli($servername,$username1,$password1,"joni_ink_db");
	
	//Getting data from Android
	$id = $_POST["id"];
	
	$sql1 = "SELECT used FROM piercing_table WHERE id='$id'";
	$res1 = $con->query($sql1);

	while ($row = mysqli_fetch_assoc($result)) {
   		$is_used = $row["used"];
	}

	if($is_used = 0){
		$sql = "DELETE FROM piercing_table WHERE id='$id'"; 
	}else{
		$sql = "UPDATE piercing_table SET usable=0 WHERE id='$id'";
	}

	$result = $con->query($sql);
	echo $result;
	mysqli_close($con);
?>