<?php
    $menu = $_POST["menu"];
    $money = $_POST["input"];
    $menu_money = 0;


   switch($menu) {
    case "밀크커피":
        $menu_money = 300;
        break;
    case "우유":
        $menu_money = 400;
        break;
    case "코코아" :
        $menu_money = 500;
        break;
    case "율무차" :
        $menu_money = 600;
        break;
    case "생수":
        $menu_money = 700;
        break;
   }

   $money -= $menu_money;
   $text = $money >= 0 ? "총 금액은".$menu_money."이고잔돈은".$money."입니다." : "잔액부족";
   echo $text;
?>