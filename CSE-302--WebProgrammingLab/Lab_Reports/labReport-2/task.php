<?php session_start(); ?>
<!DOCTYPE HTML>
<html>

<head>
    <title>Form Validation by @193002069__shmVirus</title>
    <style>
        .error {
            color: #FF0000;
        }
    </style>
</head>

<body>
    <?php
        $usernameError = $emailError = $genderError = $captchaError = $websiteError = "";
        $username = $email = $gender = $captcha = $website = $author = "";
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            if (empty($_POST["username"])) {
                $usernameError = "Enter a username!";
            } else {
                $username = test_input($_POST["username"]);
                if (!preg_match("/^[a-z-']*$/", $username)) {
                    $usernameError = "Only small-case letters and numbers are Allowed!";
                }
            }
            if (empty($_POST["email"])) {
                $emailError = "Enter a Email Address!";
            } else {
                $email = test_input($_POST["email"]);
                if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
                    $emailError = "Invalid Email, Enter a Valid Email!";
                }
            }
            if (empty($_POST["website"])) {
                $website = "";
            } else {
                $website = test_input($_POST["website"]);
                if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i", $website)) {
                    $websiteError = "Enter a Valid Website URL!";
                }
            }
            if (empty($_POST["gender"])) {
                $genderError = "Select a Gender!";
            } else {
                $gender = test_input($_POST["gender"]);
            }
            if (empty($_POST["captcha"])) {
                $captchaError = "Verify the Captcha!";
            } else {
                $a = $_SESSION['a'];
                $b = $_SESSION['b'];
                if ($_POST["captcha"] == (intval($a + $b))) {
                    $captcha = "true";
                } else {
                    $captchaError = "Incorrect result, try again.";
                    $captcha = "false";
                }
            }
            $author = "<br><h3>changes made by @193002069__shmVirus</h3>";
        }
        function test_input($data) {
            $data = trim($data);
            $data = stripslashes($data);
            $data = htmlspecialchars($data);
            return $data;
        }
    ?>
    <h2>PHP Form Validation Example</h2>
    <p><span class="error">* required field</span></p>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
        UserName: <input type="text" name="username">
        <span class="error">* <?php echo $usernameError; ?></span>
        <br><br>
        E-mail: <input type="text" name="email">
        <span class="error">* <?php echo $emailError; ?></span>
        <br><br>
        Website: <input type="text" name="website">
        <span class="error"><?php echo $websiteError; ?></span>
        <br><br>
        Gender:
        <input type="radio" name="gender" value="female">Female
        <input type="radio" name="gender" value="male">Male
        <span class="error">* <?php echo $genderError; ?></span>
        <br><br>
        Captcha Verification:
            <?php
                $_SESSION['a'] = $a = rand(10, 25);
                $_SESSION['b'] = $b = rand(10, 25);
                echo $a . " + " . $b . " = ";
            ?>
             <input type="text" name="captcha">
             <span class="error">* <?php echo $captchaError; ?></span>
        <br><br>
        <input type="submit" name="submit" value="Submit">
    </form>
    <?php
        echo "<h2> Final Output:</h2>";
        echo $username;
        echo "<br>";
        echo $email;
        echo "<br>";
        echo $website;
        echo "<br>";
        echo $gender;
        echo "<br>";
        echo $captcha;
        echo $author
    ?>
</body>

</html>