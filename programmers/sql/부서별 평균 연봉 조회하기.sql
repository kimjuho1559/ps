select d.DEPT_ID, d.DEPT_NAME_EN, round(avg(SAL), 0) as AVG_SAL
from HR_DEPARTMENT d
join HR_EMPLOYEES e
on d.dept_id = e.dept_id
group by d.dept_id
order by AVG_SAL desc;
