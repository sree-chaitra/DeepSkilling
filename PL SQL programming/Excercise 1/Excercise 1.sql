-- Disable safe updates to avoid Error 1175
SET SQL_SAFE_UPDATES = 0;

-- Drop existing database if it exists
DROP DATABASE IF EXISTS BankDB;

-- Create a fresh database
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

-- Insert Sample Customers
INSERT INTO Customers (name, age, balance) VALUES
('John Doe', 65, 8000),
('Jane Smith', 45, 15000),
('Alice Johnson', 70, 12000),
('Bob Brown', 30, 5000);

-- Insert Sample Loans
INSERT INTO Loans (customer_id, interest_rate, due_date) VALUES
(1, 5.00, CURDATE() + INTERVAL 10 DAY), -- John Doe
(2, 4.50, CURDATE() + INTERVAL 40 DAY), -- Jane Smith
(3, 6.00, CURDATE() + INTERVAL 25 DAY), -- Alice Johnson
(4, 7.00, CURDATE() + INTERVAL 60 DAY); -- Bob Brown

-- Scenario 1: Apply 1% Discount to Loan Interest Rates for Customers over 60
UPDATE Loans l
JOIN Customers c ON l.customer_id = c.customer_id
SET l.interest_rate = l.interest_rate - (l.interest_rate * 0.01)
WHERE c.age > 60;

-- View Updated Loans After Discount
SELECT 'Updated Loans After Discount' AS Info, l.* 
FROM Loans l;

-- Scenario 2: Promote Customers to VIP Based on Balance
UPDATE Customers
SET isVIP = TRUE
WHERE balance > 10000;

-- View Updated Customers After VIP Promotion
SELECT 'Updated Customers After VIP Promotion' AS Info, c.* 
FROM Customers c;

-- Scenario 3: Show Loan Reminders for Loans Due in the Next 30 Days
SELECT 'Loan Reminder' AS Info, c.name AS Customer_Name, l.loan_id, l.due_date
FROM Loans l
JOIN Customers c ON l.customer_id = c.customer_id
WHERE l.due_date BETWEEN CURDATE() AND CURDATE() + INTERVAL 30 DAY;

-- (Optional) Re-enable Safe Updates
-- SET SQL_SAFE_UPDATES = 1;
