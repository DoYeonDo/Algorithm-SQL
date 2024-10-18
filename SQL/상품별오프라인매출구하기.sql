SELECT product_code, SUM(price * sales_amount) AS sales
FROM product JOIN offline_sale AS sale
ON product.product_id = sale.product_id
GROUP BY sale.product_id
ORDER BY sales DESC, product_code