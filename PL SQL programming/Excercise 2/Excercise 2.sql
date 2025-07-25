-- Step 1: Create Database
CREATE DATABASE IF NOT EXISTS BankSystem;
USE BankSystem;

-- Step 2: Create Accounts Table
CREATE TABLE IF NOT EXISTS Accounts (
    AccountId INT PRIMARY KEY,
    AccountHolder VARCHAR(100),
    Balance DECIMAL(10, 2)
);

-- Step 3: Create Employees Table
CREATE TABLE IF NOT EXISTS Employees (
    EmployeeID INT PRIMARY KEY,
    EmployeeName VARCHAR(100),
    Salary DECIMAL(10, 2)
);

-- Step 4: Create Customers Table
CREATE TABLE IF NOT EXISTS Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100)
);

-- Step 5: Create ErrorLog Table
CREATE TABLE IF NOT EXISTS ErrorLog (
    ErrorID INT AUTO_INCREMENT PRIMARY KEY,
    ErrorMessage VARCHAR(255),
    ErrorDate DATETIME
);

-- Step 6: Insert Sample Data
INSERT INTO Accounts VALUES
(1, 'Alice', 5000.00),
(2, 'Bob', 3000.00);

INSERT INTO Employees VALUES
(1, 'John Doe', 40000.00),
(2, 'Jane Smith', 50000.00);

INSERT INTO Customers VALUES
(1, 'Tom', 'tom@example.com');

-- Step 7: Stored Procedure for SafeTransferFunds
DELIMITER //

CREATE PROCEDURE SafeTransferFunds (
    IN fromAccountId INT,
    IN toAccountId INT,
    IN transferAmount DECIMAL(10,2)
)
BEGIN
    DECLARE insufficientFunds CONDITION FOR SQLSTATE '45000';
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (CONCAT('Error during fund transfer from account ', fromAccountId, ' to account ', toAccountId), NOW());
    END;

    START TRANSACTION;

    IF (SELECT Balance FROM Accounts WHERE AccountId = fromAccountId) < transferAmount THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient funds in the source account';
    END IF;

    UPDATE Accounts
    SET Balance = Balance - transferAmount
    WHERE AccountId = fromAccountId;

    UPDATE Accounts
    SET Balance = Balance + transferAmount
    WHERE AccountId = toAccountId;

    COMMIT;
END //

DELIMITER ;

-- Step 8: Stored Procedure for UpdateSalary
DELIMITER //

CREATE PROCEDURE UpdateSalary (
    IN empId INT,
    IN percentageIncrease DECIMAL(5,2)
)
BEGIN
    DECLARE CONTINUE HANDLER FOR NOT FOUND
    BEGIN
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (CONCAT('Error: Employee ID ', empId, ' not found.'), NOW());
    END;

    UPDATE Employees
    SET Salary = Salary + (Salary * percentageIncrease / 100)
    WHERE EmployeeID = empId;

    IF ROW_COUNT() = 0 THEN
        SIGNAL SQLSTATE '02000';
    END IF;
END //

DELIMITER ;

-- Step 9: Stored Procedure for AddNewCustomer
DELIMITER //

CREATE PROCEDURE AddNewCustomer (
    IN custId INT,
    IN custName VARCHAR(100),
    IN custEmail VARCHAR(100)
)
BEGIN
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (CONCAT('Error: Customer ID ', custId, ' already exists.'), NOW());
        ROLLBACK;
    END;

    START TRANSACTION;

    INSERT INTO Customers (CustomerID, Name, Email)
    VALUES (custId, custName, custEmail);

    COMMIT;
END //

DELIMITER ;
