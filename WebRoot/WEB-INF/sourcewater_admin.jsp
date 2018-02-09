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
    <title>原水报表管理</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0" >
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap-table.css">
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/toastr.css">
    <script src="<%=basePath%>scripts/jquery.min.js"></script>
    <script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>scripts/bootstrap-table.min.js"></script>
    <script src="<%=basePath%>scripts/bootstrap-table-zh-CN.min.js"></script>
    <script src="<%=basePath%>scripts/toastr.min.js"></script>
    <script src="<%=basePath%>scripts/json2.js"></script>
    <script src="<%=basePath%>scripts/sourceWaterAdmin.js"></script>
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
            <button id="btn_edit" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove"></span>删除
            </button>
        </div>
        <table id="tb_sourcewater"></table>
    </div>
    <!--编辑模态框-->
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
            aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">X</button>
                    <h4 class="modal-title" id="myModalLabel">修改原水信息</h4>
                </div>
                <div class="modal-body">
                   <form id="updateForm" class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="srcTemperature">水温:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="srcTemperature" name="srcTemperature">
                            </div>
                            <label class="control-label col-sm-3" for="srcPh">PH:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="srcPh" name="srcPh">
                            </div>

                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="srcChroma">色度:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="srcChroma" name="srcChroma">
                            </div>
                            <label class="control-label col-sm-3" for="srcLookable">肉眼可见物:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="srcLookable" name="srcLookable">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="srcSmell">臭和味:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="srcSmell" name="srcSmell">
                            </div>
                            <label class="control-label col-sm-3" for="srcNtu">浊度:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="srcNtu" name="srcNtu">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="srcCfu">菌落总数:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="srcCfu" name="srcCfu">
                            </div>
                            <label class="control-label col-sm-3" for="srcTotalColiforms">总大肠菌群数:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="srcTotalColiforms" name="srcTotalColiforms">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="srcHeatResistant">耐热大肠菌:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="srcHeatResistant" name="srcHeatResistant">
                            </div>
                            <label class="control-label col-sm-3" for="srcCod">耗氧量:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="srcCod" name="srcCod">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="srcAmmonia">氨氮:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="srcAmmonia" name="srcAmmonia">
                            </div>
                            <label class="control-label col-sm-3" >编号:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control"  name="id" readonly="readonly">
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
