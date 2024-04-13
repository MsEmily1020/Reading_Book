<?php
    $num1 = $_POST["number1"];
    $num2 = $_POST["number2"];

    $min = ($num1 > $num2) ? $num2 : $num1;
    $max = ($num1 > $num2) ? $num1 : $num2;

    $count = 0;
    $sum = 0;
    for($i = $min; $i <= $max; $i++) {
        if($i % 3 == 0 || $i % 5 == 0) {
            $count++;
            $sum += $i;
        }
    }

    echo "합 = ".$sum.", 평균 = ".($sum / $count);
?>