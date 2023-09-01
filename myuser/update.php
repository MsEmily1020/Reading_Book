<?php

include "./db_conn.php";
$idx = $_POST["idx"];
$userid = $_POST["userid"];
$username = $_POST["username"];

// update쿼리를 사용해서 $sql에 넣고
$sql = "update myuser set user_id=$userid, user_name=$username where id=$idx;";
mysqli_query($conn, $sql);
mysqli_close($conn);
?>

<script>alert("수정되었습니다.");</script>

<meta http-equiv='refresh' content='0;url=index.php'>