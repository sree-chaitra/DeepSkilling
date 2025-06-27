-- Scenario 3: Send Loan Reminders for Loans Due in Next 30 Days

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
(1, 5.00, CURDATE() + INTERVAL 10 DAY),
(2, 4.50, CURDATE() + INTERVAL 40 DAY),
(3, 6.00, CURDATE() + INTERVAL 25 DAY),
(4, 7.00, CURDATE() + INTERVAL 60 DAY);

-- Send Loan Reminders (Due in Next 30 Days)
SELECT c.name AS Customer_Name, l.loan_id, l.due_date
FROM Loans l
JOIN Customers c ON l.customer_id = c.customer_id
WHERE l.due_date BETWEEN CURDATE() AND CURDATE() + INTERVAL 30 DAY;
