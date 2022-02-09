DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
    SELECT e.first_name, e.last_name
    FROM `employees` AS e
    WHERE e.salary > 35000
    ORDER BY e.first_name, e.last_name, e.employee_id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(salary_limit DOUBLE(19,4))
BEGIN
    SELECT e.first_name, e.last_name
    FROM `employees` AS e
    WHERE e.salary >= salary_limit
    ORDER BY e.first_name, e.last_name, e.employee_id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(name_start TEXT)
BEGIN
    SELECT t.name AS 'town_name'
    FROM `towns` AS t
    WHERE t.name LIKE concat(name_start,'%')
    ORDER BY t.name;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name TEXT)
BEGIN
    SELECT e.first_name, e.last_name
    FROM `employees` AS e
    JOIN `addresses` AS a ON e.address_id = a.address_id
    JOIN  `towns` AS t ON a.town_id = t.town_id 
    WHERE t.name = town_name
    ORDER BY e.first_name, e.last_name, e.employee_id;
END $$
DELIMITER ;

CREATE FUNCTION ufn_get_salary_level(salary DOUBLE(19,4))
RETURNS VARCHAR(7)
RETURN (
    CASE 
        WHEN salary < 30000 THEN 'Low'
        WHEN salary <= 50000 THEN 'Average'
        ELSE 'High'
    END
);

DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(7))
BEGIN
    SELECT e.first_name, e.last_name
    FROM `employees` AS e
    WHERE e.salary < 30000 AND salary_level = 'low'
        OR e.salary >= 30000 AND e.salary <= 50000 AND salary_level = 'average'
        OR e.salary > 50000 AND salary_level = 'high'
    ORDER BY e.first_name DESC, e.last_name DESC;
END $$
DELIMITER ;

CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS BIT
RETURN word REGEXP (concat('^[', set_of_letters, ']+$'));

DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
    SELECT 
        CONCAT_WS(' ', h.first_name, h.last_name) AS 'full_name'
    FROM
        `account_holders` AS h
            JOIN
        (SELECT DISTINCT
            a.account_holder_id
        FROM
            `accounts` AS a) as a ON h.id = a.account_holder_id
    ORDER BY `full_name`;
END $$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(
    initial_sum DECIMAL(19, 4), interest_rate DECIMAL(19, 4), years INT)
RETURNS DECIMAL(19, 4)
BEGIN
    RETURN initial_sum * POW((1 + interest_rate), years);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(
    account_id INT, interest_rate DECIMAL(19, 4))
BEGIN
    SELECT 
         a.id AS 'account_id', h.first_name, h.last_name, a.balance AS 'current_balance',
         ufn_calculate_future_value(a.balance, interest_rate, 5) AS 'balance_in_5_years'
    FROM
        `account_holders` AS h
            JOIN
        `accounts` AS a ON h.id=a.account_holder_id
    WHERE a.id = account_id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(
    account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    IF money_amount > 0 THEN
        START TRANSACTION;
        
UPDATE `accounts` AS a 
SET 
    a.balance = a.balance + money_amount
WHERE
    a.id = account_id;
        
        IF (SELECT a.balance 
            FROM `accounts` AS a 
            WHERE a.id = account_id) < 0
            THEN ROLLBACK;
        ELSE
            COMMIT;
        END IF;
    END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(
    account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    IF money_amount > 0 THEN
        START TRANSACTION;
        
UPDATE `accounts` AS a 
SET 
    a.balance = a.balance - money_amount
WHERE
    a.id = account_id;
        
        IF (SELECT a.balance 
            FROM `accounts` AS a 
            WHERE a.id = account_id) < 0
            THEN ROLLBACK;
        ELSE
            COMMIT;
        END IF;
    END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE usp_transfer_money(
    from_account_id INT, to_account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    IF money_amount > 0 
        AND from_account_id <> to_account_id 
        AND (SELECT a.id 
            FROM `accounts` AS a 
            WHERE a.id = to_account_id) IS NOT NULL
        AND (SELECT a.id 
            FROM `accounts` AS a 
            WHERE a.id = from_account_id) IS NOT NULL
        AND (SELECT a.balance 
            FROM `accounts` AS a 
            WHERE a.id = from_account_id) >= money_amount
    THEN
        START TRANSACTION;
        
UPDATE `accounts` AS a 
SET 
    a.balance = a.balance + money_amount
WHERE
    a.id = to_account_id;
            
UPDATE `accounts` AS a 
SET 
    a.balance = a.balance - money_amount
WHERE
    a.id = from_account_id;
        
        IF (SELECT a.balance 
            FROM `accounts` AS a 
            WHERE a.id = from_account_id) < 0
            THEN ROLLBACK;
        ELSE
            COMMIT;
        END IF;
    END IF;
END $$
DELIMITER ;