select *  from amazon_view_log  where
     <#if starttime??&& endtime??>

           str_to_date(createTime,'%Y-%m-%d') >=str_to_date(${starttime},'%Y-%m-%d') AND        str_to_date(createTime,'%Y-%m-%d')   <=str_to_date(${endtime},'%Y-%m-%d')

        </#if>



      order  by createtime  desc


      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>
