CREATE TABLE regions (
    region_id       NUMERIC(10),
    region_name     VARCHAR(25),
    PRIMARY KEY(region_id)
);
CREATE TABLE countries (
    country_id      CHAR(2),
    country_name    VARCHAR(40),
    region_id       NUMERIC(10),
    PRIMARY KEY (country_id),
    FOREIGN KEY (region_id) REFERENCES regions(region_id) ON DELETE CASCADE
);
CREATE TABLE locations (
    location_id     NUMERIC(10),
    street_address  VARCHAR(25),
    postal_code     VARCHAR(12),
    city            VARCHAR(30),
    state_province  VARCHAR(12),
    country_id      CHAR(2),
    PRIMARY KEY (location_id),
    FOREIGN KEY (country_id) REFERENCES countries(country_id) ON DELETE CASCADE
);
CREATE TABLE departments(
    department_id       NUMERIC(10),
    departement_name    VARCHAR(30),
    manager_id          NUMERIC(10),
    location_id         NUMERIC(10),
    PRIMARY KEY (department_id),
    FOREIGN KEY (location_id) REFERENCES locations(location_id) ON DELETE CASCADE
);
CREATE TABLE jobs (
    job_id          VARCHAR(10),
    job_title       VARCHAR(35),
    min_salary      NUMERIC(10),
    max_salary      NUMERIC(10),
    PRIMARY KEY (job_id)
);
CREATE TABLE job_grades (
    grade_level     VARCHAR(2),
    lowest_sal      NUMERIC(10),
    highest_sal     NUMERIC(10)
);
CREATE TABLE job_history (
    employee_id     NUMERIC(10),
    start_date      DATE,
    end_date        DATE,
    job_id          VARCHAR(10),
    department_id   NUMERIC(10),
    PRIMARY KEY (employee_id, start_date),
    FOREIGN KEY (job_id) REFERENCES jobs(job_id) ON DELETE CASCADE,
    FOREIGN KEY (department_id) REFERENCES departments(department_id) ON DELETE CASCADE
);
CREATE TABLE employees (
    employee_id     NUMERIC(10),
    first_name      VARCHAR(20),
    last_name       VARCHAR(25),
    email           VARCHAR(25),
    phone_number    VARCHAR(20),
    hire_date       DATE,
    job_id          VARCHAR(20),
    salary          NUMERIC(10),
    commission_pct  NUMERIC(10),
    manager_id      NUMERIC(10),
    department_id   NUMERIC(10),
    FOREIGN KEY (job_id) REFERENCES jobs(job_id) ON DELETE CASCADE,
    FOREIGN KEY (employee_id) REFERENCES job_history(employee_id) ON DELETE CASCADE,
    FOREIGN KEY (department_id) REFERENCES departments(department_id) ON DELETE CASCADE,
    PRIMARY KEY (employee_id)
);


INSERT INTO regions (region_id, region_name) VALUES (10001, 'Asia');
INSERT INTO regions (region_id, region_name) VALUES (10002, 'Africa');
INSERT INTO regions (region_id, region_name) VALUES (10003, 'America');

INSERT INTO countries (country_id, country_name, region_id) VALUES  ('BD', 'Bangladesh', 10001);
INSERT INTO countries (country_id, country_name, region_id) VALUES  ('SA', 'South Africa', 10002);
INSERT INTO countries (country_id, country_name, region_id) VALUES  ('US', 'United States', 10003);

INSERT INTO locations (location_id, street_address, postal_code, city, state_province, country_id) VALUES (30001, 'Chasara', '40001', 'Narayanganj', 'Dhaka', 'BD');
INSERT INTO locations (location_id, street_address, postal_code, city, state_province, country_id) VALUES (30002, 'Mirpur', '40002', 'Dhaka', 'Dhaka', 'BD');
INSERT INTO locations (location_id, street_address, postal_code, city, state_province, country_id) VALUES (30003, 'Motijhil', '40003', 'Dhaka', 'Dhaka', 'BD');

INSERT INTO departments (department_id, departement_name, manager_id, location_id) VALUES (50001, 'Computer', 60001, 30001);
INSERT INTO departments (department_id, departement_name, manager_id, location_id) VALUES (50002, 'Internet', 60002, 30002);
INSERT INTO departments (department_id, departement_name, manager_id, location_id) VALUES (50003, 'Electrical', 60002, 30003);

