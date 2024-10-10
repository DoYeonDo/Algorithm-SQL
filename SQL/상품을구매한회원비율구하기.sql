SELECT DATE_FORMAT(sales_date, '%Y') AS year, DATE_FORMAT(sales_date, '%m') AS month, COUNT(DISTINCT info.user_id) AS purchased_users, ROUND(COUNT(DISTINCT info.user_id) / (SELECT COUNT(*) FROM user_info WHERE joined LIKE '2021%'), 1) AS puchased_ratio
FROM user_info AS info JOIN online_sale AS sale
ON info.user_id = sale.user_id
WHERE joined LIKE '2021%'
GROUP BY year, month
ORDER BY year, month