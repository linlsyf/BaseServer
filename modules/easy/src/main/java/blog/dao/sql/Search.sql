SELECT * , (select  count(1)  from blog  where status is null or  status=0) as pagecount   FROM blog
        WHERE 1=1

   <#if name??>
      and  name=${name}
        </#if>

<#if type??>
      and  type=${type}
        </#if>

        <#if status??>
      and  status=${status}
        </#if>
          <#if typecode??>
      and  typecode=${typecode}
        </#if>
          <#if search??>
      and  (title like '%${search}%'
         or content like '%${search}%'
      )
        </#if>
   order  by sn desc,createtime asc

      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

