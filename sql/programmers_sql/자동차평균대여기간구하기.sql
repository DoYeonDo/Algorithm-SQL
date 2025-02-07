SELECT car_id, ROUND(AVG(diff),1) AS average_duration
FROM(
SELECT car_id, DATEDIFF(end_date, start_date)+1 AS diff
FROM car_rental_company_rental_history
) AS tmp
GROUP BY car_id
HAVING ROUND(AVG(diff),1) >= 7
ORDER BY average_duration DESC, car_id DESC
