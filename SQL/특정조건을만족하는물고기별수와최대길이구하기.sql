SELECT COUNT(info.fish_type) AS fish_count, MAX(length) AS max_length, info.fish_type
FROM fish_info AS info JOIN (
    SELECT fish_type
    FROM fish_info
    GROUP BY fish_type
    HAVING AVG(IFNULL(length, 10)) >= 33
) AS tmp
ON info.fish_type = tmp.fish_type
GROUP BY info.fish_type
ORDER BY info.fish_type