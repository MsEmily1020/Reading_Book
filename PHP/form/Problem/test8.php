<?php
    $arr = explode(" ", $_POST["arr"]);
    $even = 0;
    $odd = 0;

    foreach($arr as $num) {
        if($num % 2 == 0) $even++;
        else $odd++;
    }

    echo "짝수의 개수 = ".$even.", 홀수의 개수 = ".$odd;
?>