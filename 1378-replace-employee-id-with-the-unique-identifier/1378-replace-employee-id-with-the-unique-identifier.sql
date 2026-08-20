# Write your MySQL query statement below
select eu.unique_id, e.name    # the col order is just diff but you can see basicaly a left part is null
from Employees e
left join EmployeeUNI eu
on e.id = eu.id;