<?php
include "koneksi.php";
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM users WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement , $username, $password, $nama, $alamat, $tgl_lahir, $gol_darah);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
		$response["username"] = $username;
        $response["password"] = $password;
        $response["nama"] = $nama;
        $response["alamat"] = $alamat;
        $response["tgl_lahir"] = $tgl_lahir;
		$response["gol_darah"] = $gol_darah;
		
    }
    
    echo json_encode($response);
?>