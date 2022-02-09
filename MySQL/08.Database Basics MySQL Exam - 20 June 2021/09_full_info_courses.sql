SELECT 
    a.name,
    (SELECT DISTINCT
     CASE
		WHEN DAY(courses.`start`) BETWEEN 6 AND 20 THEN 'Day'
		WHEN DAY(courses.`start`) < 6 AND (courses.`start`) > 20 THEN 'Night'
     END
FROM courses
JOIN cars
WHERE courses.car_id = cars.id) AS 'day_time',
    cr.bill,
    cl.full_name,
    c.make,
    c.model,
    ct.name AS 'category_name'
FROM
    addresses AS a
        JOIN
    courses AS cr ON a.id = cr.from_address_id
        JOIN
    clients AS cl ON cl.id = cr.client_id
        JOIN
    cars AS c ON c.id = cr.car_id
        JOIN
    categories AS ct ON ct.id = c.category_id;