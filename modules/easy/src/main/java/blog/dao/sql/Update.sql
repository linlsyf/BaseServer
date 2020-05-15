
UPDATE blog SET

<#if title??> title=${title}, </#if>
<#if content??> content=${content}, </#if>
<#if status??> status=${status} </#if>

 WHERE id = ${id}


