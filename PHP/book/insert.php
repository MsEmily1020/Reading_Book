<?php
// 사용자가 입력한 값을 book table에 추가

$con = mysqli_connect("localhost", "test", "1111", "test", "3307");

$title = $_POST["title"];
$author = $_POST["author"];
$price = $_POST["price"];
$publish = $_POST["publish"];
$genre = $_POST["sel"];
$content = $_POST["content"];
$gender = $_POST["gender"];

$sql = "INSERT INTO book (title, author, price, publish, genre, content, gender) VALUES ('$title', '$author', '$price', '$publish', '$genre', '$content', '$gender');";
mysqli_query($con, $sql);

echo "inserted!!";

mysqli_close($con);
?>