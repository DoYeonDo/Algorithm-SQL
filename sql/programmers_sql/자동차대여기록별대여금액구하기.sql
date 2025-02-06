SELECT history_id,
(
    CASE 
    WHEN (DATEDIFF(end_date, start_date)+1) >= 90 THEN FLOOR((1-(SELECT discount_rate
FROM car_rental_company_discount_plan
WHERE car_type = '트럭'
ORDER BY discount_rate
LIMIT 1 OFFSET 2) * 0.01) * daily_fee * (DATEDIFF(end_date, start_date)+1))
    WHEN (DATEDIFF(end_date, start_date)+1) >= 30 THEN FLOOR((1-(SELECT discount_rate
FROM car_rental_company_discount_plan
WHERE car_type = '트럭'
ORDER BY discount_rate
LIMIT 1 OFFSET 1) * 0.01) * daily_fee * (DATEDIFF(end_date, start_date)+1))
    WHEN (DATEDIFF(end_date, start_date)+1) >= 7 THEN FLOOR((1-(SELECT discount_rate
FROM car_rental_company_discount_plan
WHERE car_type = '트럭'
ORDER BY discount_rate
LIMIT 1) * 0.01) * daily_fee * (DATEDIFF(end_date, start_date)+1))
    ELSE daily_fee * (DATEDIFF(end_date, start_date)+1)
    END
) AS fee
FROM car_rental_company_car AS car JOIN car_rental_company_rental_history AS history
ON car.car_id = history.car_id
WHERE car.car_type = '트럭'
ORDER BY fee DESC, history_id DESC