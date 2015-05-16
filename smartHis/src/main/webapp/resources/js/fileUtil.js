//初始化文件
/**
 * 初始化文件，如果存在文件时显示在页面上
 * @param fileIds 文件id
 * @param onlyOneFile  是否单文件
 * @param entId   页面文件隐藏框id
 * @param buttonId   页面上传按钮id
 * @param callBack   完成后执行的函数，参数会返回到此函数中
 */
function initFile(fileIds,onlyOneFile,entId,buttonId,callBack){
	if(fileIds==null||fileIds==""){
		return;
	}
	
	var idArray ="";
	//如果是单个文件并且已经存在文件，则禁用按钮
	if(onlyOneFile&&fileIds!=null&&fileIds!=""){
		$("#imgFile").attr('disabled','disabled');
		$("#"+buttonId).attr('disabled','disabled');
	}
	//是id数组，处理成字符串
	if((typeof fileIds=='object')&&fileIds.constructor==Array){
		idArray = fileIds;
		for (var int = 0; int < fileIds.length; int++) {
			if(idArray==""){
				idArray = fileIds[i];
			}else{
				idArray = idArray+","+idArray[i];
			}
			
		}
	}
	//是以“,”隔开的id字符串时不处理
	if( (typeof fileIds=='string')&&fileIds.constructor==String){
		idArray = fileIds;
	}
	//初始化文件id
	var fileIdArray = [];
	$.ajax({
		url : global_param.context_name + "/fileManager/fileQueryByIds",
		data : "ids=" + idArray,
//		async:false,
		success : function(json) {
			for (var j = 0; j < json.length; j++) {
				var data = json[j];
				//将文件id设置到页面
				var tempid="";
				if($("#"+entId).val()==null||$("#"+entId).val()==""){
					tempid = "";
					$("#"+entId).val(data.id);
				}else{
					tempid = $("#"+entId).val();
					$("#"+entId).val(tempid+","+data.id);
				}
				
				$("#fileRecord").append(
						"<p><span><a href='" + global_param.context_name + "/fileManager/fileDownload?id=" + data.id + "'>" + decodeURI(data.oldFileName)
						+ "</a></span>&nbsp&nbsp&nbsp<span><a href='#' onclick='fileDelete(this," + data.id + ")'>删除</a></span></p>");
				fileIdArray.push(data.id);
			}
			if(callBack){
				callBack($("#"+entId).val());
			}
		}
	});
}

/**
 * 
 * @param id   文件选择框id
 * @param single 
 * @param callBack
 * @param onlyOneFile  是否为单文件
 * @param buttonId    上传按钮id
 * @param hiddenId    文件隐藏域id用来保存文件id（必填）
 */
// 上传
function fileUpload(id, callBack,onlyOneFile,buttonId,hiddenId) {
	if($("#"+id).val()==""||$("#"+id).val()==null){
		return;
	}
	if(hiddenId==null||hiddenId==""){
		alert("无法保存文件id");
	}
	id = id || 'imgFile';
	$.ajaxFileUpload({
		url : global_param.context_name + "/fileManager/fileUpload", // 需要链接到服务器地址
		secureuri : false,
		fileElementId : id, // 文件选择框的id属性
		dataType : 'json', // 服务器返回的格式
		success : function(data, status) {
			//禁用按钮和上传文件框
			if(onlyOneFile){
				$("#"+id).attr('disabled','disabled');
				if(buttonId){
					$("#"+buttonId).attr('disabled','disabled');
				}
			}
			//将文件id设置到页面
			var tempid="";
			if($("#"+hiddenId).val()==null||$("#"+hiddenId).val()==""){
				tempid = "";
				$("#"+hiddenId).val(data.id);
			}else{
				tempid = $("#"+hiddenId).val();
				$("#"+hiddenId).val(tempid+","+data.id);
			}
			//展示已经上传的文件
			$("#fileRecord").append(
					"<p><span><a href='" + global_param.context_name + "/fileManager/fileDownload?id=" + data.id + "'>" + decodeURI(data.oldFileName)
							+ "</a></span>&nbsp&nbsp&nbsp<span><a href='#' onclick='fileDelete(this," + data.id + ",\""+id+"\",\""+buttonId+"\",\""+hiddenId+"\")'>删除</a></span></p>");
			if (callBack) {callBack(data.id)};
		},
		error : function(data, status, e) {
			alert(e);
			alert("error");
		}
	});
}
/**
 * 
 * @param event  事件
 * @param id   需要删除的文件的id
 * @param entId  文件上传框的id
 * @param buttonId   上传按钮的id
 */
function fileDelete(event, id,entId,buttonId,hiddenId) {
	$.ajax({
		url : global_param.context_name + "/fileManager/fileDelete",
		data : "id=" + id,
		success : function(html) {
			event.parentNode.parentNode.outerHTML = "";
			//取消禁用按钮和上传文件框
			if(entId){
				$("#"+entId).removeAttr('disabled','disabled');
			}
			if(buttonId){
				$("#"+buttonId).removeAttr('disabled','disabled');
			}
			
			//将文件id设置到页面
			var tempids="";
			var tempid="";
			if($("#"+hiddenId).val()!=null&&$("#"+hiddenId).val()!=""){
				tempids = $("#"+hiddenId).val();
				var tempArray = tempids.split(",");
				for (var i = 0; i < tempArray.length; i++) {
					if(tempArray[i]==id){
						//删除数组中从i开始的1项
						tempArray.splice(i,1);
					}else{
						if(tempid!=null&&tempid!=""){
							tempid = tempid+","+tempArray[i];
						}else{
							tempid = tempArray[i];
						}
					}
				}
				$("#"+hiddenId).val(tempid);
			}
			
		}
	});
}
function fileDownload() {
	window.open(global_param.context_name + "/fileManager/fileDownload?id=1");
}
/**
 * fileUpload.html onclick方法
 * @param id
 * @param callBack
 */
function fileUploadExcel(imgFile,callBack){
	$.ajaxFileUpload({
		url : global_param.context_name + "/upload/filedload", // 需要链接到服务器地址
		secureuri : false,
		fileElementId : imgFile, // 文件选择框的id属性
        dataType: 'result', //返回值类型 一般设置为json
		success : function(data, status) {
			if (callBack) {callBack(data);};
			if(data=='success'){
				alert("文件操作完毕！");
				$("#rewsult").html("运行完毕");
				$("#editWindow").window('close');
			}else{
					$("#comfig").html("以下用户不存在！");
					alert("存在用户不存在！存在的用户已经执行完毕！");
					var str=data.split(",");
					$("#resultCoed").html(str+"<br/>");
				}
				$("#editWindow").window('close');
		},
		error : function(data, status, e) {
			alert('操作有误');
			$("#editWindow").window('close');
		}
	});
}
