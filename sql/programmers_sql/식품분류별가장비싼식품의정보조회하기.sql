SELECT category, price AS max_price, product_name
FROM food_product
WHERE (category, price) IN 
(
SELECT category, MAX(price) AS max_price
FROM food_product
GROUP BY category
HAVING category IN('과자', '국', '김치', '식용유')
ORDER BY max_price DESC
)
ORDER BY max_price DESC