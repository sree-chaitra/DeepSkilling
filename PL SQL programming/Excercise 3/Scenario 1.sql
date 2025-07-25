-- Create New Database
CREATE DATABASE IF NOT EXISTS BankSystem4;
USE BankSystem4;

-- Create Accounts Table (including account type)
CREATE TABLE IF NOT EXISTS Accounts (
    AccountId INT PRIMARY KEY,
    AccountHolder VARCHAR(100),
    Balance DECIMAL(10, 2),
    AccountType VARCHAR(20)
);

-- Insert Sample Data
INSERT INTO Accounts VALUES
(1, 'Alice', 5000.00, 'Savings'),
(2, 'Bob', 3000.00, 'Current'),
(3, 'Charlie', 7000.00, 'Savings');

-- Stored Procedure to Process Monthly Interest
DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest ()
BEGIN
    -- Apply 1% interest to all savings accounts
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
END //

DELIMITER ;

-- Example Test Case
-- CALL ProcessMonthlyInterest;

-- View Updated Accounts
-- SELECT * FROM Accounts;
