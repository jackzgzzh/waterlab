/**
 * Created by HP on 2018/1/13.
 */
/*
获取Header对象
 */
function getHeaderObj() {
    obj = {};
    var inputList = $("#sourceWaterTable").children("tr:eq(0)").find("input");
    for ( var i = 0; i < inputList.length; i++) {
        var inputName = inputList[i].name;
        var inputValue = inputList[i].value;
        obj[inputName] = inputValue;
    }
    return obj;
}

/*
获取Footer对象
 */
function getFooterObj() {
    obj = {};
    var inputList = $("#sourceWaterTable").find("tr:last").children().find("input");
    for ( var i = 0; i < inputList.length; i++) {
        var inputName = inputList[i].name;
        var inputValue = inputList[i].value;
        obj[inputName] = inputValue;
    }
    return obj;
}

/*
获取SourceWater对象
 */
function getSourceWaterObj() {
    obj = {};
    var trList = $("#sourceWaterTable").find("tr");
    for(var i = 1;i < trList.length-1;i++){

        var inputList = trList.eq(i).children().find("input");
        for(var j = 0;j < inputList.length;j++){
            var inputName = inputList[j].name;
            var inputValue = inputList[j].value;
            obj[inputName] = inputValue;
        }

    }
    return obj;
}

$(document).ready(function () {

    $("#processBtn").on("click",function () {

        var headerObjStr = JSON.stringify(getHeaderObj());
        var footerObjStr = JSON.stringify(getFooterObj());
        var sourceWaterObjStr = JSON.stringify(getSourceWaterObj());

        $.ajax({
            type : "post",
            url : "sourcewater_add.action",
            data : {
                "headerObjStr" : headerObjStr,
                "footerObjStr" : footerObjStr,
                "sourceWaterObjStr" : sourceWaterObjStr
            },
            dataType : "json",
            success : function(data) {
                if(data.success){
                    toastr.success("提交数据成功");
                }
                $("tr").find("input").val("");
            },
            error:function(){
                toastr.error("Error");
            }
        });
        //console.log(sourceWaterObjStr);
      

    });
});