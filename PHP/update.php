<?php
	$servername = "localhost";
	$username1 = "root";
	$password1 = "";

	$con= new mysqli($servername,$username1,$password1,"joni_ink_db");
	
	//Getting data from Android
	$order_id = $_GET["order_id"];
	$status = $_GET["status"];
	$isTattoo = $_GET["is_tattoo"];
	$toDayDate = date("Y-m-d");
	$sql = "";

	if($isTattoo == 0){
		$sql = "update piercing_order_table set status = $status, approved_date = '$toDayDate' where id = $order_id ";
	}
	else{
		$sql = "update tattoo_order_table set status = $status , approved_date = '$toDayDate' where id = $order_id ";
	}

	$result = $con->query($sql);
	echo $result;
	mysqli_close($con);
?>