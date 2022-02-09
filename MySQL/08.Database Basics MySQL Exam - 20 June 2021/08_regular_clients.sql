SELECT 
    full_name,
    COUNT(cr.id) AS `count_of_cars`,
    SUM(cr.bill) AS `total_sum`
FROM
    clients AS cl
        JOIN
    courses AS cr ON cl.id = cr.client_id
        JOIN
    cars AS c ON c.id = cr.car_id
GROUP BY cl.id
HAVING SUBSTRING(full_name, 2, 1) = 'a' AND `count_of_cars` > 1
ORDER BY full_name; 