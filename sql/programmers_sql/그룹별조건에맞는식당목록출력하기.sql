-- 코드를 입력하세요
SELECT member_name, review_text, DATE_FORMAT(review_date, '%Y-%m-%d') AS review_date
FROM member_profile AS prof JOIN rest_review AS rev
ON prof.member_id = rev.member_id
WHERE prof.member_id =
(
    SELECT member_id
    FROM rest_review
    GROUP BY member_id
    HAVING SUM(review_score) = (
        SELECT SUM(review_score) AS sum_score
        FROM rest_review
        GROUP BY member_id
        ORDER BY sum_score DESC LIMIT 1
    )
)
ORDER BY review_date, review_text