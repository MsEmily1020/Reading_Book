<?php
$real_id = "test";
$real_pass = "testpass";

// TODO 사용자가 입력한 id와 pass 가져오기
// $_GET  vs  $_POST
$id = $_POST["user_id"];            // 사용자가 입력한 id값 가져오기
$password = $_POST["user_pass"];    // 사용자가 입력한 password값 가져오기

echo "id은 ".$id."이고<br/>";
echo "password은 ".$password."<br/><br/>";

// TODO 사용자가 입력한 값이 real_id, real_pass와 동일한지 확인하기

if($real_id != $id || $real_pass != $password) echo "아이디 또는 비밀번호가 정확하지 않습니다.";
else echo "로그인되었습니다.";
?>