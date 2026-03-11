select id, fish_name, length
from (
    select fi.id, fni.fish_name, fi.length, ROW_NUMBER() over (
        partition by fni.fish_type
        order by coalesce(fi.length, 10) DESC
     ) as rn
    from FISH_INFO fi
    join FISH_NAME_INFO fni
    on fi.fish_type = fni.fish_type
) t
where t.rn = 1
order by t.id;
