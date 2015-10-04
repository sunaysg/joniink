<?php
	$servername = "localhost";
	$username1 = "root";
	$password1 = "";

	class Tattoo{
		public $id = "";
		public $photo = "";
		public $price_s = "";
		public $price_m = "";
		public $price_l = "";
		public $colour = "";
		public $difficulty = "";
		public $used = "0";
		public $usable = "1";
		public $photo_small = "";
	}

	$t = new Tattoo();

	$con= new mysqli($servername,$username1,$password1,"joni_ink_db");
	
	//Getting data from Android

	$t->id = $_POST["id"];
	$t->price_s = $_POST["price_s"];
	$t->price_m = $_POST["price_m"];
	$t->price_l = $_POST["price_l"];
	$t->colour = $_POST["colour"];
	$t->difficulty = $_POST["difficulty"];
	$t->usable = $_POST["usable"];
	
	//sending data to DB
	$sql = "UPDATE tattoo_table
			SET price_s='$t->price_s', price_m='$t->price_m', price_l='$t->price_l', colour='$t->colour', difficulty='$t->difficulty', usable='$t->usable'
			WHERE id='$t->id'"; 

	$result = $con->query($sql);
	echo $result;
	mysqli_close($con);
?>