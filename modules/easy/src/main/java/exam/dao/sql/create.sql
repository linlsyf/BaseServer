



INSERT INTO EXAM_SELF
(
<#if name??> name, </#if>
<#if content??> content, </#if>
<#if hint??> hint, </#if>
<#if createtime??> createtime, </#if>
<#if createorid??> createorid, </#if>
<#if createorname??> createorname, </#if>
<#if type??> type, </#if>
<#if typename??> typename, </#if>

<#if id??> ID </#if>
   ) VALUES (
<#if name??>  ${name},</#if>
<#if content??> ${content},</#if>
<#if hint??> ${hint},</#if>
<#if createtime??> ${createtime},</#if>
<#if createorid??> ${createorid},</#if>
<#if createorname??> ${createorname},</#if>
<#if type??> ${type},</#if>
<#if typename??> ${typename},</#if>

<#if id??> ${id}</#if>
)