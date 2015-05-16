package com.neusoft.emanage.liruntongji.vo;
import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 
 * @author zhangshixi date:2014年6月20日
 * 诊断开药表
 */
public class LirunQueryBean extends EasyUiBaseBean  {

	private static final long serialVersionUID = 1L;
	private String sel_time_start;
	private String sel_time_end;
	
	public String getSel_time_start() {
		return sel_time_start;
	}
	public void setSel_time_start(String sel_time_start) {
		this.sel_time_start = sel_time_start;
	}
	public String getSel_time_end() {
		return sel_time_end;
	}
	public void setSel_time_end(String sel_time_end) {
		this.sel_time_end = sel_time_end;
	}
	
}
