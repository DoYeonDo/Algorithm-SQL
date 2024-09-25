# 3세대
SELECT a.id
FROM ecoli_data AS a JOIN (
    SELECT b.id
    FROM ecoli_data AS b JOIN (
        SELECT id 
        FROM ecoli_data
        WHERE parent_id IS NULL
    ) AS c
    ON b.parent_id = c.id
) AS tmp
ON a.parent_id = tmp.id
ORDER BY a.id