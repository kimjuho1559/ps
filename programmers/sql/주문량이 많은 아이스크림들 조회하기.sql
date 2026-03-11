with rn as (
    SELECT h.FLAVOR, sum(h.TOTAL_ORDER + j.TOTAL_SUM) as ts
    from FIRST_HALF h
    left join (
        select FLAVOR, sum(TOTAL_ORDER) as TOTAL_SUM
        from JULY
        group by FLAVOR
    ) j
    on h.FLAVOR = j.FLAVOR
    group by h.FLAVOR
    order by ts DESC
)

select FLAVOR
from rn
limit 3;