INSERT INTO jobs (job_id, job_title, min_salary, max_salary) VALUES ('70001', 'Programmer', 10000, 100000);
INSERT INTO jobs (job_id, job_title, min_salary, max_salary) VALUES ('70002', 'CyberSecurity', 20000, 200000);
INSERT INTO jobs (job_id, job_title, min_salary, max_salary) VALUES ('70003', 'ElectricalMangemnt', 30000, 300000);

INSERT INTO job_grades (grade_level, lowest_sal, highest_sal) VALUES ('A+', 20000, 200000);
INSERT INTO job_grades (grade_level, lowest_sal, highest_sal) VALUES ('A-', 40000, 400000);
INSERT INTO job_grades (grade_level, lowest_sal, highest_sal) VALUES ('A-', 50000, 600000);

INSERT INTO job_history (employee_id, start_date, end_date, job_id, department_id) VALUES (80001, '2000-07-01', '2020-07-01', '70001', 50001);
INSERT INTO job_history (employee_id, start_date, end_date, job_id, department_id) VALUES (80002, '2001-08-01', '2020-07-01', '70002', 50002);
INSERT INTO job_history (employee_id, start_date, end_date, job_id, department_id) VALUES (80003, '2002-09-01', '2020-07-01', '70003', 50003);
INSERT INTO job_history (employee_id, start_date, end_date, job_id, department_id) VALUES (80004, '2000-07-01', '2020-07-01', '70001', 50001);
INSERT INTO job_history (employee_id, start_date, end_date, job_id, department_id) VALUES (80005, '2001-08-01', '2020-07-01', '70002', 50002);
INSERT INTO job_history (employee_id, start_date, end_date, job_id, department_id) VALUES (80006, '2002-09-01', '2020-07-01', '70003', 50003);

INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
            VALUES (80001, 'Sabbir', 'Ibn Humayun', 'cool.sabbir@shmVirus.me', '01500-000001', '2000-08-01', '70001', 70000, 10, 30001, 50001);
INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
            VALUES (80002, 'Jubayer', 'Rahman', 'cool.jubayer@juba.me', '01500-000002', '2001-08-01', '70002', 85000, 15, 30002, 50002);
INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
            VALUES (80003, 'Mominul', 'Islam', 'cool.asif@momin.me', '01500-000003', '2002-08-01', '70003', 95000, 20, 30003, 50003);
INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
            VALUES (80004, 'Fahad', 'Islam', 'cool.fahad@fahad.me', '01500-000004', '2000-08-01', '70001', 80000, 10, 30001, 50001);
INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
            VALUES (80005, 'Sanim', 'Rahman', 'cool.sanim@sanim.me', '01500-000005', '2001-08-01', '70002', 75000, 15, 30002, 50002);
INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
            VALUES (80006, 'Shoeb', 'Rahman', 'cool.shoeb@shoeb.me', '01500-000006', '2002-08-01', '70003', 75000, 20, 30003, 50003);


SELECT round(sum(year(CURDATE())-year(hire_date))/count(employee_id),2) as averageEmployee_age, min(salary) as minimumSalary, max(salary) as maximumSalary FROM employees;
SELECT country_id, UCASE(country_name), region_id FROM countries;
SELECT country_id, LCASE(country_name), region_id FROM countries;
SELECT country_id, MID(country_name, 1, 3) AS ExtractedName, region_id FROM countries;
SELECT floor(sum(salary)/count(employee_id)) as floorAvgSalary FROM employees;
SELECT ceil(sum(salary)/count(employee_id)) as cellingAvgSalary FROM employees;
SELECT length(salary) as salaryLength FROM employees;
SELECT department_id, sum(salary) as maxPaidDepartmentSalary FROM employees GROUP BY department_id HAVING sum(salary) >= all (select sum(salary) FROM employees GROUP BY department_id);
SELECT department_id, sum(salary) as lessPaidDepartmentSalary FROM employees GROUP BY department_id HAVING sum(salary) <= all (select sum(salary) FROM employees GROUP BY department_id);

SELECT count(DISTINCT job_id) as numberOfJobs FROM employees;
SELECT employee_id, min(salary) as minEmployeeSalary FROM employees;
SELECT employee_id, salary as maxProgrammerSalary FROM employees WHERE salary = (select max(salary) FROM employees, jobs WHERE job_title='Programmer' AND employees.job_id=jobs.job_id);
SELECT job_id, avg(salary) as avgJobSalaryExcludingProgrammer FROM employees WHERE job_id != '70001' GROUP BY job_id;


DROP TABLE employees;
DROP TABLE job_history;
DROP TABLE job_grades;
DROP TABLE jobs;
DROP TABLE departments;
DROP TABLE locations;
DROP TABLE countries;
DROP TABLE regions;