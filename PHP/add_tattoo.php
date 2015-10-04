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
		public $times_ordered = "";
	}

	$t = new Tattoo();

	$con= new mysqli($servername,$username1,$password1,"joni_ink_db");
	
	//Getting data from Android
	$base64_string = $_POST["photo"];
	$decoded=base64_decode($base64_string);
	$path = 'images/';
	$name = "t-".date('h-i-s-j-m-y');
	file_put_contents($path.$name.'.jpg',$decoded);

	$base64_string2 = $_POST["photos"];
	$decoded2=base64_decode($base64_string2);
	$name2 = "tm-".date('h-i-s-j-m-y');
	file_put_contents($path.$name2.'.jpg',$decoded2);


	$t->photo = $path . $name . ".jpg";
	$t->photo_small = $path.$name2.".jpg";
	$t->price_s = $_POST["price_s"];
	$t->price_m = $_POST["price_m"];
	$t->price_l = $_POST["price_l"];
	$t->colour = $_POST["colour"];
	$t->difficulty = $_POST["difficulty"];
	$t->used = 0;
	$t->usable = 1;
	$t->times_ordered = 0;
	
	//sending data to DB
	$sql = "INSERT INTO tattoo_table(photo,price_s,price_m,price_l,colour,difficulty,used,usable,photo_small,times_ordered) VALUES ('$t->photo', '$t->price_s', '$t->price_m', '$t->price_l', '$t->colour', '$t->difficulty', '$t->used', '$t->usable', '$t->photo_small', '$t->times_ordered')";

	$result = $con->query($sql);
	echo $result;
	mysqli_close($con);
?>