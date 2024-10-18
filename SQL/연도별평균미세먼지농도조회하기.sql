SELECT YEAR(ym) AS year,ROUND(avg(pm_val1),2) AS pm10, ROUND(avg(pm_val2),2) AS `pm2.5`
FROM air_pollution
WHERE location2 = '수원'
GROUP BY year
ORDER BY year