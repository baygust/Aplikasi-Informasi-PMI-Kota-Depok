  <html>
  <body>
  <div align = "center">
  <?php
  include "koneksi.php";

  $insert = mysqli_query($con, "INSERT INTO record_pendonor (username, tgl_donor, tempat_donor) 
  VALUES('$_POST[username]','$_POST[tgl_donor]','$_POST[tempat_donor]')");
  if (!$insert)
    {
    die('Error: ' . mysql_error());
    }
    else{
      printf(" Data telah di masukkan");
    }
  ?>
  <br>
  <a href="inputdata.php">kembali</a>
  </div>
  </body>
  </html>
