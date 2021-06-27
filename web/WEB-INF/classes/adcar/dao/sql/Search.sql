SELECT * FROM adcar
        WHERE 1=1

              <#if type??>  and  type = $${type}</#if>

     order  by createtime  desc

      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>





   

