# Write your MySQL query statement below
select today.id from Weather today
join Weather yesterday     # use self join
on today.recordDate = DATE_ADD(yesterday.recordDate, INTERVAL 1 DAY)
where today.temperature > yesterday.temperature;