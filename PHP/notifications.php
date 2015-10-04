<?php
	$servername = "localhost";
	$username1 = "root";
	$password1 = "";


	$con= new mysqli($servername,$username1,$password1,"joni_ink_db");
	
	$not_num = 0;

	$statement = "SELECT COUNT(*) as counts FROM `piercing_order_table` WHERE status = 1";

	$result = mysqli_query($con, $statement);

	$not_num = 0;
while ($row = mysqli_fetch_assoc($result)) {
   $not_num = $row["counts"];
}



$statement = "SELECT count(*) as counts FROM `tattoo_order_table` WHERE status = 1";

	$result = mysqli_query($con, $statement);

while ($row = mysqli_fetch_assoc($result)) {
   $not_num = $not_num  + $row["counts"];
}
mysqli_close($con);

	echo $not_num;

	
	exit();
?>