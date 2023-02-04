<?php

    $con = mysqli_connect('localhost','root');
    if ($con) {
        echo "Connection successful";
    } else {
        echo "No connection";
    }

    mysqli_select_db($con, 'finalDatabase');
    $person = $_POST['number'];
    $dateX = $_POST['date'];
    $timeX = $_POST['time'];
    
    $query = "INSERT INTO reverserDetails(person, bookedDate, bookedTime) VALUES ('$person','$dateX','$timeX')";
    mysqli_query($con,$query);
    header('location:../index.php');

?>