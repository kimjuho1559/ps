select e3.ID
from ECOLI_DATA e1 
join ECOLI_DATA e2
on e1.ID = e2.PARENT_ID
join ECOLI_DATA e3
on e2.ID = e3.PARENT_ID
where e1.PARENT_ID is null
order by id;
