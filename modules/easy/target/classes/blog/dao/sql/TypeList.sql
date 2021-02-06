



        SELECT  type,typename  FROM EXAM_SELF

          where  type is  not null
            and  typename  is not null

            group by   type,typename



              order  by createtime  desc


      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

