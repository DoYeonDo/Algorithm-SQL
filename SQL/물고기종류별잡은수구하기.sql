SELECT COUNT(*) AS fish_count, fish_name
FROM fish_info AS info INNER JOIN fish_name_info AS name_info
ON info.fish_type = name_info.fish_type
GROUP BY name_info.fish_name
ORDER BY fish_count DESC