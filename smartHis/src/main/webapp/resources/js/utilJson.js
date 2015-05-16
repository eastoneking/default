// JS工具对象
var utilJson = new function() {
	this.formDataObject = function(formid){
		var formDataArray = $("#"+formid).serializeArray();
		var obj={};
		$.each(formDataArray,function(i,filed){
			obj[filed.name]=filed.value;
		});
		return obj;
	}
	 this.setFormVal= function(divid,param){
	    	var inputlist = $("#"+divid+" input[type=text]");//所有文本框
	    	var textarealist = $("#"+divid+" textarea");//所有文本域
//	    	var checkboxList=$("#"+divid+">input[type=checkbox]");//复选框
//	    	var radioList=$("#"+divid+">input[type=radio]");//单选框
//	    	var selectList=
	    	$.each(inputlist,function(i,obj){
	    		var id = obj.id;
	    		var name = obj.name;
	    		alert(param[id]);
	    		var val = name ? param[name] : param[id];
	    		$(obj).val(val);
	    	});
	    	$.each(textarealist,function(i,obj){
	    		var id = obj.id;
	    		var name = obj.name;
	    		if(name){
	    			$(obj).val(param[name]);
		  		}else{
		  			$(obj).val(param[id]);
		  		}
	    	});
//	    	$.each(checkboxList,function(i,checkbox){
//	    		var id= checkbox.id;
//	    		var name = checkbox.name;
//	    		if(name){
//	    			$(obj).val(param[name]);
//		  		}else{
//		  			$(obj).val(param[id]);
//		  		}
//	    	});
//	    	$.each(radioList,function(i,radio){
//	    		var id= radio.id;
//	    		var name = radio.name;
//	    	});
	    }
};