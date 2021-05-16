select  createtime
, (select count(*) total  from amazon_view_log)  totalview


, (select count(*) total  from amazon_view_log  where   to_days(createtime) = to_days(now()) )  todaynum


 from amazon_view_log  order by  createtime  asc  limit 1