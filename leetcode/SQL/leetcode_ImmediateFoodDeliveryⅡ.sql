SELECT ROUND(SUM(IF(tmp.order_date=delivery.customer_pref_delivery_date, 1, 0))/COUNT(*)*100,2) AS immediate_percentage
FROM delivery RIGHT JOIN (
SELECT customer_id, MIN(order_date) AS order_date
FROM delivery
GROUP BY customer_id
) AS tmp
ON delivery.customer_id = tmp.customer_id AND delivery.order_date = tmp.order_date