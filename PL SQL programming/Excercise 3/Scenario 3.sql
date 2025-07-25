-- Create New Database
CREATE DATABASE IF NOT EXISTS BankSystem4;
USE BankSystem4;

-- Create CustomerAccounts Table
CREATE TABLE IF NOT EXISTS CustomerAccounts (
    AccountId INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    Balance DECIMAL(10, 2)
);

-- Create ErrorLog Table
CREATE TABLE IF NOT EXISTS ErrorLog (
    ErrorID INT AUTO_INCREMENT PRIMARY KEY,
    ErrorMessage VARCHAR(255),
    ErrorDate DATETIME
);

-- Insert Sample Data
INSERT INTO CustomerAccounts VALUES
(1, 'Tom', 8000.00),
(2, 'Jerry', 4000.00);

-- Stored Procedure for Fund Transfer
DELIMITER //

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

-- Example Test Case
-- CALL TransferFunds(1, 2, 1000);

-- View Updated Accounts
-- SELECT * FROM CustomerAccounts;

-- View Error Log
-- SELECT * FROM ErrorLog;
