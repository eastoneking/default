//閲嶅啓toFixed鏂规硶锛岃В鍐充笉鍚屾祻瑙堝櫒瑙ｆ瀽宸紓鐨凚UG
Number.prototype.toFixed = function(exponent) {
	var j = Math.pow(10, exponent);
	var i = 0;
	if(this<0){
		i = this * j - 0.5;
	}else{
		i = this * j + 0.5;
	}
	
	var a = parseInt(i);
	var b = Math.pow(10, exponent);
    return (a/b).toString();
};
//涓簀s鐨凞ate瀵硅薄鍔犲叆浜嗘牸寮忓寲鏂规硶
Date.prototype.format = function(fmt) {
    var o = {
        "M+": this.getMonth() + 1, //鏈堜唤 
        "d+": this.getDate(), //鏃�
        "h+": this.getHours(), //灏忔椂 
        "m+": this.getMinutes(), //鍒�
        "s+": this.getSeconds(), //绉�
        "q+": Math.floor((this.getMonth() + 3) / 3), //瀛ｅ害 
        "S": this.getMilliseconds() //姣 
    };
    if (/(y+)/.test(fmt)){
         fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o){
         if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    }
    return fmt;
};
var globalUtil = {
    //鍏ㄥ眬棰滆壊鍙橀噺
    RED: '#FF6666',
    ORANGE: '#FF9933',
    BLUE: '#5C7DFE',
    GREEN: '#00FF66',

    _intervalIdArray: [],
    registInterval: function(intervalId) {
        this._intervalIdArray.push(intervalId);
    },
    closeAllInterval: function() {
        for (var i = 0; i < this._intervalIdArray.length; i++) {
            window.clearInterval(this._intervalIdArray[i]);
        }
        this._intervalIdArray = [];
    },
    
	_functionWrapperObj: {},
    /**
     * 鏂规硶璁℃暟鍖呰鍣�
     * @param varStr 璁℃暟鍖呰鍣ㄥ紩鐢ㄥ璞″瓧绗︿覆
     * @param _fn 鏂规硶
     */
	setFunctionWrapper: function(varStr, _fn) {
		if (!$.trim(varStr) || typeof _fn != 'function') return;
		if (this._functionWrapperObj[varStr] == undefined) {
			this._functionWrapperObj[varStr] = 0;
		}
		this._functionWrapperObj[varStr]++;
		_fn();
		this._functionWrapperObj[varStr]--;
	},
    /**
     * 鍦╲arStr瀵瑰簲鐨勬柟娉曡鏁板寘瑁呭櫒鍑芥暟鎵ц瀹屾垚鍚庢墽琛宊fn
     * @param varStr 璁℃暟鍖呰鍣ㄥ紩鐢ㄥ璞imer瀛楃涓�
     * @param _fn 鏂规硶
     */
	functionRunOut: function(varStr, _fn) {
		if (!$.trim(varStr) || typeof _fn != 'function') return;
		if (this._functionWrapperObj[varStr] == undefined 
				|| this._functionWrapperObj[varStr] == 0) {
			if (this._functionWrapperObj[varStr+'timer']) {
				window.clearInterval(this._functionWrapperObj[varStr+'timer']);
				this._functionWrapperObj[varStr+'timer'] = null;
			}
			_fn();
		} else if (!this._functionWrapperObj[varStr+'timer']) {
			this._functionWrapperObj[varStr+'timer'] = window.setInterval(function() {
				this.functionRunOut(varStr, _fn);
			}, 200);
		}
	},
    
    getUrlParameter: function(strParame) {
        var args = new Object();
        var query = location.search.substring(1);
        var pairs = query.split("&"); // Break at ampersand 
        for (var i = 0; i < pairs.length; i++) {
            var pos = pairs[i].indexOf('=');
            if (pos == -1) continue;
            var argname = pairs[i].substring(0, pos);
            var value = pairs[i].substring(pos + 1);
            value = decodeURIComponent(value);
            args[argname] = value;
        }
        return args[strParame];
    },
    
    //鑾峰彇鐖惰妭鐐�
    getTreeFatherNode: function(tree, node) {
        if (!node || !tree) {
            return null;
        }
        var treenode = tree.getNodeDom(node);
        var treeitem = $(treenode.target);
        var pnode = {};
        if (treeitem.parent().hasClass("l-tree")) {
            return null;
        }
        if (treeitem.parent().parent("li").length === 0) {
            return null;
        }
        pnode.target = treeitem.parent().parent("li")[0];
        pnode.data = tree.getDataByID($(pnode.target).attr("id"));
        return pnode;
    },
    
    // 寰楀埌鏍戠殑鏈�ぇ灞傜骇
    getTreeMaxLevel: function(tree) {
        var maxLevel = 0;
        var setMaxLevel = function(node, level) {
            if (maxLevel < (level + 1)) {
                maxLevel = level + 1;
            }
            var childNodes = node && (node.data || node.children);
            if (childNodes) {
                for (var i = 0; i < childNodes.length; i++) {
                    setMaxLevel(childNodes[i], level + 1);
                }
            }
        };
        if (tree.length && tree.length > 0) {
            $.each(tree,
            function(index, node) {
                setMaxLevel(node, -1);
            });
        } else {
            setMaxLevel(tree, -1);
        }
        return maxLevel;
    },

    //鏍戞帶浠舵枃瀛楅粯璁ゅ搴�
    defaultWidth: 50,
    //姣忎釜姹夊瓧鐨勫搴�
    singleWorldWidth: 12,

    // 寰楀埌鏍戞帶浠舵枃瀛楀搴�
    getTreeMaxWidth: function(tree) {
        var sObj = this;
        var maxLevel = sObj.getTreeMaxLevel(tree);
        var maxWidth = sObj.defaultWidth;

        var setMaxWidth = function(node, level) {
            var nodeWidth = 0;
            if (node.text) {
                nodeWidth = node.text.length * sObj.singleWorldWidth - (maxLevel - level) * 22;
                if (maxWidth < nodeWidth) {
                    maxWidth = nodeWidth;
                }
            }

            var childNodes = node && (node.data || node.children);
            if (childNodes) {
                for (var i = 0; i < childNodes.length; i++) {
                    setMaxWidth(childNodes[i], level + 1);
                }
            }
        };

        setMaxWidth(tree, 0);
        return maxWidth + 22;
    },

    // 寰楀埌鏍戞帶浠舵暣浣撳搴�
    getTreeWholeWidth: function(tree, step) {
        var sObj = this;
        step = step || 22;
        var maxLevel = sObj.getTreeMaxLevel(tree);
        var maxWidth = sObj.getTreeMaxWidth(tree);

        return maxWidth + maxLevel * step;
    },
    //浣跨敤get鏂瑰紡锛屽悓姝ヨ幏鍙栧悗鍙版暟鎹紝杩斿洖鏁版嵁缁撴瀯涓簀son
    syncGetJson: function(url, params,method) {
        var data = {};
        $.ajax({
            type: method || "GET",
            url: globalUtil.getTimestampUrl(url),
            data: params,
            async: false,
            dataType: 'json',
            success: function(json) {
                data = json;
            }
        });
        return data;
    },
    // loading control with it's url, when some error happens, u need call this function
    errorHandle: function(data) {
        var msg = data && data.error;
        if (msg) {
            if (msg === '100091') {
                this.errorMsg(globalErrorMsg['100091']);
                return false;
            }
            if (msg === '100092') {
            	//re login system
            	if(this.getCookieValue("cookie_username")){
            		reloginsys();
            		return;
            	}
                this.confirmMsg(globalErrorMsg['100092'], '鎻愮ず',
                function(yes) {
                    if (yes) {
                    	var obj = globalUtil._getMainpageObj(parent);
                    	obj.location.href = global_param.context_name + "/login.html";
                    } else {
                        // 姝ゅ鍒犻櫎鎺夊脊鍑虹殑澶氫綑纭妗嗭紙褰撳皢鍦板潃绮樿创鍒版柊鐨勬祻瑙堝櫒涓椂鍊欎細鍑虹幇寮瑰嚭2涓‘璁ゆ鐨勯棶棰橈紝妯℃�鎺у埗浼氭贩涔憋紝姝ゅ閬垮厤姝ら棶棰橈級
                        this.clearAllDialog();
                    }
                },
                true);
                return false;
            }
        }
        return true;
    },
    reloginsys:function(){
    	$.post(this.getTimestampUrl("/login.do"),
				 {"userCode": this.getCookieValue("cookie_username"), "userPasswd": this.getCookieValue("cookie_passwd")}, 
				 function(data) {
				if (data.error) {
					if (data.error === '100100') {
						$.ligerDialog.error(globalErrorMsg['100100']);
					} else if (data.error === '100101') {
						$.ligerDialog.error(globalErrorMsg['100101']);
					} else if (data.error === '100109') {
						openDialog();
					}
				} else {
					this.resetCookieValue('cookie_username', account, 7);
					this.resetCookieValue('cookie_passwd', pwd, 7);
					colseDialog();
				}
			}
		);
    },
    _getMainpageObj: function(obj){
    	var tmp = obj.parent;
    	while(tmp!=obj){
    		obj = tmp;
    		tmp = obj.parent;
    	}
    	return tmp;
    },

    // 娓呴櫎椤甸潰涓婄殑鎵�湁寮瑰嚭妗�
    clearAllDialog: function() {
        $('.l-window-mask').remove();
        $('.l-dialog').remove();
    },

    //娓呴櫎涓嬫媺妗嗘帶浠跺け鍘荤劍鐐瑰悗锛屼笅鎷夋涓嶆敹缂╃殑闂
    clearAllCombo: function() {
        $('.l-box-select').hide();
    },

    _mask: {},
    addMask: function(id) {
        this._mask[id] = $("<div class='l-window-mask' style='display: block;z-index: 9100' id=" + id + "></div>").appendTo('body');

    },
    delMask: function(id) {
        this._mask[id].remove();
    },

    showLoading: function() {
        $("<div class='l-loading-img' style='display:block;'></div>").appendTo('body');
        $("<div class='l-loading-text' style='display:block;'></div>").appendTo('body');
    },
    closeLoading: function() {
        $(".l-loading-img").remove();
        $(".l-loading-text").remove();
    },
    setLoadingText: function(str) {
        $(".l-loading-text").html(str);
    },

    //focusObj:dialog鍏抽棴鍚庨渶瑕佽幏鍙栫殑鐒︾偣瀵硅薄
    _alert: function(msg, type, callBackFunc) {
        var that = this;
        var obj;
        var timestamp = new Date().getTime();
        that.addMask(timestamp);

        if (type === 'success') {
            obj = $.ligerDialog.success(msg, null, null);
            var autoClose = setTimeout(function() { //2绉掑悗鑷姩鍏抽棴
                obj.close();
            },
            2000);
            obj.options.onHiddenOrClose = function() {
                that.delMask(timestamp);
                clearTimeout(autoClose); //鍙栨秷鑷姩鍏抽棴鏃堕棿锛岄伩鍏嶆墜鍔ㄥ叧闂椂閲嶅璋冪敤onHiddenOrClose鏂规硶
                if (callBackFunc && typeof(callBackFunc) == 'function') {
                    callBackFunc();
                }
            };
            return;
        } else if (type === 'error') {
            obj = $.ligerDialog.error(msg, null, callBackFunc);
        } else if (type === 'warn') {
            obj = $.ligerDialog.warn(msg, null, callBackFunc);
        } else if (type === 'alert') {
            obj = $.ligerDialog.alert(msg, null, 'alert', callBackFunc);
        }
        obj.options.onHiddenOrClose = function() {
            that.delMask(timestamp);
        };
    },
    successMsg: function(msg, callBackFunc) {
        this._alert(msg, 'success', callBackFunc);
    },
    warnMsg: function(msg, callBackFunc) {
        this._alert(msg, 'warn', callBackFunc);
    },
    errorMsg: function(msg, callBackFunc) {
        this._alert(msg, 'error', callBackFunc);
    },
    alertMsg: function(msg, callBackFunc) {
        this._alert(msg, 'alert', callBackFunc);
    },
    confirmMsg: function(content, title, callback, isClearAll, resetHeight, resetWidth) {
        var that = this;
        var obj = $.ligerDialog.confirm(content, title, callback);
        that.addMask('confirm');
        if (resetHeight) obj._setHeight(resetHeight);
        if (resetWidth) obj._setWidth(resetWidth);
        obj.options.onHiddenOrClose = function() {
            that.delMask('confirm');
            if (isClearAll) {
                that.clearAllDialog();
            }
        };
    },
    setDialogHeight: function(height) {
        return document.body.offsetHeight < height ? document.body.offsetHeight: height;
    },

    checkSession: function() {
//        $.getJSON(this.getTimestampUrl("/sysmanage/authorizedStub.do"),
//        function(data) {
//            globalUtil.errorHandle(data);
//        });
    },
    openTab: function(tabId, tabName, url, removeAll) {
        var $query = window.parent.window.$;
        tab = $query("#framecenter").ligerGetTabManager();
        if (tab.isTabItemExist(tabId)) {
            tab.removeTabItem(tabId);
        }
        if (removeAll) {
            tab.removeAll();
        }

        if (url.indexOf('?') > -1) {
            url = url + '&timestamp=' + new Date().getTime();
        } else {
            url = url + '?timestamp=' + new Date().getTime();
        }

        tab.addTabItem({
            tabid: tabId,
            text: tabName,
            url: url
        });
    },
    removeOtherTab: function(tabId) {
        var $query = window.parent.window.$;
        tab = $query("#framecenter").ligerGetTabManager();
        tab.removeOther(tabId);
    },
    closeCurrentTab: function() {
        var $query = window.parent.window.$;
        tab = $query("#framecenter").ligerGetTabManager();
        tab.removeSelectedTabItem();
    },
    isEmail: function(value) {
        value = $.trim(value);
        return /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i.test(value);
    },
    /**
     * 楠岃瘉鏄惁涓洪偖鏀跨紪鐮侊紝楠岃瘉涓�1浣嶆暟瀛�
     * @param value
     * @returns
     */
   isPostalCode: function(value) {
       value = $.trim(value);
       return /^[0-9]{6}$/.test(value);
   },
    /**
     * 楠岃瘉鏄惁涓烘墜鏈哄彿鐮侊紝楠岃瘉涓�1浣嶆暟瀛�
     * @param value
     * @returns
     */
    isPhone: function(value) {
        value = $.trim(value);
        return /^[1][358]\d{9}$/.test(value);
    },
    /**
     * 楠岃瘉鏄惁涓鸿韩浠借瘉鍙凤紝鍙獙璇佷簡浣嶆暟鍜屽嚭鐢熸棩鏈�
     * @param value
     * @returns {Boolean}
     */
    isIdCard: function(value) {
        value = $.trim(value);
        value = value.toUpperCase(); //杞负澶у啓
        if (value.length == 15) {
            if (!/^[0-9]{15}$/.test(value)) {
                return false;
            }
            var year = value.substring(6, 8);
            var month = value.substring(8, 10);
            var day = value.substring(10, 12);
            var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
            // 瀵逛簬鑰佽韩浠借瘉涓殑浣犲勾榫勫垯涓嶉渶鑰冭檻鍗冨勾铏棶棰樿�浣跨敤getYear()鏂规硶   
            if (temp_date.getYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1 || temp_date.getDate() != parseFloat(day)) {
                return false;
            } else {
                return true;
            }
        } else if (value.length == 18) {
            if (!/^[0-9]{17}([0-9]|X)$/.test(value)) {
                return false;
            }
            var year = value.substring(6, 10);
            var month = value.substring(10, 12);
            var day = value.substring(12, 14);
            var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
            // 杩欓噷鐢╣etFullYear()鑾峰彇骞翠唤锛岄伩鍏嶅崈骞磋櫕闂   
            if (temp_date.getFullYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1 || temp_date.getDate() != parseFloat(day)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    },
    getTimestampUrl: function(url) {
        url = $.trim(url);
        if (url.indexOf('?') > -1) {
            return global_param.context_name + url + '&timestamp=' + new Date().getTime();
        } else {
            return global_param.context_name + url + '?timestamp=' + new Date().getTime();
        }
    },

    /**
     * 楠岃瘉鏄惁涓烘鏁存暟
     * @param value
     * @returns
     */
    isNum: function(value) {
        value = $.trim(value);
        return /^[1-9]+[0-9]*$/.test(value);
    },
    //楠岃瘉鏄惁涓哄疄鏁帮紝濡傛灉褰曞叆012锛岃繑鍥瀎alse
    isFloat: function(str) {
        var myreg = /^(-?((0|[1-9]+)|([1-9]\d*)))(\.\d+)?$/;
        return myreg.test(str);
    },
    /**
     * 楠岃瘉鏄惁涓烘寚瀹氭牸寮忕殑瀹炴暟(鍖呮嫭璐熸暟鍜屾暣鏁板拰灏忔暟鐐�
     * @param value锛�intLen鏁存暟閮ㄥ垎鏈�暱闀垮害锛宖loatLen灏忔暟閮ㄥ垎鏈�暱闀垮害
     * @returns
     */
    isReal: function(val1ue, intLen, floatLen) {
        value = $.trim(value);
        if (!this.isFloat(value)) { //棣栧厛楠岃瘉鏄惁涓哄疄鏁�
            return false;
        }
        var pattern;
        if (!intLen) {
            return /^-?\d+(\.\d+)?$/.test(value);
        } else if (!floatLen) {
            pattern = new RegExp('^-?\\d{1,' + intLen + '}$', '');
        } else {
            pattern = new RegExp('^-?\\d{1,' + intLen + '}(\\.\\d{1,' + floatLen + '})?$', '');
        }

        return pattern.test(value);
    },
    //涓嶈繘琛屽洓鑸嶄簲鍏ヤ繚鐣檔浣嶅皬鏁�
    changeDecimal: function(x, n) {
        if (!this.isFloat(x)) {
            return x;
        }
        if ($.trim(x).length == 0) {
            return '';
        }
        var str = $.trim(x) + '';
        var pattern = new RegExp('\-{0,1}[0-9]+(\.[0-9]{1,' + n + '}){0,1}', '');
        str = str.match(pattern)[0];
        return parseFloat(str);
    },
    //涓嶈繘琛屽洓鑸嶄簲鍏ヤ繚鐣檔浣嶅皬鏁�
    changeDecimal2: function(x, n) {
        if (!this.isFloat(x)) {
            return x;
        }
        if ($.trim(x).length == 0) {
            return '';
        }
        var str = $.trim(x) + '';
        var pattern = new RegExp('\-{0,1}[0-9]+(\.[0-9]{1,' + n + '}){0,1}', '');
        str = str.match(pattern)[0];
        return str;
    },
    //鍥涜垗浜斿叆淇濈暀n浣嶅皬鏁�
    changeDecimalRound: function(x, n) {
        if (!this.isFloat(x)) {
            return x;
        }
        return parseFloat(x).toFixed(n);
    },
    //鍥涜垗浜斿叆淇濈暀n浣嶅皬鏁�
    changeDecimalRoundHalfEven: function(num, precision) {
    	if (!this.isFloat(precision)) {
    		return precision;
    	}
    	var dnum = Math.pow(10,precision);
        if(Math.floor(num*dnum*10)%5 == 0 && Math.floor(num*dnum*10) == num*dnum*10 && Math.floor(num*dnum)%2 == 0){
            return Math.floor(num*dnum)/dnum;
        }else{
        	var i = parseFloat(num);
        	var result = i.toFixed(precision)
            return result;
        }
    },

    isEmpty: function(val) {
        if (typeof(val) == 'number') {
            val += '';
        }
        var str = val || '';
        return $.trim(str).length == 0;
    },

    //楠岃瘉锛氬ぇ灏忓啓鑻辨枃瀛楃銆佹暟瀛椼�杩炲瓧绗︺�涓嬪垝绾垮洓绫诲瓧绗�
    checkSectCode: function(sectCode) {
        var sectCode = $.trim(sectCode);
        var a = /^([a-z]|[A-Z]|\-|_|\d){1,}$/;
        if (!a.test(sectCode)) {
            return false;
        } else return true;
    },
    
    /**
	   * 杩囨护瀵硅薄鎴栨暟缁勭殑灞炴�
	   * @param obj 瀵硅薄鎴栨暟缁�
	   * @param value 杩囨护鍊�
	   * @param deep 鏄惁娣卞眰杩囨护
	   */
    deleteAttributes: function(obj, value, deep) {
    	if (jQuery.isPlainObject(obj)) {
        	for (var A in obj) {
        		if ((jQuery.isPlainObject(obj[A]) || jQuery.isArray(obj[A])) && deep) {
        			globalUtil.deleteAttributes(obj[A], value, deep);
        		} else if (obj[A] === value) {
    				delete obj[A];
        		}
        	}
    	} else if (jQuery.isArray(obj)) {
    		var temp = [];
    		jQuery.each(obj, function(i, n) {
        		if ((jQuery.isPlainObject(n) || jQuery.isArray(n)) && deep) {
        			globalUtil.deleteAttributes(n, value, deep);
        			if (n.length != 0) {
        				temp.push(n);
        			}
        		} else if (n !== value) {
        			temp.push(n);
        		}
    		});
    		obj.splice(0, obj.length);
    		if (temp.length != 0) {
    			for (var i = 0, l = temp.length; i < l; i++) {
    				obj.push(temp[i]);
    			}
    		}
    	}
    },
    //杩斿洖褰撳墠鏃ユ湡鐨勫瓧绗︿覆
    getCurrentDateStr: function() {
        var now = new Date();
        var year = now.getFullYear(); //骞�
        var month = now.getMonth() + 1; //鏈�
        var day = now.getDate(); //鏃�
        var clock = year + "-";
        if (month < 10) clock += "0";
        clock += month + "-";
        if (day < 10) clock += "0";
        clock += day;
        return (clock);
    },
    //杩斿洖褰撳墠鏃堕棿鐨勫瓧绗︿覆锛寉yyy-MM-dd HH:mm:ss
    getCurrentDatetimeStr: function() {
        var now = new Date();
        return this._transToDateStr(now);
    },

    /**
	   * 鏍规嵁format鐨勬牸寮忓dateStr杩涜鏍煎紡鍖栵紝鍐呴儴閫氳繃瀛楃涓茬殑鎴彇瀹炵幇
	   * @param datestr
	   * @param format yyyy-MM-dd HH:mm:ss
	   */
    formatDateStr: function(datestr, format) {
        format = $.trim(format);
        var len = format.length;
        if (datestr.length < len) {
            return '';
        }
        return datestr.substring(0, len);
    },
    //鑾峰彇鍜屾寚瀹氭棩鏈熷瓧绗︿覆宸�diff鏃ョ殑鏃ユ湡
    getDiffDateStr: function(datestr, diff) {
        if (typeof(datestr) != 'date') {
            datestr = datestr.replace(/-/g, "/");
            datestr = new Date(datestr);
        }
        datestr.setDate(datestr.getDate() + (diff));
        var newDate = this.formatDateStr(this._transToDateStr(datestr), 'yyyy-MM-dd');
        return newDate;
    },
    //鑾峰彇鍜屾寚瀹氭棩鏈熷瓧绗︿覆宸�diff鏈堢殑鏃ユ湡
    getDiffMonthStr: function(datestr, diff) {
        if (typeof(datestr) != 'date') {
            datestr = datestr.replace(/-/g, "/");
            datestr = new Date(datestr);
        }
        datestr.setMonth(datestr.getMonth() + (diff));
        var newDate = this.formatDateStr(this._transToDateStr(datestr), 'yyyy-MM-dd');
        return newDate;
    },
    /*
	 * 杩斿洖鎸囧畾鏃ユ湡瀛楃涓插鍔犳寚瀹氭椂闂达紝杩斿洖澧炲姞鍚庣殑鏃ユ湡瀛楃涓�
	 * param涓搴旂殑value搴旇涓烘暟鍊硷紝涓嶈兘鍐欐垚瀛楃涓�
	 * */

    getDiffDateFormatStr: function(datestr, param, format) {
        if (typeof(datestr) != 'date') {
            datestr = datestr.replace(/-/g, "/");
            datestr = new Date(datestr);
        }
        if (param.year) {
            datestr.setFullYear(datestr.getFullYear() + (param.year));
        }
        if (param.month) {
            datestr.setMonth(datestr.getMonth() + (param.month));
        }
        if (param.date) {
            datestr.setDate(datestr.getDate() + (param.date));
        }
        if (param.hour) {
            datestr.setHours(datestr.getHours() + (param.hour));
        }
        if (param.min) {
            datestr.setMinutes(datestr.getMinutes() + (param.min));
        }
        if (param.sec) {
            datestr.setSeconds(datestr.getSeconds() + (param.sec));
        }
        var newDate = this.formatDateStr(this._transToDateStr(datestr), format);
        return newDate;
    },
    //杩斿洖鎸囧畾骞存湀浠界殑鎬诲ぉ鏁�
    searchDays: function(varYear, varMonth) {
        var lngDay;
        switch (varMonth) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            lngDay = 31;
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            lngDay = 30;
            break;
        case 2:
            if ((varYear % 4 == 0 && varYear % 100 != 0 || (varYear % 400 == 0))) {
                lngDay = 29;
            } else {
                lngDay = 28;
            }
            break;
        }
        return lngDay;
    },
    getFirstDayOfCurrentMonth: function() {
        var now = new Date();
        var year = now.getFullYear(); //骞�
        var month = now.getMonth() + 1; //鏈�
        var day = "01"; //鏃�
        var clock = year + "-";
        if (month < 10) clock += "0";
        clock += month + "-";
        clock += day;
        return (clock);
    },
    getLastDayOfCurrentMonth: function() {
        var now = new Date();
        var year = now.getFullYear(); //骞�
        var month = now.getMonth() + 1; //鏈�		
        var day = this.searchDays(year, month); //鏃�
        var clock = year + "-";
        if (month < 10) clock += "0";
        clock += month + "-";
        clock += day;
        return (clock);
    },
    _transToDateStr: function(datetime) {
        var year = datetime.getFullYear(); //骞�
        var month = datetime.getMonth() + 1; //鏈�
        var day = datetime.getDate(); //鏃�
        var hour = datetime.getHours();
        var min = datetime.getMinutes();
        var sec = datetime.getSeconds();
        var clock = year + "-";
        if (month < 10) clock += "0";
        clock += month + "-";
        if (day < 10) clock += "0";
        clock += day;
        clock += " ";
        if (hour < 10) {
            clock += "0";
        }
        clock += hour;
        clock += ":";
        if (min < 10) {
            clock += "0";
        }
        clock += min;
        clock += ":";
        if (sec < 10) {
            clock += "0";
        }
        clock += sec;
        return clock;
    },
    getCookieValue: function(cookieName){
    	var name = cookieName || 'cookie_username';
    	return $.cookie(name) || '';
    },
    setCookieValue: function(cookieName, cookieVal, expireDay){
    	if(global_param.use_cookie){
    		cookieName = cookieName || 'empty';
        	cookieVal = cookieVal || '';
        	expireDay = expireDay || 7;
        	$.cookie(cookieName, cookieVal, {expires: expireDay});
    	}
    },
    resetCookieValue: function(cookieName,cookieVal, expireDay){
    	$.removeCookie(cookieName);
    	globalUtil.setCookieValue(cookieName, cookieVal, expireDay);
    },
    
    isMobile: {
			Android: function() {
				return navigator.userAgent.match(/Android/i) ? true: false;
			},
			BlackBerry: function() {
				return navigator.userAgent.match(/BlackBerry/i) ? true: false;
			},
			iOS: function() {
				return navigator.userAgent.match(/iPhone|iPad|iPod/i) ? true: false;
			},
			Windows: function() {
				return navigator.userAgent.match(/IEMobile/i) ? true: false;
			},
			any: function() {
				return (this.Android() || this.BlackBerry() || this.iOS() || this.Windows());
			}
	},
    getHtml:function(url){
    	url = $.trim(url);
        if (url.indexOf('?') > -1) {
            return url + '&timestamp=' + (new Date()).getTime();
        } else {
            return url + '?timestamp=' + (new Date()).getTime();
        }
    	return url;
    },
    /*
     * 鑾峰彇鎸囧畾瀵硅薄涓嬬殑鎵�湁input銆乼extarea鍊�
     * divid锛氬灞傜殑id
     * jsonStr锛氬鏋滄棤锛屾柊鍒涘缓涓�釜瀵硅薄锛屽鏋滄湁锛岀洿鎺ュ湪瀵硅薄涓坊鍔�
     * isCheck:鏄惁杩涜蹇呭～椤瑰垽鏂�
     */
    getFormParam: function(divid,jsonStr,isCheck){
    	var inputlist = $("#"+divid+" input[type=text]");
    	var textarealist = $("#"+divid+" textarea");
    	var selectlist = $("#"+divid+" select");
    	var param = {};
    	if(jsonStr){
    		param = jsonStr;
    	}
    	
    	var iserror =false;
    	$.each(inputlist,function(i,obj){
		  var id = obj.id;
		  var name = obj.name;
		  if(!id && !name){
			  
		  }else{
			  var ligeruiid = obj.attributes.ligeruiid;
			  var val = $.trim(obj.value);
			  if(val == ''){
				  if(isCheck && $(obj).attr("isrequired") == '1'){
					  if(obj.style.display == 'none' || (obj.parentNode && obj.parentNode.style.display == 'none')){//鐖惰妭鐐规槸鍚﹂殣钘�
						  
					  }else{
						  iserror =true;
						  obj.style.border = '1px dotted #FF0000';
						  //$(obj).attr({"style":"border: 1px dotted #FF0000;"});
					  }
				  }
			  }else{
				  obj.style.border = '';
			  }
			  if(ligeruiid){
				  val = $("#"+id+"_hidden").val();
			  }
			  if(name){
				  param[name] = val;
			  }else{
				  param[id] = val;
			  }
		  }
		});
    	$.each(textarealist,function(i,obj){
		  var id = obj.id;
		  var name = obj.name;
		  if(!id && !name){
			  
		  }else{
			  var val = $.trim(obj.value);
			  if(val == ''){
				  if(isCheck && $(obj).attr("isrequired") == '1'){
					  if(obj.parentNode && obj.parentNode.style.display == 'none'){//鐖惰妭鐐规槸鍚﹂殣钘�
						  
					  }else{
						  iserror =true;
						  obj.style.border = '1px dotted #FF0000';
						  //$(obj).attr({"style":"border: 1px dotted #FF0000;"});
					  }
				  }
			  }else{
				  obj.style.border = '';
			  }
			  if(name){
				  param[name] = val;
			  }else{
				  param[id] = val;
			  }
		  }
		});
    	$.each(selectlist,function(i,obj){
  		  var id = obj.id;
  		  var name = obj.name;
  		  if(!id && !name){
  			  
  		  }else{
  			  var val = $.trim(obj.value);
  			  if(val == ''){
  				  if(isCheck && $(obj).attr("isrequired") == '1'){
  					  /*if(obj.parentNode && obj.parentNode.style.display == 'none'){//鐖惰妭鐐规槸鍚﹂殣钘�
  						  
  					  }else{
  						  iserror =true;
  						  obj.style.border = '1px dotted #FF0000';
  						  //$(obj).attr({"style":"border: 1px dotted #FF0000;"});
  					  }*/
  				  }
  			  }else{
  				 /* obj.style.border = '';*/
  			  }
  			  if(name){
  				  param[name] = val;
  			  }else{
  				  param[id] = val;
  			  }
  		  }
  		});
    	if(iserror){
    		return 'error';
    	}
    	return param;
    },
    /*
     * 鎸囧畾瀵硅薄涓嬬殑鎵�湁input銆乼extarea鍊�闄や笅鎷夋锛屼笅鎷夋闇�鍗曠嫭璧嬪�)
     */
    setFormVal: function(divid,param){
    	var inputlist = $("#"+divid+" input[type=text]");
    	var textarealist = $("#"+divid+" textarea");
    	$.each(inputlist,function(i,obj){
    		var id = obj.id;
    		var name = obj.name;
    		var ligeruiid = obj.attributes.ligeruiid;
    		var val = name ? param[name] : param[id];
    		if(!ligeruiid){
    			$(obj).val(val);
    		}
    		
    	});
    	$.each(textarealist,function(i,obj){
    		var id = obj.id;
    		var name = obj.name;
    		if(name){
    			$(obj).val(param[name]);
	  		}else{
	  			$(obj).val(param[id]);
	  		}
    	});
    }
};