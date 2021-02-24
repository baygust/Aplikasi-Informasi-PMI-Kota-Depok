<?php
include "koneksi.php";
	
	$username = $_POST["username"];
	
    $statement = mysqli_prepare($con, "SELECT tgl_donor,tempat_donor FROM record_pendonor WHERE username = ? ");
    mysqli_stmt_bind_param($statement, "s", $username);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $tgl_donor, $tempat_donor);
    
    $response = array();
    
    while(mysqli_stmt_fetch($statement)){
	$temp = array();
	$temp['tgl_donor'] = $tgl_donor; 
	$temp['tempat_donor'] = $tempat_donor; 
	array_push($response, $temp);
    }
    
    echo json_encode($response);
?>