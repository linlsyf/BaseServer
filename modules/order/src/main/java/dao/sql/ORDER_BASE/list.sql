SELECT * FROM ShopOrder
        WHERE 1=1 
 
        <#if name??> 
        AND name=''${name}''
        </#if> 
       