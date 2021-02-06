SELECT * FROM sys_dict
        WHERE 1=1

   <#if name??>
      and  name=${name}
        </#if>

<#if type??>
      and  type=${type}
        </#if>
              order  by createtime  desc


      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

