

INSERT INTO EXAM_SELF
(
<#if name??> name, </#if>
<#if type??> type, </#if>
<#if result_a??> result_a, </#if>
<#if result_b??> result_b, </#if>
<#if result_c??> result_c, </#if>
<#if result_d??> result_d, </#if>
<#if result_right??> result_right, </#if>
<#if content??> content, </#if>
<#if hint??> hint, </#if>
<#if createtime??> createtime, </#if>
<#if creator??> creator, </#if>
<#if createid??> createid, </#if>
<#if type??> type, </#if>
<#if typename??> typename, </#if>

<#if id??> ID </#if>
   ) VALUES (
<#if name??>  ${name},</#if>
<#if type??> ${type},</#if>
<#if result_a??> ${result_a},</#if>
<#if result_b??> ${result_b},</#if>
<#if result_c??> ${result_c},</#if>
<#if result_d??> ${result_d},</#if>
<#if result_right??> ${result_right},</#if>


<#if content??> ${content},</#if>
<#if hint??> ${hint},</#if>
<#if createtime??> ${createtime},</#if>
<#if creator??> ${creator},</#if>
<#if createid??> ${createid},</#if>
<#if type??> ${type},</#if>
<#if typename??> ${typename},</#if>

<#if id??> ${id}</#if>
)