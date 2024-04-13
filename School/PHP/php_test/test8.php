<style>
    h1 {
        color: red;
    }
</style>

<?php
$filename = "visit.txt";
$fp = fopen($filename, "r");
$count = intval(fgets($fp)) + 1;
echo "<h1>당신은 ".$count."번째 방문하셨습니다</h1>";
$fp = fopen($filename, "w");
fwrite($fp, $count);
fclose($fp);
?>