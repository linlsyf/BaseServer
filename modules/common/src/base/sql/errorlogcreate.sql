

INSERT INTO error_log
(
<#if content??> content, </#if>
<#if createtime??> createtime, </#if>
<#if id??> ID </#if>
   ) VALUES (
<#if content??> ${content},</#if>
<#if createtime??> ${createtime},</#if>

<#if id??> ${id}</#if>
)