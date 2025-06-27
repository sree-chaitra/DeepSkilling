-- Scenario 1: Apply Discount to Loan Interest Rates for Customers above 60

-- Create Database and Tables
DROP DATABASE IF EXISTS BankDB;
CREATE DATABASE BankDB;
USE BankDB;

-- Create Customers Table
CREATE TABLE Customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    balance DECIMAL(10,2),
    isVIP BOOLEAN DEFAULT FALSE
);

-- Create Loans Table
CREATE TABLE Loans (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    interest_rate DECIMAL(5,2),
    due_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

-- Insert Sample Data
INSERT INTO Customers (name, age, balance) VALUES
('John Doe', 65, 8000),
('Jane Smith', 45, 15000),
('Alice Johnson', 70, 12000),
('Bob Brown', 30, 5000);

INSERT INTO Loans (customer_id, interest_rate, due_date) VALUES
(1, 5.00, '2025-07-15'),
(2, 4.50, '2025-08-10'),
(3, 6.00, '2025-07-20'),
(4, 7.00, '2025-09-01');

-- Apply 1% Discount to Customers above 60
UPDATE Loans l
JOIN Customers c ON l.customer_id = c.customer_id
SET l.interest_rate = l.interest_rate - (l.interest_rate * 0.01)
WHERE c.age > 60;

-- Show Updated Loans
SELECT * FROM Loans;
