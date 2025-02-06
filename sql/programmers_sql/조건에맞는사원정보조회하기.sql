SELECT SUM(score) AS score, employees.emp_no, emp_name, position, email
FROM hr_employees AS employees JOIN hr_grade AS grade
ON employees.emp_no = grade.emp_no
GROUP BY grade.emp_no
ORDER BY score DESC LIMIT 1