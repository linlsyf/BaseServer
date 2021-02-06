select  createtime
, (select count(*) total  from amazon_view_log_account)  totalview


, (select count(*) total  from amazon_view_log_account  where   to_days(createtime) = to_days(now()) )  todaynum


 from amazon_view_log_account order by  createtime  asc  limit 1