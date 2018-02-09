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
	<title>出厂水报表管理</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<link rel="stylesheet"
		href="<%=basePath%>bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=basePath%>css/toastr.css">
	<link rel="stylesheet" href="<%=basePath%>css/reuse.css">
	<script src="<%=basePath%>scripts/jquery.min.js"></script>
	<script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>scripts/toastr.min.js"></script>
	<script src="<%=basePath%>scripts/json2.js"></script>
	<script src="<%=basePath%>scripts/processWater.js"></script>
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
				<form>
					<table class="table table-striped table-bordered">
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
							<h3>工艺过程监测数据</h3>
						</caption>
						<thead>
							<tr style="background-color: rgb(201, 203, 207);">
								<th>编号</th>
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
								<td>1</td>
								<td><input type="text" name="checkTimeProcess" /></td>
								<td><input type="text" name="sourceWaterNfu" /></td>
								<td><input type="text" name="precipitableWaterNfu" /></td>
								<td><input type="text" name="savedWaterNfu" /></td>
								<td><input type="text" name="filteredWaterNfu" /></td>
								<td><input type="text" name="finishedWaterNfu" /></td>
								<td><input type="text" name="finishedWaterHico" /></td>
							</tr>
							<tr id="waterprocess2">
								<td>2</td>
								<td><input type="text" name="checkTimeProcess" /></td>
								<td><input type="text" name="sourceWaterNfu" /></td>
								<td><input type="text" name="precipitableWaterNfu" /></td>
								<td><input type="text" name="savedWaterNfu" /></td>
								<td><input type="text" name="filteredWaterNfu" /></td>
								<td><input type="text" name="finishedWaterNfu" /></td>
								<td><input type="text" name="finishedWaterHico" /></td>
							</tr>
							<tr id="waterprocess3">
								<td>3</td>
								<td><input type="text" name="checkTimeProcess" /></td>
								<td><input type="text" name="sourceWaterNfu" /></td>
								<td><input type="text" name="precipitableWaterNfu" /></td>
								<td><input type="text" name="savedWaterNfu" /></td>
								<td><input type="text" name="filteredWaterNfu" /></td>
								<td><input type="text" name="finishedWaterNfu" /></td>
								<td><input type="text" name="finishedWaterHico" /></td>
							</tr>
							<tr id="waterprocess4">
								<td>4</td>
								<td><input type="text" name="checkTimeProcess" /></td>
								<td><input type="text" name="sourceWaterNfu" /></td>
								<td><input type="text" name="precipitableWaterNfu" /></td>
								<td><input type="text" name="savedWaterNfu" /></td>
								<td><input type="text" name="filteredWaterNfu" /></td>
								<td><input type="text" name="finishedWaterNfu" /></td>
								<td><input type="text" name="finishedWaterHico" /></td>
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
