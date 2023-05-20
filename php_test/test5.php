<style>
    h1 {
        color: blue;
    }
</style>

<?php
echo "<h1>strlen : 문자열 길이(공백포함)</h1>";
$str = "php is a popular scripting lanauage";

echo strlen($str);

echo "<h1>strcmp : 문자열 비교 (1 : 불일치(대소문자), 0 : 일치)</h1>";

$var1 = "hello";
$var2 = "Hello";
$result = strcmp($var1, $var2);

echo "result: ".$result;

echo "<h1>strpos : 문자열에 있는 인덱스 위치 반환</h1>";

$str = "abcdef";
$find = "c";
$pos = strpos($str, $find);
echo "pos: ".$pos;

echo "<h1>strtolower : 소문자</h1>";
$str = "Mary had a Little lamb and she loved IT so MUCH";

echo "lower : ".strtolower($str);

echo "<h1>strtoupper : 대문자</h1>";
echo "upper : ".strtoupper($str);

echo "<h1>substr : 범위 내의 문자열 추출</h1>";

$str = "hellophpwelcome";
// 인덱스 5부터 5길이의 문자열 만큼
$result = substr($str, 5, 5);
echo "result(5, 5) : ".$result."</br>";

// 인덱스 3부터 끝까지
$result = substr($str, 3);
echo "result(3, 끝) : ".$result;

$arr = array("pizza1", "pizza2", "pizza3", "pizza4", "pizza5");

// 배열에 구분자 추가하여 문자열로 변환
$str = implode(",", $arr);
echo "<h1>implode: 배열에 구분자 추가하여 문자열로 변환</h1>";
echo $str;

$str = "apple/mango/strawberry/melon";

// 문자열을 구분자 기준으로 배열로 변환
$arr = explode("/", $str);
echo "<h1>explode: 문자열을 구분자 기준으로 배열로 변환</h1>";
foreach ($arr as $tmp) {
    echo $tmp." ";
}

$txt = "You should eat fruits, should not buy";

// (문자열에 있는 문자열1, 문자열2, 해당 문자열) : 문자열1 -> 문자열2로 변경
$result = str_replace("should", "could", $txt);
echo "<h1>replace(문자열1, 문자열2): 문자열1을 문자열2로 변경</h1>";
echo $result;
?>