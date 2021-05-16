SELECT * FROM enwords
        WHERE 1=1

   <#if search??>
      and


       word  like      ${search}
        </#if>

<#if type??>
      and  type=${type}
        </#if>


      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

