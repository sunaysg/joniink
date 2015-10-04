<?php
	$servername = "localhost";
	$username1 = "root";
	$password1 = "";

	class User{
		public $id = "";
		public $username = "";
		public $password = "";
		public $first_name = "";
		public $last_name = "";
		public $pic_src = "";
		public $email = "";
		public $is_admin = "";
	}

	$u = new User();

	$con= new mysqli($servername,$username1,$password1,"joni_ink_db");
	
	//Getting data from Android
	$u->username = $_POST["uname"];	
	$u->password = $_POST["pword"];
	$u->first_name = $_POST["fname"];
	$u->last_name = $_POST["lname"];
	$u->pic_src = "images/user.png";
	$u->email = $_POST["email"];
	$u->is_admin = 0;

	//sending data to DB
	$sql = "INSERT INTO users_table(username,password,first_name,last_name,pic_src,email,is_admin) VALUES ('$u->username', '$u->password', '$u->first_name', '$u->last_name', '$u->pic_src', '$u->email', '$u->is_admin')";

	$result = $con->query($sql);
	echo $result;
	mysqli_close($con);
?>