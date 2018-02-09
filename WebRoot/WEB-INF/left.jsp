<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<div class="col-lg-3 col-md-3 col-xs-3 col-sm-3">
	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading"
				style="background-color: rgb(201, 203, 207);">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne"> 报表填写 </a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body">
					<ul class="list-unstyled">
						<li><a href="sourcewater_moveForward.action?id=sourcewater">原水日报表</a>
						</li>
						<li><a
							href="finishedwater_moveForward.action?id=finishedwater">出厂水日报表</a>
						</li>
						<li><a href="processwater_moveForward.action?id=processwater">工艺过程表</a>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading"
				style="background-color: rgb(201, 203, 207);">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseThree"> 数据图表 </a>
				</h4>
			</div>
			<div id="collapseThree" class="panel-collapse collapse">
				<div class="panel-body">
					<ul class="list-unstyled">
						<li><a href="lineChart_moveForward.action?id=fihbar">柱状图</a>
						</li>
						<li><a href="lineChart_moveForward.action?id=fihline">曲线图</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>