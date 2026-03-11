select c.CAR_ID, c.CAR_TYPE, round((c.DAILY_FEE * ((100-p.discount_rate)/100.0) * 30) ,0) as FEE
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p 
on c.car_type = p.car_type and p.duration_type = '30일 이상'
where c.car_type in ('SUV', '세단')
and not EXISTS (
    select *
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    where h.CAR_ID = c.CAR_ID and h.START_DATE <= '2022-11-30' and h.END_DATE >= '2022-11-01'
)
and round((c.DAILY_FEE * ((100-p.discount_rate)/100.0) * 30) ,0) >= 500000
and round((c.DAILY_FEE * ((100-p.discount_rate)/100.0) * 30) ,0) <= 2000000
order by FEE DESC, c.car_type ASC, c.CAR_ID desc
