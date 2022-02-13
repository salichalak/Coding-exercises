SELECT 
    COUNT(ct.id) AS items_count,
    ct.`name`,
    SUM(p.quantity_in_stock) AS total_quantity
FROM
    categories AS ct
        JOIN
    products AS p ON ct.id = p.category_id
GROUP BY ct.id
ORDER BY items_count DESC , total_quantity
LIMIT 5;