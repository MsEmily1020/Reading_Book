<?php
    $num = $_POST["number"];
    for($i = 1; $i <= 100; $i++) {
        if($i % $num == 0) echo $i."<br>";
    }
?>