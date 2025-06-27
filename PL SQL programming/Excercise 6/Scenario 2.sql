-- Create New Database
CREATE DATABASE IF NOT EXISTS BankCursorsDB;
USE BankCursorsDB;

-- Create Accounts Table
CREATE TABLE IF NOT EXISTS Accounts (
    AccountID INT PRIMARY KEY,
    AccountHolder VARCHAR(100),
    Balance DECIMAL(10,2)
);

-- Insert Sample Data
INSERT INTO Accounts VALUES
(1, 'Alice', 10000.00),
(2, 'Bob', 4000.00);

-- PL/SQL Block to Apply Annual Fee using Cursor
DELIMITER //

CREATE PROCEDURE ApplyAnnualFee()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE accID INT;
    DECLARE annualFee DECIMAL(10,2) DEFAULT 500.00;
    DECLARE cur CURSOR FOR
        SELECT AccountID FROM Accounts;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO accID;
        IF done THEN
            LEAVE read_loop;
        END IF;

        UPDATE Accounts
        SET Balance = Balance - annualFee
        WHERE AccountID = accID;
    END LOOP;

    CLOSE cur;
END //

DELIMITER ;

-- Example Test Case
-- CALL ApplyAnnualFee;
-- SELECT * FROM Accounts;
