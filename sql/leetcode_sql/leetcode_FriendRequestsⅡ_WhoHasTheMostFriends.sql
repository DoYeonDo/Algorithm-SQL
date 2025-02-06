SELECT id, COUNT(id) AS num
FROM
(
    (
        SELECT requester_id AS id
        FROM requestaccepted
    )
    UNION ALL
    (
        SELECT accepter_id AS id
        FROM requestAccepted
    )
) AS tmp
GROUP BY id
ORDER BY num DESC
LIMIT 1