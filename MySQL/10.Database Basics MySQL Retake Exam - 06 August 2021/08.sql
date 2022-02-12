SELECT 
    (SELECT 
            g.`name`
        FROM
            games AS g
        WHERE
            g.`name` LIKE '%2') AS 'name',
    (SELECT 
            g.release_date
        FROM
            games AS g
        WHERE
            MONTH(g.release_date) % 2 = 0) AS 'release_date',
    CONCAT(SUBSTRING(g.`description`, 1, 10), '...') AS 'summary',
    (SELECT 
            g.release_date,
                CASE
                    WHEN MONTH(g.release_date) IN (1 , 2, 3) THEN 'Q1'
                    WHEN MONTH(g.release_date) IN (4 , 5, 6) THEN 'Q2'
                    WHEN MONTH(g.release_date) IN (7 , 8, 9) THEN 'Q3'
                    WHEN MONTH(g.release_date) IN (10 , 11, 12) THEN 'Q4'
                    ELSE g.release_date
                END
        FROM
            games AS g) AS 'quarter',
    t.`name` AS 'team_name'
FROM
    games AS g
        JOIN
    teams AS t ON g.team_id = t.id;