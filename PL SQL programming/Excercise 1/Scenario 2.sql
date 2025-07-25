-- Scenario 2: Promote Customers to VIP based on Balance

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

-- Insert Sample Data
INSERT INTO Customers (name, age, balance) VALUES
('John Doe', 65, 8000),
('Jane Smith', 45, 15000),
('Alice Johnson', 70, 12000),
('Bob Brown', 30, 5000);

-- Promote Customers to VIP
UPDATE Customers
SET isVIP = TRUE
WHERE balance > 10000;

-- Show Updated Customers
SELECT * FROM Customers;
