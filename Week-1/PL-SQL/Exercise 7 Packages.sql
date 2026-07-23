-- Scenario 1: CustomerManagement
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2);
    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
        COMMIT;
    END AddCustomer;

    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2) IS
    BEGIN
        UPDATE Customers SET Name = p_name, LastModified = SYSDATE WHERE CustomerID = p_id;
        COMMIT;
    END UpdateCustomer;

    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
        RETURN v_balance;
    END GetCustomerBalance;
END CustomerManagement;
/

-- Scenario 2: EmployeeManagement
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2, p_sal NUMBER, p_dept VARCHAR2);
    PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2, p_sal NUMBER);
    FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2, p_sal NUMBER, p_dept VARCHAR2) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (p_id, p_name, p_pos, p_sal, p_dept, SYSDATE);
        COMMIT;
    END HireEmployee;

    PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2, p_sal NUMBER) IS
    BEGIN
        UPDATE Employees SET Name = p_name, Salary = p_sal WHERE EmployeeID = p_id;
        COMMIT;
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
        RETURN v_salary * 12;
    END CalculateAnnualSalary;
END EmployeeManagement;
/

-- Scenario 3: AccountOperations
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_accId NUMBER, p_custId NUMBER, p_type VARCHAR2, p_bal NUMBER);
    PROCEDURE CloseAccount(p_accId NUMBER);
    FUNCTION GetTotalBalance(p_custId NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount(p_accId NUMBER, p_custId NUMBER, p_type VARCHAR2, p_bal NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (p_accId, p_custId, p_type, p_bal, SYSDATE);
        COMMIT;
    END OpenAccount;

    PROCEDURE CloseAccount(p_accId NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_accId;
        COMMIT;
    END CloseAccount;

    FUNCTION GetTotalBalance(p_custId NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_custId;
        RETURN NVL(v_total, 0);
    END GetTotalBalance;
END AccountOperations;
/
