/**
 *  @author 
 *  @date 
 */

//常用参数
var global_param = {
		context_name: '/YLManager',
		html_path : '/YLManager/resources/html/',
		tab_number: 1, // 不控制显示标签数
        tab_limit_tip: true, // 标志标签提示是否已经给出，如果没有给出那么当标签数量超过指定数量的时候则给予提示，如已经提示过了那么直接自动关闭最早打开的标签
        tab_limit_tip_content: '主页默认最多同时打开7个标签页，请您关闭不用的标签页后再打开新页，默认会关闭最早打开的标签页，此提示不再出现。', // 关闭标签提示
        layout_bottomHeight:0, //标志主页面上最下面面板的高度
        layout_leftWidth: 130, //标志主页面上左侧菜单面板的宽度
        layout_titleHeight: 30, //面板标题高度，与样式“l-tab-links”中的height相关
        tree_menu_backcolor: '#e9e9eb', //树状菜单背景色
        tree_menu_nodeWidth: 177, //树状菜单选中宽度
		version: '?v='+new Date().getTime(),  // 解决静态缓存问题加入的版本信息
		session_check: true, // 是否检查session过期设置
		use_cookie:true, // 设置是否使用cookie
		upload_file_url: 'http://192.168.1.229:8080/upload'
};

document.write('<link rel="stylesheet" type="text/css" href="'+global_param.context_name+'/resources/js/jquery-easyui-1.3.4/themes/default/easyui.css">');
document.write('<link rel="stylesheet" type="text/css" href="'+global_param.context_name+'/resources/js/jquery-easyui-1.3.4/themes/icon.css">');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/jquery-1.8.3.min.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/ajaxfileupload.js'+global_param.version+'"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/jquery.cookie.js"></script>');
//document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/ligerui.all.js"></script>');//不在使用ligerui
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/date/WdatePicker.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/jquery.json-2.3.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/jquery.query-2.1.7.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/goldcowjs/error.message.js"></script>');
//document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/goldcowjs/global.ligerui.extend.js"></script>');//不在使用ligerui
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/goldcowjs/global.util.js"></script>');
/*document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/goldcowjs/page.init.js"></script>');*/
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/goldcowjs/menu.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/goldcowjs/tab.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/goldcowjs/form.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/util.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/utilJson.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/chart/highstock.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/fileUtil.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/textcheck.js"></script>');
document.write('<script language="Javascript" src="'+global_param.context_name+'/resources/js/index.js"></script>');