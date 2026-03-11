with dh as (
    SELECT h.HISTORY_ID,c.DAILY_FEE, datediff(end_date, start_date) as date
    from CAR_RENTAL_COMPANY_CAR c
    join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    on c.CAR_ID = h.CAR_ID
    where c.car_type = '트럭'
), p1 as (
    select CAR_TYPE, DURATION_TYPE, DISCOUNT_RATE
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
    where DURATION_TYPE = '7일 이상' and car_type = '트럭'
), p2 as (
    select CAR_TYPE, DURATION_TYPE, DISCOUNT_RATE
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
    where DURATION_TYPE = '30일 이상' and car_type = '트럭'
), p3 as (
    select CAR_TYPE, DURATION_TYPE, DISCOUNT_RATE
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
    where DURATION_TYPE = '90일 이상' and car_type = '트럭'
)

select HISTORY_ID, 
case 
    when dh.date < 7 then DAILY_FEE * (dh.DATE+1)
    when dh.date < 30 then round((DAILY_FEE * (100 - p.DISCOUNT_RATE) / 100.0)) * (dh.DATE+1)
    when dh.date < 90 then round((DAILY_FEE * (100 - pp.DISCOUNT_RATE) / 100.0)) * (dh.DATE+1)
    else round((DAILY_FEE * (100 - ppp.DISCOUNT_RATE) / 100.0)) * (dh.DATE+1)
end AS FEE
from dh
join p1 p
join p2 pp
join p3 ppp
order by FEE DESC, HISTORY_ID DESC;
