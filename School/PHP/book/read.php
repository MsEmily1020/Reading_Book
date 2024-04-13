<?php
$idx = $_GET["id"];

$con = mysqli_connect("localhost", "test", "1111", "test", "3307");

$sql = "select * from book where id = $idx";

$result = mysqli_query($con, $sql);

$re = mysqli_fetch_row($result);

?>

<form method="post" action="update.php">
    # : <input type="text" name="idx" value="<?php echo $re[0]?>" readonly><br>
    제목 : <input type="text" name="title" value="<?php echo $re[1]?>"><br>
    저자 : <input type="text" name="author" value="<?php echo $re[2]?>"><br>
    출판사 : <input type="text" name="publish" value="<?php echo $re[4]?>"><br>
    내용 : <input type="text" name="content" value="<?php echo $re[6]?>"><br>
    <button type="submit">수정완료</button>
</form>