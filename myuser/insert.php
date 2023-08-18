<?php

include('./db_conn.php');

$uid = $_POST["userid"];
$uname = $_POST["username"];

echo $uid." ".$uname;

$sql = "INSERT INTO myuser (user_id, user_name) VALUES ('$uid', '$uname')";
mysqli_query($conn, $sql);

echo "inserted!!";
echo "<script>alert('가입되었습니다');</script>";

mysqli_close($conn);

?>

<meta http-equiv='refresh' content='0;url=list.php'>