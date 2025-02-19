SELECT *
FROM
(
    SELECT tmp.car_id, tmp.car_type, FLOOR((daily_fee*(1-discount_rate/100))*30) AS fee
    FROM car_rental_company_discount_plan AS plan RIGHT JOIN (
        SELECT *
        FROM car_rental_company_car
        WHERE car_id NOT IN
        (
            SELECT car_id
            FROM car_rental_company_rental_history
            WHERE start_date <= '2022-11-30' AND end_date >= '2022-11-01'
            GROUP BY car_id
            ORDER BY car_id
        ) AND car_type IN('세단', 'SUV')
    ) AS tmp
    ON plan.car_type = tmp.car_type
    WHERE SUBSTRING(duration_type,1,1) = 3
    ORDER BY fee DESC, car_type, car_id DESC
) AS tmp2
WHERE fee>=500000 AND fee<2000000