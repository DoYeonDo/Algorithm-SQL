SELECT product.product_id, product_name, SUM(ord.amount) * product.price AS total_sales
FROM food_product AS product JOIN food_order AS ord
ON product.product_id = ord.product_id
WHERE DATE_FORMAT(produce_date, '%Y-%m') = '2022-05'
GROUP BY product.product_id
ORDER BY total_sales DESC, product.product_id