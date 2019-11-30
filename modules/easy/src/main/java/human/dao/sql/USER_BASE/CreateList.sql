
INSERT INTO DOCUMENT_APPLY
(
<#assign n=0 />
 <#if data?exists>
  <#list data?keys as key>
    <#if n gt 0 >,</#if>${key}
     <#assign n=n+1 />
  </#list>
</#if>
)

VALUES
(
<#assign n=0 />
<#if data?exists>
  <#list data?keys as key>
       <#if n gt 0 >,</#if>${$(data[key])}
       <#assign n=n+1 />
  </#list>
</#if>
)