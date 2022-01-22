SELECT * FROM `departments`
ORDER BY `department_id`;

SELECT `name`
FROM `departments`
ORDER BY `department_id`;

SELECT `first_name`, `last_name`, `salary`
FROM `employees`
ORDER BY `employee_id`;

SELECT `first_name`, `middle_name`, `last_name`
FROM `employees`
ORDER BY `employee_id`;

SELECT CONCAT(`first_name`, '.', `last_name`, '@softuni.bg')
AS 'full_ email_address'
FROM `employees`;

SELECT DISTINCT `salary`
FROM `employees`
ORDER BY `employee_id`;

SELECT * FROM `employees`
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id`;

SELECT `first_name`, `last_name`, `job_title`
FROM `employees`
WHERE `salary` >= 20000.00 AND `salary` <= 30000.00
ORDER BY `employee_id`;

SELECT CONCAT_WS(' ', `first_name`, `middle_name`, `last_name`) AS 'Full Name'
FROM `employees`
WHERE `salary` IN (25000.0 , 14000.0, 12500.0, 23600.0);

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `manager_id` IS NULL;

SELECT `first_name`, `last_name`, `salary`
FROM `employees`
WHERE `salary` > 50000.00
ORDER BY `salary` DESC;

SELECT `first_name`, `last_name`
FROM `employees`
ORDER BY `salary` DESC
LIMIT 5;

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `department_id` != 4;

SELECT *
FROM `employees`
ORDER BY `salary` DESC , `first_name` , `last_name` DESC , `middle_name` , `employee_id`;

CREATE VIEW `v_employees_salaries` AS
SELECT `first_name`, `last_name`, `salary`
FROM `employees`;

CREATE VIEW `v_employees_job_titles` AS
SELECT CONCAT_WS(' ',employee.first_name,
IF(employee.middle_name IS NULL,'',employee.middle_name),employee.last_name) AS 'Full Name', employee.job_title
FROM `employees` AS employee;

SELECT DISTINCT `job_title`
FROM `employees`
ORDER BY `job_title`;

SELECT *
FROM `projects`
ORDER BY `start_date` , `name` , `project_id`
LIMIT 10;

SELECT `first_name`, `last_name`, `hire_date`
FROM `employees`
ORDER BY `hire_date` DESC
LIMIT 7;

UPDATE `employees` 
SET `salary` = `salary` * 1.12
WHERE `department_id` IN (1 , 2, 4, 11);
SELECT `salary`
FROM `employees`;

SELECT peak.peak_name
FROM `peaks` AS peak
ORDER BY peak.peak_name;

SELECT country.country_name, country.population
FROM `countries` AS country
WHERE country.continent_code = 'EU'
ORDER BY country.population DESC , country.country_name
LIMIT 30;

SELECT country.country_name,country.country_code,
IF(country.currency_code = 'EUR','Euro','Not Euro') AS 'currency'
FROM`countries` AS country
ORDER BY country.country_name;

SELECT `name`
FROM`characters`
ORDER BY `name`;