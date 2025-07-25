-- Create New Database
CREATE DATABASE IF NOT EXISTS BankTriggersDB;
USE BankTriggersDB;

-- Create Customers Table
CREATE TABLE IF NOT EXISTS Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    Email VARCHAR(100),
    LastModified DATE
);

-- Insert Sample Data
INSERT INTO Customers VALUES
(1, 'Alice', 'alice@example.com', CURDATE()),
(2, 'Bob', 'bob@example.com', CURDATE());

-- Create Trigger to Update LastModified on Customer Update
DELIMITER //

CREATE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    SET NEW.LastModified = CURDATE();
END //

DELIMITER ;

-- Example Test Case
-- UPDATE Customers SET Email = 'alice_new@example.com' WHERE CustomerID = 1;
-- SELECT * FROM Customers;
