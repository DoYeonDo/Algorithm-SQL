WITH RECURSIVE generations AS (
    SELECT id, parent_id, 1 AS generation
    FROM ecoli_data 
    WHERE parent_id IS NULL
    
    UNION ALL
    
    SELECT e.id, e.parent_id, g.generation + 1
    FROM ecoli_data AS e
    INNER JOIN generations AS g 
    ON e.PARENT_ID = g.ID
)

SELECT COUNT(*) AS count, generation
FROM generations
WHERE id NOT IN (
    SELECT DISTINCT parent_id
    FROM generations
    WHERE parent_id IS NOT null)
GROUP BY generation
ORDER BY generation