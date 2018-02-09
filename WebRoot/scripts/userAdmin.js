/**
 * Created by HP on 2018/1/19.
 */
$(function () {
    //初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //初始化删除按钮
    var oDeleteButtonInit = new DeleteButtonInit();
    oDeleteButtonInit.Init();

    //初始化更新按钮
    var oUpdateButtonInit = new UpdateButtonInit();
    oUpdateButtonInit.Init();

    //初始化模态框的提交按钮
    var oModalSubmitInit = new ModalSubmitInit();
    oModalSubmitInit.Init();

    //初始化新增按钮
    var oAddButtonInit = new addButtonInit();
    oAddButtonInit.Init();
    
});

//表格初始化
var TableInit = function () {
    var oTableInit = new Object();

    oTableInit.Init = function () {
        $("#tb_user").bootstrapTable({
            url: "user_getPageInfo.action",
            method: "get", //只能用get方式
            dataType : "json",
            toolbar: "#toolbar",
            striped: true,
            cache: false,
            pagination: true,
            sortable: false,
            sortOrder: "asc",
            queryParams: oTableInit.queryParams, //向后台传递的参数
            sidePagination: "server",
            pageNumber:1,
            pageSize: 10,
            pageList: [10, 25, 50, 100],
            strictSearch: true,
            showColumns: true,
            showRefresh: true,
            minimumCountColumns: 2,
            clickToSelect: true,
            height: 500,
            uniqueId: "ID",
            showToggle:true,
            cardView: false,
            detailView: false, //是否显示父子表
            columns: [{
                checkbox: true
            },{
                field: 'id',
                title: '编号',
                align: 'center'
            },{
                field: 'userRole',
                title: '权限',
                align: 'center'
            },{
                field: 'userName',
                title: '用户名',
                align: 'center'
            },{
                field: 'password',
                title: '用户密码',
                align: 'center'

            }]

        });
    };

    oTableInit.queryParams = function (params) {
        var temp = {
            "limit" : params.limit,
            "offset" : params.offset,
            //"searchName" : $("#txt_search_username").val() //查找框内容
        };
        return temp;
    };

    return oTableInit;

};

//删除按钮
var DeleteButtonInit = function () {
    var oInit = new Object();

    oInit.Init = function () {
       $("#btn_delete").click(function () {
           var list = $("#tb_user").bootstrapTable('getSelections');
           //console.log();
           if(list == null || list.length <= 0){
               toastr.warning("未选中任何项");
           }else{
               var idList = new Array();
               for(var i = 0;i < list.length;i++){
                   idList[i] = list[i].id;
               }
               if(confirm("是否删除选中的数据?")){
                   $.ajax({
                       url: "user_deleteByList.action",
                       type: "post",
                       traditional : true,
                       dataType : "json",
                       data: {
                           "idList" : idList
                       },
                       success: function (data) {
                           if(data.success){
                               toastr.success("删除成功!");
                           }
                           $("#tb_user").bootstrapTable('refresh');
                       },
                       error:function(){
                           toastr.error("Error");

                       }
                   });
                  // $("#tb_user").bootstrapTable('refresh');
               }else{
            	   toastr.info("继续删除？");  
               }
           }
       }); 
    };
    return oInit;
};

//修改按钮
var UpdateButtonInit = function () {
    var oInit = new Object();

    oInit.Init = function () {
        $("#btn_edit").click(function () {
            var list = $("#tb_user").bootstrapTable('getSelections');
            if(list == null || list.length <= 0){
                toastr.warning("未选中任何项");
            }else{
                if(list.length > 1){
                    toastr.warning("请选择一行数据进行修改");
                }else{
                    var oRow = list[0];
                    //为模态框中的input元素赋值
                    var inputList = $("#updateForm").find("input");
                    for(var i = 0;i < inputList.length;i++){
                        var oRowName = inputList[i].name;
                        inputList[i].value = oRow[oRowName];
                    }
                    $("#updateModal").modal('show');
                }

            }

        });

    };

    return oInit;
};

//模态框的提交更改按钮
var ModalSubmitInit = function () {
    var oInit = new Object();
    oInit.Init = function () {
        $("#updateConfirmBtn").click(function () {
            //获取模态框中input中的值，并存储到对象中
            var oModal = {};
            $("#updateForm").find("input[name]").each(function () {
                oModal[$(this).attr("name")] = $(this).val();
            });
            //向后台传送数据
            $.ajax({
                url: "user_update.action",
                type: "post",
                dataType : "json",
                data: {
                    "userModal" : JSON.stringify(oModal)
                },
                success: function (data) {
                    if(data.success){
                        toastr.success("修改成功!");
                    }
                    $("#tb_user").bootstrapTable('refresh');
                    $("#updateModal").modal('hide');
                },
                error:function(){
                    toastr.error("Error");
                }
            });
            
        });
    };
    return oInit;
};

//新增按钮
var addButtonInit = function () {
    var oInit = new Object();

    oInit.Init = function () {
        $("#btn_add").click(function () {
            $("#addModal").modal('show');
        });
        //新增模态框的按钮点击事件
        $("#addConfirmBtn").click(function () {
            //获取模态框中input中的值，并存储到对象中
            var oModal = {};
            $("#addForm").find("input[name]").each(function () {
                oModal[$(this).attr("name")] = $(this).val();
            });
            //向后台传送数据
            $.ajax({
                url: "user_add.action",
                type: "post",
                dataType : "json",
                data: {
                    "addUserModal" : JSON.stringify(oModal)
                },
                success: function (data) {
                    if(data != null && data.success){
                        toastr.success("添加成功!");
                    }else{
                    	toastr.warning("该用户名已存在!"); 
                    }
                    $("#tb_user").bootstrapTable('refresh');
                    $("#addModal").modal('hide');
                },
                error:function(){
                    toastr.error("Error");
                }
            });
           
        });
       
    };

    return oInit;
};

