SELECT SUBSTRING(product_code, 1, 2) AS category, COUNT(*) AS products
FROM product
GROUP BY SUBSTRING(product_code, 1, 2)
ORDER BY category