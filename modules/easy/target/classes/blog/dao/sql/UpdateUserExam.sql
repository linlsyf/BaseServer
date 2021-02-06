
UPDATE EXAM_SELF SET

<#assign n=0 />
 <#if data?exists>
  <#list data?keys as key>
    <#if n gt 0 >,</#if>${key}=${$(data[key])}
     <#assign n=n+1 />
  </#list>
</#if>

WHERE id = ${$(id)}