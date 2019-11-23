

 select *  from user  where id  in ( SELECT  userid  FROM USER_AUTHS   where

    1=1



    <#if loginId??&& pwd??>
        and loginId= ${loginId} and pwd=${pwd}
        </#if>

  )



