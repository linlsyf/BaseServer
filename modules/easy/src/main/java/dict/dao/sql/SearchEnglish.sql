SELECT * FROM enwords  WHERE 1=1
   <#if search??>
      and  name=${name}
       word  like      ${search}     '%good%'
        </#if>

<#if type??>
      and  type=${type}
        </#if>


      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

