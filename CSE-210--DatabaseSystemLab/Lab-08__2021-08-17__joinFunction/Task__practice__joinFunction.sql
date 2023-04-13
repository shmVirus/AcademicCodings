CREATE TABLE student(
    sID                 int(11) NOT NULL AUTO_INCREMENT,
    firstName           varchar(255) NOT NULL,
    lastName            varchar(255) NOT NULL,
    address             varchar(255) NOT NULL,
    deptName            enum('CSE', 'EEE', 'TEX') DEFAULT NULL,
    admissionDate       datetime NOT NULL DEFAULT current_timestamp(),
    PRIMARY KEY(sID)
);
CREATE TABLE department(
    deptID          int(11) NOT NULL AUTO_INCREMENT,
    deptName        enum('CSE', 'EEE', 'TEX') DEFAULT NULL,
    deptLocation    varchar(255) NOT NULL,
    PRIMARY KEY(deptID)
);
CREATE TABLE courseRegistration(
    regSerial       int(11) NOT NULL AUTO_INCREMENT,
    courseCode      varchar(255) NOT NULL,
    courseTitle     varchar(255) NOT NULL,
    deptID          int(11) NOT NULL,
    sID             varchar(255) NOT NULL,
    PRIMARY KEY(regSerial)
);


INSERT INTO student (sID, firstName, lastName, address, deptName) VALUES (142002015, 'Zeseya', 'Sharmin', 'Dhaka', 'CSE');
INSERT INTO student (sID, firstName, lastName, address, deptName) VALUES (142002001, 'Sakib', 'Hasan', 'Natore' , 'CSE');
INSERT INTO student (sID, firstName, lastName, address, deptName) VALUES (162002002, 'Asef', 'Tajwar' , 'Rangpur' , 'EEE');
INSERT INTO student (sID, firstName, lastName, address, deptName) VALUES (162002003, 'Maruf', 'Hasan', 'Barisal', 'EEE');
INSERT INTO student (sID, firstName, lastName, address, deptName) VALUES (172082002, 'Ashek', 'Farabi', 'Gazipur' ,'TEX');
INSERT INTO student (sID, firstName, lastName, address, deptName) VALUES (173002003, 'Ismile', 'Hasan' , 'Barisal' , 'TEX');

INSERT INTO department (deptID, deptName, deptLocation) VALUES (101, 'CSE', 'Building-2');
INSERT INTO department (deptID, deptName, deptLocation) VALUES (102, 'EEE', 'Building-2');
INSERT INTO department (deptID, deptName, deptLocation) VALUES (103, 'TEX', 'Building-1');

INSERT INTO courseRegistration(courseCode, courseTitle, deptID,sID) VALUES ('CSE-311', 'Computer Networks', 101, 142002015);
INSERT INTO courseRegistration(courseCode, courseTitle, deptID,sID) VALUES ('CSE-311', 'Computer Networks', 101, 142002001);
INSERT INTO courseRegistration(courseCode, courseTitle, deptID,sID) VALUES ('EEE-301', 'Electrical Circuit', 201, 162002002);
INSERT INTO courseRegistration(courseCode, courseTitle, deptID,sID) VALUES ('TEX-201', 'Aparales', 301, 172002002);
INSERT INTO courseRegistration(courseCode, courseTitle, deptID,sID) VALUES ('CSE-312', 'Computer Networks Lab', 101, 142002015);
INSERT INTO courseRegistration(courseCode, courseTitle, deptID,sID) VALUES ('CSE-207', 'Algorithm', 101, 142002001);


SELECT sID FROM student UNION SELECT sID FROM courseRegistration;
SELECT sID FROM student UNION ALL SELECT sID FROM courseRegistration;
SELECT student.sID, student.FirstName, student.LastName FROM student INNER JOIN courseRegistration ON student.sID = courseRegistration.sID;
SELECT student.sID, student.FirstName, student.LastName FROM student INNER JOIN courseRegistration ON student.sID = courseRegistration.sID WHERE courseRegistration.sID = 142002015;
SELECT student.sID, student.FirstName, student.deptName, department.deptID FROM student INNER JOIN department ON student.deptName = department.deptName;
SELECT student.sID, student.FirstName, student.deptName, department.deptID, courseRegistration.courseCode FROM student INNER JOIN department ON student.deptName = department.deptName INNER JOIN courseRegistration ON department.deptID = courseRegistration.deptID;
SELECT student.sID, student.FirstName, student.deptName, department.deptID, courseRegistration.courseCode FROM student INNER JOIN department ON student.deptName = department.deptName INNER JOIN courseRegistration ON department.deptID = courseRegistration.deptID GROUP BY sID;

DROP TABLE courseRegistration;
DROP TABLE department;
DROP TABLE student;