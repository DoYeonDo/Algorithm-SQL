SELECT category, SUM(sales) AS total_sales
FROM book JOIN book_sales AS sales
ON book.book_id = sales.book_id
WHERE sales_date LIKE '2022-01%'
GROUP BY category
ORDER BY category