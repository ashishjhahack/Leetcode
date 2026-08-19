# Write your MySQL query statement below
select distinct author_id id     # distinct -> Used to remove duplicates
from Views
where author_id = viewer_id
order by id; # by default -> ascending 