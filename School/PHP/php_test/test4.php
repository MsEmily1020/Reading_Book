<?php
$arr = array("apple", "banana", "grape", "melon");

for($i = 0; $i < sizeof($arr); $i++) {
    echo "{$arr[$i]} ";
}

echo "<br>";

foreach($arr as $str) {
    echo "{$str} ";
}
?>