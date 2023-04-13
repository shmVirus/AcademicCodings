DROP TABLE studentDetails;
CREATE TABLE studentDetails (
    ID number(9),
    NAME varchar(15),
    CGPA number(3, 2),
    LAST_GPA number(3, 2),
    FAVOURITE_LANGUAGE varchar(10)
);
--DESCRIBE studentDetails;
INSERT INTO studentDetails (ID, NAME, CGPA, LAST_GPA, FAVOURITE_LANGUAGE) VALUES (193002023, 'Asif', 0.00, 0.00, 'JavaScript');
INSERT INTO studentDetails (ID, NAME, CGPA, LAST_GPA, FAVOURITE_LANGUAGE) VALUES (193002049, 'Muktadir', 0.00, 0.00, 'Java');
INSERT INTO studentDetails (ID, NAME, CGPA, LAST_GPA, FAVOURITE_LANGUAGE) VALUES (193002069, 'Sabbir', 0.00, 0.00, 'C/C++');
INSERT INTO studentDetails (ID, NAME, CGPA, LAST_GPA, FAVOURITE_LANGUAGE) VALUES (193002070, 'Jubayer', 0.00, 0.00, 'Python');
SELECT * FROM studentDetails;
