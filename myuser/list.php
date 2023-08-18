<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="main.css">

<table class="table table-dark table-striped">
    <tr>
        <td>#</td>
        <td>아이디</td>
        <td>이름</td>
        <td>비고</td>
    </tr>

<?php
    // 1. 디비접속 mysqli_connect();
    $con = mysqli_connect("localhost", "test", "1111", "test", "3307");

    // 2. myuser테이블의 모든 데이터 조회 쿼리 날리기
    $sql = "select * from myuser order by id desc";
    $result = mysqli_query($con, $sql);

    $count = mysqli_num_rows($result);

    for($i = 0; $i < $count; $i++) {
        $row = mysqli_fetch_array($result);
        echo "<tr>
                <td>$row[id]</td>
                <td>$row[user_id]</td>
                <td>$row[user_name]</td>
                <td>수정\t\t\t삭제</td>
            </tr>";
    }
    mysqli_close($con);
?>
</table>

<a href="insert.html">사용자 추가하기</a>