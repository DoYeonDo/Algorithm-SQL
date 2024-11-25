SELECT 
    CASE 
        WHEN (SELECT COUNT(DISTINCT salary) FROM employee) < 2 THEN NULL
        ELSE (
            SELECT DISTINCT salary
            FROM (
                SELECT salary, DENSE_RANK() OVER(ORDER BY salary DESC) AS rank_salary
                FROM employee
            ) AS ranked
            WHERE rank_salary = 2
        )
END AS SecondHighestSalary