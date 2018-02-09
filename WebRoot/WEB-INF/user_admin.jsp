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
	<title>用户管理</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<link rel="stylesheet" href="<%=basePath%>css/bootstrap-table.css">
	<link rel="stylesheet"
		href="<%=basePath%>bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=basePath%>css/toastr.css">
	<script src="<%=basePath%>scripts/jquery.min.js"></script>
	<script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>scripts/bootstrap-table.min.js"></script>
	<script src="<%=basePath%>scripts/bootstrap-table-zh-CN.min.js"></script>
	<script src="<%=basePath%>scripts/toastr.min.js"></script>
	<script src="<%=basePath%>scripts/json2.js"></script>
	<script src="<%=basePath%>scripts/userAdmin.js"></script>
	<script>
	        toastr.options.positionClass = 'toast-center-center';
	</script>
</head>

<body>
	<div class="panel-body" style="padding-bottom: 0px;">		
		<div class="panel panel-default" >
            <div class="panel-heading">报表及用户管理</div>
            <div class="panel-body">
                <ul class="list-group list-inline">
                    <li class="list-group-item"><a href="sourcewater_moveForward.action?id=sourcewater_admin">原水报表</a></li>
                    <li class="list-group-item"><a href="finishedwater_moveForward.action?id=finishedwater_admin">出厂水报表</a></li>
                    <li class="list-group-item"><a href="processwater_moveForward.action?id=processwater_admin">工艺过程表</a></li>
                    <li class="list-group-item"><a href="user_moveForward.action?id=user_admin">用户管理</a></li>
                </ul>
            </div>
        </div>
		
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove"></span>删除
			</button>
		</div>
		<table id="tb_user"></table>
	</div>

	<!--新增模态框-->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">X</button>
					<h4 class="modal-title" id="myModalLabel1">增添用户</h4>
				</div>
				<div class="modal-body">
					<form id="addForm" class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-sm-3" for="userName">用户名:</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="userName">
							</div>
							<label class="control-label col-sm-3" for="password">密码:</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="password">
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-sm-3" for="userRole">权限:</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="userRole">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="addConfirmBtn">增添用户</button>
				</div>
			</div>

		</div>
	</div>

	<!--编辑模态框-->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">X</button>
					<h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
				</div>
				<div class="modal-body">
					<form id="updateForm" class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-sm-3" for="userName">用户名:</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="userName"
									name="userName">
							</div>
							<label class="control-label col-sm-3" for="password">密码:</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="password"
									name="password">
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-sm-3" for="userRole">权限:</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="userRole"
									name="userRole">
							</div>
							<label class="control-label col-sm-3">编号:</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="id"
									readonly="readonly">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="updateConfirmBtn">提交更改</button>
				</div>
			</div>

		</div>
	</div>

</body>
</html>
