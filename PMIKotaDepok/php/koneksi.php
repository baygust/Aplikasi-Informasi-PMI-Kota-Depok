<?php
$servername = "localhost";
$username = "id16083768_db_pmidepok";
$password = "79W!U0?QA~uJ^(D5";
$dbname = "id16083768_pmidepok";
// Create connection
$con = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$con) {
    die("Connection failed: " . mysqli_connect_error());
}
?>
