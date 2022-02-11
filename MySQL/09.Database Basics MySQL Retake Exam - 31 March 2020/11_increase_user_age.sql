DELIMITER $$
CREATE PROCEDURE `udp_modify_user`(address VARCHAR(30), town VARCHAR(30))
BEGIN
	IF((SELECT a.address
		FROM addresses AS a
		WHERE address = a.address) IS NOT NULL)
	THEN UPDATE users AS u
		JOIN addresses AS ad ON u.id = ad.user_id
	SET u.age = u.age + 10
    WHERE ad.address = address AND ad.town = town;
    END IF;
END $$
DELIMITER ;