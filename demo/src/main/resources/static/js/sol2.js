/********<<<<<<小工具集>>>>>>***************************/
/**
 * 复选框全选与取消
 */
$(document).on("click",".l-checkbox-all",function() {
	if (this.checked) {
		$("[class='l-checkbox']").prop("checked", true);
		$("[class='l-checkbox-all']").prop("checked", true);
	} else {
		$("[class='l-checkbox']").prop("checked", false);
		$("[class='l-checkbox-all']").prop("checked", false);
	}
});
/**
 * 验证是否选择了复选框返回选择的数量,如果没选择返回0
 */
function validataCheckBoxs(){
	var scount=$('.l-checkbox:checked').length;
	if(scount==0){
		layer.msg('请选择要操作的项目！', {time: 3000, offset: '200px'});
		return scount;
	}
	return scount;
}
/********<<<<<<从页面表格获取获取所需数据。获取id,获取数据对象等>>>>>>***************************/
var SolUtil={
	/**
	 * 获取选择项目的projectIds以指定格式分隔分隔,不传入则默认逗号分隔
	 * "200165,200165,......."
	 */
	getProjIds:function(type){
		var projectids='';
		if(!type){type=",";}
		$(".l-checkbox:checked").each(function(index) {
		    projectids=projectids+$(this).parents("tr").attr("data-id")+',';
		});
		return projectids;
	},
	/**
	 * 获取选择项目的data-*,对象数组格式
	 * 	0: "XXXXXX"
	 * 	1: "XXXXXX"
	 */
	getdataArray:function(datatag){
		var projectIds=[];
		$(".l-checkbox:checked").each(function(index) {
			var projectId=$(this).parents("tr").attr(datatag);
			projectIds.push(projectId);
		});
		return projectIds;
	},
	/**
	 * 获取复选框选择的业务所需数据,返回对象数组
	 * 列如传入data为:var data={projectId:"data-id",cname:"data-cName"}
	 * 则获取每条数据的 data-id的值赋值对象数据的值,而key沿用传入的key projectId
	 * Array(3)
	 * 	0: {projectId: "119430", cname: "2323"}
	 *  1: {projectId: "200165", cname: "22"}
	 *	2: {projectId: "200160", cname: "1"}
	 */
	getRawData:function(data){
		var records=[];
		$(".l-checkbox:checked").each(function(index,checkBox){
			var record = {};
			$.each(data,function(key,item){
				record[key] = $(checkBox).parents("tr").attr(item);
			})
			records.push(record);
		});
		return records;
	}
}





