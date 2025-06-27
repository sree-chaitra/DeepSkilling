-- Create New Database
CREATE DATABASE IF NOT EXISTS BankCursorsDB;
USE BankCursorsDB;

-- Table 1: Customers Table
CREATE TABLE IF NOT EXISTS Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(100)
);

-- Table 2: Transactions Table
CREATE TABLE IF NOT EXISTS Transactions (
    TransactionID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    TransactionDate DATE,
    Amount DECIMAL(10,2)
);

-- Table 3: Accounts Table
CREATE TABLE IF NOT EXISTS Accounts (
    AccountID INT PRIMARY KEY,
    AccountHolder VARCHAR(100),
    Balance DECIMAL(10,2)
);

-- Table 4: Loans Table
CREATE TABLE IF NOT EXISTS Loans (
    LoanID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    InterestRate DECIMAL(5,2)
);

-- Insert Sample Data
INSERT INTO Customers VALUES
(1, 'Alice'), (2, 'Bob');

INSERT INTO Transactions (CustomerID, TransactionDate, Amount) VALUES
(1, CURDATE(), 2000.00),
(1, CURDATE(), -500.00),
(2, CURDATE(), 1500.00),
(2, CURDATE(), -300.00);

INSERT INTO Accounts VALUES
(1, 'Alice', 10000.00),
(2, 'Bob', 4000.00);

INSERT INTO Loans VALUES
(1, 'Alice', 7.5),
(2, 'Bob', 8.0);

-- Scenario 1: Generate Monthly Statements
DELIMITER //

CREATE PROCEDURE GenerateMonthlyStatements()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE transCustomerID INT;
    DECLARE transAmount DECIMAL(10,2);
    DECLARE cur CURSOR FOR
        SELECT CustomerID, Amount
        FROM Transactions
        WHERE MONTH(TransactionDate) = MONTH(CURDATE()) AND YEAR(TransactionDate) = YEAR(CURDATE());

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO transCustomerID, transAmount;
        IF done THEN
            LEAVE read_loop;
        END IF;
        SELECT CONCAT('Customer ID: ', transCustomerID, ' - Transaction Amount: ', transAmount) AS Statement;
    END LOOP;

    CLOSE cur;
END //

-- Scenario 2: Apply Annual Fee
CREATE PROCEDURE ApplyAnnualFee()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE accID INT;
    DECLARE annualFee DECIMAL(10,2) DEFAULT 500.00;
    DECLARE cur CURSOR FOR
        SELECT AccountID FROM Accounts;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO accID;
        IF done THEN
            LEAVE read_loop;
        END IF;

        UPDATE Accounts
        SET Balance = Balance - annualFee
        WHERE AccountID = accID;
    END LOOP;

    CLOSE cur;
END //

-- Scenario 3: Update Loan Interest Rates
CREATE PROCEDURE UpdateLoanInterestRates()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE loanID INT;
    DECLARE cur CURSOR FOR
        SELECT LoanID FROM Loans;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO loanID;
        IF done THEN
            LEAVE read_loop;
        END IF;

        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = loanID;
    END LOOP;

    CLOSE cur;
END //

DELIMITER ;

-- Example Test Cases
-- CALL GenerateMonthlyStatements;
-- CALL ApplyAnnualFee;
-- CALL UpdateLoanInterestRates;

-- View Tables
-- SELECT * FROM Transactions;
-- SELECT * FROM Accounts;
-- SELECT * FROM Loans;
