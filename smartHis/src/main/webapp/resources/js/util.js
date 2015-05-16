$.fn.tree.defaults.loadFilter = function(data, parent) {
	var opt = $(this).data().tree.options;
	var idField, textField, parentField;
	if (opt.parentField) {
		idField = opt.idField || 'id';
		textField = opt.textField || 'text';
		parentField = opt.parentField;
		var i, l, treeData = [], tmpMap = [];
		for (i = 0, l = data.length; i < l; i++) {
			tmpMap[data[i][idField]] = data[i];
		}
		for (i = 0, l = data.length; i < l; i++) {
			if (tmpMap[data[i][parentField]]
					&& data[i][idField] != data[i][parentField]) {
				if (!tmpMap[data[i][parentField]]['children'])
					tmpMap[data[i][parentField]]['children'] = [];
				data[i]['id'] = data[i][idField];
				data[i]['text'] = data[i][textField];
				tmpMap[data[i][parentField]]['children'].push(data[i]);
			} else {
				data[i]['id'] = data[i][idField];
				data[i]['text'] = data[i][textField];
				treeData.push(data[i]);
			}
		}
		return treeData;
	}
	return data;
};
$.fn.treegrid.defaults.loadFilter = function(data, parentId) {
	var opt = $(this).data().treegrid.options;
	var idField, textField, parentField;
	if (opt.parentField) {
		idField = opt.idField || 'id';
		textField = opt.textField || 'text';
		parentField = opt.parentField;
		var i, l, treeData = [], tmpMap = [];
		for (i = 0, l = data.length; i < l; i++) {
			tmpMap[data[i][idField]] = data[i];
		}
		for (i = 0, l = data.length; i < l; i++) {
			if (tmpMap[data[i][parentField]]
					&& data[i][idField] != data[i][parentField]) {
				if (!tmpMap[data[i][parentField]]['children'])
					tmpMap[data[i][parentField]]['children'] = [];
				data[i]['id'] = data[i][idField];
				data[i]['text'] = data[i][textField];
				tmpMap[data[i][parentField]]['children'].push(data[i]);
			} else {
				data[i]['id'] = data[i][idField];
				data[i]['text'] = data[i][textField];
				treeData.push(data[i]);
			}
		}
		return treeData;
	}
	return data;
};

$.fn.combotree.defaults.loadFilter = $.fn.tree.defaults.loadFilter;

var easyuiErrorFunction = function(XMLHttpRequest) {
	$.messager.progress('close');
//	$.messager.alert('错误', XMLHttpRequest.responseText);
	location.href = "/YLManager/login.html";// 返回应用首页
};

// $.fn.datagrid.defaults.onLoadError = easyuiErrorFunction;
// $.fn.treegrid.defaults.onLoadError = easyuiErrorFunction;
$.fn.tree.defaults.onLoadError = easyuiErrorFunction;
$.fn.combogrid.defaults.onLoadError = easyuiErrorFunction;
$.fn.combobox.defaults.onLoadError = easyuiErrorFunction;
$.fn.form.defaults.onLoadError = easyuiErrorFunction;

