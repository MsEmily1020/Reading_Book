<?php

//값이 있을 경우에는 리스트에서 선택 하기 위한 함수
function select($val , $array) {
if (in_array( $val , $array )) {
        echo "selected";
    }
}

$userId = $_POST["user_id"];
$userPass = $_POST["user_pass"];
$userPassCheck = $_POST["user_pass_check"];
$userName = $_POST["user_name"];
$userGender = $_POST["user_gender"];
$userEmail1 = $_POST["user_email1"];
$userEmail2 = $_POST["user_email2"];
$userEmailDomainList = $_POST["domain_list"];
$userAddress = $_POST["user_address"];
$userAddressDetail = $_POST["user_address_detail"];
$user_telecom = $_POST["telecom"];
$userPhoneStart = $_POST["phone_start"];
$userPhoneMiddle = $_POST["phone_middle"];
$userPhoneEnd = $_POST["phone_end"];
$userCar = $_POST["car"];
$userTxt = $_POST["txt"];

if($userPass != $userPassCheck) echo "비밀번호가 정확하지 않습니다.";

else {
    echo "id: ".$userId."<br>"
    ."password: ".$userPass."<br>"
    ."name: ".$userName."<br>"
    ."gender: ".$userGender."<br>"
    ."email: ".$userEmail1."@".$userEmail2."".$userEmailDomainList."<br>"
    ."address: ".$userAddress.$userAddressDetail."<br>"
    ."telecom: ".$user_telecom."<br>"
    ."phone: ".$userPhoneStart."-".$userPhoneMiddle."-".$userPhoneEnd."<br>"
    ."car: ".$userCar."<br>"
    ."myself introduce: ".$userTxt;
}


?>