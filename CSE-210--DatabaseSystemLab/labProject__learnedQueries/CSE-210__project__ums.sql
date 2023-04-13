DROP TABLE IF EXISTS timeSlot;
DROP TABLE IF EXISTS classroom;
DROP TABLE IF EXISTS coursesTaken;
DROP TABLE IF EXISTS section;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS instructor;
DROP TABLE IF EXISTS department;


START TRANSACTION;
SET AUTOCOMMIT = OFF;
CREATE TABLE department (
    departmentID        ENUM('CSE', 'EEE', 'TEX'),
    departmentName      VARCHAR(50),
    PRIMARY KEY         (departmentID, departmentName)
);
INSERT INTO department VALUES   ('CSE', 'Computer Science and Engineering');
INSERT INTO department VALUES   ('EEE', 'Electrical and Electronics Engineering');
INSERT INTO department VALUES   ('TEX', 'Textile Engineering');

CREATE TABLE instructor (
    instructorID        VARCHAR(5),
    firstName           VARCHAR(25)     NOT NULL,
    lastName            VARCHAR(25)     NOT NULL,
    email               VARCHAR(50)     NOT NULL,
    phone               VARCHAR(15)     NOT NULL,
    salary              INTEGER(10)     DEFAULT 0,
    departmentID        ENUM('CSE', 'EEE', 'TEX'),
    PRIMARY KEY         (instructorID),
    FOREIGN KEY         (departmentID) REFERENCES department(departmentID) ON DELETE CASCADE
);
INSERT INTO instructor VALUES   ('AR', 'Abdur', 'Razzaque', 'razzaque@cse.green.edu.bd', '01500-000001', 250000, 'CSE'),
                                ('SA', 'Saiful', 'Azad', 'saiful@cse.green.edu.bd', '01500-000002', 200000, 'CSE'),
                                ('HKR', 'Humayan Kabir', 'Rana', 'humayan@cse.green.edu.bd', '01500-000003', 150000, 'CSE'),
                                ('MAI', 'Ansarul', 'Islam', 'ansarul@cse.green.edu.bd', '01500-000004', 100000, 'CSE'),
                                ('MAQ', 'Montaser', 'Abdul Quader', 'montaser@cse.green.edu.bd', '01500-000005', 750000, 'CSE'),

                                ('AS', 'ASM', 'Shihavuddin', 'shihav@eee.green.edu.bd', '01600-000001', 200000, 'EEE'),
                                ('TI', 'Tariqul', 'Islam', 'tariqul@eee.green.edu.bd', '01600-000002', 125000, 'EEE'),
                                ('II', 'Imamul', 'Islam', 'imamul@eee.green.edu.bd', '01600-000003', 100000, 'EEE'),

                                ('IC', 'Ismail', 'Chowdhury', 'ismail@tex.green.edu.bd', '01700-000001', 150000, 'TEX'),
                                ('SHA', 'Shariful', 'Alam', 'shariful@tex.green.edu.bd', '01700-000002', 125000, 'TEX'),
                                ('SHK', 'Shakil', 'Ahmed', 'shakil@tex.green.edu.bd', '01700-000003', 100000, 'TEX');

CREATE TABLE student (
    studentID           INTEGER(10),
    firstName           VARCHAR(25)     NOT NULL,
    lastName            VARCHAR(25)     NOT NULL,
    email               VARCHAR(50)     NOT NULL,
    phone               VARCHAR(15)     NOT NULL,    
    completedCredits    FLOAT(4, 1)     DEFAULT 0 CHECK (completedCredits >= 0 AND completedCredits <= 144),
    cgpa                FLOAT(3, 2)     DEFAULT 0,
    advisorID           VARCHAR(5),
    departmentID        ENUM('CSE', 'EEE', 'TEX'),
    PRIMARY KEY         (studentID),
    FOREIGN KEY         (advisorID) REFERENCES instructor(instructorID) ON UPDATE CASCADE,
    FOREIGN KEY         (departmentID) REFERENCES department(departmentID) ON DELETE CASCADE
);
INSERT INTO student VALUES      (193002023, 'Mominul', 'Islam', 'mominul@gmail.com', '01501-000001', 63.5, 3.85, 'MAI', 'CSE'),
                                (193002039, 'Fahad', 'Islam', 'fahad@gmail.com', '01501-000002', 63.5, 3.85, 'MAQ', 'CSE'),
                                (193002049, 'Muqtadir', 'Islam', 'muktadir@gmail.com', '01501-000003', 63.5, 3.90, 'MAI', 'CSE'),
                                (193002067, 'Sha', 'Imran', 'imran@gmail.com', '01501-000004', 63.5, 3.90, 'MAQ', 'CSE'),
                                (193002069, 'Sabbir', 'Ibn Humayun', 'coolSabbir+ForYou@aleeas.com', '01501-000005', 63.5, 1.75, 'HKR', 'CSE'),
                                (193002070, 'Jubayer', 'Rahman', 'jubayer@gmail.com', '01501-000006', 63.5, 3.95, 'MAI', 'CSE'),

                                (201001001, 'Ehsan', 'Mahmud', 'ehsan@gmail.com', '01601-000001', 51, 3.85, 'TI', 'EEE'),
                                (201001002, 'Sakib', 'Rahman', 'sakib@gmail.com', '01601-000002', 51, 3.80, 'II', 'EEE'),

                                (202003001, 'IKA', 'Shaikh', 'shaikh@gmail.com', '01701-000001', 39, 3.90, 'SHA', 'TEX'),
                                (202003002, 'Naimur', 'Rahman', 'naimur@gmail.com', '01701-000002', 39, 3.80, 'SHK', 'TEX');

