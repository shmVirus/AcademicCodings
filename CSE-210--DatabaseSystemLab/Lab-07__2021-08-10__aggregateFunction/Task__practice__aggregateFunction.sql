CREATE TABLE product_order_info (
    product_no          INT(11) NOT NULL AUTO_INCREMENT,
    product_name        VARCHAR(255) NOT NULL,
    product_type        enum ('electronics', 'stationary', 'food', 'beverage') DEFAULT NULL,
    product_price       FLOAT(10,2) NOT NULL,
    product_quantity    SMALLINT NOT NULL,
    order_date          DATETIME NOT NULL DEFAULT current_timestamp,
    PRIMARY KEY(product_no)
);

INSERT INTO product_order_info (product_no, product_name, product_type, product_price, product_quantity) VALUES  (101, 'Laptop', 'electronics', 67000, 1);
INSERT INTO product_order_info (product_no, product_name, product_type, product_price, product_quantity) VALUES  (NULL, 'Mobile', 'electronics', 23500, 1);
INSERT INTO product_order_info (product_no, product_name, product_type, product_price, product_quantity) VALUES  (NULL, 'Watch', 'electronics', 8650, 2);
INSERT INTO product_order_info (product_no, product_name, product_type, product_price, product_quantity) VALUES  (NULL, 'Butter', 'stationary', 50, 5);
INSERT INTO product_order_info (product_no, product_name, product_type, product_price, product_quantity) VALUES  (NULL, 'Coca-cola', 'beverage', 35, 2);
INSERT INTO product_order_info (product_no, product_name, product_type, product_price, product_quantity) VALUES  (NULL, 'Seven-Up', 'beverage', 55, 1);

SELECT AVG(product_price) avg_product_price FROM product_order_info;
SELECT COUNT(product_no) AS total_order FROM product_order_info;
SELECT COUNT(product_no) product_type, product_name, product_price FROM product_order_info GROUP BY product_type='electronics';
SELECT COUNT(*) product_type, product_name, product_price FROM product_order_info WHERE product_type='electronics';
SELECT product_no, product_name, product_price, product_quantity, SUM(product_price*product_quantity) AS total_per_product FROM product_order_info GROUP BY product_no;
SELECT MAX(product_price) max_price FROM product_order_info;
SELECT MIN(product_price) max_price FROM product_order_info;
SELECT product_no, product_name, product_price, LENGTH(product_price) AS LengthOfPrice FROM product_order_info;
SELECT product_no, product_name, product_price FROM product_order_info WHERE LENGTH(product_price)>5;
SELECT product_no, product_name, product_price, UCASE(product_name) AS UpperCaseName FROM product_order_info;
SELECT product_no, product_name, product_price, LCASE(product_name) AS LowerCaseName FROM product_order_info;
SELECT product_no, product_name, product_price, FLOOR(product_price) AS FloorPrice FROM product_order_info;
SELECT product_no, product_name, product_price, CEIL(product_price) AS CeilPrice FROM product_order_info;
SELECT product_no, product_name, product_price, ROUND(product_price) AS RoundedPrice FROM product_order_info;
SELECT product_no, product_name, product_price, MID(product_price, 1, 3) AS ExtractedString FROM product_order_info;
SELECT product_no, product_name, product_price, CONCAT(product_name, ' ', product_type) AS ConcatenatedString FROM product_order_info;

DROP TABLE product_order_info;