/**
 * 元素大小.
 */
function Size(target){
  this.width=0;
  this.height=0;
  this.outerWidth=0;
  this.outHeight=0;
  this.innerWidth=0;
  this.innerHeight=0;
  
  if(target){
    if(target instanceof jQuery){
    }else if(typeof target=="object"){
      target = jQuery(target);
    }else{
      return;
    }
    this.width=target.width();
    this.height=target.height();
    this.outerWidth=target.outerWidth();
    this.outerHeight=target.outerHeight();
    this.innerWidth=target.innerWidth();
    this.innerHeight=target.innerHeight();
  }
}
/**
 * 计算内部元素最大大小.
 * <p>innerWidth－$innerTarget.outerWidth+$innerTarget.width.
 * 只有width和height属性.</p>
 * @param $innerTarget 内部元素.
 */
Size.prototype.calcInnerElementMaxSize = function($innerTarget){
  var dW = $innerTarget.outerWidth()-$innerTarget.width();
  var dH = $innerTarget.outerHeight()-$innerTarget.height();
  var res = new Size();
  res.width=this.innerWidth-dW;
  res.height=this.innerHeight-dH;
  return res;
};

Size.prototype.applyTo=function($target){
  $target.width(this.width);
  $target.height(this.height);
};


(function(jq){
jq.extend({
  /**
   * 数组左移一位.
   * 返回新数组.
   * 支持arguments.
   */
  shift:function(){
    var res = [];
    try{
      var arg = arguments[0];
      var len = arg.length;
      if(len&&len>1){
        for(var i=1;i<len;i++){
          res[res.length]=arg[i];
        }
      }
    }catch(e){
      $.debug("warn",e.toString());
    }
    return res;
  },
  /**
   * 获取表达式的值.
   * <p>如果表达式为一个函数，则返回执行结果.</p>
   */
  v:function(val){
    if(val&&typeof val == "function"){
      val=val.apply(window,jq.shift(arguments));
    }
    return val;
  },
  vs:function(val){
    val = jq.v(val);
    if(val){
      if(!(val instanceof Array)){
        val = [val];
      }
    }else{
      val=[];
    }
    return val;
  },
  /**
   * 调试开关.
   * <p>
   * 预留的调试开关。代码中可以检测本开关，适当输出调试信息。
   * </p>
   */
  debugStatus : false,
  /**
   * 调试器.
   */
  debug : (function() {
    /**
     * 捉虫机.
     * @constructor .
     *              <p>
     *              <strong>That's a joke.</strong>
     *              </p>
     */
    function DebugRobot() {

    }
    /**
     * 是否处于调试状态.
     * 
     * @returns 是否处于调试状态.
     */
    DebugRobot.isDebug = function() {
      return jq.debugStatus;
    };

    DebugRobot.changeDebug = function(debugStatus) {
      jq.debugStatus = debugStatus;
    };

    DebugRobot.DEBUG_LEVEL = {
      "100" : "debug",
      "300" : "info",
      "500" : "warn",
      "700" : "error",
      "999" : "fatal"
    };

    DebugRobot.DEBUG_LEVEL_REVERSE = {
      "trace" : "100",
      "debug" : "100",
      "info" : "300",
      "warn" : "500",
      "error" : "700",
      "fatal" : "999"
    };

    DebugRobot.register = function(label, value) {
      if (typeof label == 'object') {
        value = label.value;
        label = label.label;
      }
      if (/^debug|info|warn|error|fatal|trace$/.test(label)) {
        return false;
      }
      if (/^100|300|500|700|999$/.test(value)) {
        return false;
      }
      DebugRobot.DEBUG_LEVEL[label] = value;
      DebugRobot.DEBUG_LEVEL_REVERSE[value] = label;
      return true;
    };
    /**
     * 记录调试信息.
     * @param msg 调试信息.
     * @param level 输出级别.
     * @returns (void).
     */
    DebugRobot.prototype.log = function(msg, level) {
      if (!level) {
        level = "info";
      }
      return this._output(msg, level);
    };

    /**
     * 输出消息.
     * 
     * @param msg
     *          输出的信息.
     * @param level
     *          日志级别(可选，默认值“info”).
     */
    DebugRobot.prototype._output = function(msg, level) {
      // TODO: 浏览器检查.
      if (console && console.log) {
        console.log(level+":"+msg)
      }else{
        alert(level+":"+msg);
      }
    };

    /*
     * Debug常量.
     */
    var _ROBOT = new DebugRobot();

    var interfaceFunction = function(func, msg, level) {
      jq.debug.METHODS[func].call(_ROBOT, msg, level);
    };

    interfaceFunction.METHODS = {
      debug : function(msg) {
        return _ROBOT.log(msg, "debug");
      },
      trace : function(msg) {
        return _ROBOT.log(msg, "trace");
      },
      info : function(msg) {
        return _ROBOT.log(msg, "info");
      },
      warn : function(msg) {
        return _ROBOT.log(msg, "warn");
      },
      error : function(msg) {
        return _ROBOT.log(msg, "error");
      },
      fatal : function(msg) {
        return _ROBOT.log(msg, "fatal");
      },
      idDebug : DebugRobot.isDebug,
      changeDebug : DebugRobot.changeDebug,
      register : DebugRobot.register
    };

    return interfaceFunction;
  })(),

  /**
   * 原型开关.
   * <p>
   * 原型开关被置为"true"意味着所有与服务器交互均采用访问静态资源的方式。 请求的参数被处理为请求URL的一部分。
   * </p>
   */
  demoStatus : false,
  isDemo : function() {
    return jq.demoStatus;
  },
  /**
   * 插件A,用于封装Ajax相关功能.
   * <p>
   * 
   * </p>
   */
  a : (function() {

    /**
     * Ajax工具类.
     * 
     * @constructor .
     */
    function AjaxUtils() {
    }
    /**
     * ajax请求默认值.
     */
    AjaxUtils.DEFAULTS = {
      type : "POST",
      accepts : "application/*",
      contentType : "application/json",
      dataType : "json",
      success : jq.noop,// function(data, textStatus, jqXHR){},
      error : function(jqXHR, textStatus, errorThrown) {
        $.isDemo() && alert("url:" + jqXHR + ";err:" + errorThrown + ";");
        $.debug("error", " [status:" + textStatus + "] " + errorThrown);
      },
      async : true,
      data : "{}",
      url : '#'
    };

    /**
     * 同步请求.
     * @param options 请求选项.
     * @returns 当用户指定了success方法时无返回值；当success方法没有返回时，如果请求成功返回服务器端返回数据解析后的对象.
     */
    AjaxUtils.sync = function(options) {
      var settings = jq.extend({}, AjaxUtils.DEFAULTS, options, {
        async : false
      });
      if (settings.success === jQuery.noop) {
        var res = undefined;
        settings.success = function(data) {
          res = data;
        };
        alert(JSON.stringify(settings))
        jq.ajax(settings);
        return res;
      } else {
        return jq.ajax(settings);
      }
    };

    /**
     * 异步请求.
     * @param options 请求选项.
     * @returns 无返回值.
     */
    AjaxUtils.async = function(options) {
      return jq.ajax(jq.extend({}, AjaxUtils.DEFAULTS, options, {
        async : true
      }));
    };

    /**
     * 加载脚本.
     * @param options 请求选项.
     * @returns 无返回值.
     */
    AjaxUtils.loadScript = function(options) {
      return AjaxUtils.sync(jq.extend({}, options, {
        dataType : 'script'
      }));
    };

    var AJAX_UTILS = new AjaxUtils();

    var interfaceFunc = function(options, url, parameter, callbackOnSuccess,
        callbackOnFailure) {
      /*
       * 当输入参数为一个对象时,代理jQuery.ajax()方法.
       */
      if (typeof options == 'object') {
        return $.ajax(options);
      }
      var method = undefined;
      if (typeof options == 'string') {
        method = jq.a.METHODS[options];
      } else {
        return undefined;
      }

      var args = {};
      if (callbackOnFailure) {
        args.error = callbackOnFailure;
      }
      if (callbackOnSuccess) {
        args.success = callbackOnSuccess;
      }
      if (parameter) {
        args.data = JSON.stringify(parameter);
      }
      if (url) {
        args.url = url;
      }
      return method.call(AJAX_UTILS, args);
    };

    interfaceFunc.METHODS = {
      "sync" : function() {
        return AjaxUtils.sync.apply({}, arguments);
      },
      "async" : function() {
        return AjaxUtils.async.apply({}, arguments);
      },
      "loadScript" : function() {
        return AjaxUtils.loadScript.apply({}, arguments);
      },
      "postJson" : function(setting){
        var defaultSetting = 
            {
              type:"POST",
              accepts:"text/*",
              contentType:"application/json",
              dataType:"json"
            };
          
        return AjaxUtils.sync.call({}, jq.extend({},defaultSetting, setting));
      },
      "postJsonA" : function(setting){
        var defaultSetting = 
        {
          type:"POST",
          accepts:"text/*",
          contentType:"application/json",
          dataType:"json"
        };
      
    return AjaxUtils.async.call({}, jq.extend({},defaultSetting, setting));
  }
    };
    return interfaceFunc;
  })(),
  /**
   * 日期工具插件.
   */
  dateUtils:(function(){
    
    /**
     * 日期工具类.
     * @constructor .
     */
    function DateUtils(){};
    
    /**
     * 一天中的毫秒数(86400000).
     */
    DateUtils.MICRO_SECONDS_OF_A_DAY=86400000;
    
    /**
     * 两个时间之间的时间差.
     * @param t1 {Date} 被减日期.
     * @param t2 {Date} 减数日期.
     * @returns {Number} t1与t2之间相差的天数.
     */
    DateUtils.diff = function(t1,t2){
      var t1value = t1.getTime();
      var t2value = (t2?t2.getTime():jq.now());
      return (t1value-t2value)/DateUtils.MICRO_SECONDS_OF_A_DAY;
    };
    
    var MONTH_SORT_ZHCN = ['一','二','三','四','五','六',
                      '七','八','九','十','十一','十二'];
    var MONTH_LONG_ZHCN = ['一月','二月','三月',
                      '四月','五月','六月',
                      '七月','八月','九月',
                      '十月','十一月','十二月'];
    
    
    var MONTH_SORT = ['Jan','Feb','Mar','Apr','May','Jun',
                      'Jul','Aug','Sep','Oct','Nov','Dec'];
    var MONTH_LONG = ['January','February','March',
                      'April','May','June',
                      'July','August','September',
                      'October','November','December'];
    
    var WEEK_DAY_SORT = ['Sun','Mon','Tue','Wed','Thu','Fri','Sat'];
    var WEEK_DAY_LONG = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];
    var WEEK_DAY_SORT_ZHCN = ['日','一','二','三','四','五','六'];
    var WEEK_DAY_LONG_ZHCN = ['周日','周一','周二','周三','周四','周五','周六'];
    
    
    DateUtils.format = function(date, format){
      if(!format){
        format = 'YYYY-MM-DD';
      }
      var res = format;
      res = res.replace(/YYYY/g, date.getFullYear());
      res = res.replace(/YY/g, date.getFullYear()%100);
      var month = date.getMonth()+1;
      
      res = res.replace(/MMMM\.zhCN/g, MONTH_LONG_ZHCN[month-1]);
      res = res.replace(/MMM\.zhCN/g, MONTH_SORT_ZHCN[month-1]);
      
      res = res.replace(/MMMM/g, MONTH_LONG[month-1]);
      res = res.replace(/MMM/g, MONTH_SORT[month-1]);
      res = res.replace(/MM/g, (month<10?'0':'')+month);
      res = res.replace(/M/g, month);
      var day = date.getDate();
      res = res.replace(/DD/g, (day<10?'0':'')+day);
      res = res.replace(/D/g,day);

      var weekday = date.getDay();
      res = res.replace(/ww/g, weekday);
      res = res.replace(/w/g, weekday);

      res = res.replace(/WWWW\.zhCN/g, WEEK_DAY_LONG_ZHCN[weekday]);
      res = res.replace(/WWW\.zhCN/g, WEEK_DAY_SORT_ZHCN[weekday]);
      
      res = res.replace(/WWWW/g, WEEK_DAY_LONG[weekday]);
      res = res.replace(/WWW/g, WEEK_DAY_SORT[weekday]);
      
      
      var hours = date.getHours();
      res = res.replace(/HH/g,(hours<10?'0':'')+hours);
      res = res.replace(/H/g, hours);
      if(hours>12){
        hours-=12;
      }
      res = res.replace(/hh/g, (hours<10?'0':'')+hours);
      res = res.replace(/h/g, hours);
      var mi = date.getMinutes();
      res = res.replace(/mm/g, (mi<10?'0':'')+mi);
      res = res.replace(/m/g, mi);
      var se = date.getSeconds();
      res = res.replace(/ss/g,(se<10?'0':'')+se);
      res = res.replace(/s/g,se);
      var ms = date.getMilliseconds();
      res = res.replace(/SSS/g,(ms<100?'0':'')+(ms<10?'0':'')+ms);
      res = res.replace(/S/g,ms);
      
      
      
      return res;
    };
    
    DateUtils.parse = function(str){
      var res = new Date();
      str = jq.trim(str);
      if(str.length==10){
        str=str+" 00:00:00.000";
      }else if(str.length>10){
        str="1970-01-01 "+str;
      }
      res.setFullYear(str.substring(0,4));
      res.setMonth(new Number(str.substring(5,7).replace(/^0/,''))-1);
      res.setDate(new Number(str.substring(8,10).replace(/^0/,'')));
      res.setHours(new Number(str.substring(11,13).replace(/^0/,'')));
      res.setMinutes(new Number(str.substring(14,16).replace(/^0/,'')));
      res.setSeconds(new Number(str.substring(17,19).replace(/^0/,'')));
      res.setMilliseconds(new Number(str.substring(20,23).replace(/^0/,'').replace(/^0/,'')));
      
      return res;
    }
    
    var DATE_UTILS = new DateUtils();
    
    /**
     * 接口函数.
     */
    var interfaceFunc = function(func){
      var args = [];
      var len = arguments.length;
      for(var i=1;i<len;i++){
        args[args.length]=arguments[i];
      }
      return jq.dateUtils.METHODS[func].apply(DATE_UTILS,args);
    };
    
    interfaceFunc.METHODS={
        diff:function(){return DateUtils.diff.apply(DATE_UTILS, arguments);},
        format:function(){return DateUtils.format.apply(DATE_UTILS, arguments);},
        parse:function(){return DateUtils.parse.apply(DATE_UTILS, arguments);}
    };
    
    return interfaceFunc;
  })(),
  /**
   * 数字工具插件.
   * <p>
   * 主要完成数字格式化的工作.
   * </p>
   */
  numberUtils:(function(){
    /**
     * 数字工具类.
     * @constructor .
     */
    function NumberUtils(){}
    
    /**
     * 默认配置.
     * $-999,000.000999
     */
    NumberUtils.DEFAULTS={
        
    };
    
    var _find_separator = function(fmt){
      var res="";
      var flag = false;
      for(var i=0;i<fmt.length;i++){
        var cur = fmt.charAt(i);
        if(!(cur=='0'||cur=='9')){
          flag=true;
          res+=cur;
        }else if(flag){
          break;
        }
      }
      return res;
    };
    
    NumberUtils.format=function(num,format){
      
      if(!format){
        format = "0";
      }
      
      var str = format;
      var baseStr = new Number(num).toString();
      var idxFormatPoint = str.indexOf(".");
      var idxBasePoint = baseStr.indexOf(".");
      
      if(idxFormatPoint<0){
        idxFormatPoint=str.length;
      }
      
      if(idxBasePoint<0){
        idxBasePoint=baseStr.length;
      }
      
      var fmtWhole = format.substr(0,idxFormatPoint);
      var fmtFractional = format.substr(idxFormatPoint);
      var strWhole = baseStr.substr(0,idxBasePoint);
      var strFractional = baseStr.substr(idxBasePoint+1);
      
      if(fmtWhole==""){//支持.0格式写法
        fmtWhole="0";
      }
      
      var res = "";
      //处理整数部分
      var idx0_fmt = fmtWhole.indexOf("0");
      var idx9_fmt = fmtWhole.indexOf("9");
      
      if(idx0_fmt<0){
        idx0_fmt =fmtWhole.length;
      }
      
      if(idx9_fmt<0){
        idx9_fmt = fmtWhole.length;
      }
      
      var idxStart = (idx0_fmt<idx9_fmt?idx0_fmt:idx9_fmt);
      res += fmtWhole.substr(0,idxStart);
       
      fmtWhole=fmtWhole.substr(idxStart);
      
      var suffix = "";//后缀
      if(fmtFractional.length==0){
        var idxLast0 = fmtWhole.lastIndexOf('0');
        var idxLast9 = fmtWhole.lastIndexOf('9');
        
        if(idxLast0<0){
          idxLast0=fmtWhole.length;
        }
        if(idxLast9<0){
          idxLast9=fmtWhole.length;
        }
        
        var idxLastNum=(idxLast0>idxLast9?idxLast0:idxLast9);//最后一个非数字格式
        
        suffix = fmtWhole.substr(idxLastNum+1);//小数部分后缀
        
        fmtWhole=fmtWhole.substr(0,fmtWhole.length-suffix.length);
        
      }
      
      var whole = "";
      var len = strWhole.length;
      var pos = fmtWhole.length-1;//整数部分格式当前位 位置，右侧压栈
      var separator = _find_separator(fmtWhole);
      for(var i=0;i<len;i++){
        var char = strWhole.charAt(len-1-i);
        var f = fmtWhole.charAt(pos);
        while(!(f=='0'||f=='9')){
          whole = f+whole;
          pos--;
          if(pos<0){
            whole = separator+whole;
            fmtWhole=fmtWhole.replace(/0/g,'9');
            pos=fmtWhole.length-1;
          }
          f = fmtWhole.charAt(pos);
        }
        pos--;
        
        whole = char+whole;
        
      }
      
      fmtWhole=fmtWhole.substr(0,pos+1).replace(/9/g,"");
      whole = fmtWhole+whole;
      if(whole.indexOf(separator)==0){
        whole=whole.substr(separator.length);
      }
      
      res += whole;
      //处理整数部分结束
      //处理小数部分
      if(fmtFractional.indexOf('.')==0){//格式中包含小数点则处理小数部分，否则不处理.
        var idxLast0 = fmtFractional.lastIndexOf('0');
        var idxLast9 = fmtFractional.lastIndexOf('9');
        var idxLastNum = 0;
        if(idxLast0<0&&idxLast9<0){
          idxLastNum = 1;
        }else if((idxLast0<0&&idxLast9>=0)||(idxLast0>=0&&idxLast9<0)){
          idxLastNum = Math.max(idxLast0, idxLast9)+1;
        }else{
        if(idxLast0<0){
          idxLast0=fmtFractional.length;
        }
        if(idxLast9<0){
          idxLast9=fmtFractional.length;
        }
        
        idxLastNum=(idxLast0>idxLast9?idxLast0:idxLast9)+1;//最后一个非数字格式
        }
        
        if((!suffix)||suffix==''){
          suffix = fmtFractional.substr(idxLastNum);//小数部分后缀
        }
        
        fmtFractional=fmtFractional.substr(0,idxLastNum);
        if(fmtFractional=='.'){
          fmtFractional=strFractional.replace(/./g,'9');
        }else{
          fmtFractional=fmtFractional.substr(1);
        }
        var separator = _find_separator(fmtFractional);
        
        var fractional = "";
        var len = strFractional.length;
        var pos = 0;//小数部分格式当前位 位置，左侧压栈
        for(var i=0;i<len;i++){
          var char = strFractional.charAt(i);
          var f = fmtFractional.charAt(pos);
          while(!(f=='0'||f=='9')){
            fractional = fractional+f;
            pos++;
            if(pos>=fmtFractional.length){
              break;
            }
            f = fmtFractional.charAt(pos);
          }
          if(pos>=fmtFractional.length){
            break;
          }
          pos++;
          
          fractional = fractional+char;
          
        }
        var sub = fmtFractional.substr(pos).replace(/9/g,"");
        fractional = fractional + sub;
        //alert(fractional+":"+suffix)
        if(fractional.lastIndexOf(separator)==fractional.length-separator.length){
          fractional=fractional.substr(0,fractional.lastIndexOf(separator));
        }
        res +=('.'+fractional);
      }
      
      return res+suffix;
      
    };
    
    var NUMBER_UTILS = new NumberUtils();
    
    var interfaceFunc = function(options){
      var args = [];
      for(var i=1;i<arguments.length;i++){
        args[args.length]=arguments[i];
      }
      return jq.numberUtils.METHODS[options].apply(NUMBER_UTILS,args);
    };
    
    interfaceFunc.METHODS={
        format:function(){return NumberUtils.format.apply(NUMBER_UTILS,arguments);}
    };
    
    return interfaceFunc;
  })(),
  /**
   * 注册插件对象和业务对象之间的关系.
   */
  register:(function(){
    /**
     * 注册工具.
     * <p>用于将插件对象和插件业务对象关联起来。
     * 关联方式采用jQuery.data()方法.
     * </p>
     * @constructor .
     */
    function Register(){}
    
    Register.UUID='62C88DBEF29B8DB7A65298AB46E3929E';
    
    /**
     * 查找target参数对象关联的func插件的业务对象.
     * @param func 插件业务类型.
     * <p>需要func.UUID属性作为查找依据.</p>
     * @param target 需要查找管理的对象.
     * <p>此对象一般为DOM节点或其他经过jQuery封装的对象.</p>
     * @return 如果无法找到返回"undefined"或"null".
     */
    Register.find=function(func,target){
      var res = undefined;
      res = jq.data(target,func.UUID);
      return res;
    };
    /**
     * 设置两个对象之间的关联.
     * @param master 主对象.
     * @param key 关联关键字.
     * @param target 关联目标.
     * @returns 如果为设置关联,返回master;如果为获取关联,返回之前关联的target.
     */
    Register.ref=function(master, key, target){
      if(target){
        jq.data(master,key,target);
        return master;
      }else{
        return jq.data(master,key);
      }
    };
    /**
     * 获得与target相关的业务对象.
     * <p>
     * 如果没有关联的业务对象则实例化新的业务对象。
     * </p>
     * @param func 业务对象的构造函数.
     * @param target 目标元素.
     * @returns 与目标元素相关的业务对象.
     */
    Register.findOrNew=function(target, func){
      var res = undefined;
      if(target instanceof jQuery){
        target = target[0];
      }
      res = Register.find(func,target);
      if(!res){
        res = new func();
        jq.data(res, func.UUID, target);
        jq.data(target,func.UUID,res);
      }
      return res;
    }
    
    var REGISTER = Register();
    
    var interfaceFunction = function(options){
      return jq.register.METHODS[options].apply(REGISTER,jq.shift(arguments));
    };
    interfaceFunction.METHODS={
      find:function(){
        return Register.findOrNew.apply(REGISTER,arguments);
      },
      findTarget:function(object, func){
        return jq.data(object,func.UUID);
      },
      ref:function(master,key,target){
        return Register.ref.call(REGISTER,master,key,target);
      }
    };
    return interfaceFunction;
  })(),
  size:(function(){
    return new Size(this);
  })()
});
  jq.fn.extend(
    {
      addClasses:function(classes){
        if(classes instanceof Array){
          for(var i=0;i<classes.length;i++){
            this.addClass(classes[i]);
          }
        }
        return this;
      },
      addClassesEveryOne:function(classes){
        if(this.length>1){
          for(var i=0;i<this.length;i++){
            $(this[i]).addClass(classes[i%classes.length]);
          }
        }else{
          return this.addClasses(classes);
        }
        return this;
      }
    }
  );
})($ === jQuery ? $ : jQuery.noConflict());
