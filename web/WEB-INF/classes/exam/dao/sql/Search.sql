SELECT * FROM EXAM_SELF
        WHERE 1=1

              order  by createtime  desc


      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

