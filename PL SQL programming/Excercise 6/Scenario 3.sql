-- Create New Database
CREATE DATABASE IF NOT EXISTS BankCursorsDB;
USE BankCursorsDB;

-- Create Loans Table
CREATE TABLE IF NOT EXISTS Loans (
    LoanID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    InterestRate DECIMAL(5,2)
);

-- Insert Sample Data
INSERT INTO Loans VALUES
(1, 'Alice', 7.5),
(2, 'Bob', 8.0);

-- PL/SQL Block to Update Loan Interest Rates using Cursor
DELIMITER //

CREATE PROCEDURE UpdateLoanInterestRates()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE loanID INT;
    DECLARE newInterestRate DECIMAL(5,2);
    DECLARE cur CURSOR FOR
        SELECT LoanID FROM Loans;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO loanID;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Apply new interest policy (example: increase by 0.5%)
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = loanID;
    END LOOP;

    CLOSE cur;
END //

DELIMITER ;

-- Example Test Case
-- CALL UpdateLoanInterestRates;
-- SELECT * FROM Loans;
