-- Create New Database
CREATE DATABASE IF NOT EXISTS BankTriggersDB;
USE BankTriggersDB;

-- Create Accounts Table
CREATE TABLE IF NOT EXISTS Accounts (
    AccountID INT PRIMARY KEY,
    AccountHolder VARCHAR(100),
    Balance DECIMAL(10,2)
);

-- Create Transactions Table
CREATE TABLE IF NOT EXISTS Transactions (
    TransactionID INT PRIMARY KEY AUTO_INCREMENT,
    AccountID INT,
    TransactionType VARCHAR(10), -- 'Deposit' or 'Withdrawal'
    Amount DECIMAL(10,2),
    TransactionDate DATE
);

-- Insert Sample Data
INSERT INTO Accounts VALUES
(1, 'Alice', 10000.00),
(2, 'Bob', 4000.00);

-- Create Trigger to Check Transaction Rules
DELIMITER //

CREATE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    DECLARE currentBalance DECIMAL(10,2);

    SELECT Balance INTO currentBalance FROM Accounts WHERE AccountID = NEW.AccountID;

    -- Check if withdrawal exceeds balance
    IF NEW.TransactionType = 'Withdrawal' AND NEW.Amount > currentBalance THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: Withdrawal exceeds account balance';
    END IF;

    -- Check if deposit amount is positive
    IF NEW.TransactionType = 'Deposit' AND NEW.Amount <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: Deposit amount must be positive';
    END IF;
END //

DELIMITER ;

-- Example Test Cases
-- Valid Deposit:
-- INSERT INTO Transactions (AccountID, TransactionType, Amount, TransactionDate) VALUES (1, 'Deposit', 5000.00, CURDATE());

-- Invalid Deposit:
-- INSERT INTO Transactions (AccountID, TransactionType, Amount, TransactionDate) VALUES (1, 'Deposit', -1000.00, CURDATE());

-- Valid Withdrawal:
-- INSERT INTO Transactions (AccountID, TransactionType, Amount, TransactionDate) VALUES (2, 'Withdrawal', 2000.00, CURDATE());

-- Invalid Withdrawal:
-- INSERT INTO Transactions (AccountID, TransactionType, Amount, TransactionDate) VALUES (2, 'Withdrawal', 5000.00, CURDATE());

-- View Transactions:
-- SELECT * FROM Transactions;
