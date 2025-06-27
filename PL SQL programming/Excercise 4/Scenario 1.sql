-- Create New Database
CREATE DATABASE IF NOT EXISTS BankSystem5;
USE BankSystem5;

-- Create Customers Table
CREATE TABLE IF NOT EXISTS Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    DateOfBirth DATE
);

-- Insert Sample Data
INSERT INTO Customers VALUES
(1, 'Alice', '1995-06-15'),
(2, 'Bob', '1988-03-22');

-- Create Function to Calculate Age
DELIMITER //

CREATE FUNCTION CalculateAge (dob DATE)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE age INT;
    SET age = TIMESTAMPDIFF(YEAR, dob, CURDATE());
    RETURN age;
END //

DELIMITER ;

-- Example Test Case
-- SELECT CustomerName, CalculateAge(DateOfBirth) AS Age FROM Customers;
