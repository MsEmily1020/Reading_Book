<?php

$upload_dir = './uploads/';

if(!is_dir($upload_dir)) {
    mkdir($upload_dir);
}

// echo $_FILES["userfile"]["name"]."<br>";

// upload_dir 변수값 + 파일이름 (basename : 파일 이름만 뽑아내는 함수)
foreach ($_FILES['userfile']['name'] as $cnt => $upload_file) {   
    $upload_file = $upload_dir.basename($_FILES['userfile']['name'][$cnt]);
    $is_upload = move_uploaded_file($_FILES["userfile"]["tmp_name"][$cnt], $upload_file);
    if($is_upload) echo "업로드 성공";  
    else echo "업로드 실패";
}

?>