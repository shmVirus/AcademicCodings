DROP TABLE customer;
CREATE TABLE customer (
    name VARCHAR(15),
    id NUMBER(4),
    --country VARCHAR(15),
    --city VARCHAR(15),
    ---zipCode NUMBER(8),
    ipAddress VARCHAR(15),
    totalItems NUMBER(3),
    totalSpend NUMBER(5)
);
DESCRIBE customer;

--Inserting raws/values to the table
INSERT INTO customer (name, id, /*country, city, zipCode,*/ ipAddress, totalItems, totalSpend) VALUES ('Sabbir', 2069, /*'Bangladesh', 'Narayanganj', 1400,*/ '127.0.0.1', 5, 275);
INSERT INTO customer (name, id, ipAddress, totalItems, totalSpend) VALUES ('Asif', 2023, '172.5.6.50', 3, 175);
INSERT INTO customer (name, id, ipAddress, totalItems, totalSpend) VALUES ('Muktadir', 2049, '175.6.4.5', 9, 500);
INSERT INTO customer (name, id, ipAddress, totalItems, totalSpend) VALUES ('Jubayer', 2070, '105.103.102.101', 7, 350);
INSERT INTO customer (name, id, ipAddress, totalItems, totalSpend) VALUES ('Fahad', 2039, '54.57.60.63', 9, 500);
INSERT INTO customer (name, id, ipAddress, totalItems, totalSpend) VALUES ('Mushfique', 2154, '99.85.69.35', 4, 200);
INSERT INTO customer (name, id, ipAddress, totalItems, totalSpend) VALUES ('Sanim', 2037, '192.85.75.14', 7, 350);
INSERT INTO customer (name, id, ipAddress, totalItems, totalSpend) VALUES ('Imaran', 2067, '185.14.68.75', 7, 400);
INSERT INTO customer (name, id, ipAddress, totalItems, totalSpend) VALUES ('Sakib', 2086, '41.42.54.96', 6, 96);
INSERT INTO customer (name, id, ipAddress, totalItems, totalSpend) VALUES ('Shoeb', 2041, '41.28.46.96', 1, 57);
SELECT * FROM customer;

--Updating speding values for some customers
UPDATE customer SET totalSpend=200 WHERE id=2023;
UPDATE customer SET totalSpend=300 WHERE id=2049;
UPDATE customer SET totalSpend=400 WHERE id=2070;
SELECT * FROM customer;

--Adding Country and City columns
ALTER TABLE customer ADD (country VARCHAR(15), city VARCHAR(15));
DESCRIBE customer;

--Modifing size for some colums
ALTER TABLE customer MODIFY (id NUMBER(5), totalItems NUMBER(5));
DESCRIBE customer;

--Deleting some colums
--ALTER TABLE customer DROP COLUMN (country, city);
ALTER TABLE customer DROP COLUMN country;
ALTER TABLE customer DROP COLUMN city;
DESCRIBE customer;

--Renaming some colums
--ALTER TABLE customer RENAME COLUMN (ipAddress to ip_Address, totalItems to total_Items, totalSpend to total_Spend);
ALTER TABLE customer RENAME COLUMN ipAddress to ip_Address;
ALTER TABLE customer RENAME COLUMN totalItems to total_Items;
ALTER TABLE customer RENAME COLUMN totalSpend to total_Spend;
SELECT * FROM customer;