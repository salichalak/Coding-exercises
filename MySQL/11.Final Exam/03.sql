UPDATE products AS p
SET `quantity_in_stock` = `quantity_in_stock` - 5
WHERE p.`quantity_in_stock` BETWEEN 60 AND 70;