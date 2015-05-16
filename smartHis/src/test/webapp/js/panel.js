/*
 * Panel插件定义文件.
 * @author wangds@gmail.com 2014-11-16 01:27 Beijing.
 */

(function(jq){
  jq.fn.extend(
    {
      panel:(function(){
        /**
         * 标题栏.
         * @constructor .
         */
        function Title(target,options){
          var eleTarget = target instanceof jQuery?target[0]:target;
          jq.data(eleTarget, Title.UUID, this);
          jq.data(this, Title.UUID, eleTarget);
          jq.extend(this.options,Title.DEFAULTS);
          this.init(options);
        }
        
        Title.UUID="47861AE7-061F-8F17-3BBB-504E75F6FE8D";
        Title.DEFAULTS={
            text:"",
            cssTitleClz:undefined,
            cssTextClz:undefined,
            onRender:jq.noop
        };
        /**
         * .
         */
        Title.prototype.clz={UUID:Title.UUID};
        Title.prototype.options={};
        Title.prototype.init=function(options){
          jq.extend(this.options,options);
          this.construct();
          this.binds();
        };
        Title.prototype.construct=function(){
          var $target = $(jq.register("findTarget",this,Title));
          var $eleTitleText = jq("<div>"+this.options.text+"</div>");
          $target.append($eleTitleText);
          $target.addClass("panel_title");
          $eleTitleText.addClass("panel_title_text");
          this.options.cssTextClz&&$eleTitleText.addClass(this.options.cssTextClz);
          this.options.cssTitleClz&&$target.addClass(this.options.cssTitleClz);
        };
        Title.prototype.binds=function(options){
          var $this = $(this);
          jq.extend(this.options, options);
          $this.on("render", this.options.onRender||jq.noop);
        };
        Title.prototype.unbinds=function(){
          var $this = $(this);
          $this.off("render");
        };
        Title.prototype.distory=function(){
          var eleTarget = jq.data(this,Title.UUID);
          jq.data(this,Title.UUID,undefined);
          jq.data(eleTarget,Title.UUID,undefined);
          this.unbinds();
        };
        /**
         * 主面板.
         * @constructor .
         */
        function Body(target){
          target = (target instanceof jQuery?target[0]:target);
          $.data(target, Body.UUID, this);
          $.data(this, Body.UUID, target);
        }
        Body.UUID="C94D58ED-F50B-8794-569C-3288AC30F386";
        /**
         * 面板.
         * @constructor
         */
        function Panel(){
          //为实例的options属性设置默认值.
          jq.extend(this.options, Panel.DEFAULTS);
        }
        /**
         * 唯一标识.
         */
        Panel.UUID="47861AE7-061F-8F17-3BBB-504E75F6FE8D";
        /**
         * Panel实例的默认值.
         */
        Panel.DEFAULTS={
            title:{text:""},
            forceReconstruct:false
        };
        
        /**
         * 选项.
         */
        Panel.prototype.options = {};
        /**
         * 标题对象.
         */
        Panel.prototype.title = undefined;
        
        Panel.prototype.onRenderDefaultActions = function(){
          $(this.title).trigger("render");
        };
        Panel.prototype.onRender = jq.noop;
        
        /**
         * 初始化方法.
         * @param options 自定义选项.
         */
        Panel.prototype.init=function(options){
          jq.extend(this.options,options);
          
          this.construct();
          
          this.onRender=this.options.onRender||jq.noop;
          
          this.binds();
          
        };
        Panel.prototype.construct=function(){
          var object = this;
          var target = jq.register("findTarget", this, Panel);
          var $target = $(target);
          //强制重构
          this.options.forceReconstruct&&this.houseKeeping();
          var bodyHtml = $target.html();
          $target.empty();
          this.constructTitle();
          this.constructBody(bodyHtml);
        };
        Panel.prototype.houseKeeping=function(){
          this.cleanTitle();
        };
        /**
         * 构建标题栏.
         */
        Panel.prototype.constructTitle=function(){
          var object = this;
          var target = jq.register("findTarget", this, Panel);
          var $target = $(target);
          if((!this.title)&&this.options.title){
            var eleTitle = jq("<div/>");
            $target.append(eleTitle);//TODO: insert
            this.title=new Title(eleTitle,this.options.title);
          }
          return;
        };
        Panel.prototype.constructBody=function(html){
          var eleTitle = jq.register("findTarget", this.title, Title);
          var target = jq.register("findTarget", this, Panel);
          var $target = $(target);
          //生成Body元素.
          var $eleBody = jq("<div/>");
          $target.append($eleBody);
          //设置Body元素大小
          var titleSize = new Size($(eleTitle));
          var tgtSize = new Size($target);
          var bodySize = tgtSize.calcInnerElementMaxSize($eleBody);
          bodySize.height=bodySize.height-titleSize.outerHeight;
          bodySize.applyTo($eleBody);
          //复制基础元素中的内容到Body中
          $eleBody.html(html);
          
          this.body=new Body($eleBody);
        };
        Panel.prototype.binds=function(){
          var $object = $(this);
          $object.on("render", this.onRenderDefaultActions);
          $object.on("render", this.onRender);
          return;
        };
        /**
         * 清理Title属性.
         */
        Panel.prototype.cleanTitle=function(){
          this.title&&this.title.destory();
          this.title=undefined;
          return;
        };
        
        Panel.prototype.getBodyElement=function(){
          return $(jq.register("findTarget", this.body, Body));
        }
        /**
         * 接口方法.
         * @returns .
         */
        Panel.interfaceMethod = function(){
          var object = jq.register("find", this, Panel);
          var res = null;
          if(typeof arguments[0] == "string"){
            res = this.panel.METHODS[arguments[0]]
            &&this.panel.METHODS[arguments[0]].apply(
                  object,
                  jq.shift(arguments)
                );
          } else {
            res = this;
            object.init&&typeof object.init=="function"&&object.init.apply(object,arguments);
          }
          return res?res:this;
        };
        Panel.interfaceMethod.METHODS={
            getBody:function(){
              var object = this;
              return object.getBodyElement();
            }
        };
        return Panel.interfaceMethod;
      })()
    }
  );
})(jQuery);