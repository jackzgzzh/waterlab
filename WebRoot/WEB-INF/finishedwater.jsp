<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>出厂水报表</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<link rel="stylesheet"
		href="<%=basePath%>bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=basePath%>css/toastr.css">
	<link rel="stylesheet" href="<%=basePath%>css/reuse.css">
	<script src="<%=basePath%>scripts/jquery.min.js"></script>
	<script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>scripts/toastr.min.js"></script>
	<script src="<%=basePath%>scripts/json2.js"></script>
	<script src="<%=basePath%>scripts/finishedWater.js"></script>
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
					<table class="table table-striped" id="finishedWaterTable">
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
						<caption class="text-center text-muted">
							<h3>出厂水日报表</h3>
						</caption>
						<thead>
							<tr style="background-color: rgb(201, 203, 207);">
								<th colspan="2">检测项目</th>
								<th colspan="2">单位</th>
								<th colspan="2">国家标准</th>
								<th colspan="2">XXXX</th>
							</tr>
						</thead>
						<tr>
							<td colspan="2">水温</td>
							<td colspan="2">℃</td>
							<td colspan="2">/</td>
							<td colspan="2"><input type="text" name="fihTemperature" />
							</td>
						</tr>
						<tr>
							<td colspan="2">PH</td>
							<td colspan="2">无量纲</td>
							<td colspan="2">6.5～8.5</td>
							<td colspan="2"><input type="text" name="fihPh" /></td>
						</tr>
						<tr>
							<td colspan="2">色度</td>
							<td colspan="2">度</td>
							<td colspan="2">≤15</td>
							<td colspan="2"><input type="text" name="fihChroma" /></td>
						</tr>
						<tr>
							<td colspan="2">肉眼可见物</td>
							<td colspan="2">/</td>
							<td colspan="2">无</td>
							<td colspan="2"><input type="text" name="fihLookable" /></td>
						</tr>
						<tr>
							<td colspan="2">臭和味</td>
							<td colspan="2">/</td>
							<td colspan="2">无异臭、异味</td>
							<td colspan="2"><input type="text" name="fihSmell" /></td>
						</tr>
						<tr>
							<td colspan="2">浑浊度</td>
							<td colspan="2">NTU</td>
							<td colspan="2">≤1，特≤3</td>
							<td colspan="2"><input type="text" name="fihNtu" /></td>
						</tr>
						<tr>
							<td colspan="2">二氧化氯</td>
							<td colspan="2">mg/L</td>
							<td colspan="2">≥0.1</td>
							<td colspan="2"><input type="text" name="fihChlorineDioxide" />
							</td>
						</tr>
						<tr>
							<td colspan="2">游离余氯</td>
							<td colspan="2">mg/L</td>
							<td colspan="2">≥0.3</td>
							<td colspan="2"><input type="text" name="fihHico" /></td>
						</tr>
						<tr>
							<td colspan="2">总氯</td>
							<td colspan="2">mg/L</td>
							<td colspan="2">≤3.0</td>
							<td colspan="2"><input type="text" name="fihUhr" /></td>
						</tr>
						<tr>
							<td colspan="2">菌落总数</td>
							<td colspan="2">CFU/mL</td>
							<td colspan="2">≤100</td>
							<td colspan="2"><input type="text" name="fihCfu" /></td>
						</tr>
						<tr>
							<td colspan="2">总大肠菌群</td>
							<td colspan="2">MPN/100mL</td>
							<td colspan="2">不得检出</td>
							<td colspan="2"><input type="text" name="fihTotalColiforms" />
							</td>
						</tr>
						<tr>
							<td colspan="2">耐热大肠菌群</td>
							<td colspan="2">MPN/100mL</td>
							<td colspan="2">不得检出</td>
							<td colspan="2"><input type="text" name="fihHeatResistant" />
							</td>
						</tr>
						<tr>
							<td colspan="2">耗氧量</td>
							<td colspan="2">mg/L</td>
							<td colspan="2">≤3，特≤5</td>
							<td colspan="2"><input type="text" name="fihCod" /></td>
						</tr>
						<tr style="border-bottom-style: solid;border-bottom-width: 1px;">
							<td colspan="2">氨氮</td>
							<td colspan="2">mg/L</td>
							<td colspan="2">≤0.5</td>
							<td colspan="2"><input type="text" name="fihAmmonia" /></td>
						</tr>
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
