<?php

$idx = $_POST["idx"];
$title = $_POST["title"];
$author = $_POST["author"];
$publish = $_POST["publish"];
$content = $_POST["content"];

$con = mysqli_connect("localhost", "test", "1111", "test", "3307");

$sql = "update book set title='$title', author='$author', publish='$publish', content='$content' where id=$idx;";

mysqli_query($con, $sql);
mysqli_close($con);
?>

<script>alert("수정되었습니다.");</script>

<meta http-equiv='refresh' content='0;url=list.php'>