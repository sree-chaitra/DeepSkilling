-- Create New Database
CREATE DATABASE IF NOT EXISTS BankCursorsDB;
USE BankCursorsDB;

-- Create Customers Table
CREATE TABLE IF NOT EXISTS Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(100)
);

-- Create Transactions Table
CREATE TABLE IF NOT EXISTS Transactions (
    TransactionID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    TransactionDate DATE,
    Amount DECIMAL(10,2)
);

-- Insert Sample Data
INSERT INTO Customers VALUES
(1, 'Alice'), (2, 'Bob');

INSERT INTO Transactions (CustomerID, TransactionDate, Amount) VALUES
(1, CURDATE(), 2000.00),
(1, CURDATE(), -500.00),
(2, CURDATE(), 1500.00),
(2, CURDATE(), -300.00);

-- PL/SQL Block to Generate Monthly Statements using Cursor
DELIMITER //

CREATE PROCEDURE GenerateMonthlyStatements()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE transCustomerID INT;
    DECLARE transAmount DECIMAL(10,2);
    DECLARE cur CURSOR FOR
        SELECT CustomerID, Amount
        FROM Transactions
        WHERE MONTH(TransactionDate) = MONTH(CURDATE()) AND YEAR(TransactionDate) = YEAR(CURDATE());

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO transCustomerID, transAmount;
        IF done THEN
            LEAVE read_loop;
        END IF;
        SELECT CONCAT('Customer ID: ', transCustomerID, ' - Transaction Amount: ', transAmount) AS Statement;
    END LOOP;

    CLOSE cur;
END //

DELIMITER ;

-- Example Test Case
-- CALL GenerateMonthlyStatements;
