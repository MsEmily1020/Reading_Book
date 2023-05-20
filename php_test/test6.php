<?php
// 저장
$filename = "write.txt";

// 해당파일, 모드 (r : read, w : write, a : append)
$fp = fopen($filename, "w");

$str = "Mary had a dog";
$str1 = "Tom had a cat";
// 해당파일, 저장할 string값
fwrite($fp, $str);
fwrite($fp, $str1);

fclose($fp);
echo "저장되었습니다.<br>";

// 읽기
$fp1 = fopen($filename, "r");

// eof : end of file
while(!feof($fp1)) {
    // echo fgetc($fp1);
    echo fgets($fp1);
}

fclose($fp1);

?>