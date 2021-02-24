<?php
include "koneksi.php";
     
	 	$username = $_POST["username"];
        $password = $_POST["password"];
        $nama = $_POST["nama"];
        $alamat = $_POST["alamat"];
        $tgl_lahir = $_POST["tgl_lahir"];
		$gol_darah = $_POST["gol_darah"];
		
	function registerUsers(){
	global $con, $username, $password, $nama, $alamat, $tgl_lahir, $gol_darah; 
    $statement = mysqli_prepare($con, "INSERT INTO users (username, password, nama, alamat, tgl_lahir, gol_darah) VALUES (?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement,"ssssss", $username, $password, $nama, $alamat, $tgl_lahir, $gol_darah);
    mysqli_stmt_execute($statement);
	mysqli_stmt_close($statement);     
    }
    
    function usernameAvailable() {
        global $con, $username;
        $statement = mysqli_prepare($con, "SELECT * FROM users WHERE username = ?"); 
        mysqli_stmt_bind_param($statement, "s", $username);
        mysqli_stmt_execute($statement);
        mysqli_stmt_store_result($statement);
        $count = mysqli_stmt_num_rows($statement);
        mysqli_stmt_close($statement); 
        if ($count < 1){
            return true; 
        }else {
            return false; 
        }
    }
    $response = array();
    $response["success"] = false;  
    if (usernameAvailable()){
        registerUsers();
        $response["success"] = true;  
    }
    
    echo json_encode($response);
?>