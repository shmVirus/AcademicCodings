CREATE TABLE Depositor (
    c_Name          VARCHAR(15),
    account_number  NUMBER(5),
    PRIMARY KEY (account_number)
);
CREATE TABLE Borrower (
    c_Name          VARCHAR(15),
    loan_number     NUMBER(5),
    PRIMARY KEY (loan_number)
);
CREATE TABLE Customer (
    c_Name          VARCHAR(15),
    city            VARCHAR(15)
);
CREATE TABLE Loan (
    loan_number     NUMBER(5),
    branch_name     VARCHAR(15),
    amount          NUMBER(10),
    FOREIGN KEY (loan_number) REFERENCES Borrower(loan_number)
);
CREATE TABLE Branch (
    branch_id       NUMBER(5),
    branch_name     VARCHAR(15),
    branch_city     VARCHAR(15),
    PRIMARY KEY (branch_id)
);
CREATE TABLE Account (
    account_number  NUMBER(5),
    branch_name     VARCHAR(15),
    balance         NUMBER(10),
    FOREIGN KEY (account_number) REFERENCES Depositor(account_number)
);


INSERT INTO Depositor (c_Name, account_number) VALUES ('Sabbir', 101);
INSERT INTO Depositor (c_Name, account_number) VALUES ('Jubayer', 102);

INSERT INTO Borrower (c_Name, loan_number) VALUES ('Sabbir', 201);
INSERT INTO Borrower (c_Name, loan_number) VALUES ('Jubayer', 202);

INSERT INTO Customer (c_Name, city) VALUES ('Sabbir', 'Narayanganj');
INSERT INTO Customer (c_Name, city) VALUES ('Jubayer', 'Mirpur');

INSERT INTO Loan (loan_number, branch_name, amount) VALUES (201, 'Narayanganj', 20000);
INSERT INTO Loan (loan_number, branch_name, amount) VALUES (202, 'Mirpur', 25000);

INSERT INTO Branch (branch_id, branch_name, branch_city) VALUES (501, 'Narayanganj', 'Narayanganj');
INSERT INTO Branch (branch_id, branch_name, branch_city) VALUES (502, 'Mirpur', 'Mirpur');

INSERT INTO Account (account_number, branch_name, balance) VALUES (101, 'Narayanganj', 5000);
INSERT INTO Account (account_number, branch_name, balance) VALUES (102, 'Mirpur', 75000);


SELECT loan_number as Mirpur_Loan FROM Loan WHERE (amount>=12000 AND branch_name='Mirpur');
SELECT c_Name FROM Customer WHERE  c_Name LIKE '%ot';
SELECT * FROM Account ORDER BY balance DESC;
SELECT loan_number as Mirpur_Loan FROM Loan WHERE (amount>=12000 AND branch_name='Mirpur');
SELECT amount From Loan WHERE amount < ( SELECT Max(amount) FROM Loan);
DELETE FROM Account WHERE (balance < (balance/2));
RENAME Depositor to DEPOSTR;

DROP TABLE Account;
DROP TABLE Branch;
DROP TABLE Loan;
DROP TABLE Customer;
DROP TABLE Borrower;
--DROP TABLE Depositor;
DROP TABLE DEPOSTR;