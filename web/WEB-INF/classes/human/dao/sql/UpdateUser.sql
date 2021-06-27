
UPDATE user SET

<#if name??> name=${name}, </#if>
<#if sex??> sex=${sex}, </#if>
<#if status??> status=${status}, </#if>
<#if address??> address=${address}, </#if>
<#if birthday??> birthday=${birthday}, </#if>
<#if headImageName??> headImageName=${headImageName}, </#if>
   updatetime=${updatetime}

 WHERE id = ${id}


