
INSERT INTO ShopOrder
(
<#if goodsId??> goodsId, </#if>

<#if id??> ID </#if>
   ) VALUES (
<#if goodsId??>{$(goodsId)},</#if>

<#if id??>{$(id)}</#if>
)