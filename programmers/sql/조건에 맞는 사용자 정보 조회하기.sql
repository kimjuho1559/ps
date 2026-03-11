with cu as (
    SELECT u.USER_ID as UI
    from USED_GOODS_BOARD b
    join USED_GOODS_USER u
    on b.WRITER_ID = u.USER_ID
    group by u.USER_ID
    having count(b.WRITER_ID) >= 3
)

select u.USER_ID, u.NICKNAME, concat(u.CITY , ' ', u.STREET_ADDRESS1, ' ', u.STREET_ADDRESS2) as 전체주소, 
concat(SUBSTR(u.TLNO , 1, 3), '-'
       , SUBSTR(u.TLNO , 4, 4), '-'
       , SUBSTR(u.TLNO , 8, 4)) as 전화번호
from USED_GOODS_USER u
join cu c
on c.UI = u.USER_ID
order by c.UI DESC;
