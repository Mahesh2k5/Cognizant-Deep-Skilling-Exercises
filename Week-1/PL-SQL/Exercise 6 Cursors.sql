-- Scenario 1: GenerateMonthlyStatements
DECLARE
    CURSOR c_transactions IS 
        SELECT c.Name, t.TransactionDate, t.Amount, t.TransactionType 
        FROM Transactions t 
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE);
BEGIN
    FOR rec IN c_transactions LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ' | Date: ' || rec.TransactionDate || ' | ' || rec.TransactionType || ': $' || rec.Amount);
    END LOOP;
END;
/

-- Scenario 2: ApplyAnnualFee
DECLARE
    CURSOR c_accounts IS SELECT AccountID, Balance FROM Accounts;
BEGIN
    FOR rec IN c_accounts LOOP
        UPDATE Accounts SET Balance = Balance - 50 WHERE AccountID = rec.AccountID;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: UpdateLoanInterestRates
DECLARE
    CURSOR c_loans IS SELECT LoanID FROM Loans;
BEGIN
    FOR rec IN c_loans LOOP
        UPDATE Loans SET InterestRate = InterestRate + 0.5 WHERE LoanID = rec.LoanID;
    END LOOP;
    COMMIT;
END;
/
