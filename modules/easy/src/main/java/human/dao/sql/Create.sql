



INSERT INTO user_auths
(
<#if userid??> userid, </#if>
<#if loginId??> loginId, </#if>
<#if pwd??> pwd, </#if>
<#if type??> type, </#if>
<#if createtime??> createtime, </#if>
<#if createorid??> createorid, </#if>
<#if createorname??> createorname, </#if>
<#if headImageName??> headImageName, </#if>

<#if id??> ID </#if>
   ) VALUES (
<#if userid??>  ${userid},</#if>
<#if loginId??>  ${loginId},</#if>
<#if pwd??> ${pwd},</#if>
<#if type??> ${type},</#if>
<#if createtime??> ${createtime},</#if>
<#if createorid??> ${createorid},</#if>
<#if createorname??> ${createorname},</#if>
<#if headImageName??> ${headImageName},</#if>

<#if id??> ${id}</#if>
)