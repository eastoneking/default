/*
 * 
 */
(function(jq){
  jq.fn.extend({
    layout:(function(){
      /**
       * Border布局.
       */
      function Layout(){
      }
      /**
       * 类UUID.
       */
      Layout.UUID='F80074936B06E38A5BF363B21EE17C10';
      /**
       * 默认属性.
       */
      Layout.DEFAULTS={
          
      };
      //----成员属性--定义开始----------
      /**
       * 类元数据.
       */
      Layout.prototype.clz={
          UUID:Layout.UUID
      };
      /**
       * 业务对象可选项配置.
       * <p>对外配置接口.
       * </p>
       */
      Layout.prototype.options={};
      /**
       * 调整大小过程中，第一次按下鼠标左键时的位置.
       * <p>用于确定调整大小的方向是向内或向外.</p>
       */
      Layout.prototype.originOffset=undefined;
      //----成员属性--定义结束----------
      //----私有----成员方法----定义开始----
      //----私有----成员方法----定义结束----
      //----公共----成员方法----定义开始----
      /**
       * 初始化方法.
       */
      Layout.prototype.init=function(options){
        var target = $($.register("findTarget",Layout,this));
        jq.extend(this.options, Layout.DEFAULTS, options);

      };

      /**
       * 接口方法.
       */
      Layout.interfaceMethod = function(){
        var object = jq.register("find", Layout, this);
        var res = null;
        if(typeof arguments[0] == "string"){
          res = this.layout.METHODS[arguments[0]]
            &&this.layout.METHODS[arguments[0]].apply(
                object,
                jq.shift(arguments)
              );
        } else {
          res = this;
          object.init&&typeof object.init=="function"&&object.init.apply(object,arguments);
        }
        return res?res:this;
      };

      Layout.interfaceMethod.METHODS={
      };

      return Layout.interfaceMethod;
    })()
  });
})($ === jQuery ? $ : jQuery.noConflict());