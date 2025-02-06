WITH test as
(
    SELECT 'Low Salary' AS category
    UNION ALL
    SELECT 'Average Salary' AS category
    UNION ALL
    SELECT 'High Salary' AS category
)

SELECT test.category, IFNULL(accounts_count,0) AS accounts_count
FROM test LEFT join ( 
SELECT category,COUNT(category) AS accounts_count
FROM(
    SELECT
    (
        CASE
        WHEN income > 50000 THEN 'High Salary'
        WHEN income >= 20000 THEN 'Average Salary'
        ELSE 'Low Salary'
        END
    ) AS category
    FROM accounts
) AS tmp
GROUP BY category
) AS tmp1
ON test.category = tmp1.category
