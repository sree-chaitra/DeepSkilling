-- Step 1: Create Database
CREATE DATABASE IF NOT EXISTS BankSystem3;
USE BankSystem3;

-- Step 2: Create Customers Table
CREATE TABLE IF NOT EXISTS Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100)
);

-- Step 3: Create ErrorLog Table
CREATE TABLE IF NOT EXISTS ErrorLog (
    ErrorID INT AUTO_INCREMENT PRIMARY KEY,
    ErrorMessage VARCHAR(255),
    ErrorDate DATETIME
);

-- Step 4: Insert Sample Data into Customers Table
INSERT INTO Customers VALUES
(1, 'Tom', 'tom@example.com');

-- Step 5: Create Stored Procedure to Add New Customer
DELIMITER //

CREATE PROCEDURE AddNewCustomer (
    IN custId INT,
    IN custName VARCHAR(100),
    IN custEmail VARCHAR(100)
)
BEGIN
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
        -- Log duplicate customer ID error
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (CONCAT('Error: Customer ID ', custId, ' already exists.'), NOW());
        -- Rollback the failed insert
        ROLLBACK;
    END;

    START TRANSACTION;

    -- Attempt to insert customer
    INSERT INTO Customers (CustomerID, Name, Email)
    VALUES (custId, custName, custEmail);

    COMMIT;
END //

DELIMITER ;

-- Example Test Cases
-- Successful Insert:
-- CALL AddNewCustomer(2, 'Jerry', 'jerry@example.com');

-- Failed Insert (Duplicate Customer ID):
-- CALL AddNewCustomer(1, 'Tom Again', 'duplicate@example.com');

-- View Customers:
-- SELECT * FROM Customers;

-- View Error Log:
-- SELECT * FROM ErrorLog;
