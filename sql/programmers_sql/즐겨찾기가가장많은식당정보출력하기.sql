SELECT info.food_type, info.rest_id, rest_name, info.favorites
FROM rest_info AS info JOIN (
    SELECT food_type, MAX(favorites) AS favorites
    FROM rest_info
    GROUP BY food_type
) AS tmp
ON info.food_type = tmp.food_type AND info.favorites = tmp.favorites
ORDER BY food_type DESC