-- Create New Database
CREATE DATABASE IF NOT EXISTS BankSystem5;
USE BankSystem5;

-- Create Accounts Table
CREATE TABLE IF NOT EXISTS Accounts (
    AccountId INT PRIMARY KEY,
    AccountHolder VARCHAR(100),
    Balance DECIMAL(10, 2)
);

-- Insert Sample Data
INSERT INTO Accounts VALUES
(1, 'Alice', 8000.00),
(2, 'Bob', 3000.00);

-- Create Function to Check Sufficient Balance
DELIMITER //

CREATE FUNCTION HasSufficientBalance (
    inputAccountId INT,
    requiredAmount DECIMAL(10,2)
)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
    DECLARE currentBalance DECIMAL(10,2);

    SELECT Balance INTO currentBalance
    FROM Accounts
    WHERE AccountId = inputAccountId;

    RETURN currentBalance >= requiredAmount;
END //

DELIMITER ;

-- Example Test Case
-- SELECT HasSufficientBalance(1, 5000) AS Result; -- Should return 1 (true)
-- SELECT HasSufficientBalance(2, 5000) AS Result; -- Should return 0 (false)
