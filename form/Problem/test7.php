<?php
    $arr = explode(" ", $_POST["arr"]);

    $sum = 0;
    for($i = 0; $i < count($arr); $i++) {
        $sum += $arr[$i];
    }

    echo "평균 = ".($sum / count($arr));
?>