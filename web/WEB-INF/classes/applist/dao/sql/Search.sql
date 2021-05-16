SELECT * FROM app_list
        WHERE 1=1

 <#if type??>
       and type=${type}
        </#if>
 <#if parent_id??>
       and parent_id=${parent_id}
       
<#else> 
  and parent_id is null
</#if> 

        order  by sn  desc

