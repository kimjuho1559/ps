select count(FISH_TYPE) as FISH_COUNT, max(length) as MAX_LENGTH, FISH_TYPE
from FISH_INFO
group by fish_type
having sum(COALESCE(length, 10))/count(FISH_TYPE) > 33
order by FISH_TYPE ASC;
