INSERT INTO `clients`(full_name, phone_number)
	(
    SELECT 
		CONCAT(first_name, ' ', last_name) AS 'full_name',
        CONCAT('(088) 9999', `drivers`.id * 2) AS 'phone_number'
    FROM `drivers`
    WHERE `drivers`.`id` BETWEEN 10 AND 20
    );