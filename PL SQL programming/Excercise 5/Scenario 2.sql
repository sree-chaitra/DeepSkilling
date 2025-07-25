-- Create New Database
CREATE DATABASE IF NOT EXISTS BankTriggersDB;
USE BankTriggersDB;

-- Create Transactions Table
CREATE TABLE IF NOT EXISTS Transactions (
    TransactionID INT PRIMARY KEY AUTO_INCREMENT,
    AccountID INT,
    TransactionType VARCHAR(10), -- 'Deposit' or 'Withdrawal'
    Amount DECIMAL(10,2),
    TransactionDate DATE
);

-- Create AuditLog Table
CREATE TABLE IF NOT EXISTS AuditLog (
    AuditID INT PRIMARY KEY AUTO_INCREMENT,
    TransactionID INT,
    ActionTimeStamp DATETIME
);

-- Create Trigger to Log Transactions
DELIMITER //

CREATE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, ActionTimeStamp)
    VALUES (NEW.TransactionID, NOW());
END //

DELIMITER ;

-- Example Test Case
-- INSERT INTO Transactions (AccountID, TransactionType, Amount, TransactionDate) VALUES (1, 'Deposit', 5000.00, CURDATE());
-- SELECT * FROM Transactions;
-- SELECT * FROM AuditLog;
