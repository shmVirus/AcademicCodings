CREATE TABLE branch (
    branch_name		CHAR(15),
    branch_city		CHAR(15),
    assets			CHAR(15)
);
CREATE TABLE customer (
    customer_id		INT(5),
    customer_name	CHAR(15),
    customer_city	CHAR(15),
    PRIMARY KEY (customer_id)
);
CREATE TABLE account (
    account_number	INT(5),
    branch_name		CHAR(15),
    balance			INT(10),
    PRIMARY KEY (account_number)
);
CREATE TABLE loan (
    loan_number		INT(5),
    branch_name		CHAR(15),
    amount			INT(10),
    PRIMARY KEY (loan_number)
);
CREATE TABLE depositor (
    customer_name	CHAR(15),
    account_number	INT(5),
    FOREIGN KEY (account_number) REFERENCES account(account_number) ON DELETE NO ACTION
);
CREATE TABLE borrower (
    customer_name	CHAR(15),
    loan_number		INT(5),
    FOREIGN KEY (loan_number) REFERENCES loan(loan_number) ON DELETE NO ACTION
);


INSERT INTO branch (branch_name, branch_city, assets) VALUES ('Chasara', 'Narayanganj', 750000);
INSERT INTO branch (branch_name, branch_city, assets) VALUES ('Narayanganj', 'Narayanganj', 750000);
INSERT INTO branch (branch_name, branch_city, assets) VALUES ('Mirpur', 'Dhaka', 500000);
INSERT INTO branch (branch_name, branch_city, assets) VALUES ('Motijhil', 'Dhaka', 500000);
INSERT INTO branch (branch_name, branch_city, assets) VALUES ('Cumilla', 'Cumilla', 250000);

INSERT INTO customer (customer_id,customer_name, customer_city) VALUES (10001, 'Sabbir', 'Narayanganj');
INSERT INTO customer (customer_id,customer_name, customer_city) VALUES (10002, 'Jubayer', 'Narayanganj');
INSERT INTO customer (customer_id,customer_name, customer_city) VALUES (10003, 'Asif', 'Dhaka');
INSERT INTO customer (customer_id,customer_name, customer_city) VALUES (10004, 'Muktadir', 'Dhaka');
INSERT INTO customer (customer_id,customer_name, customer_city) VALUES (10005, 'Sanim', 'Cumilla');

INSERT INTO account (account_number, branch_name, balance) VALUES (20001, 'Chasara', 750000);
INSERT INTO account (account_number, branch_name, balance) VALUES (20002, 'Narayanganj', 750000);
INSERT INTO account (account_number, branch_name, balance) VALUES (20003, 'Dhaka', 500000);
INSERT INTO account (account_number, branch_name, balance) VALUES (20004, 'Dhaka', 500000);
INSERT INTO account (account_number, branch_name, balance) VALUES (20005, 'Cumilla', 250000);

INSERT INTO loan (loan_number, branch_name, amount) VALUES (30001, 'Chasara', 75000);
INSERT INTO loan (loan_number, branch_name, amount) VALUES (30002, 'Narayanganj', 75000);
INSERT INTO loan (loan_number, branch_name, amount) VALUES (30003, 'Dhaka', 50000);
INSERT INTO loan (loan_number, branch_name, amount) VALUES (30004, 'Dhaka', 50000);
INSERT INTO loan (loan_number, branch_name, amount) VALUES (30005, 'Cumilla', 75000);

INSERT INTO depositor (customer_name, account_number) VALUES ('Sabbir', 20001);
INSERT INTO depositor (customer_name, account_number) VALUES ('Jubayer', 20002);
INSERT INTO depositor (customer_name, account_number) VALUES ('Asif', 20003);
INSERT INTO depositor (customer_name, account_number) VALUES ('Muktadir', 20004);
INSERT INTO depositor (customer_name, account_number) VALUES ('Sanim', 20005);

INSERT INTO borrower (customer_name, loan_number) VALUES ('Sabbir', 30001);
INSERT INTO borrower (customer_name, loan_number) VALUES ('Jubayer', 30002);
INSERT INTO borrower (customer_name, loan_number) VALUES ('Asif', 30003);
INSERT INTO borrower (customer_name, loan_number) VALUES ('Muktadir', 30004);
INSERT INTO borrower (customer_name, loan_number) VALUES ('Sanim', 30005);

SELECT * FROM borrower,loan WHERE amount IN (30000, 50000) AND borrower.loan_number = loan.loan_number;
SELECT branch_name FROM branch WHERE (branch_city='Dhaka' OR branch_city='Cumilla');
SELECT customer_name FROM borrower WHERE (customer_name LIKE '%J%' OR  customer_name LIKE 'M%');

SELECT distinct * FROM account,customer WHERE (branch_name='Chasara' OR branch_name = 'Narayanganj') AND (account_number-customer_id=10000);
SELECT * FROM account WHERE branch_name NOT LIKE 'Cumilla';
SELECT * FROM account ORDER BY balance ASC;
SELECT * FROM account ORDER BY balance DESC;
SELECT * from loan WHERE amount BETWEEN 25000 AND 50000;
SELECT * from loan WHERE amount NOT BETWEEN 25000 AND 50000;
SELECT * from loan WHERE amount IN (25000, 50000);
SELECT * from loan WHERE amount NOT IN (25000, 50000);

DROP TABLE borrower;
DROP TABLE depositor;
DROP TABLE loan;
DROP TABLE account;
DROP TABLE customer;
DROP TABLE branch;