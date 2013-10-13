var DEBUG = false;
var ISDEMO = false;

var CONTEXT_PATH = "/bmnc";

var URL_CREATE_FILE = CONTEXT_PATH+"/CreateFileServlet";

function CreateFileRequest(filepath,filedata){
	this.filePath = filepath;
	this.fileData = filedata;
}

function createfile(path,data){
	$.ajax(
			{
				type:"POST",
				accepts:"text/json",
				contentType:"text/json",
				dataType:"json",
				success:function(res){
					alert(res&&res.message?res.message:res);},
				error:function(){alert(URL_CREATE_FILE+":"+$(this).responseText);},
				async:true,
				data:JSON.stringify(new CreateFileRequest(path,data)),
				url:URL_CREATE_FILE
				});
}

function loadScript(url){$.ajax({
	  async: false,
	  url: url,
	  dataType: 'script'
	});
}

function parseurl(url,objstr){
	if(ISDEMO){
		objstr =  objstr.replace(/\{/g,"");
		objstr =  objstr.replace(/\}/g,"");
		objstr =  objstr.replace(/\(/g,"");
		objstr =  objstr.replace(/\)/g,"");
		objstr =  objstr.replace(/\[/g,"");
		objstr =  objstr.replace(/\]/g,"");
		objstr =  objstr.replace(/\:/g,"");
		objstr =  objstr.replace(/\,/g,"");
		objstr =  objstr.replace(/\=/g,"");
		objstr =  objstr.replace(/\'/g,"");
		objstr =  objstr.replace(/\"/g,"");
		objstr =  objstr.replace(/\n/g,"");
		objstr =  objstr.replace(/\r/g,"");
		objstr =  objstr.replace(/\\/g,"");
	}
	var rec = (url.charAt(0)=='.'?"":((url.indexOf("http")||url.indexOf("."))==0?"":CONTEXT_PATH))+(ISDEMO?"/data":"")+url+(ISDEMO?(","+objstr+".json"):"");
	return rec;
}

function apost(url,data,succfunc,failfunc){
	 return post(true,url,data,succfunc,failfunc);
}

function spost(url,data,succfunc,failfunc){
	 return post(false,url,data,succfunc,failfunc);
}

function post(async,url,data,succfunc,failfunc){
	var objstr = JSON.stringify(data);
	var purl = parseurl(url,objstr);
	return $.ajax(
			{
				type:"POST",
				accepts:"text/*",
				contentType:"text/json",
				dataType:"json",
				success:succfunc,
				error:failfunc?failfunc:function(jqXHR, textStatus, errorThrown){
						if(ISDEMO)
							alert("url:"+purl+";err:"+errorThrown+";");
					},
				async:async,
				data:objstr,
				url:purl
			}
		);
}

function uploadForm(url,form,succfunc,failfunc){
	return form.ajaxSubmit({
		async:true,
		type:"POST",
		accepts:"text/*",
		contentType:false,
		processData: false,
		dataType:"json",
		url:url,
		success:succfunc,
		error:failfunc?failfunc:function(jqXHR, textStatus, errorThrown){
			if(ISDEMO)
				alert(";err:"+errorThrown+";");
		}
	});
}

function uploadfiles(url,fileinputlist,succfunc,failfunc){
	var formdata = new FormData();
	$(fileinputlist).each(
		function(i){
			var _field = this;
			$(this.files).each(
				function(){
					formdata.append(_field.name, this);
				}
			);
		}
	);
	return $.ajax(
			{
				type:"POST",
				accepts:"text/*",
				contentType:false,
				processData: false,
				dataType:"json",
				success:succfunc,
				error:failfunc?failfunc:function(jqXHR, textStatus, errorThrown){
						if(ISDEMO)
							alert(";err:"+errorThrown+";");
					},
				async:true,
				data:formdata,
				url:url
			}
		);
}

var DateUtil = function(){
    /**
    * 判断闰年
    * @param date Date日期对象
    * @return boolean true 或false
    */
    this.isLeapYear = function(date){
    return (0==date.getYear()%4&&((date.getYear()%100!=0)||(date.getYear()%400==0)));
    };
    /**
    * 日期对象转换为指定格式的字符串
    * @param f 日期格式,格式定义如下 yyyy-MM-dd HH:mm:ss
    * @param date Date日期对象, 如果缺省,则为当前时间
    *
    * YYYY/yyyy/YY/yy 表示年份
    * MM/M 月份
    * W/w 星期
    * dd/DD/d/D 日期
    * hh/HH/h/H 时间
    * mm/m 分钟
    * ss/SS/s/S 秒
    * @return string 指定格式的时间字符串
    */
    this.dateToStr = function(formatStr, date){
    formatStr = arguments[0] || "yyyy-MM-dd HH:mm:ss";
    date = arguments[1] || new Date();
    var str = formatStr;
    var Week = ['日','一','二','三','四','五','六'];
    str=str.replace(/yyyy|YYYY/,date.getFullYear());
    str=str.replace(/yy|YY/,(date.getYear() % 100)>9?(date.getYear() % 100).toString():'0' + (date.getYear() % 100));
    str=str.replace(/MM/,date.getMonth()>9?(date.getMonth() + 1):'0' + (date.getMonth() + 1));
    str=str.replace(/M/g,date.getMonth()+1);
    str=str.replace(/w|W/g,Week[date.getDay()]);
    str=str.replace(/dd|DD/,date.getDate()>9?date.getDate().toString():'0' + date.getDate());
    str=str.replace(/d|D/g,date.getDate());
    str=str.replace(/hh|HH/,date.getHours()>9?date.getHours().toString():'0' + date.getHours());
    str=str.replace(/h|H/g,date.getHours());
    str=str.replace(/mm/,date.getMinutes()>9?date.getMinutes().toString():'0' + date.getMinutes());
    str=str.replace(/m/g,date.getMinutes());
    str=str.replace(/ss|SS/,date.getSeconds()>9?date.getSeconds().toString():'0' + date.getSeconds());
    str=str.replace(/s|S/g,date.getSeconds());
    return str;
    }
    /**
    * 日期计算
    * @param strInterval string  可选值 y 年 m月 d日 w星期 ww周 h时 n分 s秒
    * @param num int
    * @param date Date 日期对象
    * @return Date 返回日期对象
    */
    this.dateAdd = function(strInterval, num, date){
    date =  arguments[2] || new Date();
    switch (strInterval) {
    case 's' :return new Date(date.getTime() + (1000 * num));
    case 'n' :return new Date(date.getTime() + (60000 * num));
    case 'h' :return new Date(date.getTime() + (3600000 * num));
    case 'd' :return new Date(date.getTime() + (86400000 * num));
    case 'w' :return new Date(date.getTime() + ((86400000 * 7) * num));
    case 'm' :return new Date(date.getFullYear(), (date.getMonth()) + num, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
    case 'y' :return new Date((date.getFullYear() + num), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
    }
    }
    /**
    * 比较日期差 dtEnd 格式为日期型或者有效日期格式字符串
    * @param strInterval string  可选值 y 年 m月 d日 w星期 ww周 h时 n分 s秒
    * @param dtStart Date  可选值 y 年 m月 d日 w星期 ww周 h时 n分 s秒
    * @param dtEnd Date  可选值 y 年 m月 d日 w星期 ww周 h时 n分 s秒
    */
    this.dateDiff = function(strInterval, dtStart, dtEnd) {
    switch (strInterval) {
    case 's' :return parseInt((dtEnd - dtStart) / 1000);
    case 'n' :return parseInt((dtEnd - dtStart) / 60000);
    case 'h' :return parseInt((dtEnd - dtStart) / 3600000);
    case 'd' :return parseInt((dtEnd - dtStart) / 86400000);
    case 'w' :return parseInt((dtEnd - dtStart) / (86400000 * 7));
    case 'm' :return (dtEnd.getMonth()+1)+((dtEnd.getFullYear()-dtStart.getFullYear())*12) - (dtStart.getMonth()+1);
    case 'y' :return dtEnd.getFullYear() - dtStart.getFullYear();
    }
    }
    /**
    * 字符串转换为日期对象
    * @param date Date 格式为yyyy-MM-dd HH:mm:ss,必须按年月日时分秒的顺序,中间分隔符不限制
    */
    this.strToDate = function(dateStr){
    var data = dateStr;
    var reCat = /(\d{1,4})/gm;
    var t = data.match(reCat);
    t[1] = t[1] - 1;
    eval('var d = new Date('+t.join(',')+');');
    return d;
    }
    /**
    * 把指定格式的字符串转换为日期对象yyyy-MM-dd HH:mm:ss
    *
    */
    this.strFormatToDate = function(formatStr, dateStr){
    var year = 0;
    var start = -1;
    var len = dateStr.length;
    if((start = formatStr.indexOf('yyyy')) > -1 && start < len){
    year = dateStr.substr(start, 4);
    }
    var month = 0;
    if((start = formatStr.indexOf('MM')) > -1  && start < len){
    month = parseInt(dateStr.substr(start, 2)) - 1;
    }
    var day = 0;
    if((start = formatStr.indexOf('dd')) > -1 && start < len){
    day = parseInt(dateStr.substr(start, 2));
    }
    var hour = 0;
    if( ((start = formatStr.indexOf('HH')) > -1 || (start = formatStr.indexOf('hh')) > 1) && start < len){
    hour = parseInt(dateStr.substr(start, 2));
    }
    var minute = 0;
    if((start = formatStr.indexOf('mm')) > -1  && start < len){
    minute = dateStr.substr(start, 2);
    }
    var second = 0;
    if((start = formatStr.indexOf('ss')) > -1  && start < len){
    second = dateStr.substr(start, 2);
    }
    return new Date(year, month, day, hour, minute, second);
    }
    /**
    * 日期对象转换为毫秒数
    */
    this.dateToLong = function(date){
    return date.getTime();
    }
    /**
    * 毫秒转换为日期对象
    * @param dateVal number 日期的毫秒数
    */
    this.longToDate = function(dateVal){
    return new Date(dateVal);
    }
    /**
    * 判断字符串是否为日期格式
    * @param str string 字符串
    * @param formatStr string 日期格式, 如下 yyyy-MM-dd
    */
    this.isDate = function(str, formatStr){
    if (formatStr == null){
    formatStr = "yyyyMMdd";
    }
    var yIndex = formatStr.indexOf("yyyy");
    if(yIndex==-1){
    return false;
    }
    var year = str.substring(yIndex,yIndex+4);
    var mIndex = formatStr.indexOf("MM");
    if(mIndex==-1){
    return false;
    }
    var month = str.substring(mIndex,mIndex+2);
    var dIndex = formatStr.indexOf("dd");
    if(dIndex==-1){
    return false;
    }
    var day = str.substring(dIndex,dIndex+2);
    if(!isNumber(year)||year>"2100" || year< "1900"){
    return false;
    }
    if(!isNumber(month)||month>"12" || month< "01"){
    return false;
    }
    if(day>getMaxDay(year,month) || day< "01"){
    return false;
    }
    return true;
    }
    this.getMaxDay = function(year,month) {
    if(month==4||month==6||month==9||month==11)
    return "30";
    if(month==2)
    if(year%4==0&&year%100!=0 || year%400==0)
    return "29";
    else
    return "28";
    return "31";
    }
    /**
    *    变量是否为数字
    */
    this.isNumber = function(str)
    {
    var regExp = /^\d+$/g;
    return regExp.test(str);
    }
    /**
    * 把日期分割成数组 [年、月、日、时、分、秒]
    */
    this.toArray = function(myDate)
    {
    myDate = arguments[0] || new Date();
    var myArray = Array();
    myArray[0] = myDate.getFullYear();
    myArray[1] = myDate.getMonth();
    myArray[2] = myDate.getDate();
    myArray[3] = myDate.getHours();
    myArray[4] = myDate.getMinutes();
    myArray[5] = myDate.getSeconds();
    return myArray;
    }
    /**
    * 取得日期数据信息
    * 参数 interval 表示数据类型
    * y 年 M月 d日 w星期 ww周 h时 n分 s秒
    */
    this.datePart = function(interval, myDate)
    {
    myDate = arguments[1] || new Date();
    var partStr='';
    var Week = ['日','一','二','三','四','五','六'];
    switch (interval)
    {
    case 'y' :partStr = myDate.getFullYear();break;
    case 'M' :partStr = myDate.getMonth()+1;break;
    case 'd' :partStr = myDate.getDate();break;
    case 'w' :partStr = Week[myDate.getDay()];break;
    case 'ww' :partStr = myDate.WeekNumOfYear();break;
    case 'h' :partStr = myDate.getHours();break;
    case 'm' :partStr = myDate.getMinutes();break;
    case 's' :partStr = myDate.getSeconds();break;
    }
    return partStr;
    }
    /**
    * 取得当前日期所在月的最大天数
    */
    this.maxDayOfDate = function(date)
    {
    date = arguments[0] || new Date();
    date.setDate(1);
    date.setMonth(date.getMonth() + 1);
    var time = date.getTime() - 24 * 60 * 60 * 1000;
    var newDate = new Date(time);
    return newDate.getDate();
    }
    return this;
    }();


///////////////////accounting.js start/////////////////
/*!
* accounting.js v0.3.2, copyright 2011 Joss Crowcroft, MIT license, http://josscrowcroft.github.com/accounting.js
*/
(function(p,z){function q(a){return!!(""===a||a&&a.charCodeAt&&a.substr)}function m(a){return u?u(a):"[object Array]"===v.call(a)}function r(a){return"[object Object]"===v.call(a)}function s(a,b){var d,a=a||{},b=b||{};for(d in b)b.hasOwnProperty(d)&&null==a[d]&&(a[d]=b[d]);return a}function j(a,b,d){var c=[],e,h;if(!a)return c;if(w&&a.map===w)return a.map(b,d);for(e=0,h=a.length;e<h;e++)c[e]=b.call(d,a[e],e,a);return c}function n(a,b){a=Math.round(Math.abs(a));return isNaN(a)?b:a}function x(a){var b=c.settings.currency.format;"function"===typeof a&&(a=a());return q(a)&&a.match("%v")?{pos:a,neg:a.replace("-","").replace("%v","-%v"),zero:a}:!a||!a.pos||!a.pos.match("%v")?!q(b)?b:c.settings.currency.format={pos:b,neg:b.replace("%v","-%v"),zero:b}:a}var c={version:"0.3.2",settings:{currency:{symbol:"$",format:"%s%v",decimal:".",thousand:",",precision:2,grouping:3},number:{precision:0,grouping:3,thousand:",",decimal:"."}}},w=Array.prototype.map,u=Array.isArray,v=Object.prototype.toString,o=c.unformat=c.parse=function(a,b){if(m(a))return j(a,function(a){return o(a,b)});a=a||0;if("number"===typeof a)return a;var b=b||".",c=RegExp("[^0-9-"+b+"]",["g"]),c=parseFloat((""+a).replace(/\((.*)\)/,"-$1").replace(c,"").replace(b,"."));return!isNaN(c)?c:0},y=c.toFixed=function(a,b){var b=n(b,c.settings.number.precision),d=Math.pow(10,b);return(Math.round(c.unformat(a)*d)/d).toFixed(b)},t=c.formatNumber=function(a,b,d,i){if(m(a))return j(a,function(a){return t(a,b,d,i)});var a=o(a),e=s(r(b)?b:{precision:b,thousand:d,decimal:i},c.settings.number),h=n(e.precision),f=0>a?"-":"",g=parseInt(y(Math.abs(a||0),h),10)+"",l=3<g.length?g.length%3:0;return f+(l?g.substr(0,l)+e.thousand:"")+g.substr(l).replace(/(\d{3})(?=\d)/g,"$1"+e.thousand)+(h?e.decimal+y(Math.abs(a),h).split(".")[1]:"")},A=c.formatMoney=function(a,b,d,i,e,h){if(m(a))return j(a,function(a){return A(a,b,d,i,e,h)});var a=o(a),f=s(r(b)?b:{symbol:b,precision:d,thousand:i,decimal:e,format:h},c.settings.currency),g=x(f.format);return(0<a?g.pos:0>a?g.neg:g.zero).replace("%s",f.symbol).replace("%v",t(Math.abs(a),n(f.precision),f.thousand,f.decimal))};c.formatColumn=function(a,b,d,i,e,h){if(!a)return[];var f=s(r(b)?b:{symbol:b,precision:d,thousand:i,decimal:e,format:h},c.settings.currency),g=x(f.format),l=g.pos.indexOf("%s")<g.pos.indexOf("%v")?!0:!1,k=0,a=j(a,function(a){if(m(a))return c.formatColumn(a,f);a=o(a);a=(0<a?g.pos:0>a?g.neg:g.zero).replace("%s",f.symbol).replace("%v",t(Math.abs(a),n(f.precision),f.thousand,f.decimal));if(a.length>k)k=a.length;return a});return j(a,function(a){return q(a)&&a.length<k?l?a.replace(f.symbol,f.symbol+Array(k-a.length+1).join(" ")):Array(k-a.length+1).join(" ")+a:a})};if("undefined"!==typeof exports){if("undefined"!==typeof module&&module.exports)exports=module.exports=c;exports.accounting=c}else"function"===typeof define&&define.amd?define([],function(){return c}):(c.noConflict=function(a){return function(){p.accounting=a;c.noConflict=z;return c}}(p.accounting),p.accounting=c)})(this);


var NumberFormat = accounting;
//////////////////accounting.js end///////////////////////

