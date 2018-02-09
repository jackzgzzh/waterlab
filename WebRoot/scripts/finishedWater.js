/**
 * Created by HP on 2018/1/13.
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

$(document).ready(function () {

    $('#processBtn').on("click",function () {
        var finishedWaterStr =  JSON.stringify(getObj('#finishedWaterTable'));

        $.ajax({
            type: "post",
            url: "finishedwater_add.action",
            data: {
                "finishedWaterStr" : finishedWaterStr
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
        $("tr").find("input").val("");
    });
});