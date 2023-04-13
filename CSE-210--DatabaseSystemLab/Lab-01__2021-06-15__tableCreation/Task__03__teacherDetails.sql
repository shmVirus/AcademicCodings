DROP TABLE teacherDetails;
CREATE TABLE teacherDetails (
    NAME varchar(15),
    DEPT varchar(5),
    PAPERs number(3),
    EXPERIENCE varchar(10)
);
--DESCRIBE teacherDetails;
INSERT INTO teacherDetails (NAME, DEPT, PAPERs, EXPERIENCE) VALUES ('Sabbir', 'CSE', 5, '2 Years');
INSERT INTO teacherDetails (NAME, DEPT, PAPERs, EXPERIENCE) VALUES ('Jubayer', 'EEE', 3, '2.5 Years');
INSERT INTO teacherDetails (NAME, DEPT, PAPERs, EXPERIENCE) VALUES ('Muktadir', 'CSE', 3, '2 Years');
SELECT * FROM teacherDetails;
