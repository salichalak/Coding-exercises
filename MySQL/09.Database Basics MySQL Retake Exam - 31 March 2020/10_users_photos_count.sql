CREATE FUNCTION `udf_users_photos_count` (username VARCHAR(30))
RETURNS INT
DETERMINISTIC
RETURN (
SELECT COUNT(*)
FROM users AS u
JOIN users_photos AS up
ON u.id = up.user_id
WHERE u.username = username
);