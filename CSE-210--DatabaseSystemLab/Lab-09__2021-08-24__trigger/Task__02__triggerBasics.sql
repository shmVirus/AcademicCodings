DROP TABLE IF EXISTS WaiverInfo;
DROP TABLE IF EXISTS StudentInfo;
DROP TRIGGER IF EXISTS waiverTrigger;
CREATE TABLE StudentInfo (
    studentID           INT(10),
    studentName         VARCHAR(25) NOT NULL,
    address             VARCHAR(25),
    email               VARCHAR(50) UNIQUE,
    PRIMARY KEY         (studentID)
);
CREATE TABLE WaiverInfo (
    studentID           INT(10),
    studentName         VARCHAR(25) NOT NULL,
    cgpa                FLOAT(4, 2),
    waiverPercentage    INT(3),
    FOREIGN KEY         (studentID) REFERENCES StudentInfo(studentID) ON DELETE CASCADE
);
delimiter $$
CREATE TRIGGER waiverTrigger BEFORE INSERT ON WaiverInfo FOR EACH ROW
    BEGIN
        IF NEW.cgpa >= 3.50 && NEW.cgpa <= 3.99 && NEW.waiverPercentage > 60 THEN SET NEW.waiverPercentage = 60;
        END IF;
        IF NEW.cgpa >= 3.25 && NEW.cgpa <= 3.49 && NEW.waiverPercentage > 50 THEN SET NEW.waiverPercentage = 50;
        END IF;
        IF NEW.cgpa >= 3.00 && NEW.cgpa <= 3.25 && NEW.waiverPercentage > 40 THEN SET NEW.waiverPercentage = 40;
        END IF;
        IF NEW.cgpa >= 2.50 && NEW.cgpa <= 2.99 && NEW.waiverPercentage > 30 THEN SET NEW.waiverPercentage = 30;
        END IF;
        IF NEW.cgpa <= 2.50 && NEW.waiverPercentage > 20 THEN SET NEW.cgpa = 20;
        END IF;
    END$$
delimiter ;

INSERT INTO StudentInfo VALUES  (193002023, 'Mominul Islam', 'Dhaka', 'mominul@gmail.com'),
                                (193002037, 'Sanim Hasan', 'Cumilla', 'sanim@gmail.com'),
                                (193002039, 'Fahad Islam', 'Cumilla', 'fahad@gmail.com'),
                                (193002041, 'Shoeb Rahman', 'Dhaka', 'shoeb@gmail.com'),
                                (193002049, 'Muqtadir Islam', 'Dhaka', 'muktadir@gmail.com'),
                                (193002067, 'Sha Imran', 'Dhaka', 'imran@gmail.com'),
                                (193002069, 'Sabbir Ibn Humayun', 'Narayanganj', 'coolSabbir+ForYou@aleeas.com'),
                                (193002070, 'Jubayer Rahman', 'Narayanganj', 'jubayer@gmail.com'),
                                (193002154, 'Mahfujur Rahman', 'Panchagar', 'mushfique@gmail.com'),
                                (193002169, 'Unknown Person', 'Virtual', 'unknown.me@gmail.com');
INSERT INTO WaiverInfo VALUES   (193002023, 'Mominul Islam', 3.25, 30),
                                (193002037, 'Sanim Hasan', 1.75, 10),
                                (193002039, 'Fahad Islam', 2.75, 20),
                                (193002041, 'Shoeb Rahman', 2.50, 20),
                                (193002049, 'Muqtadir Islam', 3.85, 40),
                                (193002067, 'Sha Imran', 3.15, 30),
                                (193002069, 'Sabbir Ibn Humayun', 3.93, 50),
                                (193002070, 'Jubayer Rahman', 3.75, 40),
                                (193002154, 'Mahfujur Rahman', 2.25, 10),
                                (193002169, 'Unknown Person', 3.99, 100);

SELECT * FROM WaiverInfo;