/*
 * 
 */
(function(jq) {
  jq.fn.extend({
    layout:(function() {
      /**
       * Border布局.
       * <p>
       * 在所选元素中添加子<code><div/></code>.
       * </p>
       * @constructor
       */
      function Layout(){
      }
      /**
       * 类UUID.
       */
      Layout.UUID = '5986A989-1BC0-1DB6-2A0A-C11066792052';
      /**
       * 默认属性.
       */
      Layout.DEFAULTS = {
          panels:[
            {name:"center"}
          ]
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
       * 中心Panel元素.
       */
      Layout.prototype.center=undefined;
      /**
       * 上部Panel元素.
       */
      Layout.prototype.north=undefined;
      /**
       * 下部Panel元素.
       */
      Layout.prototype.sorth=undefined;
      /**
       * 左部Panel元素.
       */
      Layout.prototype.west=undefined;
      /**
       * 右部Panel元素.
       */
      Layout.prototype.east=undefined;
      //----成员属性--定义结束----------
      //----私有----成员方法----定义开始----
      //----私有----成员方法----定义结束----
      //----公共----成员方法----定义开始----
      /**
       * 初始化方法.
       */
      Layout.prototype.init=function(options) {
        var target = $($.register("findTarget", this, Layout));
        jq.extend(this.options, Layout.DEFAULTS, options&&typeof options=="object"?options:{});
        
      };
      /**
       * .
       */
      Layout.prototype.binds=function(){
        $(this).bind("render",this.onRender);
      };
      /**
       * .
       */
      Layout.prototype.onRender=function(){
        
      };

      /**
       * 接口方法.
       */
      Layout.interfaceMethod = function(){
        var object = jq.register("find", this, Layout);
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