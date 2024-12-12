SELECT department.name AS Department, tmp.name AS employee, salary
FROM(
SELECT *,
DENSE_RANK() OVER(PARTITION BY departmentId ORDER BY salary DESC) AS rank_salary
FROM employee
) AS tmp JOIN department
ON tmp.departmentId = department.id
WHERE rank_salary <= 3