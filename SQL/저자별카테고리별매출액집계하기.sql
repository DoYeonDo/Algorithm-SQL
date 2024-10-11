SELECT book.author_id, author.author_name, book.category, SUM(sales*price) AS total_sales
FROM author JOIN book
ON book.author_id = author.author_id 
JOIN book_sales
ON book.book_id = book_sales.book_id
WHERE sales_date LIKE '2022-01%'
GROUP BY author.author_id, book.category
ORDER BY author.author_id, category DESC