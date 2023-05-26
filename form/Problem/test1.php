<?php
    $num = explode(" ", $_POST["number"]);
    $sumOdd = 0;
    $sumEven = 0;
    foreach($num as $n) {
        if($n % 2 == 0) $sumEven += $n;
        else $sumOdd += $n;
    }

    echo "짝수의 합 = ".$sumEven.", 홀수의 합 = ".$sumOdd;
?>