
UPDATE blog SET

<#if title??> title=${title}, </#if>
<#if content??> content=${content} </#if>

 WHERE id = ${id}


