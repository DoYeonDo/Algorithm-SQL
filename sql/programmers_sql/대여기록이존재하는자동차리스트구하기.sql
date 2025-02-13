SELECT DISTINCT(car.car_id)
FROM car_rental_company_rental_history AS history JOIN
(SELECT car_id
FROM car_rental_company_car
WHERE car_type = '세단') AS car
ON history.car_id = car.car_id
WHERE start_date LIKE '%-10-%'
ORDER BY car.car_id DESC