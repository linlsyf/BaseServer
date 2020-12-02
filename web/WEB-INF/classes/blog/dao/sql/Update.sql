
UPDATE blog SET

<#if title??> title=${title}, </#if>
<#if content??> content=${content}, </#if>
<#if status??> status=${status} </#if>
<#if typename??> typename=${typename} </#if>
<#if typecode??> typecode=${typecode} </#if>

 WHERE id = ${id}