CREATE TABLE course (
    courseID            VARCHAR(10),
    courseTitle         VARCHAR(100)    UNIQUE,
    credits             FLOAT(2, 1)     NOT NULL,
    prequesites         VARCHAR(10)     DEFAULT NULL,
    departmentID        ENUM('CSE', 'EEE', 'TEX'),
    PRIMARY KEY         (courseID),
    FOREIGN KEY         (departmentID) REFERENCES department(departmentID) ON DELETE CASCADE
);
INSERT INTO course VALUES       ('CSE-103', 'Structured Programming', 3, NULL, 'CSE'),
                                ('CSE-104', 'Structured Programming Lab', 1.5, NULL, 'CSE'),
                                ('CSE-105', 'Data Structures', 3, 'CSE-103', 'CSE'),
                                ('CSE-106', 'Data Structures Lab', 1.5, 'CSE-103', 'CSE'),
                                ('CSE-201', 'Object Oriented Programming', 3, 'CSE-103', 'CSE'),
                                ('CSE-202', 'Object Oriented Programming Lab', 1.5, 'CSE-103', 'CSE'),
                                ('CSE-205', 'Algorithms', 3, 'CSE-105', 'CSE'),
                                ('CSE-206', 'Algorithms Lab', 1.5, 'CSE-105', 'CSE'),
                                ('CSE-203', 'Digital Logic Design', 3, NULL, 'CSE'),
                                ('CSE-204', 'Digital Logic Design Lab', 1, NULL, 'CSE'),
                                ('CSE-301', 'Untitled Course', 2, NULL, 'CSE'),

                                ('EEE-201', 'Introduction to Electrical Engineering', 3, NULL, 'EEE'),
                                ('EEE-202', 'Introduction to Electrical Engineering Lab', 1.5, NULL, 'EEE'),
                                ('EEE-203', 'Electronic Devices and Circuits & Pulse Techniques', 3, 'EEE-201', 'EEE'),
                                ('EEE-204', 'Electronic Devices and Circuits & Pulse Techniques Lab', 1, 'EEE-201', 'EEE'),
                                ('EEE-205', 'Electrical Drives and Instrumentation', 3, 'EEE-203', 'EEE'),

                                ('TEX-201', 'Manmade Fibers', 3, NULL, 'TEX'),
                                ('TEX-202', 'Manmade Fibers Lab', 2, NULL, 'TEX'),
                                ('TEX-203', 'Yarn Manufacturing', 3, NULL, 'TEX'),
                                ('TEX-205', 'Weaving Technology', 3, NULL, 'TEX');

CREATE TABLE section (
    sectionID           VARCHAR(10),
    trimesterID         VARCHAR(5)      NOT NULL,
    trimesterYear       YEAR            NOT NULL,
    PRIMARY KEY         (sectionID)
);
INSERT INTO section VALUES      ('193DA', '212', 2021),
                                ('201DA', '212', 2021),
                                ('202DA', '212', 2021);

