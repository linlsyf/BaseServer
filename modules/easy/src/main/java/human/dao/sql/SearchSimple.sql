SELECT

id doc_id ,
name  doc_name
,PART_NUMBER
,LINE_NUMBER
FROM ShopOrder a
 WHERE 1=1
<#if search??>

 AND NAME like ${$like(search)}


 </#if>
<#if id??> AND ID like ${$like(id)}</#if>

<#if ids??> AND ID in (${$in(ids)})</#if>

<#if type??> AND TYPE like ${$like(type)}</#if>
<#if name??> AND NAME like ${$like(name)}</#if>
<#if partNumber??> AND PART_NUMBER like ${$like(partNumber)}</#if>
<#if lineNumber??> AND LINE_NUMBER like ${$like(lineNumber)}</#if>
<#if rules??> AND RULES like ${$like(rules)}</#if>
<#if price??> AND PRICE like ${$like(price)}</#if>
<#if status??> AND STATUS like ${$like(status)}</#if>
<#if createTime??> AND CREATE_TIME like ${$like(createTime)}</#if>
<#if creatorId??> AND CREATOR_ID like ${$like(creatorId)}</#if>
<#if creator??> AND CREATOR like ${$like(creator)}</#if>
<#if modifierId??> AND MODIFIER_ID like ${$like(modifierId)}</#if>
<#if modifiedTime??> AND MODIFIED_TIME like ${$like(modifiedTime)}</#if>
<#if modifier??> AND MODIFIER like ${$like(modifier)}</#if>
<#if code??> AND CODE like ${$like(code)}</#if>

ORDER BY CODE ASC