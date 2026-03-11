select i.ITEM_ID, i.ITEM_NAME, i.RARITY
from ITEM_INFO i
where i.ITEM_ID not in (
    select distinct parent_item_id
    from item_tree
    where parent_item_id is not null
)
order by ITEM_ID DESC;
