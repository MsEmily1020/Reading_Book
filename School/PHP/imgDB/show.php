<script>
function action_imageView(url) {
    if(url) {
        var imgW=document.getElementById('img1').naturalWidth;
        var imgH=document.getElementById('img1').naturalHeight;
        var imgWindow=window.open("","_image_view_","width="+imgW+",height="+imgH);
        imgWindow.document.write("<img src='"+url+"'>");
    }
}
</script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="main.css">

<table class="table table-dark table-striped">
    <tr>
        <td>#</td>
        <td>이름</td>
        <td>사이즈</td>
        <td>경로</td>
        <td>임시 공간</td>
    </tr>

<?php

    include "../myuser/db_conn.php";

    $sql = "select * from image";
    $list = mysqli_query($conn, $sql);

    $count = mysqli_num_rows($list);

    for($i = 0; $i < $count; $i++) {
        $row = mysqli_fetch_row($list);
        echo "<tr>
        <td>$row[0]</td>
        <td>$row[1]</td>
        <td>$row[2]</td>
        <td>$row[3]</td>
        <td>$row[4]</td>
        </tr>
        ";
    ?>

<img src="<?php echo $row[3]?>" id="img1" width="100px" onclick="action_imageView('<?php echo $row[3]?>')">

<?php } ?>

</table>
