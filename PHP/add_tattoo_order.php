<?php
	$servername = "localhost";
	$username1 = "root";
	$password1 = "";

	class TattooOrder{
		public $id = "";
		public $tattoo_id = "";
		public $order_date = "";
		public $approved_date = "";
		public $client_id = "";
		public $admin_id = "";
		public $price = "";
		public $status = 1;
	}

	$t = new TattooOrder();

	$con= new mysqli($servername,$username1,$password1,"joni_ink_db");
	
	//Getting data from Android
	$t->tattoo_id = $_GET["tattoo_id"];
	$t->order_date = date("Y-m-d");
	$t->approved_date = "NULL";
	$t->client_id = $_GET["client_id"];
	$t->admin_id = "NULL";
	$t->price = $_GET["price"];
	$t->status = 1;

	//sending data to DB
	$sql = "INSERT INTO tattoo_order_table(tattoo_id,order_date,approved_date,client_id,admin_id,price,status) VALUES ($t->tattoo_id, '$t->order_date', '$t->approved_date', $t->client_id, $t->admin_id, $t->price, $t->status)";

	$sql2 = "UPDATE tattoo_table SET used=1, times_ordered=(times_ordered+1) WHERE id=$t->tattoo_id";


	$result = $con->query($sql);
	$result2 = $con->query($sql2);
	echo $result;
	mysqli_close($con);
?>