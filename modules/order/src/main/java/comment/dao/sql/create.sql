

INSERT INTO comment
(
<#if name??> name, </#if>

<#if phone??> phone, </#if>
<#if content??> content, </#if>
<#if email??> email, </#if>
<#if createtime??> createtime, </#if>
<#if creator??> creator, </#if>
<#if createid??> createid, </#if>
<#if title??> title, </#if>
<#if titlename??> titlename, </#if>
<#if imgId??> imgId, </#if>

<#if id??> ID </#if>
   ) VALUES (
<#if name??>  ${name},</#if>

<#if phone??> ${phone},</#if>


<#if content??> ${content},</#if>
<#if email??> ${email},</#if>
<#if createtime??> ${createtime},</#if>
<#if creator??> ${creator},</#if>
<#if createid??> ${createid},</#if>
<#if title??> ${title},</#if>
<#if titlename??> ${titlename},</#if>
<#if imgId??> ${imgId},</#if>

<#if id??> ${id}</#if>
)