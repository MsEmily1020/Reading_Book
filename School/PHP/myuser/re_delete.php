<?php

include('./db_conn.php');

$idx = $_POST["idx"]; // 삭제할 번호가 들어있음.
$sql = "delete from myuser where id = $idx";
mysqli_query($conn, $sql);
echo "Deleted!!";

mysqli_close($conn);

?>
