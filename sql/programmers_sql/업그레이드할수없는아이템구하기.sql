SELECT item_id, item_name, rarity
FROM item_info LEFT JOIN 
(
    SELECT parent_item_id
    FROM item_tree
    GROUP BY parent_item_id
) AS tmp
ON item_info.item_id = tmp.parent_item_id
WHERE parent_item_id IS NULL
ORDER BY item_id DESC