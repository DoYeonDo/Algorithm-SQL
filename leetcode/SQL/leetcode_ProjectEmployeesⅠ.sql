SELECT project_id, ROUND(AVG(experience_years),2) AS average_years
FROM project AS p INNER JOIN employee AS e
ON p.employee_id = e.employee_id
GROUP BY project_id