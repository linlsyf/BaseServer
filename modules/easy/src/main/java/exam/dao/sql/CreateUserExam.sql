

INSERT INTO EXAM_USER
(
<#if name??> name, </#if>

<#if createtime??> createtime, </#if>
<#if creator??> creator, </#if>
<#if createid??> createid, </#if>
<#if examid??> examid, </#if>
<#if userid??> userid</#if>

   ) VALUES (
<#if name??>  ${name},</#if>

<#if createtime??> ${createtime},</#if>
<#if creator??> ${creator},</#if>
<#if createid??> ${createid},</#if>
<#if examid??> ${examid},</#if>
<#if userid??> ${userid}</#if>

)