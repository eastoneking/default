(function(jq){
jq.fn.extend(
    {
      /**
       * 按钮插件.
       */
      button:(function(){
        
        /**
         * 按钮对象.
         * @constructor .
         */
        function Button(){
          
        }
        
        /**
         * 按钮默认配置.
         */
        Button.DEFAULT={};
        
        /**
         * Button插件的UUID.
         * <p>
         * 用于作为插件的唯一识别标志.
         * </p>
         */
        Button.UUID='7348EB23C54E5119917BB3263B4401C0';
        /**
         * 类型元数据.
         */
        Button.prototype.clz={
            UUID:Button.UUID
        }
        /*
         * button插件接口函数.
         */
        var interfaceFunction = function(){
          var object = jq.register("find", Button, this);
          
          var res = null;
          if(typeof arguments[0] == "string"){
            res = this.button.METHODS[arguments[0]]
              &&this.button.METHODS[arguments[0]].apply(
                  object,
                  jq.shift(arguments)
                );
          } else {
            res = this;
            object.init&&typeof object.init=="function"&&object.init.apply(object,arguments);
          }
          return res?res:this;
        };
        
        interfaceFunction.METHODS={
        };
        
        return interfaceFunction;
      })()
    }
);

})($ === jQuery ? $ : jQuery.noConflict());