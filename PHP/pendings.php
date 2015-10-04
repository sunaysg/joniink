<?php
	$servername = "localhost";
	$username1 = "root";
	$password1 = "";


	$con= new mysqli($servername,$username1,$password1,"joni_ink_db");
	

//SELECT pot.*, pt.price FROM `piercing_order_table` as pot join `piercing_table` as pt on pt.id = pot.piercing_id WHERE client_id = ?

	//SELECT * FROM `tattoo_order_table` where client_id = ?
	//sending data to DB

	$statement = "SELECT pot.id as orderID, pot.order_date, pot.approved_date, pot.status , 0 as isTatoo, pt.price, pt.photo_small, coalesce(CONCAT(u.first_name, ' ', u.last_name),'') as names FROM `piercing_order_table`as pot join users_table as u on u.id = pot.client_id join `piercing_table` as pt on pt.id = pot.piercing_id WHERE status = 1";

	//$result = mysqli_query($con,"SELECT * FROM piercing_table where usable=1");
	$result = mysqli_query($con, $statement);

	$rows = array();
while ($row = mysqli_fetch_assoc($result)) {
   $rows[] = $row;
}



$statement = "SELECT tot.id as orderID, tot.order_date, tot.approved_date, tot.status , 1 as isTatoo, t.photo_small, tot.price , coalesce(CONCAT(u.first_name, ' ', u.last_name),'') as names FROM `tattoo_order_table` as tot join users_table as u on u.id = tot.client_id join tattoo_table as t on tot.tattoo_id = t.id WHERE status = 1";
//echo $statement;
	$result = mysqli_query($con, $statement);

while ($row = mysqli_fetch_assoc($result)) {
   $rows[] = $row;
}
mysqli_close($con);

	echo json_encode($rows);

	
	exit();
?>