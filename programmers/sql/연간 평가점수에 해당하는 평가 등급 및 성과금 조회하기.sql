select e.EMP_NO, e.EMP_NAME, 
case
    when sum(SCORE) / 2 >= 96 then 'S'
    when sum(SCORE) / 2 >= 90 then 'A'
    when sum(SCORE) / 2 >= 80 then 'B'
    else 'C'
end as GRADE, 
case 
    when sum(SCORE) / 2 >= 96 then e.SAL * 0.2
    when sum(SCORE) / 2 >= 90 then e.SAL * 0.15
    when sum(SCORE) / 2 >= 80 then e.SAL * 0.1
    else 0
end as BONUS
from HR_EMPLOYEES e
join HR_GRADE g
on e.EMP_NO = g.EMP_NO
group by e.EMP_NO;
