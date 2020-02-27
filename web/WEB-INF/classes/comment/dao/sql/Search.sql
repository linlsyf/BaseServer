SELECT * FROM comment
        WHERE 1=1

      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

