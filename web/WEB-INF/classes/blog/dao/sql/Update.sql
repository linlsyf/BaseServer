
UPDATE blog SET

<#if title??> title=${$(title)}, </#if>
<#if content??> content=${$(content)}, </#if>
<#if name??> NAME=${$(name)}, </#if>
<#if basicSalary??> BASIC_SALARY=${$(basicSalary)}, </#if>
<#if performSalary??> PERFORM_SALARY=${$(performSalary)}, </#if>
<#if nextRank??> NEXT_RANK=${$(nextRank)}, </#if>
<#if promotionPercent??> PROMOTION_PERCENT=${$(promotionPercent)}, </#if>
<#if status??> STATUS=${$(status)}, </#if>
<#if createTime??> CREATE_TIME=${$(createTime)}, </#if>
<#if creatorId??> CREATOR_ID=${$(creatorId)}, </#if>
<#if creator??> CREATOR=${$(creator)}, </#if>
<#if modifierId??> MODIFIER_ID=${$(modifierId)}, </#if>
<#if modifiedTime??> MODIFIED_TIME=${$(modifiedTime)}, </#if>
<#if modifier??> MODIFIER=${$(modifier)}, </#if>
<#if id??> ID=${$(id)} </#if>
 WHERE id = ${$(id)}


