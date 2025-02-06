SELECT half.flavor FROM 
first_half AS half INNER JOIN july
ON half.flavor = july.flavor
GROUP BY july.flavor
ORDER BY SUM(half.total_order) + SUM(july.total_order) DESC LIMIT 3