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
	<title>Line Chart</title>
	<meta name="viewport" content="initial-scale = 1, user-scalable = no">
	<link href="<%=basePath%>bootstrap/css/bootstrap.min.css"
		rel="stylesheet" />
	<link rel="stylesheet" href="<%=basePath%>css/reuse.css">
	<script src="<%=basePath%>scripts/jquery.min.js"></script>
	<script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/Chart.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/util.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>scripts/fihLineChart.js"></script>
</head>

<body>
	<div class="container">
		<div class="row col-lg-12 col-md-12 col-xs-12 col-sm-12">
			
			<%@include file="/WEB-INF/left.jsp" %>
			
			<div class="col-lg-9 col-md-9 col-xs-9 col-sm-9"
				style="background-color: #FFFFFF ">
				<ul class="nav nav-tabs" role="tablist" style="margin-top: 10px;">
					<li role="presentation" class="active"><a id="hicoBtn"
						href="#hico" role="tab" data-toggle="tab">HICO</a></li>
					<li role="presentation"><a id="ntuBtn" href="#nfu" role="tab"
						data-toggle="tab">NTU</a></li>
				</ul>
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="hico">
						<canvas id="hicoCanvas" width="600" height="450"></canvas>
					</div>
					<div role="tabpanel" class="tab-pane" id="nfu">
						<canvas id="ntuCanvas" width="600" height="450"></canvas>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
