-- A customer can be promoted to VIP status based on their balance --
CREATE DATABASE bank;
USE bank;

CREATE TABLE customers (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT NOT NULL,
    balance DECIMAL(10,2) DEFAULT 0,
    IsVIP BOOLEAN DEFAULT FALSE
);

INSERT INTO customers (id, name, age, balance) VALUES
(101, 'MOHAN', 23, 5000),
(102, 'KUNAL', 25, 12000),
(103, 'RAJU', 75, 25000),
(104, 'MEHTA', 61, 8000);

SELECT * FROM customers;

CREATE TABLE loans (
    loan_id INT PRIMARY KEY,
    customer_id INT,
    interest_rate DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

INSERT INTO loans (loan_id, customer_id, interest_rate) VALUES
(1, 101, 8.50),
(2, 102, 9.00),
(3, 103, 7.75),
(4, 104, 8.25);

SELECT * FROM loans;

USE bank;

UPDATE customers SET balance = 5000  WHERE id = 101;  -- MOHAN
UPDATE customers SET balance = 12000 WHERE id = 102;  -- KUNAL
UPDATE customers SET balance = 25000 WHERE id = 103;  -- RAJU
UPDATE customers SET balance = 8000  WHERE id = 104;  -- MEHTA

DELIMITER //

CREATE PROCEDURE apply_vip_status()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_id INT;
    DECLARE v_balance DECIMAL(10,2);

    DECLARE cust_cursor CURSOR FOR
        SELECT id, balance FROM customers;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cust_cursor;

    read_loop: LOOP
        FETCH cust_cursor INTO v_id, v_balance;
        IF done = 1 THEN
            LEAVE read_loop;
        END IF;

        IF v_balance > 10000 THEN
            UPDATE customers
            SET IsVIP = TRUE
            WHERE id = v_id;
        END IF;

    END LOOP;

    CLOSE cust_cursor;
END //

DELIMITER ;

CALL apply_vip_status();

SELECT c.id, c.name, c.age, c.balance, c.IsVIP, l.interest_rate
FROM customers c                                -- INNER JOIN 
JOIN loans l ON c.id = l.customer_id;

CALL apply_vip_status();

SELECT id, name, balance, IsVIP FROM customers;


UPDATE customers
SET IsVIP = (balance > 10000);

