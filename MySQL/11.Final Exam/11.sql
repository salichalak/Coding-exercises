DELIMITER $$
CREATE PROCEDURE `udp_reduce_price`(category_name VARCHAR(50))
BEGIN
	UPDATE products AS p
	JOIN categories AS ct ON p.category_id = ct.id
    JOIN reviews AS rw ON p.review_id = rw.id
	SET p.price = ROUND(0.7 * p.price, 2)
    WHERE ct.`name` = category_name AND rw.rating < 4;
END $$
DELIMITER ;