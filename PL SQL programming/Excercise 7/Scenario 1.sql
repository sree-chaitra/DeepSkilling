-- Create New Database
CREATE DATABASE IF NOT EXISTS BankPackagesDB;
USE BankPackagesDB;

-- Create Customers Table
CREATE TABLE IF NOT EXISTS Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    Email VARCHAR(100),
    Balance DECIMAL(10,2)
);

-- Create CustomerManagement Package Specification
DELIMITER //

CREATE PROCEDURE AddCustomer (IN c_id INT, IN c_name VARCHAR(100), IN c_email VARCHAR(100), IN c_balance DECIMAL(10,2))
BEGIN
    INSERT INTO Customers VALUES (c_id, c_name, c_email, c_balance);
END //

CREATE PROCEDURE UpdateCustomerDetails (IN c_id INT, IN new_name VARCHAR(100), IN new_email VARCHAR(100))
BEGIN
    UPDATE Customers
    SET CustomerName = new_name, Email = new_email
    WHERE CustomerID = c_id;
END //

CREATE FUNCTION GetCustomerBalance (c_id INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE cust_balance DECIMAL(10,2);
    SELECT Balance INTO cust_balance FROM Customers WHERE CustomerID = c_id;
    RETURN cust_balance;
END //

DELIMITER ;

-- Example Test Case
-- CALL AddCustomer(1, 'Alice', 'alice@example.com', 5000.00);
-- CALL UpdateCustomerDetails(1, 'Alice New', 'alice_new@example.com');
-- SELECT GetCustomerBalance(1);
