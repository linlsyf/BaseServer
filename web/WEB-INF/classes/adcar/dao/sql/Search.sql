SELECT * FROM adcar
        WHERE 1=1

<<<<<<< HEAD
      <#if start??&& limit??>
=======
SELECT * FROM adcar        WHERE 1=1                    order  by  createtime asc


 <#if start??&& limit??>
>>>>>>> parent of 8f10269... 更新react
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