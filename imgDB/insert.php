<?php

include "../myuser/db_conn.php";
$upload_dir = './uploads/';

$is_upload = move_uploaded_file($_FILES["image"]["tmp_name"], $upload_dir.basename($_FILES["image"]["name"]));
if($is_upload) {
    $name = $_FILES["image"]["name"];
    $size = $_FILES["image"]["size"];
    $path = $upload_dir.basename($_FILES["image"]["name"]);;
    $tmp_name = $_FILES["image"]["tmp_name"];
    $sql = "insert into image(fname, fsize, fpath, ftmp_name) values('$name', '$size', '$path', '$tmp_name')";
    mysqli_query($conn, $sql);
    echo "Yes";
}
else echo "No";

?>