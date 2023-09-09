<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="main.css">

<table class="table table-dark table-striped" style = "width:1300px; margin-left:auto; margin-right:auto; text-align: center;">
    <tr>
        <td>#</td>
        <td>제목</td>
        <td>저자</td>
        <td>가격</td>
        <td>출판사</td>
        <td>장르</td>
        <td>성별</td>
        <td>IP</td>
    </tr>

<?php

$con = mysqli_connect("localhost", "test", "1111", "test", "3307");

$sql = "select * from book order by id desc";
$result = mysqli_query($con, $sql);


$count = mysqli_num_rows($result);

for($i = 0; $i < $count; $i++) {
    $re = mysqli_fetch_row($result);
    echo "<tr>
    <td>$re[0]</td>
    <td><a href='read.php?id=$re[0]'>$re[1]</a></td>
    <td>$re[2]</td>
    <td>$re[3]</td>
    <td>$re[4]</td>
    <td>$re[5]</td>
    <td>$re[7]</td>
    <td>$_SERVER[REMOTE_ADDR]</td>
    </tr>";
}

?>

</table>