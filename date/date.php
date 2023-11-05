<?php

include "../myuser/db_conn.php";

$reg = date("Y-m-d H:i:s");
echo $reg;

$sql = "insert into test(reg_date) values ('$reg')";
mysqli_query($conn, $sql);

?>