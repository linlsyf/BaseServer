SELECT * FROM app_msg
        WHERE 1=1
<#if id??>
     and   id=${id}
        </#if>
 <#if type??>
     and   type=${type}
        </#if>

        order  by sn  desc

