SELECT id, email, first_name, last_name
FROM developers
WHERE skill_code & (
    SELECT BIT_OR(code) AS code
    FROM skillcodes
    GROUP BY category
    HAVING category = 'Front end'
) > 0
ORDER BY id