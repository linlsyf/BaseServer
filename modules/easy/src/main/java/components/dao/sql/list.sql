SELECT * FROM sys_components
        WHERE 1=1 
 
        <#if name??> 
        AND name=''${name}''
        </#if> 

