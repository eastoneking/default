// JS工具对象
var textcheck = new function() {
	String.prototype.trim=function(){   
		var str = this.replace(/(^\s*)|(\s*$)/g, "");//首位空格替换为空
		reg = /\s/;
		//匹配空格
		if(str.match(reg)){
			return "";
		}
	    return str;    
	};
	/**
	 * str 字符串
	 * title 提示内容
	 *
	 */
	this.IsNull = function(strValue,title){

		var str = strValue.trim(); 
	    if(str.length==0){
	    	if(title){
	    		util.alert(title);
	    		return false;
	    	}else{
	    		util.alert("此字段不能为空");
	    		return false;
	    	}
	    } 
	    return true;
	};
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * 校验日期格式是否为yyyy-MM-dd
	 */
	this.IsDate = function(strValue,title){
		var result=false;
		var str = strValue.trim();    
		if(str.length!=0){    
	        var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;     
	        var r = str.match(reg);     
	        if(r!=null){
	        	return true;
	        } 
	        result=false;
	        if(title){
	        	util.alert(title);     
	        }else{
	        	util.alert("日期格式不正确");
	        }
	    }
		return result;
	};
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * 判断日期类型是否为YYYY-MM-DD hh:mm:ss格式的类型 
	 */
	this.IsDateTime = function(strValue,title){
		var result=false;
		var str = strValue.trim();    
		if(str.length!=0){    
			var reg =  /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;    
			var r = str.match(reg);     
			if(r!=null){
				return true;
			}
			result =false;
			if(title){
				util.alert(title);  
			}else{
				util.alert("日期格式不正确");
			}
		}
		return result;
	};
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * 判断输入的字符是否为英文字母    
	 */
	this.IsLetter = function(strValue,title)     
	{   
		var result=false;
	    var str = strValue.trim();    
	    if(str.length!=0){    
		    reg=/^[a-zA-Z]+$/;     
		    if(reg.test(str)){    
		        return true; 
		    }
		    result=false;
		    if(title){
				util.alert(title);    
			}else{
				util.alert("只能输入字母");
			}
	    } 
	    return result;
	}; 
	
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * 判断输入的字符是否为整数       
	 */
	this.IsInteger = function(strValue,title)     
	{       
		var result=false;
	    var str = strValue.trim();    
	    if(str.length!=0){    
		    reg=/^\d*$/;     
		    if(reg.test(str)){    
		        return true;
		    }
		    result=false;
		    if(title){
				util.alert(title);    
			}else{
				util.alert("对不起，请输入整数!");
			}
	    }  
	    return result;
	};
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * 判断输入是否为双进度数       
	 */
	this.IsDouble = function(strValue,title)     
	{       
		var result=false;
		var str = strValue.trim();    
		if(str.length!=0){    
			reg=/^\d+(\.\d+)?$/;     
			if(reg.test(str)){    
				return true;
			}
			result=false;
			if(title){
				util.alert(title);    
			}else{
				util.alert("对不起，请输入数字!");    
			}
		}
		return result;
	};
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * 判断输入是否为双进度数       
	 */
	this.IsDoublePes4 = function(strValue,title)     
	{       
		var result=false;
		var str = strValue.trim();    
		if(str.length!=0){    
			reg=/^\d+(\.\d{0,4})?$/;     
			if(reg.test(str)){    
				return true;
			}
			result=false;
			if(title){
				util.alert(title);    
			}else{
				util.alert("对不起，请输入数字!");    
			}
		}
		return result;
	};
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * 判断输入是否为双进度数       
	 */
	this.IsDoublePes2 = function(strValue,title)     
	{       
		var result=false;
		var str = strValue.trim();    
		if(str.length!=0){    
			reg=/^\d+(\.\d{0,2})?$/;     
			if(reg.test(str)){    
				return true;
			}
			result=false;
			if(title){
				util.alert(title);    
			}else{
				util.alert("对不起，请输入数字!");    
			}
		}
		return result;
	};
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * 判断输入是否为字母和数字       
	 */
	this.IsString = function(strValue,title)     
	{       
		var result=false;
		var str = strValue.trim();    
		if(str.length!=0){    
			reg=/^[a-zA-Z0-9_]+$/;     
			if(reg.test(str)){    
				return true;
			}
			result=false;
			if(title){
				util.alert(title);    
			}else{
				util.alert("对不起，只能输入字母和数字!");    
			}
		}   
		return result;
	};
	/**
	 * 紧判断是字符串和中文
	 */
	this.tightString = function(strValue,title)     
	{       
		var result=false;
		var str = strValue.trim();    
		if(str.length!=0){    
			reg=/^[a-zA-Z\u0391-\uFFE5]+$/;     
			if(reg.test(str)){    
				return true;
			}
			result=false;
			if(title){
				util.alert(title);    
			}else{
				util.alert("对不起，只能输入字母!");    
			}
		}   
		return false;
	};
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * 判断输入是否中文       
	 */
	this.IsChinese = function(strValue,title)     
	{     
		var result=false;
		var str = strValue.trim();    
		if(str.length!=0){    
			reg=/^[\u0391-\uFFE5]+$/;     
			if(reg.test(str)){    
				return true;
			}
			result=false;
			if(title){
				util.alert(title);    
			}else{
				util.alert("对不起，请输入中文!");    
			}
		}   
		return result;
	};
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * 判断输入是否为邮件格式     
	 */
	this.IsEmail = function(strValue,title)     
	{       
		var result=false;
		var str = strValue.trim();    
		if(str.length!=0){    
			reg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;     
			if(reg.test(str)){    
				return true;
			}
			result=false;
			if(title){
				util.alert(title);    
			}else{
				util.alert("对不起，您输入的邮件格式不正确!");    
			}
		}    
		return result;
	};
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * max 不能大于的值
	 * 判断输入不能大于某个值    
	 */
	this.MaxValue = function(strValue,title,max)     
	{       
		var result=false;
		var str = strValue.trim();
		if(!max){
			return false;
		}
		if(str.length!=0){    
			reg=/^\d+(\.\d+)?$/;   
//			reg=/^[-+]?\d*$/;     
			if(reg.test(str)){
				if(parseInt(str)<=parseInt(max)){
					return true;
				}
			}
			result=false;
			if(title){
				util.alert(title);    
			}else{
				util.alert("对不起，最大值为!"+max);    
			}
		}    
		return result;
	};
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * max 不能大于的值
	 * 判断输入不能小于某个值    
	 */
	this.minValue = function(strValue,title,min)     
	{       
		var result=false;
		var str = strValue.trim();
		if(!min){
			return false;
		}
		if(str.length!=0){    
			reg=/^\d+(\.\d+)?$/;     
			if(reg.test(str)){
				if(parseInt(str)>=parseInt(min)){
					return true;
				}
			}
			result=false;
			if(title){
				util.alert(title);    
			}else{
				util.alert("对不起，最小值为!"+min);    
			}
		}   
		return result;
	};
	
	/**
	 * str需要校验的值
	 * title不正确时的提示
	 * 手机号码     
	 */
	this.IsMobile = function(strValue,title)     
	{       
		var result=false;
		var str = strValue.trim();    
		if(str.length!=0){    
			reg=/^(13[0-9]{8})|(15[0-9]{8})|(18[0-9]{8})|(14[0-9]{8})$/;
			if(reg.test(str)){    
				return true;
			}
			result=false;
			if(title){
				util.alert(title);    
			}else{
				util.alert("对不起，您输入的手机号码格式不正确!");    
			}
		}    
		return result;
	};
	this.IsMobile2 = function(strValue,title)     
	{       
		var result=false;
		var str = strValue.trim();    
		if(str.length!=0){    
			reg=/^(13[0-9]{9})|(15[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})$/;
			if(reg.test(str)){    
				return true;
			}
			result=false;
			if(title){
				util.alert(title);    
			}
		}    
		return result;
	};
	
    
    
    
    var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];    // 加权因子   
    var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];            // 身份证验证位值.10代表X   
    this.IdCardValidate = function(idCard){ 
        idCard = idCard.replace(/ /g, "").trim();               //去掉字符串头尾空格                     
        if (idCard.length == 15) {   
            return this.isValidityBrithBy15IdCard(idCard);       //进行15位身份证的验证    
        } else if (idCard.length == 18) {   
        	var a_idCard = idCard.split("");                // 得到身份证数组   
            if(this.isValidityBrithBy18IdCard(idCard)&&this.isTrueValidateCodeBy18IdCard(a_idCard)){   //进行18位身份证的基本验证和第18位的验证
                return true;   
            }else {   
                return false;   
            }   
        } else {   
            return false;   
        }   
    };   
    /**  
     * 判断身份证号码为18位时最后的验证位是否正确  
     * @param a_idCard 身份证号码数组  
     * @return  
     */  
    this.isTrueValidateCodeBy18IdCard = function(a_idCard) {   
        var sum = 0;                             // 声明加权求和变量   
        if (a_idCard[17].toLowerCase() == 'x') {   
            a_idCard[17] = 10;                    // 将最后位为x的验证码替换为10方便后续操作   
        }   
        for ( var i = 0; i < 17; i++) {   
            sum += Wi[i] * a_idCard[i];            // 加权求和   
        }   
        valCodePosition = sum % 11;                // 得到验证码所位置   
        if (a_idCard[17] == ValideCode[valCodePosition]) {   
            return true;   
        } else {   
            return false;   
        }   
    };   
    /**  
      * 验证18位数身份证号码中的生日是否是有效生日  
      * @param idCard 18位书身份证字符串  
      * @return  
      */  
    this.isValidityBrithBy18IdCard = function(idCard18){   
        var year =  idCard18.substring(6,10);   
        var month = idCard18.substring(10,12);   
        var day = idCard18.substring(12,14);   
        var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
        // 这里用getFullYear()获取年份，避免千年虫问题   
        if(temp_date.getFullYear()!=parseFloat(year)   
              ||temp_date.getMonth()!=parseFloat(month)-1   
              ||temp_date.getDate()!=parseFloat(day)){   
                return false;   
        }else{   
            return true;   
        }   
    };   
      /**  
       * 验证15位数身份证号码中的生日是否是有效生日  
       * @param idCard15 15位书身份证字符串  
       * @return  
       */  
      this.isValidityBrithBy15IdCard = function(idCard15){   
          var year =  idCard15.substring(6,8);   
          var month = idCard15.substring(8,10);   
          var day = idCard15.substring(10,12);   
          var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
          // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法   
          if(temp_date.getYear()!=parseFloat(year)   
                  ||temp_date.getMonth()!=parseFloat(month)-1   
                  ||temp_date.getDate()!=parseFloat(day)){   
                    return false;   
            }else{   
                return true;   
            }   
      };  
      /**  
       * 比较两个日期的大小
       * @param date1 日期1  日期格式 yyyy-MM-dd
       * @param date2 日期2  日期格式 yyyy-MM-dd
       * @return  date1>date2 返回1  date1=date2 返回0 date1<date2 返回-1 为空时返回-2
       */  
      this.compareDate = function(date1,date2){
    	  var regEx = new RegExp("\\-","gi");
  		  if(!date1){
  			  return -2;
  		  }
  		  if(!date2){
  			  return -2;
  		  }
    	  var sdateStr = date1.replace(regEx,"/");//格式化date1
  		  var edateStr = date2.replace(regEx,"/");//格式化date2
  		  var sdateMilliseconds = Date.parse(sdateStr);//date1的毫米数
  		  var edateMilliseconds = Date.parse(edateStr);//date2的毫米数
  		  if(sdateMilliseconds>edateMilliseconds){
  			  return 1;
  		  }
  		  if(sdateMilliseconds==edateMilliseconds){
  			  return 0;
  		  }
  		  if(sdateMilliseconds<edateMilliseconds){
  			  return -1;
  		  }
      };
      /**  
       * 比较两个日期的大小
       * @param date1 日期1  日期格式 yyyy-MM-dd
       * @param date2 日期2  日期格式 yyyy-MM-dd
       * @return  date1>date2 返回1  date1=date2 返回0 date1<date2 返回-1 为空时返回-2
       */  
      this.compareDateTwo = function(date1,date2){
    	  if(!date1){
    		  return -2;
    	  }
    	  if(!date2){
    		  return -2;
    	  }
    	  var sdateStr = (new Date(date1)).format('yyyy/MM/dd');//格式化date1
    	  var edateStr = (new Date(date2)).format('yyyy/MM/dd');//格式化date2
    	  var sdateMilliseconds = Date.parse(sdateStr);//date1的毫秒数
    	  var edateMilliseconds = Date.parse(edateStr);//date2的毫秒数
    	  if(sdateMilliseconds>edateMilliseconds){
    		  return 1;
    	  }
    	  if(sdateMilliseconds==edateMilliseconds){
    		  return 0;
    	  }
    	  if(sdateMilliseconds<edateMilliseconds){
    		  return -1;
    	  }
      };
};
//小数位数的处理
function doubleNumber(Number, Count) {
	if (Count == undefined || Count == "undefined") {
		Count = 1;
	}
	var _count = 0;
	var _temp = "";
	if(Number){
		var str = Number.toString();
	}else{
		return 0;
	}
	if (str.indexOf(".") > 0) {
		var arr = str.split(".");
		if (arr[1].length >= Count) {
			return arr[0] + "." + arr[1].substr(0, Count);
		} else {
			_count = Count - arr[1].length;
			for (var i = 0; i < _count; i++) {
				_temp += "0";
			}
			return str + _temp;
		}
	} else {
		for (var i = 0; i < Count; i++) {
			_temp += "0";
		}
		return str + "." + _temp;
	}
}

