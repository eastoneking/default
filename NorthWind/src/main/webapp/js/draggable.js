/*
 * .
 */

(function(jq){
  jq.fn.extend({
    draggable:(function(){
      
      var CURRENT_DRAG_CONTEXT = {
          target:undefined
      };
      
      /**
       * 可拖拽类.
       */
      function Draggable(){
      }
      /**
       * 类UUID.
       */
      Draggable.UUID='A4E725B60F7ECA6C54B5FA45659BC89E';
      /**
       * 默认属性.
       */
      Draggable.DEFAULTS={
        /**
         * 在拖拽过程中的跟随对象.
         */
        following:undefined,
        onDragstart:jq.noop,
        onDragend:jq.noop,
        onDrag:jq.noop
      };
      
      /**
       * 在拖拽开始时保存拖拽初始状态到业务对象.
       * @param e 拖拽事件.
       */
      Draggable.onDragStartSaveStatus = function(e){
        
        var target = $(this);
        var object = $.register("find", Draggable, target);
        
        CURRENT_DRAG_CONTEXT.target = target;
        
        var targetOffset=target.offset();
        var mouseOffset={left:event.pageX,top:event.pageY};
        jq.extend(object.status.start,{
          targetOffset:targetOffset,
          mouseOffset:mouseOffset
        });
        
        object.followingElement = object._createFollowing();
        if(object.followingElement){
          $("body").append(object.followingElement);
        }
        if(object.followingElement){
          object.followingElement.offset({left:mouseOffset.left+1,top:mouseOffset.top+1});
        }
      };
      /**
       * 拖拽过程中更新业务对象的状态信息.
       * @param e 拖拽事件.
       */
      Draggable.onDragUpdateStatus = function(e){
        var target = $(this);
        var object = $.register("find", Draggable, target);
        var targetOffset=target.offset();
        var mouseOffset={left:event.pageX,top:event.pageY};
        jq.extend(object.status.current,{
          targetOffset:targetOffset,
          mouseOffset:mouseOffset
        });
        if(object.followingElement){
          object.followingElement.offset({left:mouseOffset.left+1,top:mouseOffset.top+1});
        }
      };
      
      Draggable.onDragEndDefaultActions=function(e){
        var target = $(this);
        var object = $.register("find", Draggable, target);
        if(object.options.moveable){
          var m = object.status.current.mouseOffset;
          var ot = object.status.start.targetOffset;
          var om = object.status.start.mouseOffset;
          //var left = m.left;
          target.offset(
              {
                left:m.left-(om.left-ot.left),
                top:m.top-(om.top-ot.top)
              });
        }
        if(object.followingElement){
          object.followingElement.detach();
          object.followingElement=undefined;
        }
        
        CURRENT_DRAG_CONTEXT.target = undefined;
      };
      /**
       * 类元数据.
       */
      Draggable.prototype.clz={
          UUID:Draggable.UUID
      };
      /**
       * 业务对象可选项配置.
       * <p>对外配置接口.
       * </p>
       */
      Draggable.prototype.options={};
      /**
       * 保存拖拽状态.
       */
      Draggable.prototype.status={
          /**
           * 拖拽开始时的状态.
           */
          start:{
            /**
             * 被拖拽对象的位置.
             */
            targetOffset:undefined,
            /**
             * 拖拽开始时鼠标位置.
             */
            mouseOffset:undefined
          },
          /**
           * 当前位置.
           */
          current:{
            targetOffset:undefined,
            mouseOffset:undefined
          },
      };
      /**
       * 拖拽过程中的代理对象.
       */
      Draggable.prototype.followingElement=null;
      //----成员属性--定义结束----------
      //----私有----成员方法----定义开始----
      /**
       * 根据插件业务对象的options选项中following属性生成代理对象.
       * @returns 代理对象.
       */
      Draggable.prototype._createFollowing = function(){
        var res = this.options.following;
        if(res){
          var typeofres = typeof res;
          if(typeofres == "function"){
            res = res.apply(this);
          }else if(typeofres == "string"){
            res = $(res);
          }
        }
        return res;
      };
      //----私有----成员方法----定义结束----
      //----公共----成员方法----定义开始----
      /**
       * 拖拽业务对象初始化.
       */
      Draggable.prototype.init=function(options){
        var target = $($.register("findTarget",Draggable,this));
        target.attr("draggable","true");//设置目标可拖拽 html5生效

        //合并业务选项.
        jq.extend(this.options, Draggable.DEFAULTS, options);
        
        //绑定保存现场状态的回调函数.
        target.on("dragstart",Draggable.onDragStartSaveStatus);
        target.on("drag", Draggable.onDragUpdateStatus);
        target.on("dragend",Draggable.onDragEndDefaultActions);
        
        if(this.options.onDragstart&&typeof this.options.onDragstart=="function"){
          target.on("dragstart", this.options.onDragstart);
        }
        if(this.options.onDragend&&typeof this.options.onDragend=="function"){
          target.on("dragend", this.options.onDragend);
        }
        if(this.options.onDrag&&typeof this.options.onDrag=="function"){
          target.on("drag", this.options.onDrag);
        }
      };

      /**
       * 接口方法.
       */
      Draggable.interfaceMethod = function(){
        var object = jq.register("find", Draggable, this);
        var res = null;
        if(typeof arguments[0] == "string"){
          res = this.draggable.METHODS[arguments[0]]
            &&this.draggable.METHODS[arguments[0]].apply(
                object,
                jq.shift(arguments)
              );
        } else {
          res = this;
          object.init&&typeof object.init=="function"&&object.init.apply(object,arguments);
        }
        return res?res:this;
      };

      Draggable.interfaceMethod.METHODS={
          context:function(){
            return CURRENT_DRAG_CONTEXT;
          }
      };

      return Draggable.interfaceMethod;
    })()
  });
})($ === jQuery ? $ : jQuery.noConflict());