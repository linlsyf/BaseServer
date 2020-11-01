SELECT * FROM second_words
        WHERE 1=1

   <#if search??>
      and


       word  like      ${search}
        </#if>

<#if type??>
      and  type=${type}
        </#if>


<#if part??>
      and  part=${part}
        </#if>

<#if item??>
      and  item=${item}
        </#if>

      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

