
$(function () {
    hicoChartShow();

    $("#hicoBtn").bind('click',function () {
        hicoChartShow();
    });

    $("#ntuBtn").bind('click',function () {
        ntuChartShow();
    });

});

function hicoChartShow() {
   var myJsonData = $.ajax({
       url: "lineChart_getData.action",
       dataType: "json",
       async: false,
       success: function (res) {
    	   console.log(res);
           var lables = res.lables,data = [];
           var fihArray = res.finishedWaters;
           
           //console.log(lables.length);
           if(lables.length <= 1){
        	   lables = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
           }
           
           for(var i = 0;i < fihArray.length;i++){
               data.push(fihArray[i].fihHico);
           }
           
           
           var lineChartData = {
               labels: lables,
               datasets: [
                   {
                       backgroundColor: window.chartColors.red,
                       borderColor: window.chartColors.red,
                       fill: false,
                       label: 'HICO',
                       data : data
                   }

               ]
           };

           var ctx = document.getElementById("hicoCanvas").getContext("2d");

           var myLineChart = new Chart(ctx,{
               type: 'line',
               data: lineChartData,
               options:{
                   responsive:true,
                   tooltips: { //该设置可以在图表中移动，从而显示数据，不需要在数据点上滑动
                       mode: 'index',
                       intersect: false
                   },
                   scales:{
                       yAxes: [{
                           gridLines: {
                               display: false
                           },
                           ticks:{
                               min : 0,
                               max : 1
                           }
                       }],
                       xAxes: [{
                           gridLines: {
                               display: false
                           },
                           scaleLabel: {
                               display: true,
                               labelString: 'Week'
                           }
                       }]
                   },
                   title: {
                       display: true,
                       text: 'FinishedWater HICO'
                   },
                   legend: {
                       display: true,
                       position: 'bottom',
                       labels: {
                           usePointStyle : false
                       }
                   }
               }
           });
       },
       error: function () {

       }
   });
}

function ntuChartShow() {
	var myJsonData = $.ajax({
	       url: "lineChart_getData.action",
	       dataType: "json",
	       async: false, //采用同步的方式，保证用户在resize的时候，不会影响到图表
	       success: function (res) {
	    	   
	           var lables = res.lables,data = [];
	           var fihArray = res.finishedWaters;
	           
	           if(lables.length <= 1){
	        	   lables = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
	           }	           
	           
	           for(var i = 0;i < fihArray.length;i++){
	               data.push(fihArray[i].fihNtu);
	           }
	           
	           
	           var lineChartData = {
	               labels: lables,
	               datasets: [
	                   {
	                       fill: false,
	                       backgroundColor: window.chartColors.blue,
	                       borderColor: window.chartColors.blue,
	                       label: 'NTU',
	                       data : data
	                   }

	               ]
	           };

	           var ctx = document.getElementById("ntuCanvas").getContext("2d");

	           var myLineChart = new Chart(ctx,{
	               type: 'line',
	               data: lineChartData,
	               options:{
	                   responsive:true,
	                   tooltips: {
	                       mode: 'index',
	                       intersect: false
	                   },
	                   scales:{
	                       yAxes: [{
	                           gridLines: {
	                               display: false
	                           },
	                           ticks:{
	                               min : 0,
	                               max : 1
	                           }
	                       }],
	                       xAxes: [{
	                           gridLines: {
	                               display: false
	                           },
	                           scaleLabel: {
	                               display: true,
	                               labelString: 'Week'
	                           }
	                       }]
	                   },
	                   title: {
	                       display: true,
	                       text: 'FinishedWater NTU'
	                   },
	                   legend: {
	                       display: true,
	                       position: 'bottom',
	                       labels: {
	                           usePointStyle : false
	                       }
	                   }
	               }
	           });
	       },
	       error: function () {

	       }
	   });
}