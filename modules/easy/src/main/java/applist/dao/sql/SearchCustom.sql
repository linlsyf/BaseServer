

SELECT * FROM app_custom_list 

     WHERE 1=1

 <#if type??>
       and type=${type}
        </#if>
 <#if video??>
       and (type='radio' or type='video')
        </#if>
 <#if parent_id??>
       and parent_id=${parent_id}
       
<#else> 
   and  (parent_id is null or parent_id='')
</#if> 

        order  by sn  desc

