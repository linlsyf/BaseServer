SELECT * FROM app_list
        WHERE 1=1

 <#if type??>
       type=${type}
        </#if>
 <#if parent_id??>
       parent_id=${parent_id}
        </#if>

        order  by sn  desc

