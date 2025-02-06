SELECT id
FROM(
    SELECT id,
    IF(temperature>LAG(temperature, 1) OVER(ORDER BY recordDate),1,0) AS flag1,
    IF(DATEDIFF(recordDate, LAG(recordDate,1) OVER(ORDER BY recordDate))=1,1,0) AS flag2 
    FROM weather
) AS tmp
WHERE flag1=1 AND flag2=1