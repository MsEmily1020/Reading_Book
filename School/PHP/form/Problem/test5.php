<?php
    $num1 = $_POST["number1"];
    $num2 = $_POST["number2"];

    $max = ($num1 > $num2) ? $num1 : $num2;
    $min = ($num1 > $num2) ? $num2 : $num1;

    for ($i = $min; $i <= $max; $i++) {
        echo $i."<br>";
    }
?>