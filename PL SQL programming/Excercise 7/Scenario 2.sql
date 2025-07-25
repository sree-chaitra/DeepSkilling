-- Create New Database
CREATE DATABASE IF NOT EXISTS BankPackagesDB;
USE BankPackagesDB;

-- Create Employees Table
CREATE TABLE IF NOT EXISTS Employees (
    EmployeeID INT PRIMARY KEY,
    EmployeeName VARCHAR(100),
    Department VARCHAR(50),
    MonthlySalary DECIMAL(10,2)
);

-- Create EmployeeManagement Package
DELIMITER //

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

DELIMITER ;

-- Example Test Case
-- CALL HireEmployee(1, 'John', 'IT', 40000);
-- CALL UpdateEmployeeDetails(1, 'John Smith', 'HR');
-- SELECT CalculateAnnualSalary(1);
