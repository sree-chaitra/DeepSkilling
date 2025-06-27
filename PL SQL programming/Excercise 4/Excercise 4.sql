-- Create New Database
CREATE DATABASE IF NOT EXISTS BankSystem5;
USE BankSystem5;

-- Create Customers Table
CREATE TABLE IF NOT EXISTS Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    DateOfBirth DATE
);

-- Create Loans Table
CREATE TABLE IF NOT EXISTS Loans (
    LoanID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    LoanAmount DECIMAL(10, 2),
    InterestRate DECIMAL(5, 2),
    LoanDurationYears INT
);

-- Create Accounts Table
CREATE TABLE IF NOT EXISTS Accounts (
    AccountId INT PRIMARY KEY,
    AccountHolder VARCHAR(100),
    Balance DECIMAL(10, 2)
);

-- Insert Sample Data
INSERT INTO Customers VALUES
(1, 'Alice', '1995-06-15'),
(2, 'Bob', '1988-03-22');

INSERT INTO Loans VALUES
(1, 'Tom', 500000.00, 7.5, 5),
(2, 'Jerry', 300000.00, 8.0, 3);

INSERT INTO Accounts VALUES
(1, 'Alice', 8000.00),
(2, 'Bob', 3000.00);

-- Function 1: Calculate Age
DELIMITER //

CREATE FUNCTION CalculateAge (dob DATE)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE age INT;
    SET age = TIMESTAMPDIFF(YEAR, dob, CURDATE());
    RETURN age;
END //

-- Function 2: Calculate Monthly Installment
CREATE FUNCTION CalculateMonthlyInstallment (
    loanAmount DECIMAL(10,2),
    annualInterestRate DECIMAL(5,2),
    loanDurationYears INT
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE monthlyInterestRate DECIMAL(10,6);
    DECLARE numberOfPayments INT;
    DECLARE installment DECIMAL(10,2);

    SET monthlyInterestRate = (annualInterestRate / 100) / 12;
    SET numberOfPayments = loanDurationYears * 12;

    SET installment = (loanAmount * monthlyInterestRate) / (1 - POW(1 + monthlyInterestRate, -numberOfPayments));

    RETURN installment;
END //

-- Function 3: Has Sufficient Balance
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

-- Example Test Cases
-- SELECT CustomerName, CalculateAge(DateOfBirth) AS Age FROM Customers;

-- SELECT CustomerName, CalculateMonthlyInstallment(LoanAmount, InterestRate, LoanDurationYears) AS MonthlyInstallment FROM Loans;

-- SELECT HasSufficientBalance(1, 5000) AS Result; -- Should return 1 (true)
-- SELECT HasSufficientBalance(2, 5000) AS Result; -- Should return 0 (false)
