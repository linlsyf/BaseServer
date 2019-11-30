SELECT * FROM adcar
        WHERE 1=1

<<<<<<< HEAD
SELECT * FROM adcar        WHERE 1=1                    order  by  createtime desc


 <#if start??&& limit??>
=======
      <#if start??&& limit??>
>>>>>>> parent of e4665e7... 添加登录限制
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