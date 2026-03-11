with FE as (
    select sum(code) as CODE
    from SKILLCODES
    where CATEGORY = 'Front End'
    group by category
)

select d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from DEVELOPERS d
cross join FE f
on (d.SKILL_CODE & f.CODE) > 0
order by d.ID;
