with rc as (
    select CAR_ID, COUNT(*) as count
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where START_DATE >= '2022-08-01' and start_date < '2022-11-01'
    group by CAR_ID
    having COUNT(*) >= 5
)

select month(start_date) as MONTH, h.CAR_ID, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
join rc c
on h.CAR_ID = c.CAR_ID
where START_DATE >= '2022-08-01' and start_date < '2022-11-01'
group by month(start_date), h.CAR_ID
order by month ASC, CAR_ID desc;
