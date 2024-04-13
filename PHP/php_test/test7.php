<?php

$filename = "write.txt";
$fp = fopen($filename, "r");
$contents = fread($fp, filesize($filename));
echo $contents;
fclose($fp);
?>