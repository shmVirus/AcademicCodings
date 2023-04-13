CREATE TABLE salesman (
    salesmanID      INT(5),
    name            VARCHAR(25),
    city            VARCHAR(25),
    commission      FLOAT(5),
    PRIMARY KEY (salesmanID)
);
CREATE TABLE customer (
    customerID      INT(5),
    customerName    VARCHAR(25),
    city            VARCHAR(15),
    grade           INT(3),
    salesmanID      INT(5),
    PRIMARY KEY (customerID),
    FOREIGN KEY (salesmanID) REFERENCES salesman(salesmanID) ON DELETE CASCADE
);
CREATE TABLE orders (
    orderNo         INT(5),
    purchaseAmount  FLOAT(10, 2),
    orderDate       DATE,
    customerID      INT(5),
    salesmanID      INT(5),
    FOREIGN KEY (customerID) REFERENCES customer(customerID) ON DELETE CASCADE,
    FOREIGN KEY (salesmanID) REFERENCES salesman(salesmanID) ON DELETE CASCADE
);



INSERT INTO salesman (salesmanID, name, city, commission) VALUES (5001, 'James Hoog', 'New York', 0.15);
INSERT INTO salesman (salesmanID, name, city, commission) VALUES (5002, 'Nail Knite', 'Paris', 0.13);
INSERT INTO salesman (salesmanID, name, city, commission) VALUES (5005, 'Pit Alex', 'London', 0.11);
INSERT INTO salesman (salesmanID, name, city, commission) VALUES (5006, 'Mc Lyon', 'Paris', 0.14);
INSERT INTO salesman (salesmanID, name, city, commission) VALUES (5003, 'Lauson Hense', null, 0.12);
INSERT INTO salesman (salesmanID, name, city, commission) VALUES (5007, 'Paul Adam', 'Rome', 0.13);

INSERT INTO customer (customerID, customerName, city, grade, salesmanID) VALUES (3002, 'Nick Rimando', 'New York', 100, 5001);
INSERT INTO customer (customerID, customerName, city, grade, salesmanID) VALUES (3005, 'Graham Zusi', 'California', 200, 5002);
INSERT INTO customer (customerID, customerName, city, grade, salesmanID) VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006);
INSERT INTO customer (customerID, customerName, city, grade, salesmanID) VALUES (3007, 'Brad Davis', 'New York', 200, 5001);
INSERT INTO customer (customerID, customerName, city, grade, salesmanID) VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003);
INSERT INTO customer (customerID, customerName, city, grade, salesmanID) VALUES (3008, 'Julian Green', 'London', 300, 5002);
INSERT INTO customer (customerID, customerName, city, grade, salesmanID) VALUES (3001, 'Bran Guzan', 'London', null, 5005);
INSERT INTO customer (customerID, customerName, city, grade, salesmanID) VALUES (3003, 'Jozy Altidore', 'Moscow', 200, 5007);

INSERT INTO orders (orderNo, purchaseAmount, orderDate, customerID, salesmanID) VALUES (70001, 150.50, '2012-10-05', 3005, 5002);
INSERT INTO orders (orderNo, purchaseAmount, orderDate, customerID, salesmanID) VALUES (70009, 270.65, '2012-09-10', 3001, 5005);
INSERT INTO orders (orderNo, purchaseAmount, orderDate, customerID, salesmanID) VALUES (70002, 65.26, '2012-10-05', 3002, 5001);
INSERT INTO orders (orderNo, purchaseAmount, orderDate, customerID, salesmanID) VALUES (70004, 110.50, '2012-08-17', 3009, 5003);
INSERT INTO orders (orderNo, purchaseAmount, orderDate, customerID, salesmanID) VALUES (70007, 948.50, '2012-09-10', 3005, 5002);
INSERT INTO orders (orderNo, purchaseAmount, orderDate, customerID, salesmanID) VALUES (70005, 2400.60, '2012-07-27', 3007, 5001);
INSERT INTO orders (orderNo, purchaseAmount, orderDate, customerID, salesmanID) VALUES (70008, 5760.00, '2012-09-10', 3002, 5001);
INSERT INTO orders (orderNo, purchaseAmount, orderDate, customerID, salesmanID) VALUES (70010, 1983.43, '2012-10-10', 3004, 5006);
INSERT INTO orders (orderNo, purchaseAmount, orderDate, customerID, salesmanID) VALUES (70003, 2480.40, '2012-10-10', 3009, 5003);
INSERT INTO orders (orderNo, purchaseAmount, orderDate, customerID, salesmanID) VALUES (70012, 250.45, '2012-06-27', 3008, 5002);
INSERT INTO orders (orderNo, purchaseAmount, orderDate, customerID, salesmanID) VALUES (70011, 75.29, '2012-08-17', 3003, 5007);
INSERT INTO orders (orderNo, purchaseAmount, orderDate, customerID, salesmanID) VALUES (70013, 3045.60, '2012-04-25', 3002, 5001);


SELECT orders.orderNo, orders.orderDate, orders.purchaseAmount, customer.customerName, customer.grade, salesman.name AS salesmanName, salesman.commission FROM orders INNER JOIN customer ON orders.customerID=customer.customerID INNER JOIN salesman ON orders.salesmanID=salesman.salesmanID;
SELECT customer.customerName, customer.city, customer.grade, salesman.name AS salesmanName, salesman.city FROM customer LEFT JOIN salesman ON customer.salesmanID=salesman.salesmanID ORDER BY customer.customerID;


DROP TABLE orders;
DROP TABLE customer;
DROP TABLE salesman;