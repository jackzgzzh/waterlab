<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"] />
<#assign basePath=request.getContextPath()+"/">
<!DOCTYPE html>
<html>
<head>  
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0" >
    <title>工艺过程表</title>
    <link href="${basePath}bootstrap3/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${basePath}css/reuse.css" rel="stylesheet" />
    <script type="text/javascript" src="${basePath}scripts/jquery.js"></script>
    <script type="text/javascript" src="${basePath}bootstrap3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${basePath}scripts/json2.js"></script>
    <script type="text/javascript">
        function getObj(id) {
            var inputList = $(id).find("input");
            var obj = {};
            for(var i = 0;i < inputList.length;i++){
                var inputName = inputList[i].name;
                var inputValue = inputList[i].value;
                obj[inputName] = inputValue;
            }
            return obj;
        }

        function getJsonObj(obj) {
            var jsonStr = JSON.stringify(obj);
            var jsonObj = JSON.parse(jsonStr);
            return jsonObj;
        }

        function changDate(obj) {
            var mydate = new Date();
            var newdate = mydate.getFullYear()+"-"+(mydate.getMonth()+1)+"-"+mydate.getDate()+obj.checkTimeProcess+":00";
            obj.checkTimeProcess = newdate;
            return obj;
        }

        function getJsonArr() {
            var arr = [];

            var obj1 = getJsonObj(changDate(getObj('#waterprocess1')));
            var obj2 = getJsonObj(changDate(getObj('#waterprocess2')));
            var obj3 = getJsonObj(changDate(getObj('#waterprocess3')));
            var obj4 = getJsonObj(changDate(getObj('#waterprocess4')));
            arr.push(obj1);
            arr.push(obj2);
            arr.push(obj3);
            arr.push(obj4);
            return arr;
        }


        function onClick() {
            var arr = getJsonArr();
            $.ajax({
                type : "POST",
                url : "processwater!add.action",
                contentType: "application/json;charset=utf-8",
                data : arr,
                traditional: true,
                success : function (data) {
                    //alert(data);
                }

            });

        }
    </script>
  </head>
  <body>
	<form  id="waterProcessForm" name="waterProcessForm" role="form" method="post" action="">
	        <table class="table table-bordered">
	            <colgroup>
	                <col style="width: 10%;">
	                <col style="width: 10%;">
	                <col style="width: 10%;">
	                <col style="width: 10%;">
	                <col style="width: 10%;">
	                <col style="width: 10%;">
	                <col style="width: 10%;">
	            </colgroup>
	            <caption class="text-center">工艺过程监测表</caption>
	            <thead>
	                <tr>
	                    <th>检测时间</th>
	                    <th>源水浊度</th>
	                    <th>沉淀水浊度</th>
	                    <th>清水池浊度</th>
	                    <th>滤后水浊度</th>
	                    <th>出厂水浊度</th>
	                    <th>出厂水余氯</th>
	                </tr>
	            </thead>
	           <tbody>
            <tr id="waterprocess1">
                <td>
                    <input type="text"  name="checkTimeProcess" />
                </td>
                <td>
                    <input type="text" name="sourceWaterNfu" />
                </td>
                <td>
                    <input type="text"  name="precipitableWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="savedWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="filteredWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="finishedWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="finishedWaterHico"/>
                </td>
            </tr>
            <tr id="waterprocess2">
                <td>
                    <input type="text"  name="checkTimeProcess" />
                </td>
                <td>
                    <input type="text" name="sourceWaterNfu" />
                </td>
                <td>
                    <input type="text"  name="precipitableWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="savedWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="filteredWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="finishedWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="finishedWaterHico"/>
                </td>
            </tr>
            <tr id="waterprocess3">
                <td>
                    <input type="text"  name="checkTimeProcess" />
                </td>
                <td>
                    <input type="text" name="sourceWaterNfu" />
                </td>
                <td>
                    <input type="text"  name="precipitableWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="savedWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="filteredWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="finishedWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="finishedWaterHico"/>
                </td>
            </tr>
            <tr id="waterprocess4">
                <td>
                    <input type="text"  name="checkTimeProcess" />
                </td>
                <td>
                    <input type="text" name="sourceWaterNfu" />
                </td>
                <td>
                    <input type="text"  name="precipitableWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="savedWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="filteredWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="finishedWaterNfu"/>
                </td>
                <td>
                    <input type="text"  name="finishedWaterHico"/>
                </td>
            </tr>
        </tbody>
	
	        </table>
	        <input type="submit" onclick="onClick();" value="提交"/>
	   </form>
  </body>
</html>
