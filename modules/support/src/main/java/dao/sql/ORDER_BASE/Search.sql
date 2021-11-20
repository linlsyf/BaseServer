SELECT a.* FROM ShopOrder a
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



--  排序
ORDER BY
<#if sortId?? && (sortId == 'asc' || sortId=='desc')>ID ${sortId},  </#if>
<#if sortType?? && (sortType == 'asc' || sortType=='desc')>TYPE ${sortType},  </#if>
<#if sortName?? && (sortName == 'asc' || sortName=='desc')>NAME ${sortName},  </#if>
<#if sortPartNumber?? && (sortPartNumber == 'asc' || sortPartNumber=='desc')>PART_NUMBER ${sortPartNumber},  </#if>
<#if sortLineNumber?? && (sortLineNumber == 'asc' || sortLineNumber=='desc')>LINE_NUMBER ${sortLineNumber},  </#if>
<#if sortRules?? && (sortRules == 'asc' || sortRules=='desc')>RULES ${sortRules},  </#if>
<#if sortPrice?? && (sortPrice == 'asc' || sortPrice=='desc')>PRICE ${sortPrice},  </#if>
<#if sortStatus?? && (sortStatus == 'asc' || sortStatus=='desc')>STATUS ${sortStatus},  </#if>
<#if sortCreateTime?? && (sortCreateTime == 'asc' || sortCreateTime=='desc')>CREATE_TIME ${sortCreateTime},  </#if>
<#if sortCreatorId?? && (sortCreatorId == 'asc' || sortCreatorId=='desc')>CREATOR_ID ${sortCreatorId},  </#if>
<#if sortCreator?? && (sortCreator == 'asc' || sortCreator=='desc')>CREATOR ${sortCreator},  </#if>
<#if sortModifierId?? && (sortModifierId == 'asc' || sortModifierId=='desc')>MODIFIER_ID ${sortModifierId},  </#if>
<#if sortModifiedTime?? && (sortModifiedTime == 'asc' || sortModifiedTime=='desc')>MODIFIED_TIME ${sortModifiedTime},  </#if>
<#if sortModifier?? && (sortModifier == 'asc' || sortModifier=='desc')>MODIFIER ${sortModifier},  </#if>
<#if sortSimpleName?? && (sortSimpleName == 'asc' || sortSimpleName=='desc')>SIMPLE_NAME ${sortSimpleName},  </#if>
<#if sortPrefixCode?? && (sortPrefixCode == 'asc' || sortPrefixCode=='desc')>PREFIX_CODE ${sortPrefixCode},  </#if>
<#if sortCode?? && (sortCode == 'asc' || sortCode=='desc')>CODE ${sortCode},  </#if>
   CODE ASC