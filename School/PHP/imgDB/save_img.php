<?php
// 1. db 접속
include '../myuser/db_conn.php';

// 2. 업로드된 파일 편집
// 서버에 올라간 임시파일을 읽어와서 특수문자에 \추가해서 _file에 대입
$_file = addslashes(file_get_contents($_FILES['image']['tmp_name']));

$sql = "insert into img_test1 (image) values ('$_file')";
mysqli_query($conn, $sql);
echo "Saved!!";
?>