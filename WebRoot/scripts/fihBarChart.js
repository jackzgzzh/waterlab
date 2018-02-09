
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
           var lables = res.lables,data = [];
           var fihArray = res.finishedWaters;
           
           if(lables.length <= 1){
        	   lables = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
           }
           
           for(var i = 0;i < fihArray.length;i++){
               data.push(fihArray[i].fihHico);
           }
           
           var color = Chart.helpers.color;
           var barChartData = {
               labels: lables,
               datasets: [
                   {
                       borderColor : window.chartColors.red,
                       backgroundColor: color(window.chartColors.red).alpha(0.5).rgbString(),
                       borderWidth: 1,
                       label: 'HICO',
                       data : data
                   }

               ]
           };

           var ctx = document.getElementById("hicoCanvas").getContext("2d");

           var myBarChart = new Chart(ctx,{
               type: 'horizontalBar',
               data: barChartData,
               options:{
                   responsive:true,
                   elements: {
                       rectangle: {
                           borderWidth: 2
                       }
                   },
                   scales:{
                       yAxes: [{
                           gridLines: {
                               display: false
                           },
                           scaleLabel: {
                               display: true,
                               labelString: 'Week'
                           }
                       }],
                       xAxes: [{
                           gridLines: {
                               display: false
                           },
                           ticks:{
                               min : 0,
                               max : 1
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
	           
	           var color = Chart.helpers.color;
	           var barChartData = {
	               labels: lables,
	               datasets: [
	                   {
	                       backgroundColor: color(window.chartColors.blue).alpha(0.5).rgbString(),
	                       borderColor: window.chartColors.blue,
	                       borderWidth: 1,
	                       label: 'NTU',
	                       data : data
	                   }

	               ]
	           };

	           var ctx = document.getElementById("ntuCanvas").getContext("2d");

	           var myBarChart = new Chart(ctx,{
	               type: 'horizontalBar',
	               data: barChartData,
	               options:{
	                   responsive:true,
	                   elements: {
	                       rectangle: {
	                           borderWidth: 2
	                       }
	                   },
	                   scales:{
	                	   yAxes: [{
	                           gridLines: {
	                               display: false
	                           },
	                           scaleLabel: {
	                               display: true,
	                               labelString: 'Week'
	                           }
	                       }],
	                       xAxes: [{
	                           gridLines: {
	                               display: false
	                           },
	                           ticks:{
	                               min : 0,
	                               max : 1
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