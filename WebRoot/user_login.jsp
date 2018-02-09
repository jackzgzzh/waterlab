<%@ page language="java" import="java.util.*,com.waterlab.bean.User" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>用户登录</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<link rel="stylesheet"
		href="<%=basePath%>bootstrap/css/bootstrap.min.css">
	<link href="<%=basePath%>css/bootstrapValidator.css" rel="stylesheet" />
	<link rel="stylesheet" href="<%=basePath%>css/reuse.css">
	<script src="<%=basePath%>scripts/jquery.min.js"></script>
	<script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>scripts/bootstrapValidator.min.js"></script>
	<script src="<%=basePath%>scripts/userLogin.js"></script>
</head>

<body>
	  <div class="container">
        <div class="col-lg-4 col-lg-offset-4 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2">
            <form class="form" id="loginForm" method="post" action="userLoginAction!login.action">
                <h2>Welcome To My Lab</h2>
                <div class="form-group">
                    <label class="sr-only">username</label>
                    <input type="text" class="form-control" placeholder="请输入用户名" name="userName"/>
                </div>
                <div class="form-group">
                    <label class="sr-only">password</label>
                    <input type="password"  class="form-control" placeholder="请输入密码" name="password">
                </div>

                <button class="btn btn-lg btn-primary btn-block" type="submit" id="loginBtn">登录</button>
            </form>
        </div>
    </div>
</body>
</html>
