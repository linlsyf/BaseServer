



INSERT INTO user
(

<#if createtime??> createtime, </#if>
<#if createorid??> createorid, </#if>
<#if createorname??> createorname, </#if>
<#if registerId??> registerId, </#if>

<#if id??> ID </#if>
   ) VALUES (

<#if createtime??> ${createtime},</#if>
<#if createorid??> ${createorid},</#if>
<#if createorname??> ${createorname},</#if>
<#if registerId??> ${registerId},</#if>

<#if id??> ${id}</#if>
)