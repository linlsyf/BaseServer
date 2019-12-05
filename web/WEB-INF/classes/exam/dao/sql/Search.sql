SELECT * FROM EXAM_SELF
        WHERE 1=1

   <#if name??>
      and  name=${name}
        </#if>


              order  by createtime  desc


      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

