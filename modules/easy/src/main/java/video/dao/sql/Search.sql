SELECT * FROM pre_video
        WHERE 1=1

   <#if name??>
      and  name=${name}
        </#if>

<#if type??>
      and  type=${type}
        </#if>

        <#if status??>
      and  status=${status}
        </#if>
          <#if typecode??>
      and  typecode=${typecode}
        </#if>
              order  by createtime  desc


      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

