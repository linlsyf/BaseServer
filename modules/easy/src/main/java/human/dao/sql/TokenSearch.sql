


SELECT * FROM authstoken
        WHERE 1=1

 <#if accessToken???>
        and accessToken= ${accessToken}
        </#if>

