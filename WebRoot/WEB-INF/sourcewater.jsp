<%@ page language="java" import="java.util.Date,java.text.SimpleDateFormat" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>原水报表</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<link rel="stylesheet"
		href="<%=basePath%>bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=basePath%>css/toastr.css">
	<link rel="stylesheet" href="<%=basePath%>css/reuse.css">
	<script src="<%=basePath%>scripts/jquery.min.js"></script>
	<script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>scripts/toastr.min.js"></script>
	<script src="<%=basePath%>scripts/json2.js"></script>
	<script src="<%=basePath%>scripts/sourceWater.js"></script>
	<script>
		        toastr.options.positionClass = 'toast-center-center';
		</script>
</head>

<body>
	<div class="container">
		<div class="row col-lg-12 col-md-12 col-xs-12 col-sm-12">
			
			<%@include file="/WEB-INF/left.jsp" %>
			
			<div class="col-lg-9 col-md-9 col-xs-9 col-sm-9"
				style="background-color: #FFFFFF ">
				<form role="form">
					<table class="table table-striped">
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 10%;">
							<col style="width: 10%;">
							<col style="width: 10%;">
							<col style="width: 10%;">
							<col style="width: 10%;">
							<col style="width: 10%;">
							<col style="width: 10%;">
						</colgroup>
						<thead>
							<tr>
								<th colspan="8" class="text-muted">
									<h3>XXX日报表</h3></th>
							</tr>
						</thead>
						<tbody id="sourceWaterTable">
							<tr style="background-color: rgb(201, 203, 207);">
								<td>样品来源</td>
								<td><input type="text" name="waterFrom" /></td>
								<td>日期</td>
								<td><input type="text" id="checkTime" name="checkTime"
									value=<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%> readonly="readonly"/></td>
								<td>天气</td>
								<td><input type="text" name="weather" /></td>
								<td>室温</td>
								<td><input type="text" name="temperature" /></td>
							</tr>

							<tr>
								<td colspan="8">原水日报表</td>
							</tr>
							<tr style="background-color: rgb(201, 203, 207);">
								<td colspan="2">检测项目</td>
								<td colspan="2">单位</td>
								<td colspan="2">国家标准</td>
								<td colspan="2">长江</td>
							</tr>
							<tr>
								<td colspan="2">水温</td>
								<td colspan="2">℃</td>
								<td colspan="2">/</td>
								<td colspan="2"><input type="text" name="srcTemperature" />
								</td>
							</tr>
							<tr>
								<td colspan="2">PH</td>
								<td colspan="2">无量纲</td>
								<td colspan="2">6.0~9.0</td>
								<td colspan="2"><input type="text" name="srcPh" /></td>
							</tr>
							<tr>
								<td colspan="2">色度</td>
								<td colspan="2">度</td>
								<td colspan="2">/</td>
								<td colspan="2"><input type="text" name="srcChroma" /></td>
							</tr>
							<tr>
								<td colspan="2">肉眼可见物</td>
								<td colspan="2">/</td>
								<td colspan="2">/</td>
								<td colspan="2"><input type="text" name="srcLookable" /></td>
							</tr>
							<tr>
								<td colspan="2">臭和味</td>
								<td colspan="2">/</td>
								<td colspan="2">/</td>
								<td colspan="2"><input type="text" name="srcSmell" /></td>
							</tr>
							<tr>
								<td colspan="2">浑浊度</td>
								<td colspan="2">NTU</td>
								<td colspan="2">/</td>
								<td colspan="2"><input type="text" name="srcNtu" /></td>
							</tr>
							<tr>
								<td colspan="2">菌落总数</td>
								<td colspan="2">CFU/mL</td>
								<td colspan="2">/</td>
								<td colspan="2"><input type="text" name="srcCfu" /></td>
							</tr>
							<tr>
								<td colspan="2">总大肠菌群</td>
								<td colspan="2">MPN/100mL</td>
								<td colspan="2">/</td>
								<td colspan="2"><input type="text" name="srcTotalColiforms" />
								</td>
							</tr>
							<tr>
								<td colspan="2">耐热大肠菌群</td>
								<td colspan="2">MPN/100mL</td>
								<td colspan="2">≤1000</td>
								<td colspan="2"><input type="text" name="srcHeatResistant" />
								</td>
							</tr>
							<tr>
								<td colspan="2">耗氧量</td>
								<td colspan="2">mg/L</td>
								<td colspan="2">≤6.0</td>
								<td colspan="2"><input type="text" name="srcCod" /></td>
							</tr>
							<tr>
								<td colspan="2">氨氮</td>
								<td colspan="2">mg/L</td>
								<td colspan="2">≤1.0</td>
								<td colspan="2"><input type="text" name="srcAmmonia" /></td>
							</tr>

							<tr
								style="text-align: center;background-color: rgb(201, 203, 207);">
								<td>检测人</td>
								<td colspan="3"><input type="text" name="checker" /></td>
								<td>审核人</td>
								<td colspan="3"><input type="text" name="verifier" /></td>
							</tr>
						</tbody>

					</table>
					<div style="text-align: right;padding-right: 50px;">
						<input id="processBtn" type="button" class="btn btn-primary"
							value="GO ON" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
