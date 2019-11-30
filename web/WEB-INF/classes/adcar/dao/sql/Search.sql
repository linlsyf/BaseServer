SELECT * FROM adcar
        WHERE 1=1

      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