CREATE TABLE coursesTaken (
    courseID            VARCHAR(10),
    studentID           INTEGER(10),
    instructorID        VARCHAR(5),
    sectionID           VARCHAR(10),
    grade               VARCHAR(2),
    FOREIGN KEY         (courseID) REFERENCES course(courseID) ON UPDATE CASCADE,
    FOREIGN KEY         (studentID) REFERENCES student(studentID) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY         (instructorID) REFERENCES instructor(instructorID) ON UPDATE CASCADE,
    FOREIGN KEY         (sectionID) REFERENCES section(sectionID) ON UPDATE CASCADE
);
INSERT INTO coursesTaken VALUES ('CSE-103', 193002023, 'HKR', '202DA', 'A+'),
                                ('CSE-104', 193002023, 'HKR', '202DA', 'A+'),
                                ('CSE-105', 193002049, 'MAQ', '201DA', 'A+'),
                                ('CSE-106', 193002049, 'MAQ', '201DA', 'A+'),
                                ('CSE-205', 193002069, 'MAI', '193DA', 'C'),
                                ('CSE-206', 193002069, 'MAI', '193DA', 'C'),
                                ('CSE-204', 193002067, 'MAQ', '193DA', 'A'),
                                ('CSE-301', 193002070, 'SA', '193DA', 'A'),

                                ('EEE-201', 201001001, 'TI', '201DA', 'A+'),

                                ('TEX-201', 202003001, 'SHK', '202DA', 'A+');

CREATE TABLE classroom (
    buildingID          VARCHAR(1),
    roomNumber          INTEGER(3)      NOT NULL,
    capacity            INTEGER(3)      NOT NULL,
    courseID            VARCHAR(10),
    sectionID           VARCHAR(10),
    PRIMARY KEY         (courseID, sectionID),
    FOREIGN KEY         (courseID) REFERENCES course(courseID) ON UPDATE CASCADE,
    FOREIGN KEY         (sectionID) REFERENCES section(sectionID) ON UPDATE CASCADE
);
INSERT INTO classroom VALUES    ('A', 401, 40, 'CSE-103', '202DA'),
                                ('A', 402, 20, 'CSE-104', '202DA'),
                                ('A', 403, 35, 'CSE-105', '201DA'),
                                ('A', 404, 20, 'CSE-106', '201DA'),
                                ('A', 405, 25, 'CSE-205', '193DA'),
                                ('A', 406, 15, 'CSE-206', '193DA'),
                                ('A', 407, 40, 'CSE-204', '193DA'),
                                ('A', 408, 30, 'CSE-301', '193DA'),

                                ('B', 409, 30, 'EEE-201', '201DA'),

                                ('B', 410, 30, 'TEX-201', '202DA');

CREATE TABLE timeSlot (
    timeSlotID          INTEGER(5) AUTO_INCREMENT,
    startTime           TIME,
    endTime             TIME,
    courseID            VARCHAR(10),
    sectionID           VARCHAR(10),
    PRIMARY KEY         (timeSlotID, courseID, sectionID),
    FOREIGN KEY         (courseID) REFERENCES course(courseID) ON UPDATE CASCADE,
    FOREIGN KEY         (sectionID) REFERENCES section(sectionID) ON UPDATE CASCADE
);
ALTER TABLE timeSlot AUTO_INCREMENT = 101;
INSERT INTO timeSlot (startTime, endTime, courseID, sectionID) VALUES   ('08:30:00', '10:00:00', 'CSE-103', '202DA'),
                                                                        ('10:00:00', '13:00:00', 'CSE-104', '202DA'),
                                                                        ('08:30:00', '10:00:00', 'CSE-105', '201DA'),
                                                                        ('10:00:00', '13:00:00', 'CSE-106', '201DA'),
                                                                        ('08:30:00', '10:00:00', 'CSE-205', '193DA'),
                                                                        ('10:00:00', '13:00:00', 'CSE-206', '193DA'),
                                                                        ('10:00:00', '12:00:00', 'CSE-204', '193DA'),
                                                                        ('10:00:00', '11:30:00', 'CSE-301', '193DA'),

                                                                        ('13:30:00', '15:50:00', 'EEE-201', '201DA'),

                                                                        ('13:30:00', '15:00:00', 'TEX-201', '202DA');


