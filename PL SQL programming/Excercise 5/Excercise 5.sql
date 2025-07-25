-- Create New Database
CREATE DATABASE IF NOT EXISTS BankTriggersDB;
USE BankTriggersDB;

-- Table 1: Customers Table
CREATE TABLE IF NOT EXISTS Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    Email VARCHAR(100),
    LastModified DATE
);

-- Table 2: Accounts Table
CREATE TABLE IF NOT EXISTS Accounts (
    AccountID INT PRIMARY KEY,
    AccountHolder VARCHAR(100),
    Balance DECIMAL(10,2)
);

-- Table 3: Transactions Table
CREATE TABLE IF NOT EXISTS Transactions (
    TransactionID INT PRIMARY KEY AUTO_INCREMENT,
    AccountID INT,
    TransactionType VARCHAR(10), -- 'Deposit' or 'Withdrawal'
    Amount DECIMAL(10,2),
    TransactionDate DATE
);

-- Table 4: Audit Log Table
CREATE TABLE IF NOT EXISTS AuditLog (
    AuditID INT PRIMARY KEY AUTO_INCREMENT,
    TransactionID INT,
    ActionTimeStamp DATETIME
);

-- Insert Sample Data
INSERT INTO Customers VALUES
(1, 'Alice', 'alice@example.com', CURDATE()),
(2, 'Bob', 'bob@example.com', CURDATE());

INSERT INTO Accounts VALUES
(1, 'Alice', 10000.00),
(2, 'Bob', 4000.00);

-- Trigger 1: Update Customer LastModified
DELIMITER //

CREATE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    SET NEW.LastModified = CURDATE();
END //

-- Trigger 2: Log Transaction
CREATE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, ActionTimeStamp)
    VALUES (NEW.TransactionID, NOW());
END //

-- Trigger 3: Check Transaction Rules
CREATE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    DECLARE currentBalance DECIMAL(10,2);

    SELECT Balance INTO currentBalance FROM Accounts WHERE AccountID = NEW.AccountID;

    IF NEW.TransactionType = 'Withdrawal' AND NEW.Amount > currentBalance THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: Withdrawal exceeds account balance';
    END IF;

    IF NEW.TransactionType = 'Deposit' AND NEW.Amount <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: Deposit amount must be positive';
    END IF;
END //

DELIMITER ;

-- Example Test Cases
-- Trigger 1 Test:
-- UPDATE Customers SET Email = 'alice_new@example.com' WHERE CustomerID = 1;
-- SELECT * FROM Customers;

-- Trigger 2 Test:
-- INSERT INTO Transactions (AccountID, TransactionType, Amount, TransactionDate) VALUES (1, 'Deposit', 5000.00, CURDATE());
-- SELECT * FROM Transactions;
-- SELECT * FROM AuditLog;

-- Trigger 3 Test:
-- INSERT INTO Transactions (AccountID, TransactionType, Amount, TransactionDate) VALUES (2, 'Withdrawal', 2000.00, CURDATE()); -- Valid
-- INSERT INTO Transactions (AccountID, TransactionType, Amount, TransactionDate) VALUES (2, 'Withdrawal', 6000.00, CURDATE()); -- Invalid
-- INSERT INTO Transactions (AccountID, TransactionType, Amount, TransactionDate) VALUES (1, 'Deposit', -1000.00, CURDATE()); -- Invalid

-- View Transactions:
-- SELECT * FROM Transactions;
