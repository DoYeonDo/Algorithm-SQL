SELECT emp.emp_no, emp.emp_name, 
CASE
    WHEN AVG(SCORE) >= 96 THEN 'S'
    WHEN AVG(SCORE) >= 90 THEN 'A'
    WHEN AVG(SCORE) >= 80 THEN 'B'
    ELSE 'C'
END AS grade,
CASE
    WHEN AVG(SCORE) >= 96 THEN sal * 0.2
    WHEN AVG(SCORE) >= 90 THEN sal * 0.15
    WHEN AVG(SCORE) >= 80 THEN sal * 0.1
    ELSE 0
END AS bonus
FROM hr_department AS dep JOIN hr_employees AS emp
ON dep.dept_id = emp.dept_id
INNER JOIN hr_grade AS gr
ON emp.emp_no = gr.emp_no
GROUP BY emp_no
ORDER BY emp_no