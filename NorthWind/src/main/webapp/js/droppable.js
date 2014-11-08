/*
 * 
 */


(function(jq){
  jq.fn.extend({
    droppable:(function(){
      /**
       * 可拖拽类.
       */
      function Droppable(){
      }
      /**
       * 类UUID.
       */
      Droppable.UUID='08D04A8F622803A25BBFEA53F0F75104';
      /**
       * 默认属性.
       */
      Droppable.DEFAULTS={
        accept:"*",
        onDragenter:jq.noop,
        onDragover:jq.noop,
        onDragleave:jq.noop,
        onDrop:jq.noop
      };
      //----成员属性--定义开始----------
      /**
       * 类元数据.
       */
      Droppable.prototype.clz={
          UUID:Droppable.UUID
      };
      /**
       * 业务对象可选项配置.
       * <p>对外配置接口.
       * </p>
       */
      Droppable.prototype.options={};
      //----成员属性--定义结束----------
      //----私有----成员方法----定义开始----
      //----私有----成员方法----定义结束----
      //----公共----成员方法----定义开始----
      /**
       * 拖拽业务对象初始化.
       */
      Droppable.prototype.init=function(options){
        var target = $($.register("findTarget",Droppable,this));
        target.on("dragover",function(ev){ev.preventDefault();});//默认处理无法触发drop事件.

        jq.extend(this.options, Droppable.DEFAULTS, options);

        target.on("dragenter",this.options.onDragenter);
        target.on("dragover",this.options.onDragover);
        target.on("dragleave",this.options.onDragleave);
        
        target.on("drop", function(ev){
          var object = jq.register("find", Droppable, this);
          if(!$(this).draggable("context").target.is(object.options.accept)){
            ev.stopImmediatePropagation();
          }
        });
        
        target.on("drap", this.options.onDrag);
        
      };

      /**
       * 接口方法.
       */
      Droppable.interfaceMethod = function(){
        var object = jq.register("find", Droppable, this);
        var res = null;
        if(typeof arguments[0] == "string"){
          res = this.droppable.METHODS[arguments[0]]
            &&this.droppable.METHODS[arguments[0]].apply(
                object,
                jq.shift(arguments)
              );
        } else {
          res = this;
          object.init&&typeof object.init=="function"&&object.init.apply(object,arguments);
        }
        return res?res:this;
      };

      Droppable.interfaceMethod.METHODS={
      };

      return Droppable.interfaceMethod;
    })()
  });
})($ === jQuery ? $ : jQuery.noConflict());