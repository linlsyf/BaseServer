INSERT INTO adcar
(
<#if name??> name, </#if>
<#if content??> content, </#if>
<#if hint??> hint, </#if>
<#if type??> type, </#if>
<#if createtime??> createtime, </#if>
<#if createorid??> createorid, </#if>
<#if createorname??> createorname, </#if>

<#if id??> ID </#if>
   ) VALUES (
<#if name??>  ${name},</#if>
<#if content??> ${content},</#if>
<#if hint??> ${hint},</#if>
<#if type??> ${type},</#if>
<#if createtime??> ${createtime},</#if>
<#if createorid??> ${createorid},</#if>
<#if createorname??> ${createorname},</#if>

<#if id??> ${id}</#if>
)