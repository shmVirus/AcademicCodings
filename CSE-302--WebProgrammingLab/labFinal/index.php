<!DOCTYPE html>
<html>

<head>
    <title>193002069</title>
    <link rel="stylesheet" href="CSS/index.css">
</head>

<body>
    <header id="header">
        <div>
            <p>DISCOVER THE MAGIC</p>
            <h1>Authentic Flavours</h1>
            <h1>Delicious Food</h1>
        </div>
    </header>

    <section id="rec">
        <div>
            <p>RECOMMENDATIONS</p>
            <h1>Best Specialties</h1>
            <div>
                <section id="foods">
                    <div id="dt1">
                        <img src="resources/11.PNG" alt="">
                        <h3>Beef burger meal</h3>
                        <p>Roast Beef / Bone Marrow / Black</p>
                        <p>Garlic / Mustard Seeds</p>
                        <p>$12.55</p>
                        <button type="submit" name="type1" id="type1" onclick="ty1()">ADD TO CART</button>
                    </div>
                    <div id="dt2">
                        <img src="resources/12.PNG" alt="">
                        <h3>Venison Wellington</h3>
                        <p>Roast Beef / Bone Marrow / Black</p>
                        <p>Garlic / Mustard Seeds</p>
                        <p>$19.00</p>
                        <button type="submit" name="type2" id="type2" onclick="ty2()">ADD TO CART</button>
                    </div>
                    <div id="dt3">
                        <img src="resources/13.PNG" alt="">
                        <h3>Sensation White</h3>
                        <p>Roast Beef / Bone Marrow / Black</p>
                        <p>Garlic / Mustard Seeds</p>
                        <p>$17.50</p>
                        <button type="submit" name="type3" id="type3" onclick="ty3()">ADD TO CART</button>
                    </div>
                    <div id="dt4">
                        <img src="resources/14.PNG" alt="">
                        <h3>Lobster Tortellini</h3>
                        <p>Roast Beef / Bone Marrow / Black</p>
                        <p>Garlic / Mustard Seeds</p>
                        <p>$11.55</p>
                        <button type="submit" name="type4" id="type4" onclick="ty4()">ADD TO CART</button>
                    </div>
                </section>

                <span>Total Amount = $ <span id="res"></span></span>
            </div>
        </div>
    </section>

    <section id="reserve">
        <h5>RESERVATIONS</h5>
        <h2>Book A Table</h2>
        <div id="inputBox">
            <form action="PHP/postData.php" method="POST">
                <input type="number" name="number" id="" placeholder="1 Person">
                <input type="date" name="date" id="" placeholder="MM/DD/YYYY">
                <input type="time" name="time" placeholder="07:00 pm">
                <button type="submit" name="submit">BOOK A TABLE</button>
            </form>
        </div>
    </section>

    <section id="image">
        <img src="resources/1.PNG" alt="">
        <img src="resources/2.PNG" alt="">
        <img src="resources/3.PNG" alt="">
        <img src="resources/4.PNG" alt="">
    </section>

    <footer>
        <div id="footer">
            <div id="f1">
                <h5>LOCATION</h5>
                <p>401 Broadway, 24th Floor New York,</p>
                <p>NY10013</p>
            </div>
            <div id="f2">
                <h5>LET'S TALK</h5>
                <p>Phone: 1-800-222-000</p>
                <p>Fax: 1-800-222-002</p>
            </div>
            <div>
                <h5>EMAIL US</h5>
                <p>info@yourdomain.com</p>
                <p>hr@yourdomain.com</p>
            </div>
            <div>
                <h5>OPENING HOURS</h5>
                <p>Mon-Sat: 09:00-18:00</p>
                <p>Sunday: 10:00-22:00</p>
            </div>
        </div>
    </footer>
    <script src="JS/index.js"></script>
</body>

</html>