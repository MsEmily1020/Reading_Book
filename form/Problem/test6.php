<?php
    $num = $_POST["number"];
    $sum = 0;
    for($i = 1; $i <= $num; $i++) {
        if($i % 5 == 0) {
            $sum += $i;
        }
    }

    echo "합 = ".$sum;
?>