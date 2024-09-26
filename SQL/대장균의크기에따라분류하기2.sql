SELECT origin.id, 
(
    CASE 
    WHEN tmp.rnk <= total_count/4 THEN 'CRITICAL'
    WHEN tmp.rnk <= total_count/4*2 THEN 'HIGH'
    WHEN tmp.rnk <= total_count/4*3 THEN 'MEDIUM'
    ELSE 'LOW'
    END
) AS colony_name
FROM ecoli_data as origin INNER JOIN 
(SELECT id, COUNT(*) OVER () AS total_count, ROW_NUMBER() OVER(ORDER BY size_of_colony DESC) AS rnk
FROM ecoli_data) 
AS tmp
ON origin.id = tmp.id
ORDER BY origin.id

