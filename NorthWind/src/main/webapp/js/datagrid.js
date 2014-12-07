/*
 * 数据表格插件.
 * <p>
 * 该插件会清空所选元素中的内容，并且按照表格的要求重新填充内容，其中包括一个<code><table/></code>元素。
 * </p>
 */

(function(jq){
  jq.fn.extend(
    {
      datagrid:(function(){
        /**
         * 列定义
         * @constructor .
         */
        function ColumnDefination(p){
          if(p){
            $.extend(this,p);
          }
        }
        
        ColumnDefination.prototype.colspan = 1;
        ColumnDefination.prototype.rowspan = 1;
        ColumnDefination.prototype.width = 'auto';
        ColumnDefination.prototype.title = '';
        ColumnDefination.prototype.field = '';
        ColumnDefination.prototype.align = 'center';
        ColumnDefination.prototype.halign = 'middle';
        ColumnDefination.prototype.formatter = function(value,row,index){return value;};
        ColumnDefination.prototype.styler = function(value,row,index){return;};
        /**
         * 数据表格业务对象.
         * @constructor .
         */
        function Datagrid(){
          jq.extend(this.options,Datagrid.DEFAULT);
        }
        /**
         * 数据表格对象唯一ID.
         */
        Datagrid.UUID="155897E6-4ACC-45F8-875A-A91CCE37FDF7";
        /**
         * 默认配置项.
         */
        Datagrid.DEFAULT={
            title:"table title",
            /**
             * A function which's 'this' object is the Datagrid object's property 'caption'.
             */
            captionFormatter:undefined,
            columns:[[]]
        };
        /**
         * 对象信息.
         */
        Datagrid.prototype.clz={
            UUID:Datagrid.UUID
        };
        /**
         * 插件选项.
         */
        Datagrid.prototype.options={};
        /**
         * .
         */
        Datagrid.prototype.table=undefined;
        /**
         * .
         */
        Datagrid.prototype.caption=undefined;
        /**
         * .
         */
        Datagrid.prototype.thead=undefined;
        /**
         * .
         */
        Datagrid.prototype.tfoot=undefined;
        /**
         * .
         */
        Datagrid.prototype.tbody=undefined;
        
        /**
         * 初始化方法.
         */
        Datagrid.prototype.init=function(options){
          options&&jq.extend(this.options,options);
          
          this.composite();
          this.binds();
          
          $(this).trigger("render");
        };
        Datagrid.prototype.compositeThead = function(){
          var object = this;
          var defs = object.options.columns;
          var head = object.thead;
          
          $(defs).each(
              function(row){
                var trDef = this;
                var tr = $("<tr/>").appendTo(head);
                $(trDef).each(
                    function(column){
                      var tdDef = this;
                      var td = $("<td/>").appendTo(tr);
                      td.html(this.title);
                    }
                );
              }
          );
        };
        Datagrid.prototype.compositeTbody = function(){
          var object = this;
          var defs = object.options.columns;
          var data = object.options.data;
          $(data).each(
              function(){
                var record = this;
                var tr = $("<tr/>").appendTo(object.tbody);
                $(defs).each(
                    function(row){
                      var trDef=this;
                      $(trDef).each(
                          function(column){
                            var tdDef = this;
                            var td = $("<td/>").appendTo(tr);
                            td.html(record[tdDef.field]);
                          }
                      );
                    }
                );
              }
          );
        };
        /**
         * 组合方法.
         */
        Datagrid.prototype.composite=function(){
          var object = this;
          var target = $(jq.register("findTarget",this, Datagrid));
          target.empty();
          this.table = $("<table cellspacing='0' cellpadding='0'></table>");
          target.append(this.table);
          this.caption=$("<caption/>");
          this.thead=$("<thead/>");
          this.tfoot=$("<tfoot/>");
          this.tbody=$("<tbody/>");
          this.table.append(this.caption);
          this.table.append(this.thead);
          this.table.append(this.tfoot);
          this.table.append(this.tbody);
          
          this.compositeThead();
          
          this.compositeTbody();
        };
        /**
         * 绑定.
         */
        Datagrid.prototype.binds=function(){
          var $object = $(this);
          $object.on("render", this.onRender||jq.noop);
        };
        /**
         * 绘制表格.
         */
        Datagrid.prototype.onRender=function(){
          var target = jq(jq.register("findTarget", this, Datagrid));
          target.addClass("datagrid");
          var object = this;
          
          this.caption.text(this.options.title);
          
          var psize = new Size(target.parent());
          var size = psize.calcInnerElementMaxSize(target);
          size.height-=((target.offset().top-target.parent().offset().top));
          size.applyTo(target);
          
          this.table.height(
              target.innerHeight()
              -this.caption.outerHeight()
            );
          this.table.width(
              target.innerWidth()
              -(this.tbody.outerWidth()-this.tbody.width())
            );
          
          object.options.captionFormater
            &&typeof object.options.captionFormater == 'function'
            &&object.options.captionFormater.apply(object.caption[0]);
        };
        /**
         * 接口函数.
         */
        Datagrid.interfaceMethod = function(){
          var target = this;
          var object = jq.register("find",target, Datagrid);
          if(arguments&&arguments.length>0&&typeof arguments[0]=="string"){
            return target.datagrid.METHODS[arguments[0]].apply(target,jq.shift(arugments));
          }else{
            object.init&&typeof object.init=="function"&&object.init.apply(object, arguments);
            return target;
          }
        };
        /**
         * 公开接口方法列表.
         */
        Datagrid.interfaceMethod.METHODS={
          
        };
        return Datagrid.interfaceMethod;
      })()
    }
  );
})(jQuery);