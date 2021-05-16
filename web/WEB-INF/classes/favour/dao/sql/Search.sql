SELECT * FROM favour
        WHERE 1=1

      <#if start??&& limit??>
       limit ${start},${limit}
        </#if>

--   <#if  ordercolum??&& orderType??>
--
--
--    order  by   ${start}    ${orderType}
--
--
--
-- <#else>
--       order  by  createtime desc
-- </#if>