var createGridHeaderContextMenu = function(e, field) {
	e.preventDefault();
	var grid = $(this);/* grid本身 */
	var headerContextMenu = this.headerContextMenu;/* grid上的列头菜单对象 */
	if (!headerContextMenu) {
		var tmenu = $('<div style="width:100px;"></div>').appendTo('body');
		var fields = grid.datagrid('getColumnFields');
		for ( var i = 0; i < fields.length; i++) {
			var fildOption = grid.datagrid('getColumnOption', fields[i]);
			if (!fildOption.hidden) {
				$('<div iconCls="icon-ok" field="' + fields[i] + '"/>').html(
						fildOption.title).appendTo(tmenu);
			} else {
				$('<div iconCls="icon-empty" field="' + fields[i] + '"/>')
						.html(fildOption.title).appendTo(tmenu);
			}
		}
		headerContextMenu = this.headerContextMenu = tmenu.menu({
			onClick : function(item) {
				var field = $(item.target).attr('field');
				if (item.iconCls == 'icon-ok') {
					grid.datagrid('hideColumn', field);
					$(this).menu('setIcon', {
						target : item.target,
						iconCls : 'icon-empty'
					});
				} else {
					grid.datagrid('showColumn', field);
					$(this).menu('setIcon', {
						target : item.target,
						iconCls : 'icon-ok'
					});
				}
			}
		});
	}
	headerContextMenu.menu('show', {
		left : e.pageX,
		top : e.pageY
	});
};
$.fn.datagrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;
$.fn.treegrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;
// datagrid的悬浮提示功能
$.extend($.fn.datagrid.methods, {  
    /**  
     * 开打提示功能  
     * @param {} jq  
     * @param {} params 提示消息框的样式  
     * @return {}  
     */  
    doCellTip: function(jq, params){  
        function showTip(data, td, e){  
        	if ($(td).text() == "")   
                return;  
            data.tooltip.text($(td).text()).css({  
                top: (e.pageY + 10) + 'px',  
                left: (e.pageX + 20) + 'px',  
                'z-index': $.fn.window.defaults.zIndex,  
                display: 'block'  
            });  
        };  
        return jq.each(function(){  
            var grid = $(this);  
            var options = $(this).data('datagrid');  
            if (!options.tooltip) {  
                var panel = grid.datagrid('getPanel').panel('panel');  
                var defaultCls = {  
                    'border': '1px solid #333',  
                    'padding': '2px',  
                    'color': '#333',  
                    'background': '#f7f5d1',  
                    'position': 'absolute',  
                    'max-width': '200px',  
                    'border-radius' : '4px',  
                    '-moz-border-radius' : '4px',  
                    '-webkit-border-radius' : '4px',  
                    'display': 'none'  
                }  
                var tooltip = $("<div id='celltip'></div>").appendTo('body');  
                tooltip.css($.extend({}, defaultCls, params.cls));  
                options.tooltip = tooltip;  
                panel.find('.datagrid-body').each(function(){  
                    var delegateEle = $(this).find('> div.datagrid-body-inner').length ? $(this).find('> div.datagrid-body-inner')[0] : this;  
                    $(delegateEle).undelegate('td', 'mouseover').undelegate('td', 'mouseout').undelegate('td', 'mousemove').delegate('td', {  
                        'mouseover': function(e){  
                            if (params.delay) {  
                                if (options.tipDelayTime)   
                                    clearTimeout(options.tipDelayTime);  
                                var that = this;  
                                options.tipDelayTime = setTimeout(function(){  
                                    showTip(options, that, e);  
                                }, params.delay);  
                            }  
                            else {  
                                showTip(options, this, e);  
                            }  
                              
                        },  
                        'mouseout': function(e){  
                            if (options.tipDelayTime)   
                                clearTimeout(options.tipDelayTime);  
                            options.tooltip.css({  
                                'display': 'none'  
                            });  
                        },  
                        'mousemove': function(e){  
                            var that = this;
                            if (options.tipDelayTime)   
                                clearTimeout(options.tipDelayTime);  
                            //showTip(options, this, e);  
                            options.tipDelayTime = setTimeout(function(){  
                                    showTip(options, that, e);  
                                }, params.delay);  
                        }  
                    });  
                });  
                  
            }  
              
        });  
    },  
    /**  
     * 关闭消息提示功能  
     *  
     * @param {}  
     *            jq  
     * @return {}  
     */  
    cancelCellTip: function(jq){  
        return jq.each(function(){  
            var data = $(this).data('datagrid');  
            if (data.tooltip) {  
                data.tooltip.remove();  
                data.tooltip = null;  
                var panel = $(this).datagrid('getPanel').panel('panel');  
                panel.find('.datagrid-body').undelegate('td', 'mouseover').undelegate('td', 'mouseout').undelegate('td', 'mousemove')  
            }  
            if (data.tipDelayTime) {  
                clearTimeout(data.tipDelayTime);  
                data.tipDelayTime = null;  
            }  
        });  
    },
    
    
    /**
     * 属性表格的提示
     */
    doTreeCellTip: function(jq, params){  
        function showTip(data, td, e){  
        	if ($(td).text() == "")   
                return;  
            data.tooltip.text($(td).text()).css({  
                top: (e.pageY + 10) + 'px',  
                left: (e.pageX + 20) + 'px',  
                'z-index': $.fn.window.defaults.zIndex,  
                display: 'block'  
            });  
        };  
        return jq.each(function(){  
            var grid = $(this);  
            var options = $(this).data('datagrid');  
            if (!options.tooltip) {  
                var panel = grid.datagrid('getPanel').panel('panel');  
                var defaultCls = {  
                    'border': '1px solid #333',  
                    'padding': '2px',  
                    'color': '#333',  
                    'background': '#f7f5d1',  
                    'position': 'absolute',  
                    'max-width': '200px',  
                    'border-radius' : '4px',  
                    '-moz-border-radius' : '4px',  
                    '-webkit-border-radius' : '4px',  
                    'display': 'none'  
                }  
                var tooltip = $("<div id='celltip'></div>").appendTo('body');  
                tooltip.css($.extend({}, defaultCls, params.cls));  
                options.tooltip = tooltip;  
                panel.find('.datagrid-body').each(function(){  
                    var delegateEle = $(this).find('> div.datagrid-body-inner').length ? $(this).find('> div.datagrid-body-inner')[0] : this;  
                    $(delegateEle).undelegate('td', 'mouseover').undelegate('td', 'mouseout').undelegate('td', 'mousemove').delegate('.datagrid-cell', {  
                        'mouseover': function(e){  
                            if (params.delay) {  
                                if (options.tipDelayTime)   
                                    clearTimeout(options.tipDelayTime);  
                                var that = this;  
                                options.tipDelayTime = setTimeout(function(){  
                                    showTip(options, that, e);  
                                }, params.delay);  
                            }  
                            else {  
                                showTip(options, this, e);  
                            }  
                              
                        },  
                        'mouseout': function(e){  
                            if (options.tipDelayTime)   
                                clearTimeout(options.tipDelayTime);  
                            options.tooltip.css({  
                                'display': 'none'  
                            });  
                        },  
                        'mousemove': function(e){  
                            var that = this;
                            if (options.tipDelayTime)   
                                clearTimeout(options.tipDelayTime);  
                            //showTip(options, this, e);  
                            options.tipDelayTime = setTimeout(function(){  
                                    showTip(options, that, e);  
                                }, params.delay);  
                        }  
                    });  
                });  
                  
            }  
              
        });  
    }
    
});
$(document).keydown(function(e) {
	var doPrevent;
	if (e.keyCode == 8) {
		var d = e.srcElement || e.target;
		if (d.tagName.toUpperCase() == 'INPUT' || d.tagName.toUpperCase() == 'TEXTAREA') {
			doPrevent = d.readOnly || d.disabled;
		} else
			doPrevent = true;
	} else
		doPrevent = false;
	if (doPrevent)
		e.preventDefault();
}); 

