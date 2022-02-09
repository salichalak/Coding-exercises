SELECT COUNT(*)
FROM clients
WHERE CHAR_LENGTH(full_name) > 3 AND id = (
SELECT id
FROM courses
WHERE from_address_id = ''	
);