DROP TABLE IF EXISTS employee;
DROP TRIGGER IF EXISTS salaryTrigger;

CREATE TABLE employee (
    employeeID      INT(5),
    employeeName    VARCHAR(15),
    basicSalary     DOUBLE(10, 2),
    startDate       DATE,
    noofPub         INT(5),
    PRIMARY KEY(employeeID)
);

delimiter $$
CREATE TRIGGER salaryTrigger BEFORE INSERT ON employee FOR EACH ROW
    BEGIN
        IF NEW.basicSalary < 50000 THEN SET NEW.basicSalary = 50000;
        END IF;
        /*UPDATE NEW.basicSalary = 50000 WHERE NEW.basicSalary < 50000;*/
        /*IF NEW.basicSalary > 100000 THEN UPDATE NEW.basicSalary = 100000;
        END IF;*/
    END$$
delimiter ;

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