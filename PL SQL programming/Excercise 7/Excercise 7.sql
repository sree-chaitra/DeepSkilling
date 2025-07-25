-- Create New Database
CREATE DATABASE IF NOT EXISTS BankPackagesDB;
USE BankPackagesDB;

-- Table 1: Customers
CREATE TABLE IF NOT EXISTS Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    Email VARCHAR(100),
    Balance DECIMAL(10,2)
);

-- Table 2: Employees
CREATE TABLE IF NOT EXISTS Employees (
    EmployeeID INT PRIMARY KEY,
    EmployeeName VARCHAR(100),
    Department VARCHAR(50),
    MonthlySalary DECIMAL(10,2)
);

-- Table 3: Accounts
CREATE TABLE IF NOT EXISTS Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR(50),
    Balance DECIMAL(10,2)
);

-- Insert Sample Data (Optional)
-- Customers: INSERT INTO Customers VALUES (1, 'Alice', 'alice@example.com', 5000.00);
-- Employees: INSERT INTO Employees VALUES (1, 'John', 'IT', 40000);
-- Accounts: INSERT INTO Accounts VALUES (1, 1, 'Savings', 5000.00);

-- Package 1: Customer Management
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

-- Package 2: Employee Management
CREATE PROCEDURE HireEmployee (IN e_id INT, IN e_name VARCHAR(100), IN e_dept VARCHAR(50), IN e_salary DECIMAL(10,2))
BEGIN
    INSERT INTO Employees VALUES (e_id, e_name, e_dept, e_salary);
END //

CREATE PROCEDURE UpdateEmployeeDetails (IN e_id INT, IN new_name VARCHAR(100), IN new_dept VARCHAR(50))
BEGIN
    UPDATE Employees
    SET EmployeeName = new_name, Department = new_dept
    WHERE EmployeeID = e_id;
END //

CREATE FUNCTION CalculateAnnualSalary (e_id INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE annual_salary DECIMAL(10,2);
    SELECT MonthlySalary * 12 INTO annual_salary FROM Employees WHERE EmployeeID = e_id;
    RETURN annual_salary;
END //

-- Package 3: Account Operations
CREATE PROCEDURE OpenAccount (IN acc_id INT, IN cust_id INT, IN acc_type VARCHAR(50), IN acc_balance DECIMAL(10,2))
BEGIN
    INSERT INTO Accounts VALUES (acc_id, cust_id, acc_type, acc_balance);
END //

CREATE PROCEDURE CloseAccount (IN acc_id INT)
BEGIN
    DELETE FROM Accounts WHERE AccountID = acc_id;
END //

CREATE FUNCTION GetTotalCustomerBalance (cust_id INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE total_balance DECIMAL(10,2);
    SELECT IFNULL(SUM(Balance), 0) INTO total_balance FROM Accounts WHERE CustomerID = cust_id;
    RETURN total_balance;
END //

DELIMITER ;

-- Example Test Cases
-- CALL AddCustomer(1, 'Alice', 'alice@example.com', 5000.00);
-- CALL UpdateCustomerDetails(1, 'Alice New', 'alice_new@example.com');
-- SELECT GetCustomerBalance(1);

-- CALL HireEmployee(1, 'John', 'IT', 40000);
-- CALL UpdateEmployeeDetails(1, 'John Smith', 'HR');
-- SELECT CalculateAnnualSalary(1);

-- CALL OpenAccount(1, 1, 'Savings', 5000.00);
-- CALL CloseAccount(1);
-- SELECT GetTotalCustomerBalance(1);
