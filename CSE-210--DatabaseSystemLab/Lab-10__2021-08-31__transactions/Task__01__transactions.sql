START TRANSACTION;
SET AUTOCOMMIT = OFF;
DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
    employeeID      INT(5),
    employeeName    VARCHAR(15),
    basicSalary     DOUBLE(10, 2),
    startDate       DATE,
    noofPub         INT(5),
    PRIMARY KEY(employeeID)
);

/*LOCK TABLE employee READ;
INSERT INTO employee VALUES (10001, 'noName0', 75000, '2020-12-01', 75);
INSERT INTO employee VALUES (10002, 'noName1', 80000, '2021-01-01', 5);
UNLOCK TABLE employee;*/

INSERT INTO employee VALUES (10001, 'noName0', 75000, '2020-12-01', 75);
INSERT INTO employee VALUES (10002, 'noName1', 80000, '2021-01-01', 5);
INSERT INTO employee VALUES (10003, 'noName2', 85000, '2021-02-01', 10);
INSERT INTO employee VALUES (10004, 'noName3', 90000, '2021-03-01', 15);
INSERT INTO employee VALUES (10005, 'noName4', 95000, '2021-04-01', 20);
INSERT INTO employee VALUES (10006, 'noName5', 100000, '2021-05-01', 25);
INSERT INTO employee VALUES (10007, 'noName6', 105000, '2021-06-01', 30);
INSERT INTO employee VALUES (10008, 'noName0', 25000, '2020-12-01', 1);
INSERT INTO employee VALUES (10009, 'noName7', 110000, '2021-07-01', 35);
INSERT INTO employee VALUES (10010, 'noName8', 115000, '2021-08-01', 40);

SELECT * FROM employee;

DELETE FROM employee WHERE noofPub < 10;
SELECT * FROM employee;

ROLLBACK;
UPDATE employee SET basicSalary = 25000 WHERE noofPub < 10;
SELECT * FROM employee;

ROLLBACK;

INSERT INTO employee VALUES (10011, 'noName11', 150000, '2021-04-01', 25);
INSERT INTO employee VALUES (10012, 'noName12', 175000, '2021-05-01', 15);
INSERT INTO employee VALUES (10013, 'noName13', 135000, '2020-06-01', 10);
INSERT INTO employee VALUES (10014, 'noName14', 200000, '2021-07-01', 12);
INSERT INTO employee VALUES (10015, 'noName15', 255000, '2021-08-01', 13);
SELECT * FROM employee;

DELETE FROM employee WHERE (noofPub > 10 && noofPub < 25 && basicSalary > 100000);
COMMIT;

SELECT * FROM employee;