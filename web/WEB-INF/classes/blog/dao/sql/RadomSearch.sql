SELECT * FROM EXAM_SELF
        WHERE 1=1


<#if type??>
      and  type=${type}
        </#if>


        <#if limitUserId??>

        and  id  not  in (select   examid from exam_user where userid=${limitUserId})
        </#if>
order by rand() limit 1