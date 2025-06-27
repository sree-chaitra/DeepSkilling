-- Step 1: Create Database
CREATE DATABASE IF NOT EXISTS BankSystem1;
USE BankSystem1;

-- Step 2: Create Accounts Table
CREATE TABLE IF NOT EXISTS Accounts (
    AccountId INT PRIMARY KEY,
    AccountHolder VARCHAR(100),
    Balance DECIMAL(10, 2)
);

-- Step 3: Create ErrorLog Table
CREATE TABLE IF NOT EXISTS ErrorLog (
    ErrorID INT AUTO_INCREMENT PRIMARY KEY,
    ErrorMessage VARCHAR(255),
    ErrorDate DATETIME
);

-- Step 4: Insert Sample Data into Accounts Table
INSERT INTO Accounts VALUES
(1, 'Alice', 5000.00),
(2, 'Bob', 3000.00);

-- Step 5: Create Stored Procedure for Safe Fund Transfer
DELIMITER //

CREATE PROCEDURE SafeTransferFunds (
    IN fromAccountId INT,
    IN toAccountId INT,
    IN transferAmount DECIMAL(10,2)
)
BEGIN
    DECLARE insufficientFunds CONDITION FOR SQLSTATE '45000';
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        -- Rollback on error
        ROLLBACK;
        -- Log the error
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (CONCAT('Error during fund transfer from account ', fromAccountId, ' to account ', toAccountId), NOW());
    END;

    START TRANSACTION;

    -- Check if sufficient balance is available
    IF (SELECT Balance FROM Accounts WHERE AccountId = fromAccountId) < transferAmount THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient funds in the source account';
    END IF;

    -- Deduct from source account
    UPDATE Accounts
    SET Balance = Balance - transferAmount
    WHERE AccountId = fromAccountId;

    -- Add to destination account
    UPDATE Accounts
    SET Balance = Balance + transferAmount
    WHERE AccountId = toAccountId;

    COMMIT;
END //

DELIMITER ;

-- Example Test Cases (You can run these to test the procedure)
-- Successful Transfer:
-- CALL SafeTransferFunds(1, 2, 2000);

-- Failed Transfer (Insufficient Funds):
-- CALL SafeTransferFunds(1, 2, 6000);

-- View Account Balances:
-- SELECT * FROM Accounts;

-- View Error Log:
-- SELECT * FROM ErrorLog;
