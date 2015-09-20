 $(document).ready(function () {
	 
	$("#mytable").flexigrid({
		 url: 'hetongAction.do?method=getJsonList',
		 dataType: 'json',
		 colModel :[
		            {display:'<input type="checkbox" id="chHeader" class="clsHeader" onclick = "javascript:fnSelectAll()" />',name:'checkbox',width : 50, sortable : false,checkbox:true, align: 'center'},
					{display:'基站名称',name:'jzmc',width : 200, sortable : false, align: 'center'},
		            {display:'合同',name:'hetong',width : 100, sortable : false, align: 'center'},
		            {display:'期别',name:'jibie',width : 100, sortable : false, align: 'center'},
		            {display:'区域',name:'quyu',width : 100, sortable : false, align: 'center'},
		            {display:'镇区',name:'zhengqu',width : 100, sortable : false, align: 'center'},
		            {display:'面积(M2)',name:'mianji',width : 100, sortable : false, align: 'center'},
		            {display:'地址',name:'dizhi',width : 200, sortable : false, align: 'center'},
		            {display:'业主姓名',name:'yzmc',width : 100, sortable : false, align: 'center'},
		            {display:'业主电话',name:'yzdh',width : 150, sortable : false, align: 'center'}
		            ],
		            sortname: "RINO",  
		            sortorder: "desc",  
		            usepager: true,  
		            title: '未输入合同的基站',  
		            useRp: true,  
		            rp: 5,  
		            showTableToggleBtn: false,
		            width : '1320',
					height : '400',
		            showToggleBtn : false,
					autoload : true,
					singleSelect : true,
					showTableToggleBtn : true,  
					resizable : false,
					sortname : null,
					sortorder : 'desc'
	 });   	
	
});

 // 全选/反选
function fnSelectAll() {
     $('.clsHeader').each(function () {
         if ($(this).is(':checked')) {
             $(this).attr('checked', true);
             $(this).attr("checked", "checked")
             $('.row').each(function () {
                 $(this).attr('checked', true);
                 $(this).parent().parent().parent().addClass('trSelected');
             });
         }
         else {
           
             $(this).removeAttr("checked")
             $('.row').each(function () {
                 $(this).attr('checked', false);
                 $(this).parent().parent().parent().removeClass('trSelected');
             });

         }
     });
 }
// 设置选中当行，选中checkbox
 function singleRowCheck(chk) {
     var row = $(chk).parent().parent().parent();
     if ($(chk).is(':checked')) {
         $(chk).attr('checked', true);
         $(chk).parent().parent().parent().addClass('trSelected');
     }
     else {
         $(chk).attr('checked', false);
         $(chk).parent().parent().parent().removeClass('trSelected');
         $('.clsHeader').each(function () {
             $(this).removeAttr('checked');
         });
     }
 }
 //批量删除
 function doDelete(){
	var ids = "";
	$("input[name='mycheckbox']:checked").each(function(){
		ids += $(this).val()+",";
	});
	if(ids == "" || ids.length == 0){
		alert("请至少选择一条记录！");
		return false;
	}
	location.href = 'hetongAction.do?method=deletebach&pkes='+ids;
 }
 
 //修改
 function doUpdate(){
		var ids = "";
		var index = 0;
		$("input[name='mycheckbox']:checked").each(function(){
			ids += $(this).val()+",";
			index ++;
		});
		if(ids == "" || ids.length == 0){
			alert("请至少选择一条记录！");
			return false;
		}
		if(index >1){
			alert("只能选择一条记录！");
			return false;
		}
		location.href = 'hetongAction.do?method=queryVo&id='+ids;
 }