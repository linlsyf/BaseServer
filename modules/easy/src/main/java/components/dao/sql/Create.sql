

INSERT INTO sys_components
(
<#if name??> name, </#if>
<#if title??> title, </#if>
<#if result_right??> result_right, </#if>
<#if content??> content, </#if>
<#if hint??> hint, </#if>
<#if createtime??> createtime, </#if>
<#if creator??> creator, </#if>
<#if createid??> createid, </#if>
<#if type??> type, </#if>
<#if typename??> typename, </#if>
<#if typecode??> typecode, </#if>
<#if historyyear??> historyyear, </#if>
<#if headImageUrl??> headImageUrl, </#if>
<#if data_type??> data_type, </#if>

<#if id??> ID </#if>
   ) VALUES (
<#if name??>  ${name},</#if>
<#if title??>  ${title},</#if>

<#if result_right??> ${result_right},</#if>


<#if content??> ${content},</#if>
<#if hint??> ${hint},</#if>
<#if createtime??> ${createtime},</#if>
<#if creator??> ${creator},</#if>
<#if createid??> ${createid},</#if>
<#if type??> ${type},</#if>
<#if typename??> ${typename},</#if>
<#if typecode??> ${typecode},</#if>
<#if historyyear??> ${historyyear},</#if>
<#if headImageUrl??> ${headImageUrl},</#if>
<#if data_type??> ${data_type},</#if>

<#if id??> ${id}</#if>
)