-- Create New Database
CREATE DATABASE IF NOT EXISTS BankSystem4;
USE BankSystem4;

-- Common Tables for All Scenarios
CREATE TABLE IF NOT EXISTS Accounts (
    AccountId INT PRIMARY KEY,
    AccountHolder VARCHAR(100),
    Balance DECIMAL(10, 2),
    AccountType VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Employees (
    EmployeeID INT PRIMARY KEY,
    EmployeeName VARCHAR(100),
    Department VARCHAR(50),
    Salary DECIMAL(10, 2)
);

CREATE TABLE IF NOT EXISTS CustomerAccounts (
    AccountId INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    Balance DECIMAL(10, 2)
);

CREATE TABLE IF NOT EXISTS ErrorLog (
    ErrorID INT AUTO_INCREMENT PRIMARY KEY,
    ErrorMessage VARCHAR(255),
    ErrorDate DATETIME
);

-- Insert Sample Data
INSERT INTO Accounts VALUES
(1, 'Alice', 5000.00, 'Savings'),
(2, 'Bob', 3000.00, 'Current'),
(3, 'Charlie', 7000.00, 'Savings');

INSERT INTO Employees VALUES
(1, 'John Doe', 'HR', 40000.00),
(2, 'Jane Smith', 'IT', 50000.00),
(3, 'Mark Lee', 'IT', 55000.00);

INSERT INTO CustomerAccounts VALUES
(1, 'Tom', 8000.00),
(2, 'Jerry', 4000.00);

-- Stored Procedure 1: Process Monthly Interest
DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest ()
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
END //

-- Stored Procedure 2: Update Employee Bonus
CREATE PROCEDURE UpdateEmployeeBonus (
    IN deptName VARCHAR(50),
    IN bonusPercent DECIMAL(5,2)
)
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonusPercent / 100)
    WHERE Department = deptName;
END //

-- Stored Procedure 3: Transfer Funds
CREATE PROCEDURE TransferFunds (
    IN fromAccountId INT,
    IN toAccountId INT,
    IN transferAmount DECIMAL(10,2)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (CONCAT('Error during fund transfer from account ', fromAccountId, ' to account ', toAccountId), NOW());
    END;

    START TRANSACTION;

    IF (SELECT Balance FROM CustomerAccounts WHERE AccountId = fromAccountId) < transferAmount THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient funds in source account';
    END IF;

    UPDATE CustomerAccounts
    SET Balance = Balance - transferAmount
    WHERE AccountId = fromAccountId;

    UPDATE CustomerAccounts
    SET Balance = Balance + transferAmount
    WHERE AccountId = toAccountId;

    COMMIT;
END //

DELIMITER ;

-- Example Test Cases
-- CALL ProcessMonthlyInterest;
-- CALL UpdateEmployeeBonus('IT', 10);
-- CALL TransferFunds(1, 2, 1000);

-- View Tables
-- SELECT * FROM Accounts;
-- SELECT * FROM Employees;
-- SELECT * FROM CustomerAccounts;
-- SELECT * FROM ErrorLog;