Number.prototype.add = function(arg){   
    var r1,r2,m;   
    try{
    	r1=this.toString().split(".")[1].length;
    }catch(e){
    	r1=0;
    }   
    try{
    	r2=arg.toString().split(".")[1].length;
    }catch(e){
    	r2=0;
    }   
    m=Math.pow(10,Math.max(r1,r2));   
    return (this*m+arg*m)/m;   
} ;  
 
//减法   
Number.prototype.sub = function (arg){   
    return this.add(-arg);   
} ;  
 
//乘法   
Number.prototype.mul = function (arg)   
{   
    var m=0,s1=this.toString(),s2=arg.toString();   
    try{
    	m+=s1.split(".")[1].length;
    }catch(e){
    	
    }   
    try{
    	m+=s2.split(".")[1].length;
    }catch(e){
    	
    }   
    return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);
};   
 
//除法   
Number.prototype.div = function (arg){   
    var t1=0,t2=0,r1,r2;   
    try{
    	t1=this.toString().split(".")[1].length;
    }catch(e){
    	
    }   
    try{
    	t2=arg.toString().split(".")[1].length;
    }catch(e){
    	
    }   
    with(Math){   
        r1=Number(this.toString().replace(".",""));   
        r2=Number(arg.toString().replace(".",""));   
        return (r1/r2)*pow(10,t2-t1);   
    }
}; 
/**
 * 数字时返回以","隔开的字符串，不是数字时直接返回
 * @returns
 */
String.prototype.formatStrNum = function (){
    return this.replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,'); 
}; 
/**
 * 将","隔开的字符串，转为数字,字符串去掉"，"后如果不是数字则报错
 * @returns
 */
String.prototype.formatStrNumToNum = function (){
	var strNum = this.replace(/,/g,'');
	if(!strNum){
		return 0;
	}
	return parseFloat(strNum); 
}; 
/**
 * 返回以"，"隔开的字符串
 * @returns
 */
Number.prototype.formatStrNum = function() { 
	 return doubleNumber(this,2).replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,'); 
};

Array.prototype.contains = function(obj) { 
	for (var i = 0; i < this.length; i++) {
		if (this[i] === obj) { 
			  return i; 
		} 
	}
	return -1; 
};
