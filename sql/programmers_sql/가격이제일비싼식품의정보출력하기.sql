SELECT product_id, product_name, product_cd, category, price
FROM food_product
WHERE price = (
    SELECT MAX(price) as max_price
    FROM food_product
)