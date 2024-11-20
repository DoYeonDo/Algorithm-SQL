SELECT seat.id, IFNULL(tmp.student, seat.student) AS student
FROM seat LEFT JOIN (
    SELECT 
    (CASE
        WHEN id%2=0 THEN id-1
        ELSE id+1
    END) AS id, student
    FROM seat
) AS tmp
ON seat.id = tmp.id