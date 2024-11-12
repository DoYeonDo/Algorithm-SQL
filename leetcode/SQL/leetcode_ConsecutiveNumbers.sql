SELECT DISTINCT num AS ConsecutiveNums
FROM (
    SELECT num,
           LAG(num, 1) OVER () AS prev_number,
           LEAD(num, 1) OVER () AS next_number
    FROM Logs
) AS ConsecutiveNums
WHERE num = prev_number AND num = next_number