DROP TABLE studentDetails;
CREATE TABLE studentDetails (
    ID                  NUMBER(9)       PRIMARY KEY,
    NAME                VARCHAR(15)     NOT NULL,
    DEPARTMENT          VARCHAR(10)     NOT NULL,
    CGPA                NUMBER(3, 2),
    LAST_GPA            NUMBER(3, 2),
    FAVOURITE_LANGUAGE  VARCHAR(20)
);
INSERT INTO studentDetails (ID, NAME, DEPARTMENT, CGPA, LAST_GPA, FAVOURITE_LANGUAGE) VALUES (193002023, 'Asif', 'CSE', 0.00, 0.00, 'JavaScript');
INSERT INTO studentDetails (ID, NAME, DEPARTMENT, CGPA, LAST_GPA, FAVOURITE_LANGUAGE) VALUES (193002049, 'Muktadir', 'CSE', 0.00, 0.00, 'Java');
INSERT INTO studentDetails (ID, NAME, DEPARTMENT, CGPA, LAST_GPA, FAVOURITE_LANGUAGE) VALUES (193002069, 'Sabbir', 'CSE', 0.00, 0.00, 'C/C++');
INSERT INTO studentDetails (ID, NAME, DEPARTMENT, CGPA, LAST_GPA, FAVOURITE_LANGUAGE) VALUES (193002070, 'Jubayer', 'CSE', 0.00, 0.00, 'Python');
SELECT * FROM studentDetails;

DROP TABLE courseDetails;
CREATE TABLE courseDetails (
    COURSE_ID           VARCHAR(9)      PRIMARY KEY,
    COURSE_NAME         VARCHAR(15)     UNIQUE,
    COURSE_CREDITS      NUMBER(2, 1)    DEFAULT 3.0
);
INSERT INTO courseDetails (COURSE_ID, COURSE_NAME, COURSE_CREDITS) VALUES ('CSE-103', 'C', 3.0);
SELECT * FROM courseDetails;

DROP TABLE coursesTaken;
CREATE TABLE coursesTaken (
    S_ID        NUMBER(9),
    COURSE_ID   VARCHAR(9)   PRIMARY KEY,
    FOREIGN KEY(S_ID) REFERENCES studentDetails(ID)  ON DELETE CASCADE
);
INSERT INTO coursesTaken (COURSE_ID) VALUES ('CSE-103');
SELECT * FROM coursesTaken;