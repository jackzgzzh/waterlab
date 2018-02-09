/*
 * 根据id获取表格中的input对象，并将其中的name和value值保存到新建对象中
 */
function getObj(id) {
    var inputList = $(id).find("input");
    var obj = {};
    for ( var i = 0; i < inputList.length; i++) {
        var inputName = inputList[i].name;
        var inputValue = inputList[i].value;
        obj[inputName] = inputValue;
    }
    return obj;
}
/*
 * 更改表格中的日期表现形式，如输入09:00，则输出为2018-1-11 09:00:00
 */
function changDate(obj) {
    var mydate = new Date();
    var myMonth = mydate.getMonth()+1;
    var checktime = "";
    if(myMonth >= 10){
        checktime = mydate.getFullYear() + "-" + myMonth + "-" + mydate.getDate() + " " + obj.checkTimeProcess + ":00";
    }else{
        checktime = mydate.getFullYear() + "-" + "0"+myMonth + "-" + mydate.getDate() + " " + obj.checkTimeProcess + ":00";
    }

    obj.checkTimeProcess = checktime;
    return obj;
}

/*
 * 为表单的按钮绑定click事件，并通过jQuery.ajax向后台传送json数据
 */
function btn() {
    var btnObj = $("#processBtn");

    btnObj.bind("click", function() {
        var data1 = JSON.stringify(changDate(getObj('#waterprocess1')));
        var data2 = JSON.stringify(changDate(getObj('#waterprocess2')));
        var data3 = JSON.stringify(changDate(getObj('#waterprocess3')));
        var data4 = JSON.stringify(changDate(getObj('#waterprocess4')));
        var processWaterList = [ data1, data2, data3, data4 ];

        $.ajax({
            type : "post",
            //async:false,
            url : "processwater_add.action",
            traditional : true,
            //contentType:"application/json;charset=UTF-8",
            data : {
                "processWaterList" : processWaterList
            },
            dataType : "json",
            success : function(data) {
                if(data.success){
                    toastr.success("提交数据成功");
                }
            },
            error:function(){
                toastr.error("Error");
            }
        });
        $("tr").find("input").val("");//数据传送完成后清空input中的数据
    });
}
/*
 * 页面加载完成时
 */
$(document).ready(function() {
    btn();
});