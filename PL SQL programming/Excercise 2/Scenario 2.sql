-- Step 1: Create Database
CREATE DATABASE IF NOT EXISTS BankSystem2;
USE BankSystem2;

-- Step 2: Create Employees Table
CREATE TABLE IF NOT EXISTS Employees (
    EmployeeID INT PRIMARY KEY,
    EmployeeName VARCHAR(100),
    Salary DECIMAL(10, 2)
);

-- Step 3: Create ErrorLog Table
CREATE TABLE IF NOT EXISTS ErrorLog (
    ErrorID INT AUTO_INCREMENT PRIMARY KEY,
    ErrorMessage VARCHAR(255),
    ErrorDate DATETIME
);

-- Step 4: Insert Sample Data into Employees Table
INSERT INTO Employees VALUES
(1, 'John Doe', 40000.00),
(2, 'Jane Smith', 50000.00);

-- Step 5: Create Stored Procedure to Update Salary
DELIMITER //

CREATE PROCEDURE UpdateSalary (
    IN empId INT,
    IN percentageIncrease DECIMAL(5,2)
)
BEGIN
    DECLARE CONTINUE HANDLER FOR NOT FOUND
    BEGIN
        -- Log error if employee not found
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (CONCAT('Error: Employee ID ', empId, ' not found.'), NOW());
    END;

    -- Attempt to update salary
    UPDATE Employees
    SET Salary = Salary + (Salary * percentageIncrease / 100)
    WHERE EmployeeID = empId;

    -- Check if row was affected
    IF ROW_COUNT() = 0 THEN
        -- Raise NOT FOUND handler
        SIGNAL SQLSTATE '02000';
    END IF;
END //

DELIMITER ;

-- Example Test Cases
-- Successful Update:
-- CALL UpdateSalary(1, 10);

-- Failed Update (Non-existing Employee):
-- CALL UpdateSalary(5, 10);

-- View Updated Employees:
-- SELECT * FROM Employees;

-- View Error Log:
-- SELECT * FROM ErrorLog;
