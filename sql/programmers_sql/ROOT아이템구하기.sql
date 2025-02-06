SELECT info.item_id, item_name
FROM item_info AS info JOIN item_tree AS tree
ON info.item_id = tree.item_id
WHERE parent_item_id IS NULL
ORDER BY info.item_id