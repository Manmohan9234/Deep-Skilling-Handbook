DROP DATABASE IF EXISTS bank;
CREATE DATABASE bank;
USE bank;

CREATE TABLE customers (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT NOT NULL
);

INSERT INTO customers (id, name, age) VALUES
(101, 'MOHAN', 23),
(102, 'KUNAL', 25),
(103, 'RAJU', 75),
(104, 'MEHTA', 61);

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

-- Check data before discount
SELECT c.id, c.name, c.age, l.loan_id, l.customer_id, l.interest_rate
FROM customers c
JOIN loans l ON c.id = l.customer_id;

DELIMITER //

CREATE PROCEDURE apply_senior_discount()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_id INT;
    DECLARE v_age INT;

    DECLARE cust_cursor CURSOR FOR
        SELECT id, age FROM customers;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cust_cursor;

    read_loop: LOOP
        FETCH cust_cursor INTO v_id, v_age;
        IF done = 1 THEN
            LEAVE read_loop;
        END IF;

        IF v_age > 60 THEN
            UPDATE loans
            SET interest_rate = interest_rate - 1.00
            WHERE customer_id = v_id
              AND interest_rate > 1.00;
        END IF;

    END LOOP;

    CLOSE cust_cursor;
END //

DELIMITER ;

CALL apply_senior_discount();
  

SELECT c.id, c.name, c.age, l.loan_id, l.customer_id, l.interest_rate
FROM customers c
JOIN loans l ON c.id = l.customer_id;



SELECT c.id, c.name, c.age,
       CASE 
           WHEN c.age > 60 THEN l.interest_rate + 1.00 
           ELSE l.interest_rate 
       END AS original_rate,                 -- it show applied discount (original,current)
       l.interest_rate AS current_rate,
       CASE WHEN c.age > 60 THEN 1.00 ELSE 0 END AS discount_applied
FROM customers c
JOIN loans l ON c.id = l.customer_id;