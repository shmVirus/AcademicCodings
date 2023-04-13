DROP TABLE IF EXISTS manages;
DROP TABLE IF EXISTS works;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS employee;


CREATE TABLE employee (
    person_name         VARCHAR(25),
    street              VARCHAR(25),
    city                VARCHAR(25),
    PRIMARY KEY         (person_name)
);
CREATE TABLE company (
    company_name        VARCHAR(25),
    city                VARCHAR(25),
    PRIMARY KEY         (company_name)
);
CREATE TABLE works (
    person_name         VARCHAR(25),
    company_name        VARCHAR(25),
    salary              INTEGER(10),
    FOREIGN KEY         (person_name) REFERENCES employee(person_name) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY         (company_name) REFERENCES company(company_name) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE manages (
    person_name         VARCHAR(25),
    manager_name        VARCHAR(25),
    FOREIGN KEY         (person_name) REFERENCES employee(person_name) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TRIGGER IF EXISTS salaryTrigger;
DELIMITER $$
CREATE TRIGGER salaryTrigger BEFORE INSERT ON works FOR EACH ROW
    BEGIN
        IF NEW.salary < 10000 THEN SET NEW.salary = 10000;
        END IF;
    END$$
DELIMITER ;


INSERT INTO employee (person_name, street, city) VALUES ('Asif', '101/1', 'Dhaka');
INSERT INTO employee (person_name, street, city) VALUES ('Sanim', '102/2', 'Dhaka');
INSERT INTO employee (person_name, street, city) VALUES ('Md Fahad', '103/3', 'Dhaka');
INSERT INTO employee (person_name, street, city) VALUES ('Shoeb', '104/4', 'Dhaka');


INSERT INTO company (company_name, city) VALUES ('A-Company', 'Dhaka');
INSERT INTO company (company_name, city) VALUES ('S-Company', 'Dhaka');
INSERT INTO company (company_name, city) VALUES ('Beximco Textiles Limited', 'Dhaka');
INSERT INTO company (company_name, city) VALUES ('Padma Textiles Limited', 'Dhaka');

INSERT INTO works (person_name, company_name, salary) VALUES ('Asif', 'A-Company', 75000);
INSERT INTO works (person_name, company_name, salary) VALUES ('Sanim', 'S-Company', 80000);
INSERT INTO works (person_name, company_name, salary) VALUES ('Md Fahad', 'Beximco Textiles Limited', 75000);
INSERT INTO works (person_name, company_name, salary) VALUES ('Shoeb', 'Padma Textiles Limited', 75000);


INSERT INTO manages (person_name, manager_name) VALUES ('Asif', 'Fisa');
INSERT INTO manages (person_name, manager_name) VALUES ('Sanim', 'Minas');
INSERT INTO manages (person_name, manager_name) VALUES ('Md Fahad', 'Sanim');

SELECT employee.person_name, company.company_name, employee.city FROM employee INNER JOIN works ON employee.person_name = works.person_name INNER JOIN company ON works.company_name = company.company_name WHERE employee.city = company.city;
SELECT * FROM employee WHERE person_name LIKE 'Md%';
SELECT * FROM works WHERE salary > (SELECT MAX(salary) FROM works WHERE company_name = 'Beximco Textiles Limited');
UPDATE works SET salary = salary * 1.10 WHERE (salary <= 100000 and person_name IN (SELECT manager_name FROM manages));
SELECT * FROM works;
--DELETE FROM employee INNER JOIN works ON employee.person_name = works.person_nam WHERE works.salary < avg(works.salary) group by works.company_name;
--SELECT * FROM works WHERE Min;
SELECT employee.person_name, employee.street, employee.city FROM employee INNER JOIN works ON employee.person_name = works.person_name WHERE works.salary > 11000 and works.company_name = 'Padma Textiles Limited';