<?php
    $name = "Sabbir";
    $a = 25;
    $b = 25;
    echo "Hello Mr. $name!<br>";
    print "Hello Mr. " . $name . "!<br>";
    echo "Summation: " . ($a+$b) . "<br>";

    if ($a > $b) {
        echo $a . " is Greater than " . $b . "!<br>";
    } elseif ($a < $b) {
        echo $b . " is Greater than " . $a . "!<br>";
    } else {
        echo "Both " . $a .  " and " . $b . " are Equal!<br>";
    }
?>