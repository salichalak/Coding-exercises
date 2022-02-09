UPDATE 
	`cars`
SET 
	`condition` = 'C'
WHERE 
	`year` <= 2010 AND `make` NOT LIKE '%Mercedes-Benz%'
	AND (`mileage` >= 800000 OR `mileage` IS NULL);