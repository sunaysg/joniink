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

	$p = new Piercing();

	$con= new mysqli($servername,$username1,$password1,"joni_ink_db");
	
	//Getting data from Android
	$base64_string = $_POST["photo"];
	$decoded=base64_decode($base64_string);
	$path = 'images/';
	$name = "p-".date('h-i-s-j-m-y');
	file_put_contents($path.$name.'.jpg',$decoded);

	$base64_string2 = $_POST["photos"];
	$decoded2=base64_decode($base64_string2);
	$name2 = "pm-".date('h-i-s-j-m-y');
	file_put_contents($path.$name2.'.jpg',$decoded2);


	$p->photo = $path . $name . ".jpg";
	$p->photo_small = $path.$name2.".jpg";
	$p->price = $_POST["price"];
	$p->material_id = $_POST["mat"];
	$p->area_id = $_POST["area"];
	$p->used = 0;
	$p->usable = 1;
	
	//sending data to DB
	$sql = "INSERT INTO piercing_table(photo,price,material_id,area_id,used,usable,photo_small) VALUES ('$p->photo', '$p->price', '$p->material_id', '$p->area_id', '$p->used', '$p->usable', '$p->photo_small')";


	if(!$result = $con->query($sql)){
    	die('{ "HTTP_CODE": 400, "message":"' $con->error . '"}');
	}
	else
	{
		echo '{ "HTTP_CODE": 200, "message":"Piercing added!"}';
	}
?>