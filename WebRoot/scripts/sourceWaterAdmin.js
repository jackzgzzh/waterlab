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
});


var TableInit = function () {
    var oTableInit = new Object();  
    
    oTableInit.Init = function () {
    	
        $("#tb_sourcewater").bootstrapTable({
            url: "sourcewater_getPageInfo.action",
            method: "get",
            toolbar: "#toolbar",
            striped: true,
            cache: false,
            pagination: true,
            //sortable: true,
            //sortOrder: 'desc',
            queryParams: oTableInit.queryParams, //向后台传递的参数
            sidePagination: "server",
            pageNumber:1,
            pageSize: 10,
            pageList: [10, 25, 50, 100],
            //search: true,
            strictSearch: true,
            showColumns: true,
            showRefresh: true,
            minimumCountColumns: 2,
            clickToSelect: true,
            height: 500,
            uniqueId: "id",
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
                field: 'srcTemperature',
                title: '水温',
                align: 'center'
            },{
                field: 'srcPh',
                title: 'PH',
                align: 'center'
            },{
                field: 'srcChroma',
                title: '色度',
                align: 'center'
            },{
                field: 'srcLookable',
                title: '肉眼可见物',
                align: 'center'

            },{
                field: 'srcSmell',
                title: '臭和味',
                align: 'center'
            },{
                field: 'srcNtu',
                title: '浊度',
                align: 'center'
            },{
                field: 'srcCfu',
                title: '菌落总数',
                align: 'center'
            },{
                field: 'srcTotalColiforms',
                title: '总大肠菌群',
                align: 'center'
            },{
                field: 'srcHeatResistant',
                title: '耐热大肠菌',
                align: 'center'
            },{
                field: 'srcCod',
                title: '耗氧量',
                align: 'center'
            },{
                field: 'srcAmmonia',
                title: '氨氮',
                align: 'center'
            }]

        });

    };
        
    oTableInit.queryParams = function (params) {
        var temp = {
            limit: params.limit, //页面大小
            offset: params.offset //页码
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
           var list = $("table").bootstrapTable('getSelections');
          // console.log(list);
           if(list == null || list.length <= 0){
               toastr.warning("未选中任何项");
           }else{
               var idList = new Array();
               for(var i = 0;i < list.length;i++){
                   idList[i] = list[i].id;
               }
               console.log(idList);
               if(confirm("是否删除选中的数据?")){
                   $.ajax({
                       url: "sourcewater_deleteByList.action",
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
                           $("table").bootstrapTable('refresh');//重新加载表格
                       },
                       error:function(){
                           toastr.error("Error");                         
                       }
                   });
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
            var list = $("#tb_sourcewater").bootstrapTable('getSelections');
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
            
            //console.log(oModal);
            //向后台传送数据
            $.ajax({
                url: "sourcewater_update.action",
                type: "post",
                dataType : "json",
                data: {
                    "sourceModal" : JSON.stringify(oModal)
                },
                success: function (data) {
                    if(data.success){
                        toastr.success("修改成功!");
                    }
                    $("table").bootstrapTable('refresh');
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