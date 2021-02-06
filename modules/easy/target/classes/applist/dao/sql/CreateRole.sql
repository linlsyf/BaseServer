



INSERT INTO role
(
<#if name??> name, </#if>
<#if code??> code, </#if>
<#if type??> type, </#if>
<#if createtime??> createtime, </#if>
<#if createorid??> createorid, </#if>
<#if createorname??> createorname, </#if>

<#if id??> ID </#if>
   ) VALUES (
<#if name??>  ${name},</#if>
<#if code??>  ${code},</#if>
<#if type??> ${type},</#if>
<#if createtime??> ${createtime},</#if>
<#if createorid??> ${createorid},</#if>
<#if createorname??> ${createorname},</#if>

<#if id??> ${id}</#if>
)