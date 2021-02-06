SELECT * FROM EXAM_USER
        WHERE 1=1

   <#if examid??>
      and  examid=${examid}
        </#if>

<#if userid??>
      and  userid=${userid}
        </#if>
              order  by createtime  desc


      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

