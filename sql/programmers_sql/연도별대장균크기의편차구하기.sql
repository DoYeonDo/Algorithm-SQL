SELECT YEAR(ecoli_data.differentiation_date) AS year, (tmp.size - ecoli_data.size_of_colony) AS year_dev, id
FROM ecoli_data LEFT JOIN (
    SELECT YEAR(differentiation_date) as year, MAX(size_of_colony) as size 
    FROM ecoli_data
    GROUP BY YEAR(differentiation_date)
) AS tmp
ON YEAR(ecoli_data.differentiation_date) = tmp.year
ORDER BY year, year_dev