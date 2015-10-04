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

	$con=mysqli_connect($servername,$username1,$password1,"joni_ink_db");

	if (mysqli_connect_errno($con))
	{
   		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	$username1 = $_GET['username'];
	$password1 = $_GET['password'];
	
	$result = mysqli_query($con,"SELECT * FROM users_table where username='$username1' and password='$password1'");
	$row = mysqli_fetch_array($result);

	$data = $row[0];

	if($data){
		$u->id = $row["id"];
		$u->username = $row["username"];
		$u->first_name = $row["first_name"];
		$u->last_name = $row["last_name"];
		$u->pic_src = $row["pic_src"];
		$u->email = $row["email"];
		$u->is_admin = $row["is_admin"];
   		echo json_encode($u);
	}

	mysqli_close($con);
?>