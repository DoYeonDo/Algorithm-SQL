SELECT p.product_id, ROUND(SUM(units*price)/SUM(units),2) AS average_price
FROM prices AS p RIGHT JOIN unitssold AS u
ON p.product_id = u.product_id AND (u.purchase_date BETWEEN p.start_date AND p.end_date)
GROUP BY u.product_id
UNION
SELECT p.product_id, 0 AS average_price
FROM prices AS p LEFT JOIN unitssold AS u
ON p.product_id = u.product_id
WHERE units IS NULL