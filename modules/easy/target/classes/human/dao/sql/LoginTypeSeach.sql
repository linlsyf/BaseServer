 select *  from user  where id  in ( SELECT  userid  FROM USER_AUTHS   where

    1=1



    <#if loginId??&& type??>
        and loginId= ${loginId} and type=${type}
        </#if>

  )