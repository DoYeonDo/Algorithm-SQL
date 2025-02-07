SELECT CONCAT("/home/grep/src/", board.board_id, "/", file_id, file_name, file_ext) AS file_path
FROM used_goods_file AS board JOIN 
(
SELECT board_id
FROM used_goods_board AS board JOIN
    (
        SELECT MAX(views) AS views
        FROM used_goods_board
    ) AS tmp
ON board.views = tmp.views
) AS file
ON board.board_id = file.board_id
ORDER BY file_id DESC
    