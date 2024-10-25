SELECT used.user_id, nickname, SUM(price) AS total_sales
FROM used_goods_board AS board JOIN used_goods_user AS used
ON board.writer_id = used.user_id
WHERE status = 'DONE'
GROUP BY board.writer_id
HAVING SUM(price) >= 700000
ORDER BY total_sales