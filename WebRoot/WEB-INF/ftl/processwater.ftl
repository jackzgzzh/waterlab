<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"] />
<!DOCTYPE html>
<html>
  <head>
    <title>freemarkerDemo</title>	
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

  </head> 
  <body>
  <ul>
  <#list processWaterList as processWater>
    <li>检测时间:${processWater.checkTimeProcess}</li>
    <li>源水浊度:${processWater.sourceWaterNfu}</li>
    <li>沉淀水浊度:${processWater.precipitableWaterNfu}</li>
    <li>清水池浊度:${processWater.savedWaterNfu}</li>
    <li>滤后水浊度:${processWater.filteredWaterNfu}</li>
    <li>出厂水浊度：${processWater.finishedWaterNfu}</li>
    <li>出厂水余氯：${processWater.finishedWaterHico}</li>
  </#list>
  </ul>
  </body>

</html>