$.ajaxSetup({
	cache : false,
	//type : 'POST',
	error : function(XMLHttpRequest, textStatus, errorThrown) {
		$.messager.progress('close');
//		$.messager.alert('错误', XMLHttpRequest.responseText);
	},
	complete : function(xhr, textStatus) {
		if (xhr.status == 999||xhr.status==0) {
			location.reload();// 返回应用首页
			return;
		}
	}
});

var util = new function() {
	var ctx = global_param.context_name;
	// 继承datagrid，默认项目table规则
	this.table = function(tableId, options) {
		var self = $('#' + tableId);
		var defaults = {
			fitColumns : true,
			pageSize : 10,
			fit : true,
			method : 'post',
			// iconCls : 'icon-edit', // 图标
			singleSelect : true, // 单选
			nowrap : true,
			striped : true, // 奇偶行颜色不同
			collapsible : false,// 可折叠
			sortName : 'id', // 排序的列
			sortOrder : 'desc', // 倒序
			pageList : [10,20,50,100],
			remoteSort : true, // 服务器端排序
			idField : 'id', // 主键字段
			pagination : true, // 显示分页
			rownumbers : true, // 显示行号
			onLoadSuccess : function() {
				$(self).datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				$(this).datagrid('doCellTip',{'max-width':'300px','delay':500});
			}
		};
		options = $.extend(defaults, options);
		
		// 验证按钮权限，没有权限的从数组中移除
		/*var toolbar = options.toolbar;
		var permissionCodeArray = [];
		for (var i = 0; toolbar && i < toolbar.length; i++) {
			if (toolbar[i].permission != null) {
				permissionCodeArray.push(toolbar[i].permission);
			}
		}
		if (permissionCodeArray.length > 0) {
			var result = xf.checkPermission(permissionCodeArray);
			for (var i = toolbar.length - 1; i >= 0; i--) {
				if (toolbar[i].permission != null) {
					var _r = result.pop();
					if (_r == false || _r == "false") {
						toolbar.splice(i, 1);
					}
				}
			}
		}*/
		
		$(self).datagrid(options);
	};

	// 继承treegrid，默认项目treegrid规则
	this.treegrid = function(tableId, options) {
		var self = $('#' + tableId);
		var defaults = {
			method : 'post',
			fit : true,
			fitColumns : true,
			border : false,
			onLoadSuccess : function() {
				$(self).datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				$(this).datagrid('doTreeCellTip',{'max-width':'300px','delay':500});
			},
			toolbar : []
		};
		var defaultToolbar = [ {
			text : '展开',
			iconCls : 'icon-redo',
			handler : function() {
				var node = $(self).treegrid('getSelected');
				if (node) {
					$(self).treegrid('expandAll', node.cid);
				} else {
					$(self).treegrid('expandAll');
				}
			}
		}, {
			text : '折叠',
			iconCls : 'icon-undo',
			handler : function() {
				var node = $(self).treegrid('getSelected');
				if (node) {
					$(self).treegrid('collapseAll', node.cid);
				} else {
					$(self).treegrid('collapseAll');
				}
			}
		}, {
			text : '刷新',
			iconCls : 'icon-reload',
			handler : function() {
				$(self).treegrid('reload');
			}
		} ];

		options = $.extend(defaults, options);
		options.toolbar = $.merge(options.toolbar, defaultToolbar);

		// 验证按钮权限，没有权限的从数组中移除
		/*var toolbar = options.toolbar;
		var permissionCodeArray = [];
		for (var i = 0; i < toolbar.length; i++) {
			if (toolbar[i].permission != null) {
				permissionCodeArray.push(toolbar[i].permission);
			}
		}
		if (permissionCodeArray.length > 0) {
			var result = xf.checkPermission(permissionCodeArray);
			for (var i = toolbar.length - 1; i >= 0; i--) {
				if (toolbar[i].permission != null) {
					var _r = result.pop();
					if (_r == false || _r == "false") {
						toolbar.splice(i, 1);
					}
				}
			}
		}*/

		$(self).treegrid(options);
	};
	
	/**
	 * 用于打开新window窗口
	 * 
	 * @param winId 窗口ID
	 * @param options 配置
	 */
	this.window = function(winId, options) {
		var defaults = {
			title : '标题',
			width : 640,
			height : 480,
			shadow : true,
			modal : true,
			iconCls : 'icon-edit',
			closed : true,
			minimizable : false,
			maximizable : false,
			collapsible : false,
			onClose : function() {
				$('#' + winId).find("form").form("disableValidation");
			},
			onLoad : function() {
				$('#' + winId).find("form").form("disableValidation");
				// 修改numberbox宽度错误问题
				if (!!window.ActiveXObject || "ActiveXObject" in window) {
					$.each($(".easyui-numberbox"), function(i, n) {
						$(n).css("width", $(n).width() + 2);
					});
				}
			}
		};
		options = $.extend(defaults, options);
		$('#' + winId).window(options);
	};

	/**
	 * 打开window窗口
	 * 
	 * @param winId 窗口ID
	 * @param options 配置
	 */
	var window_param = null;
	this.openWindow = function(winId, url, param) {
		$('#' + winId).window('open');
		window_param = param;
		if (window_param == null) {
			window_param = {};
		}
		if (url) {
			$('#' + winId).window('refresh', url);
		} else {
			$('#' + winId).find("form").form("enableValidation");
		}
	};
	
	this.getWindowParam = function() {
		return window_param;
	};

	/**
	 * 关闭window窗口
	 * 
	 * @param winId 窗口ID
	 * @param options 配置
	 */
	this.closeWindow = function(winId) {
		$('#' + winId).window('close');
	};

	/**
	 * 打新的窗口
	 */
	this.openDialog = function(options, dlid) {
		var def_dlid = 'newDlg';
		var defaults = {
			iconCls : 'icon-edit',// 默认编辑图标
			modal : true,// 模式
			width : 600,
			height : 400,
			closable : true,// 右侧关闭按钮
			resizable : true,// 可改变大小
			onClose : function() {// 默认关闭时，销毁窗口
				if (dlid) {
					$("#" + dlid).window('destroy');
				} else {
					$("#" + def_dlid).window('destroy');
				}
			}
		};
		options = $.extend(defaults, options);
		if (dlid) {
			def_dlid = dlid;
		}
		if ($("#" + def_dlid).size() == 0) {
			$('<div id="' + def_dlid + '"/>').appendTo('body');
		}
		$("#" + def_dlid).dialog(options);
	};

	/**
	 * 填充下拉列表
	 * 
	 * @param options 配置
	 */
	this.select = function(options) {
		var el = $("#" + options.id);
		var defaults = {
			url : ctx + "/system/parameter/get",
			editable : false,
			valueField : 'value',
			textField : 'name',
//			panelHeight:'auto',
			value:'请选择'
		};
		options = $.extend(defaults, options);
		if (options.param) {
			options.url = options.url.indexOf('?') == -1 ? options.url + "?" : options.url + "&";
			options.url = options.url + $.param(options.param);
		}
		el.combobox(options);
	};

	/**
	 * 填充树形下拉列表
	 * 
	 * @param options 配置
	 */
	this.selectTree = function(options) {
		var el = $("#" + options.id);
		var val = el.val();
		var defaults = {
			idField : 'id',
			textField : 'name',
			parentField : 'parent_id',
			lines : true,
			multiple : false
		};
		options = $.extend(defaults, options);
		if (options.param) {
			options.url = options.url.indexOf('?') == -1 ? options.url + "?" : options.url + "&";
			options.url = options.url + $.param(options.param);
		}
		el.combotree(options);
	};

	/**
	 * 用于取得datagrid选中的行
	 * @param tableId 表格ID
	 * @param isSingle 是否单选
	 */
	this.getSelections = function(tableId, isSingle) {
		var rows = $('#' + tableId).datagrid('getSelections');
		var arr = [];
		$.each(rows, function(index, row) {
			arr.push(row);
		});
		if (isSingle) {
			return arr.length == 1 ? arr[0] : null;
		} else {
			return arr;
		}
	};

	/**
	 * 用于datagrid查询
	 * 
	 * @param tableId 表格ID
	 * @param formId 表单ID
	 * @param paramO 其他参数
	 */
	this.query = function(tableId, formId, paramO) {
		var el = $("#" + tableId);
		var pm = el.datagrid('options').queryParams;
		pm = this.formParams(formId);
		if (!$.isEmptyObject(paramO)) {
			$.extend(pm, paramO);
		}
		el.datagrid('getPager').pagination('refresh', {
			pageNumber: 1
		});
		el.datagrid('options').pageNumber = 1;
		el.datagrid('options').queryParams = pm;
		el.datagrid('reload');
	};

	/**
	 * 用于表单提交
	 * 
	 * @param formId 表单ID
	 * @param validFn 验证函数
	 */
	this.submit = function(formId, validFn) {
		var checkResult = validFn ? validFn() : this.valid(formId);
		var form = $("#" + formId);
		var result = null;
		if (checkResult) {
			$.ajax({
				url : form.attr("action"),
				data : form.serializeArray(),
				async : false,
				type : "post",
				success : function(data) {
					result = data;
				}
			});
		}
		return result;
	};

	/**
	 * ajax访问
	 * 
	 * @param url 表单ID
	 * @param param 验证函数
	 * @param async 异步执行
	 * @param fn 回调函数
	 */
	this.ajax = function(url, param, async, fn) {
		var result = {};
		$.ajax({
			url : url,
			data : param,
			async : async || false,
			type : "post",
			success : function(data) {
				result = data;
				fn && typeof(fn) == "function" && fn(data);
			}
		});
		return result;
	};

	/**
	 * 验证表单
	 * 
	 * @param formId 表单ID
	 */
	this.valid = function(formId) {
		return $('#' + formId).form('validate');
	};

	// 清除验证信息
	this.clearValid = function(formId) {
		$("#" + formId).form('disableValidation');
	};

	/**
	 * 默认的获取表单数据
	 * 
	 * @param formId 表单ID
	 */
	this.formParams = function(formId) {
		var o = {};
		$.each($('#' + formId).serializeArray(), function(index) {
			if (o[this['name']]) {
				o[this['name']] = o[this['name']] + "," + this['value'];
			} else {
				o[this['name']] = this['value'];
			}
		});
		return o;
	};

	/**
	 * 默认的获取表单数据
	 * 
	 * @param id ID
	 * @param formatter 格式
	 * @param initValue 初始值
	 */
	this.datebox = function(id, formatter, initValue) {
		if (id) {
			formatter = formatter ? formatter : "yyyy-MM-dd";
			if (initValue != null) {
				$("#" + id).val(initValue);
			}
			$("#" + id).addClass("Wdate");
			$("#" + id).attr("readonly", "readonly");
			$("#" + id).on("click", function() {
				WdatePicker({skin:'ext', dateFmt:formatter, readOnly:true});
			});
		}
	};

	/**
	 * 正常提示信息
	 * 
	 * @param message 信息
	 */
	this.alert = function(message) {
		$.messager.alert('提示', message, "info");
	};

	/**
	 * 错误提示信息
	 * 
	 * @param message 信息
	 */
	this.error = function(message) {
		$.messager.alert('提示', message, "error");
	};

	/**
	 * 错误提示信息
	 * 
	 * @param message 信息
	 */
	this.confirm = function(message, fn,title) {
		if(!title){
			title="提示";
		}
		$.messager.confirm(title, message, function(result) {
			if (result) {
				fn();
			}
		});
	};

	/**
	 * 弹出提示信息
	 * 
	 * @param message 信息
	 */
	this.show = function(message) {
		$.messager.show({
			title : '提示',
			msg : message
		});
	};

	// 基础信息缓存
	var _SYS_PARAMETER_ = {};
	/**
	 * 获取基础信息，用于列表显示。
	 * 
	 * @param typeCode 类别代码
	 * @param 值
	 */
	this.getSysParam = function(typeCode, value, needBlank) {
		if (needBlank != true || needBlank != "true") {
			needBlank = false;
		}
		// 未缓存先进行查询
		if (!_SYS_PARAMETER_[typeCode]) {
			// 使用的系统参数分页查询
			$.ajax({
				url : ctx + "/system/parameter/get",
				data : {typeCode : typeCode, needBlank : needBlank},
				async : false,
				type : "post",
				success : function(data) {
					if (data && data instanceof Array) {
						_SYS_PARAMETER_[typeCode] = data;
					} else {
						_SYS_PARAMETER_[typeCode] = [];
					}
				}
			});
		}

		if (value == null) {
			return value;//_SYS_PARAMETER_[typeCode];
		}

		for (var i = 0; i < _SYS_PARAMETER_[typeCode].length; i++) {
			var parameter = _SYS_PARAMETER_[typeCode][i];
			if (parameter.value == value) {
				return parameter.name;
			}
		}

		return value;
	};
	
	/**
	 * 检查权限
	 * 
	 * @param permissionCodeArray 权限标识数组
	 * @param 布尔型结果，数组型，对应于权限数组
	 */
	this.checkPermission = function(permissionCodeArray) {
		var result = this.ajax(ctx + "/system/permission/checkPermission", {
			permissionCodeArray : permissionCodeArray.join(",")
		});
		return result.message;
	};
	
	/**
	 * 获取路径
	 * 
	 * @param url
	 */
	this.getTimestampUrl = function(url) {
        url = $.trim(url);
        if (url.indexOf('?') > -1) {
            return global_param.context_name + url + '&timestamp=' + new Date().getTime();
        } else {
            return global_param.context_name + url + '?timestamp=' + new Date().getTime();
        }
    };
    
    this.getHtml = function(url){
    	url = $.trim(url);
        if (url.indexOf('?') > -1) {
            return url + '&timestamp=' + (new Date()).getTime();
        } else {
            return url + '?timestamp=' + (new Date()).getTime();
        }
    	return url;
    };
};

