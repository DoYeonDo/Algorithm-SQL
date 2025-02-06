SELECT info.rest_id, rest_name, food_type, favorites, address, ROUND(SUM(review_score)/COUNT(*), 2) AS score
FROM rest_info AS info JOIN rest_review AS review
ON info.rest_id = review.rest_id
WHERE SUBSTR(address, 1, 2) = '서울'
GROUP BY address
ORDER BY score DESC, favorites DESC