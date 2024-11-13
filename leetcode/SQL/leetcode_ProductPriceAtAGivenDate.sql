SELECT tmp1.product_id, IFNULL(new_price, 10) AS price
FROM products JOIN (
    SELECT product_id, MAX(change_date) AS change_date
    FROM products
    WHERE change_date <= '2019-08-16' 
    GROUP BY product_id
) AS tmp 
ON products.product_id = tmp.product_id AND products.change_date = tmp.change_date
RIGHT JOIN (
    SELECT product_id
    FROM products
    GROUP BY product_id 
) AS tmp1
ON tmp.product_id = tmp1.product_id
