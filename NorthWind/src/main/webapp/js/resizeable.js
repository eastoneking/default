/*
 * 
 */
(function(jq){
  jq.fn.extend({
    resizeable:(function(){
      /**
       * 可变大小类.
       */
      function Resizeable(){
      }
      /**
       * 类UUID.
       */
      Resizeable.UUID='3C0E9A61-152A-A379-55B6-DC763EEE5E62';
      /**
       * 默认属性.
       */
      Resizeable.DEFAULTS={
        /**
         * 敏感度.
         * <p>距离边框小于此数值则调整大小生效.</p>
         */
        effect:15
      };
      Resizeable.onMousedown = function(ev){
        var target = jq(this);
        var object = jq.register("find", target, Resizeable);
        object.leftDown = true;
      };
      Resizeable.onMouseup = function(ev){
        var target = jq(this);
        var object = jq.register("find", target, Resizeable);
        object.leftDown = false;
      };
      Resizeable.onMouseleave = function(ev){
        var target = jq(this);
        var object = jq.register("find", target, Resizeable);
        object.houseKeeping();
      };
      Resizeable.onMouseenter = function(ev){
        var target = jq(this);
        var object = jq.register("find", target, Resizeable);
      };
      Resizeable.onDragstart = function(ev){
        ev.preventDefault();
        ev.stopImmediatePropagation();
      };
      Resizeable.onDragstartHouseKeeping=function(){
        var target = jq(this);
        var object = jq.register("find", target, Resizeable);
        object.houseKeeping();
      };
      /**
       * 鼠标移动回调函数.
       */
      Resizeable.onMousemove = function(ev){
        var p = {top:ev.pageY,left:ev.pageX};
        var target = jq(this);
        var object = jq.register("find", target, Resizeable);
        
        var offset = target.offset();
        
        var effect = object.options.effect;
        
        var b_w = ((target.outerWidth()-target.innerWidth())/2
            +(target.width()-target.innerWidth())/2//考虑padding /*效果依然
            +(target.outerWidth()-target.width())/2);//考虑border *不完美.*/
        
        var b_h = ((target.outerHeight()-target.innerHeight())/2-(target.height()-target.innerHeight()));
        var c_w = p.left-offset.left<effect;
        var c_n = p.top-offset.top<effect;
        var c_e = p.left-(offset.left+target.innerWidth()+b_w)>-effect;
        var c_s = p.top-(offset.top+target.height()+b_h)>-effect;
        
        var c_ne = c_n&&c_e;
        var c_nw = c_n&&c_w;
        var c_se = c_s&&c_e;
        var c_sw = c_s&&c_w;
        if(c_ne){
          target.css("cursor","ne-resize");
          target.on("dragstart", Resizeable.onDragstart);
        }else if(c_nw){
          target.css("cursor","nw-resize");
          target.off("dragstart", Resizeable.onDragstartHouseKeeping);
          target.on("dragstart", Resizeable.onDragstart);
        }else if(c_se){
          target.css("cursor","se-resize");
          target.off("dragstart", Resizeable.onDragstartHouseKeeping);
          target.on("dragstart", Resizeable.onDragstart);
        }else if(c_sw){
          target.css("cursor","sw-resize");
          target.off("dragstart", Resizeable.onDragstartHouseKeeping);
          target.on("dragstart", Resizeable.onDragstart);
        }else if(c_w){
          target.css("cursor","w-resize");
          target.off("dragstart", Resizeable.onDragstartHouseKeeping);
          target.on("dragstart", Resizeable.onDragstart);
        }else if(c_n){
          target.css("cursor","n-resize");
          target.off("dragstart", Resizeable.onDragstartHouseKeeping);
          target.on("dragstart", Resizeable.onDragstart);
        }else if(c_e){
          target.css("cursor","e-resize");
          target.off("dragstart", Resizeable.onDragstartHouseKeeping);
          target.on("dragstart", Resizeable.onDragstart);
        }else if(c_s){
          target.css("cursor","s-resize");
          target.off("dragstart", Resizeable.onDragstartHouseKeeping);
          target.on("dragstart", Resizeable.onDragstart);
        }
        else{
          target.css("cursor","default");
          target.off("dragstart", Resizeable.onDragstart);
          target.on("dragstart", Resizeable.onDragstartHouseKeeping);
        }

        if(object.leftDown==1){
          var curOffset = {
              left:ev.pageX,top:ev.pageY
          };
          if(object.originOffset){
            var dX = 0;//方向
            var dY = 0;
            if((curOffset.left-object.originOffset.left)>0){
              dX = 1;
            }else if((curOffset.left-object.originOffset.left)<0){
              dX = -1;
            }
            if((curOffset.top-object.originOffset.top)>0){
              dY = 1;
            }else if((curOffset.top-object.originOffset.top)<0){
              dY = -1;
            }
            
            if(c_ne){
              target.offset({top:target.offset().top+(1*dY)});
              target.height(target.height()-(1*dY));
              target.width(target.width()+(dX*1));
            }else if(c_nw){
              target.offset({top:target.offset().top+(1*dY)});
              target.height(target.height()-(1*dY));
              target.offset({left:target.offset().left+(1*dX)});
              target.width(target.width()-(1*dX));
            }else if(c_se){
              target.height(target.height()+(1*dY));
              target.width(target.width()+(dX*1));
            }else if(c_sw){
              target.height(target.height()+(1*dY));
              target.offset({left:target.offset().left+(1*dX)});
              target.width(target.width()-(1*dX));
            }else if(c_e){
              target.width(target.width()+(dX*1));
            }else if(c_s){
              target.height(target.height()+(1*dY));
            }else if(c_n){
              target.offset({top:target.offset().top+(1*dY)});
              target.height(target.height()-(1*dY));
            }else if(c_w){
              target.offset({left:target.offset().left+(1*dX)});
              target.width(target.width()-(1*dX));
            }
          }
          object.originOffset=curOffset;
        }
        
      };
      //----成员属性--定义开始----------
      /**
       * 类元数据.
       */
      Resizeable.prototype.clz={
          UUID:Resizeable.UUID
      };
      /**
       * 业务对象可选项配置.
       * <p>对外配置接口.
       * </p>
       */
      Resizeable.prototype.options={};
      /**
       * 调整大小过程中，第一次按下鼠标左键时的位置.
       * <p>用于确定调整大小的方向是向内或向外.</p>
       */
      Resizeable.prototype.originOffset=undefined;
      Resizeable.prototype.leftDown=false;
      //----成员属性--定义结束----------
      //----私有----成员方法----定义开始----
      //----私有----成员方法----定义结束----
      //----公共----成员方法----定义开始----
      /**
       * 初始化方法.
       */
      Resizeable.prototype.init=function(options){
        var target = $($.register("findTarget", this, Resizeable));
        jq.extend(this.options, Resizeable.DEFAULTS, options);
        target.on("mouseenter", Resizeable.onMouseenter);
        target.on("mousemove",Resizeable.onMousemove);
        target.on("mousedown", Resizeable.onMousedown);
        target.on("mouseup", Resizeable.onMouseup);
        target.on("mouseleave", Resizeable.onMouseleave);
        target.on("dragstart", Resizeable.onDragstartHouseKeeping);
      };
      /**
       * 清理过程状态.
       */
      Resizeable.prototype.houseKeeping = function(){
        this.originOffset = undefined;
        this.leftDown=false;
      };
      /**
       * 接口方法.
       */
      Resizeable.interfaceMethod = function(){
        var object = jq.register("find", this, Resizeable);
        var res = null;
        if(typeof arguments[0] == "string"){
          res = this.resizeable.METHODS[arguments[0]]
            &&this.resizeable.METHODS[arguments[0]].apply(
                object,
                jq.shift(arguments)
              );
        } else {
          res = this;
          object.init&&typeof object.init=="function"&&object.init.apply(object,arguments);
        }
        return res?res:this;
      };

      Resizeable.interfaceMethod.METHODS={
      };

      return Resizeable.interfaceMethod;
    })()
  });
})($ === jQuery ? $ : jQuery.noConflict());