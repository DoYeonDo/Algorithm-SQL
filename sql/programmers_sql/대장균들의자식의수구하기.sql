SELECT id, IFNULL(tmp.child_count,0) AS child_count
FROM ecoli_data LEFT JOIN (
SELECT parent_id, COUNT(*) AS child_count
FROM ecoli_data
GROUP BY parent_id
) AS tmp
ON ecoli_data.id = tmp.parent_id
ORDER BY ecoli_data.id