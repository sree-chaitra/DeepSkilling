-- Create New Database
CREATE DATABASE IF NOT EXISTS BankSystem4;
USE BankSystem4;

-- Create Employees Table
CREATE TABLE IF NOT EXISTS Employees (
    EmployeeID INT PRIMARY KEY,
    EmployeeName VARCHAR(100),
    Department VARCHAR(50),
    Salary DECIMAL(10, 2)
);

-- Insert Sample Data
INSERT INTO Employees VALUES
(1, 'John Doe', 'HR', 40000.00),
(2, 'Jane Smith', 'IT', 50000.00),
(3, 'Mark Lee', 'IT', 55000.00);

-- Stored Procedure to Update Employee Bonus
DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus (
    IN deptName VARCHAR(50),
    IN bonusPercent DECIMAL(5,2)
)
BEGIN
    -- Apply bonus to employees in given department
    UPDATE Employees
    SET Salary = Salary + (Salary * bonusPercent / 100)
    WHERE Department = deptName;
END //

DELIMITER ;

-- Example Test Case
-- CALL UpdateEmployeeBonus('IT', 10);

-- View Updated Employees
-- SELECT * FROM Employees;
