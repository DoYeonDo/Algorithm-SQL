SELECT YEAR(sales_date) AS year, MONTH(sales_date) AS month, gender, COUNT(DISTINCT info.user_id) AS users
FROM user_info AS info JOIN online_sale AS sale
ON info.user_id = sale.user_id
WHERE gender IS NOT NULL
GROUP BY year, month, gender
ORDER BY year, month, gender