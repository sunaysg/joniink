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

	

	$con=mysqli_connect($servername,$username1,$password1,"joni_ink_db");

	if (mysqli_connect_errno($con))
	{
   		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
	$result = mysqli_query($con,"SELECT * FROM users_table where is_admin = 0");
	//$rows = mysqli_fetch_array($result);

	$users = array();
	while ($row = mysqli_fetch_array($result)) {
	    //printf("ID: %s  Name: %s", $row[0], $row[1]);  
	    $u = new User();
	    $u->id = $row["id"];
		$u->username = $row["username"];
		$u->first_name = $row["first_name"];
		$u->last_name = $row["last_name"];
		$u->pic_src = $row["pic_src"];
		$u->email = $row["email"];
		$u->is_admin = $row["is_admin"];
		array_push($users, $u);
   		
	}

	echo json_encode($users);

	// $data = $row[0];

	// if($data){
	// 	$u->id = $row["id"];
	// 	$u->username = $row["username"];
	// 	$u->first_name = $row["first_name"];
	// 	$u->last_name = $row["last_name"];
	// 	$u->pic_src = $row["pic_src"];
	// 	$u->email = $row["email"];
	// 	$u->is_admin = $row["is_admin"];
 //   		echo json_encode($u);
	// }

	mysqli_close($con);
?>