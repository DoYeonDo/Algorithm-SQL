(SELECT name AS results
FROM users JOIN (
SELECT user_id, COUNT(movie_id) AS sum_rating
FROM movierating
GROUP BY user_id
) AS tmp
ON users.user_id = tmp.user_id
ORDER BY sum_rating DESC, name
LIMIT 1)
UNION ALL
(SELECT title AS results
FROM movies JOIN(
SELECT movie_id, AVG(rating) AS avg_rating
FROM movierating
WHERE created_at LIKE '2020-02%'
GROUP BY movie_id
) AS tmp1
ON movies.movie_id = tmp1.movie_id
ORDER BY avg_rating DESC, title
LIMIT 1)