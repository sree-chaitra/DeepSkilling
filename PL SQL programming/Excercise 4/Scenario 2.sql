-- Create New Database
CREATE DATABASE IF NOT EXISTS BankSystem5;
USE BankSystem5;

-- Create Loans Table
CREATE TABLE IF NOT EXISTS Loans (
    LoanID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    LoanAmount DECIMAL(10, 2),
    InterestRate DECIMAL(5, 2), -- Annual interest rate in percentage
    LoanDurationYears INT
);

-- Insert Sample Data
INSERT INTO Loans VALUES
(1, 'Tom', 500000.00, 7.5, 5),
(2, 'Jerry', 300000.00, 8.0, 3);

-- Create Function to Calculate Monthly Installment
DELIMITER //

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

DELIMITER ;

-- Example Test Case
-- SELECT CustomerName, CalculateMonthlyInstallment(LoanAmount, InterestRate, LoanDurationYears) AS MonthlyInstallment FROM Loans;
