SELECT * FROM ERROR_LOG
        WHERE 1=1

      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

