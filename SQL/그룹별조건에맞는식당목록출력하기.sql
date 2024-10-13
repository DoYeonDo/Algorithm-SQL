SELECT member_name, review_text, DATE_FORMAT(review_date, '%Y-%m-%d') AS review_date
FROM member_profile AS profile JOIN rest_review AS review
ON profile.member_id = review.member_id
WHERE profile.member_id = 
(
SELECT member_id
FROM rest_review
GROUP BY member_id
ORDER BY SUM(review_score) DESC
LIMIT 1
)
ORDER BY review_date, review_text
