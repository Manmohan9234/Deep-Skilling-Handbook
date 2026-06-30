USE bank;

CREATE TABLE savings_accounts (
    account_id INT PRIMARY KEY,
    customer_name VARCHAR(50),
    balance DECIMAL(10,2)
);

INSERT INTO savings_accounts VALUES
(101, 'MOHAN', 10000),
(102, 'KUNAL', 20000),
(103, 'RAJU', 15000);

SELECT * FROM savings_accounts;

DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE savings_accounts
    SET balance = balance + (balance * 0.01);
END //

DELIMITER ;

SHOW PROCEDURE STATUS
WHERE Db = 'bank';

SET SQL_SAFE_UPDATES = 0;
CALL ProcessMonthlyInterest();

SHOW CREATE PROCEDURE ProcessMonthlyInterest;


SELECT * FROM savings_accounts;

DROP PROCEDURE IF EXISTS ProcessMonthlyInterest;

DROP TABLE accounts;