//扩展easyui表单的验证
$.extend($.fn.validatebox.defaults.rules, {
    //校验
	charts:{
		validator: function (value) {
            return /^[a-zA-Z\u0391-\uFFE5]+$/.test(value);
        },
        message: '只支持字母和汉字'
	},
	IsMobile:{
		validator: function (value) {
			return /^(13[0-9]{8})|(15[0-9]{8})|(18[0-9]{8})|(14[0-9]{8})$/.test(value);
        },
        message: '对不起，您输入的手机号码格式不正确!'
	},
	IsMobileAndPhone:{
		validator: function (value) {
//			return /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/.test(value);
			return /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$|((\d{4}-\d{3}-\d{3}))$/.test(value);
        },
        message: '对不起，您输入的手机号码或座机格式不正确!'
	},
	IsString:{
		validator: function (value) {
		
			return /^[a-zA-Z0-9_]+$/.test(value);
        },
        message: '对不起，用户密码只能是数字或英文'
	}
})

$.extend($.fn.validatebox.defaults.rules, {
    //校验
	myidcard:{
		validator: function (value) {
            return textcheck.IdCardValidate(value);
        },
        message: '请输入正确的身份证号码'
	}
})



// 设置权限
//$(function() {
//	var els = $(".permission");
//	var permissionCodeArray = [];
//	$.each(els, function(index, el) {
//		var permission = $(el).attr("permission");
//		$(el).removeClass("permission");
//		permissionCodeArray.push(permission);
//	});
//	if (permissionCodeArray.length > 0) {
//		var result = xf.checkPermission(permissionCodeArray);
//		$.each(els, function(index, el) {
//			if (result[index] == true || result[index] == "true") {
//				$(el).removeClass("permission");
//			} else {
//				$(el).remove();
//			}
//		});
//	}
//});