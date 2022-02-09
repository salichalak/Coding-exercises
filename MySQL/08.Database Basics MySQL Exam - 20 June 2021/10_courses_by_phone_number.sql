CREATE FUNCTION `udf_courses_by_client`(phone_num VARCHAR (20)) RETURNS int
    DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(cr.id)
FROM courses as cr
JOIN clients as cl
ON cr.client_id = cl.id
WHERE cl.`phone_number` = phone_num
);
END