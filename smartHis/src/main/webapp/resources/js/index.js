
window.onload = function(){
	$('#loading-mask').fadeOut();
	tabClose();
	tabCloseEven();
	
	//右键菜单
	tabMenuClose("欢迎使用",0);
    tabMenuCloseEven();
};

/*------------------ 右键菜单相关 ------------------*/
//右键菜单定位
function tabMenuClose(title,index) {
	var divs = $(".tabs-inner");
	var subtitle;
	$.each(divs,function(name,divValue){
		subtitle = $(divValue).children("span").text();
		//初始化首页
		if(title == subtitle){
    		$(divValue).bind('contextmenu',function(e){
    			$('#tt').tabs('select', title);
    			$('#tabMenu').menu('show', {
		            left: e.pageX,
		            top: e.pageY
		        });
    			$('#tabMenu').data("currtab",subtitle);
    			return false;
    	    });
    		
    		/*双击关闭TAB选项卡*/
    		$(divValue).dblclick(function(){
    	    	//不关闭首页
    	    	if (subtitle != "欢迎使用") {
    	    		$('#tt').tabs('close',subtitle);
    	    	} else {
    	    		$.messager.alert('提示','不可关闭！','info');
    	    		return false;
    	    	}
    	    	
    		});
		}
	});
	
}

	//绑定右键菜单事件
	function tabMenuCloseEven() {
    //关闭当前
    $('#tab-tabclose').click(function(){
        var currtab_title = $('#tabMenu').data("currtab");
        //不关闭首页
    	if (currtab_title != "欢迎使用") {
    		$('#tt').tabs('close',currtab_title);
    	} else {
    		$.messager.alert('提示','不可关闭！','info');
    		return false;
    	}    
    	
    });
    
    //关闭所有
    $('#tab-tabcloseall').click(function(){
        $('.tabs-inner span').each(function(i,n){
        	//不关闭首页
        	if ($(n).text() != "欢迎使用") {
        		var t = $(n).text();
                $('#tt').tabs('close', t);
        	}
        });    
        
    });
    
    //关闭除当前之外的TAB
    $('#tab-tabcloseother').click(function(){
        var currtab_title = $('#tabMenu').data("currtab");
        $('.tabs-inner span').each(function(i, n){
            var t = $(n).text();

            //不关闭首页
        	if (t != "欢迎使用" && currtab_title != t) {
        		$('#tt').tabs('close', t);
        	}                 
        });                    
    });

    //关闭当前右侧的TAB
    $('#tab-tabcloseright').click(function(){
        var nextall = $('.tabs-selected').nextAll();
        nextall.each(function(i,n){
            var t = $('a:eq(0) span', $(n)).text();
          
            //不关闭首页
        	if (t != "欢迎使用") {
        		$('#tt').tabs('close', t);
        	} 
        });
        
    });
    
    //关闭当前左侧的TAB
    $('#tab-tabcloseleft').click(function(){
        var prevall = $('.tabs-selected').prevAll();
        prevall.each(function(i,n){
            var t = $('a:eq(0) span', $(n)).text();
            
            //不关闭首页
        	if (t != "欢迎使用") {
        		$('#tt').tabs('close', t);
        	} 
        });
        
    });    
}

var onlyOpenTitle="娆㈣繋浣跨敤";//涓嶅厑璁稿叧闂殑鏍囩鐨勬爣棰�

//增加tab标签
function addTab(subtitle,url,icon){
	if(!$('#tt').tabs('exists',subtitle)){
		$('#tt').tabs('add',{
			title:subtitle,
			content:createFrame(url),
			closable:true,
			icon:icon
		});
	}else{
		$('#tt').tabs('select',subtitle);
		$('#mm-tabupdate').click();
	}
//	tabClose();
}

//创建Iframe
function createFrame(url)
{
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}
//关闭tab标签
function tabClose()
{
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();

		$('#mm').data("currtab",subtitle);
		$('#tt').tabs('select',subtitle);
		return false;
	});
}

function tabCloseEven() {

    $('#mm').menu({
        onClick: function (item) {
            closeTab(item.id);
        }
    });

    return false;
}

function closeTab(action)
{
    var alltabs = $('#tt').tabs('tabs');
    var currentTab =$('#tt').tabs('getSelected');
	var allTabtitle = [];
	$.each(alltabs,function(i,n){
		allTabtitle.push($(n).panel('options').title);
	});


    switch (action) {
        case "refresh":
            var iframe = $(currentTab.panel('options').content);
            var src = iframe.attr('src');
            $('#tt').tabs('update', {
                tab: currentTab,
                options: {
                    content: createFrame(src)
                }
            });
            break;
        case "close":
            var currtab_title = currentTab.panel('options').title;
            $('#tt').tabs('close', currtab_title);
            break;
        case "closeall":
            $.each(allTabtitle, function (i, n) {
                if (n != onlyOpenTitle){
                    $('#tt').tabs('close', n);
				}
            });
            break;
        case "closeother":
            var currtab_title = currentTab.panel('options').title;
            $.each(allTabtitle, function (i, n) {
                if (n != currtab_title && n != onlyOpenTitle)
				{
                    $('#tt').tabs('close', n);
				}
            });
            break;
        case "closeright":
            var tabIndex = $('#tt').tabs('getTabIndex', currentTab);

            if (tabIndex == alltabs.length - 1){
                alert('关闭tab标签失败');
                return false;
            }
            $.each(allTabtitle, function (i, n) {
                if (i > tabIndex) {
                    if (n != onlyOpenTitle){
                        $('#tt').tabs('close', n);
					}
                }
            });

            break;
        case "closeleft":
            var tabIndex = $('#tt').tabs('getTabIndex', currentTab);
            if (tabIndex == 1) {
                alert('关闭左侧导航失败');
                return false;
            }
            $.each(allTabtitle, function (i, n) {
                if (i < tabIndex) {
                    if (n != onlyOpenTitle){
                        $('#tt').tabs('close', n);
					}
                }
            });

            break;
        case "exit":
            $('#closeMenu').menu('hide');
            break;
    }
}

function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}