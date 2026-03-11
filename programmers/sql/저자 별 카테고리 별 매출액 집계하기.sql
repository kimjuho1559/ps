SELECT a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(s.TS * b.PRICE) as TOTAL_SALES
from AUTHOR a
join BOOK b
on a.AUTHOR_ID = b.AUTHOR_ID
join (
    select BOOK_ID, SUM(SALES) as TS
    from BOOK_SALES
    where SALES_DATE < '2022-02-01' and SALES_DATE > '2021-12-31'
    group by BOOK_ID
) s
on b.BOOK_ID = s.BOOK_ID
group by a.AUTHOR_NAME, b.CATEGORY
order by AUTHOR_ID ASC, CATEGORY DESC;
