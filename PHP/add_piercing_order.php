<?php
	$servername = "localhost";
	$username1 = "root";
	$password1 = "";

	class PiercingOrder{
		public $id = "";
		public $piercing_id = "";
		public $order_date = "";
		public $approved_date = "";
		public $client_id = "";
		public $admin_id = "";
		public $status = 1;
	}

	$t = new PiercingOrder();

	$con= new mysqli($servername,$username1,$password1,"joni_ink_db");
	
	//Getting data from Android
	$t->piercing_id = $_GET["piercing_id"];
	$t->order_date = date("Y-m-d");;
	$t->approved_date = "NULL";
	$t->client_id = $_GET["client_id"];
	$t->admin_id = "NULL";
	$t->status = 1;

	//sending data to DB
	$sql = "INSERT INTO piercing_order_table(piercing_id,order_date,approved_date,client_id,admin_id,status) VALUES ($t->piercing_id, '$t->order_date', '$t->approved_date', $t->client_id, $t->admin_id, $t->status)";

	$result = $con->query($sql);
	echo $result;
	mysqli_close($con);
?>