with mb as (
    select BOARD_ID
    from USED_GOODS_BOARD
    order by views DESC
    limit 1
)

SELECT concat('/home/grep/src/',concat(f.BOARD_ID, concat('/',concat(f.FILE_ID ,concat(f.FILE_NAME),f.FILE_EXT)))) as FILE_PATH
from USED_GOODS_FILE f
join mb b
on f.BOARD_ID = b.BOARD_ID
order by f.FILE_ID DESC;
