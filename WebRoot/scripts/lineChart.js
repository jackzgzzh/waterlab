/**
 * Created by HP on 2018/1/25.
 */

$(document).ready(function () {
    var jsonData = $.ajax({
        url: "lineChart_getData.action",
        dataType: "json"
    }).done(function (res) {

         var lables = res.lables,data = [];
         var fihArray = res.finishedWaters;
         for(var i = 0;i < fihArray.length;i++){
             data.push(fihArray[i].fihHico);
         }


         var lineChartData = {
             labels: lables,
             datasets: [
                 {
                     borderColor : "rgba(220,220,220,1)",
                     pointBackgroundColor: '#000000',
                     pointHoverBackgroundColor: 'blue',
                     label: '余氯',
                     data : data
                 }

             ]
         };

         var ctx = document.getElementById("canvas").getContext("2d");

         var myLineChart = new Chart(ctx,{
             type: 'line',
             data: lineChartData,
             options:{
                 responsive:false,
                 title: {
                     display: true,
                     text: '出厂水余氯折线图'
                 },
                 legend: {
                     display: true,
                     position: 'bottom',
                     labels: {
                         fontColor: 'rgb(255, 99, 132)'
                     }
                 }
             }
         });

     });

});