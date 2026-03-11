SELECT b.CATEGORY, sum(s.ts) as TOTAL_SALES
from BOOK b
join (
    select BOOK_ID, SUM(SALES) AS ts
    from BOOK_SALES
    where SALES_DATE between '2022-01-01' and '2022-01-31'
    group by BOOK_ID 
) s
on b.BOOK_ID = s.BOOK_ID
group by b.CATEGORY
order by CATEGORY
