<?php
	$servername = "localhost";
	$username1 = "root";
	$password1 = "";

	class Piercing{
		public $id = "";
		public $photo = "";
		public $price = "";
		public $material_id = "";
		public $area_id = "";
		public $used = "0";
		public $usable = "1";
		public $photo_small = "";
	}

	$t = new Piercing();

	$con= new mysqli($servername,$username1,$password1,"joni_ink_db");
	
	//Getting data from Android

	$t->id = $_POST["id"];
	$t->price = $_POST["price"];
	$t->material_id = $_POST["material"];
	$t->area_id = $_POST["area"];
	$t->usable = $_POST["usable"];
	
	//sending data to DB
	$sql = "UPDATE piercing_table
			SET price='$t->price', material_id='$t->material_id', area_id='$t->area_id', usable='$t->usable'
			WHERE id='$t->id'"; 

	$result = $con->query($sql);
	echo $result;
	mysqli_close($con);
?>