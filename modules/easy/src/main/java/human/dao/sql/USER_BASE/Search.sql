SELECT * FROM USER
        WHERE 1=1

      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>


    <#if loginId??&& pwd??>
       and loginId= ${loginId} and pwd=${pwd}
        </#if>

