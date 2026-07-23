-- Scenario 1: ProcessMonthlyInterest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts 
    SET Balance = Balance + (Balance * 0.01) 
    WHERE AccountType = 'Savings';
    COMMIT;
END;
/

-- Scenario 2: UpdateEmployeeBonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department VARCHAR2,
    p_bonus_percentage NUMBER
) AS
BEGIN
    UPDATE Employees 
    SET Salary = Salary + (Salary * p_bonus_percentage / 100) 
    WHERE Department = p_department;
    COMMIT;
END;
/

-- Scenario 3: TransferFunds
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from NUMBER, p_to NUMBER, p_amount NUMBER
) AS
BEGIN
    -- Assumes SafeTransferFunds from Exercise 2 exists
    SafeTransferFunds(p_from, p_to, p_amount);
END;
/
