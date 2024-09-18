SELECT id, fish_name, info.length
FROM fish_info AS info JOIN fish_name_info AS name_info 
ON info.fish_type = name_info.fish_type
WHERE info.fish_type IN 
(
    SELECT fish_type
    FROM fish_info
    GROUP BY fish_type
    HAVING length = MAX(length)
)
ORDER BY id