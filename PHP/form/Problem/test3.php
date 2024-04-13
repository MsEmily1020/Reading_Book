<?php
    $num = $_POST["number"];
    $count = 0;
    $sum = 0;
    for($i = 100; $i < 1000; $i++) {
        if($i % $num == 0) {
            $count++;
            $sum += $i;
        }
    }

    echo $num."의 배수의 갯수 = ".$count.", 합 = ".$sum;
?>