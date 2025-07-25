-- Create New Database
CREATE DATABASE IF NOT EXISTS BankPackagesDB;
USE BankPackagesDB;

-- Create Accounts Table
CREATE TABLE IF NOT EXISTS Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR(50),
    Balance DECIMAL(10,2)
);

-- Create AccountOperations Package
DELIMITER //

CREATE PROCEDURE OpenAccount (IN acc_id INT, IN cust_id INT, IN acc_type VARCHAR(50), IN acc_balance DECIMAL(10,2))
BEGIN
    INSERT INTO Accounts VALUES (acc_id, cust_id, acc_type, acc_balance);
END //

CREATE PROCEDURE CloseAccount (IN acc_id INT)
BEGIN
    DELETE FROM Accounts WHERE AccountID = acc_id;
END //

CREATE FUNCTION GetTotalCustomerBalance (cust_id INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE total_balance DECIMAL(10,2);
    SELECT IFNULL(SUM(Balance), 0) INTO total_balance FROM Accounts WHERE CustomerID = cust_id;
    RETURN total_balance;
END //

DELIMITER ;

-- Example Test Case
-- CALL OpenAccount(1, 1, 'Savings', 5000.00);
-- CALL CloseAccount(1);
-- SELECT GetTotalCustomerBalance(1);
