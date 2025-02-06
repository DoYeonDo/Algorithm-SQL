SELECT department.dept_id,  dept_name_en, ROUND(AVG(sal)) AS avg_sal
FROM hr_department AS department JOIN hr_employees AS employees
ON department.dept_id = employees.dept_id
GROUP BY department.dept_id
ORDER BY avg_sal DESC;