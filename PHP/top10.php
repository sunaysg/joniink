<?php
	$servername = "localhost";
	$username1 = "root";
	$password1 = "";


	$con= new mysqli($servername,$username1,$password1,"joni_ink_db");
	

//SELECT pot.*, pt.price FROM `piercing_order_table` as pot join `piercing_table` as pt on pt.id = pot.piercing_id WHERE client_id = ?

	//SELECT * FROM `tattoo_order_table` where client_id = ?
	//sending data to DB

	$statement = "SELECT pt.photo, pt.times_ordered from `piercing_table` as pt order by pt.times_ordered desc limit 10";

	//$result = mysqli_query($con,"SELECT * FROM piercing_table where usable=1");
	$result = mysqli_query($con, $statement);

	$rows = array();
while ($row = mysqli_fetch_assoc($result)) {
   $rows[] = $row;
}



$statement = "SELECT tt.photo, tt.times_ordered from `tattoo_table` as tt order by tt.times_ordered desc limit 10";
//echo $statement;
	$result = mysqli_query($con, $statement);

while ($row = mysqli_fetch_assoc($result)) {
   $rows[] = $row;
}
mysqli_close($con);

if(count($rows) > 0 ){

$rows = quicksort($rows);

if(count($rows) > 10 ){
$rows = array_slice($rows, 0, 10);
}
	
}
	echo json_encode($rows);

	
	exit();


	function quicksort( $array ) {
    if( count( $array ) < 2 ) {
        return $array;
    }
    $left = $right = array( );
    reset( $array );
    $pivot_key  = key( $array );
    $pivot  = array_shift( $array );
    foreach( $array as $k => $v ) {
        if( $v['times_ordered'] > $pivot['times_ordered'] )
            $left[$k] = $v;
        else
            $right[$k] = $v;
    }
    return array_merge(quicksort($left), array($pivot_key => $pivot), quicksort($right));
}
?>