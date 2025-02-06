SELECT product_name, unit
FROM products JOIN (
    SELECT product_id, SUM(unit) AS unit
    FROM orders
    WHERE order_date LIKE '2020-02%'
    GROUP BY product_id
) AS tmp
ON products.product_id = tmp.product_id
WHERE unit >= 100