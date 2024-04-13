<?php
$idx = $_GET["idx"];
echo "id: ".$idx."<br>";

$con = mysqli_connect("localhost", "test", "1111", "test", "3307");
$sql = "select * from myuser where id=$idx";
$result = mysqli_query($con, $sql);
$re = mysqli_fetch_row($result);

echo $re[0]." ".$re[1]." ".$re[2];

?>

<form method="post" action="update.php">
        순번 <input type="text" name="idx" value="<?php echo $re[0] ?>" readonly> <br>
        아이디 <input type="text" name="userid" value="<?php echo $re[1] ?>"> <br>
        이름 <input type="text" name="username" value="<?php echo $re[2] ?>"> <br>
        <!-- <input type="hidden" name="idx" value= -->
        <button type="submit">수정완료</button>
    </form>
