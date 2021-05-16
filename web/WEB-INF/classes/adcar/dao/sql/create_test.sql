INSERT INTO favour (id, name) VALUES ('Wilson', '中文')





INSERT INTO favour
(
<#if name??> name, </#if>
<#if content??> content, </#if>
<#if hint??> hint, </#if>
<#if createtime??> createtime, </#if>
<#if createorid??> createorid, </#if>
<#if createorname??> createorname, </#if>

<#if id??> ID </#if>
   ) VALUES (
<#if name??>  name,</#if>
<#if content??>{$(content)},</#if>
<#if hint??>{$(hint)},</#if>
<#if createtime??>{$(createtime)},</#if>
<#if createorid??>{$(createorid)},</#if>
<#if createorname??>{$(createorname)},</#if>

<#if id??>'w2w'</#if>
)