--checking definition of a table
DESCRIBE department;
--altering table
ALTER TABLE department ADD tempColumn VARCHAR(69); 
DESCRIBE department;
ALTER TABLE department MODIFY COLUMN tempColumn INTEGER(69);
DESCRIBE department;
ALTER TABLE department DROP COLUMN tempColumn;
DESCRIBE department;
--selecting all the attributes from a table
SELECT * FROM department;
--selecting specific attibutes from a table
SELECT instructorID, instructor.firstName, instructor.departmentID FROM instructor;
--using alias for attributes
SELECT studentID AS "Student ID", student.firstName AS "First Name", student.departmentID AS "Department" FROM student;
--creating specific view with different queries
DROP VIEW IF EXISTS brightStudents;
CREATE VIEW brightStudents AS SELECT studentID, firstName, departmentID, cgpa FROM student WHERE cgpa >= 3.8;
SELECT * FROM brightStudents;
--using and, or, not operators
SELECT * FROM student WHERE (departmentID = 'CSE' AND (cgpa > 3.85 && cgpa <= 3.95));
SELECT * FROM student WHERE (departmentID = 'TEX' OR departmentID = 'EEE' || cgpa >= 3.95);
SELECT * FROM student WHERE (NOT departmentID = 'CSE' AND cgpa != 3.8);
--using order by with asc, desc
SELECT studentID, student.firstName, student.lastName, student.departmentID FROM student ORDER BY studentID DESC;
SELECT studentID, student.firstName, student.lastName, student.departmentID FROM student ORDER BY firstName, lastName ASC;
--updating specific data
UPDATE student SET cgpa = 1.25 WHERE studentID = 193002069;
SELECT * FROM student WHERE studentID = 193002069;
--usecase of commit, rollback, delete keywords
COMMIT;
DELETE FROM student WHERE studentID = 193002069;
SELECT * FROM student;
ROLLBACK;
SELECT * FROM student;
--using limit
SELECT * FROM course WHERE course.prequesites IS NULL LIMIT 3;
--using like and wildcards
SELECT * FROM section WHERE sectionID LIKE '%_A%';
--using in, betwwen, distinct
SELECT * FROM coursesTaken WHERE instructorID IN ('HKR', 'MAI', 'MAQ');
SELECT * FROM classroom WHERE capacity BETWEEN 30 AND 50;
SELECT DISTINCT startTime FROM timeSlot;
--switch case
SELECT * FROM course ORDER BY (CASE
                                    WHEN departmentID = 'CSE' THEN courseID
                                    WHEN departmentID = 'EEE' THEN credits
                                    ELSE courseTitle
                                END);
--aggregate functions
SELECT * FROM student WHERE cgpa = (SELECT min(cgpa) FROM student);
SELECT * FROM student WHERE cgpa = (SELECT max(cgpa) FROM student);
--group by/having
SELECT departmentID AS "Max Paid Department", sum(salary) AS "Amount" FROM instructor GROUP BY departmentID HAVING sum(salary) >= all (SELECT sum(salary) FROM instructor GROUP BY departmentID);
SELECT departmentID, round(avg(cgpa), 3) AS "Average CGPA" FROM student GROUP BY departmentID;
SELECT studentID, UCASE(firstName), LCASE(lastName), CONCAT(firstName, ' ', lastName) AS "Full Name", email FROM student;
--different join operations
SELECT * FROM section INNER JOIN coursesTaken ON section.sectionID = coursesTaken.sectionID;
SELECT * FROM classroom LEFT JOIN timeSlot ON classroom.sectionID = timeSlot.sectionID WHERE classroom.courseID = timeSlot.courseID;
SELECT * FROM coursesTaken RIGHT JOIN classroom ON coursesTaken.sectionID = classroom.sectionID WHERE coursesTaken.courseID = classroom.courseID;
SELECT * FROM department CROSS JOIN instructor WHERE department.departmentID = instructor.departmentID;
SELECT * FROM department, student WHERE department.departmentID = student.departmentID;
--triggers
SELECT studentID AS "Student ID", student.firstName AS "First Name", cgpa AS "CGPA" FROM student;
DROP TRIGGER IF EXISTS studentTrigger;
delimiter $$
CREATE TRIGGER studentTrigger BEFORE UPDATE ON student FOR EACH ROW
    BEGIN
        IF NEW.cgpa <= OLD.cgpa THEN SET NEW.cgpa = OLD.cgpa;
        END IF;
    END$$
delimiter ;
UPDATE student SET cgpa = 3.80 WHERE studentID = 193002023;
UPDATE student SET cgpa = 3.95 WHERE studentID = 193002049;
UPDATE student SET cgpa = 1.00 WHERE studentID = 193002069;
UPDATE student SET cgpa = 3.90 WHERE studentID = 193002070;
SELECT studentID AS "Student ID", student.firstName AS "First Name", cgpa AS "CGPA" FROM student;
COMMIT;