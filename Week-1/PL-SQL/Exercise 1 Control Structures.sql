-- Prerequisites
ALTER TABLE Customers ADD IsVIP CHAR(1) DEFAULT 'N';

-- Scenario 1: Discount to loan interest rates for customers above 60 years old.
DECLARE
    v_age NUMBER;
BEGIN
    FOR rec IN (SELECT c.CustomerID, c.DOB, l.LoanID FROM Customers c JOIN Loans l ON c.CustomerID = l.CustomerID) LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
        IF v_age > 60 THEN
            UPDATE Loans SET InterestRate = InterestRate - 1 WHERE LoanID = rec.LoanID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Promote to VIP status based on balance over $10,000.
BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers SET IsVIP = 'Y' WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Reminders for loans due within the next 30 days.
BEGIN
    FOR rec IN (SELECT c.Name, l.EndDate FROM Loans l JOIN Customers c ON l.CustomerID = c.CustomerID WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name || ' has a loan due on ' || rec.EndDate);
    END LOOP;
END;
/
