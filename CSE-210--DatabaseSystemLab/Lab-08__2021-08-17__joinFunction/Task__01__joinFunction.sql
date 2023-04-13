CREATE TABLE employee (
    empID               INT(10),
    empFirstName        VARCHAR(25),
    empLastName         VARCHAR(25),
    age                 INT(3),
    empEmailID          VARCHAR(50),
    empPhoneNo          VARCHAR(15),
    address             VARCHAR(25),
    PRIMARY KEY (empID, empEmailID, empPhoneNo)
);
CREATE TABLE client (
    clientID            INT(10),
    clientFirstName     VARCHAR(25),
    clientLastName      VARCHAR(25),
    age                 INT(3),
    clientEmailID       VARCHAR(50),
    clientPhoneNo       VARCHAR(15),
    address             VARCHAR(25),
    empID               INT(10),
    PRIMARY KEY (clientID, clientEmailID, clientPhoneNo),
    FOREIGN KEY (empID) REFERENCES employee(empID) ON DELETE CASCADE
);
CREATE TABLE project (
    projectID           INT(5),
    empID               INT(10),
    clientID            INT(10),
    projectName         VARCHAR(25),
    projectStartDate    date,
    PRIMARY KEY (projectID),
    FOREIGN KEY (empID) REFERENCES employee(empID) ON DELETE CASCADE,
    FOREIGN KEY (clientID) REFERENCES client(clientID) ON DELETE CASCADE
);

INSERT INTO employee (empID, empFirstName, empLastName, age, empEmailID, empPhoneNo, address) VALUES (10001, 'Sabbir', 'Ibn Humayun', 21, 'coolSabbir+forYou@aleeas.com', '01500-000000', 'Narayanganj');
INSERT INTO employee (empID, empFirstName, empLastName, age, empEmailID, empPhoneNo, address) VALUES (10002, 'Jubayer', 'Rahman', 22, 'jubayer@gmail.com', '01300-000000', 'Narayanganj');
INSERT INTO employee (empID, empFirstName, empLastName, age, empEmailID, empPhoneNo, address) VALUES (10003, 'Mominul', 'Islam', 20, 'mominul@gmail.com', '01600-000000', 'Narayanganj');

INSERT INTO client (clientID, clientFirstName, clientLastName, age, clientEmailID, clientPhoneNo, address, empID) VALUES (20001, 'Fahad', 'Islam', 21, 'fahad@gmail.com', '01700-000001', 'Dhaka', 10001);
INSERT INTO client (clientID, clientFirstName, clientLastName, age, clientEmailID, clientPhoneNo, address, empID) VALUES (20002, 'Sanim', 'Rahman', 21, 'sanim@gmail.com', '01700-000002', 'Cumilla', 10002);
INSERT INTO client (clientID, clientFirstName, clientLastName, age, clientEmailID, clientPhoneNo, address, empID) VALUES (20003, 'Shoeb', 'Rahman', 21, 'shoeb@gmail.com', '01700-000003', 'Dhaka', 10003);

INSERT INTO project (projectID, empID, clientID, projectName, projectStartDate) VALUES (30001, 10001, 20001, 'Sudoku0', '2021-08-15');
INSERT INTO project (projectID, empID, clientID, projectName, projectStartDate) VALUES (30002, 10001, 20001, 'Sudoku1', '2021-08-16');
INSERT INTO project (projectID, empID, clientID, projectName, projectStartDate) VALUES (30003, 10002, 20002, 'Snake0', '2021-08-16');
INSERT INTO project (projectID, empID, clientID, projectName, projectStartDate) VALUES (30004, 10002, 20002, 'Snake1', '2021-08-17');
INSERT INTO project (projectID, empID, clientID, projectName, projectStartDate) VALUES (30005, 10003, 20003, 'Puzzle0', '2021-08-17');
INSERT INTO project (projectID, empID, clientID, projectName, projectStartDate) VALUES (30006, 10003, 20003, 'Puzzle1', '2021-08-18');

SELECT empID FROM employee UNION SELECT empID FROM project;
SELECT empID FROM employee UNION ALL SELECT empID FROM project;
SELECT project.projectID, project.projectName, employee.empID, employee.empFirstName, employee.empLastName FROM employee INNER JOIN project ON employee.empID = project.empID;
SELECT project.projectID, project.projectName, employee.empID, employee.empFirstName, employee.empLastName FROM employee INNER JOIN project ON employee.empID = project.empID WHERE project.empID=10001;
SELECT DISTINCT project.projectID, project.projectName, client.clientID, client.clientFirstName FROM client INNER JOIN project project ON client.clientID = project.clientID;
SELECT project.projectID, project.projectName, client.clientID, client.clientFirstName, employee.empID, employee.empFirstName FROM project INNER JOIN client ON project.clientID = client.clientID INNER JOIN employee ON client.empID = employee.empID;
SELECT project.projectID, project.projectName, client.clientID, client.clientFirstName, employee.empID, employee.empFirstName FROM project INNER JOIN client ON project.clientID = client.clientID INNER JOIN employee ON client.empID = employee.empID GROUP BY clientID;
SELECT DISTINCT address as distinctClientAddress FROM client;

DROP TABLE project;
DROP TABLE client;
DROP TABLE employee;