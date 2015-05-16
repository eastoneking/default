package com.neusoft.emanage.zonghechaxun.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.emanage.zonghechaxun.service.IZonghechaxunService;
import com.neusoft.emanage.zonghechaxun.vo.CXKaiyaoQueryBean;
import com.neusoft.sframe.util.DataGridModel;

@Controller
@RequestMapping(value = "/zonghechaxun/zonghechaxun")
public class ZongheChaxunController {
	private static Logger log = LoggerFactory.getLogger(ZongheChaxunController.class);

	@Autowired
	protected IZonghechaxunService zonghechaxunService;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "yishengkaiyaolist")
	@ResponseBody
	public Map<String, Object>  getYishengKaiyaolist(CXKaiyaoQueryBean queryBean, DataGridModel dgm) {
//		dgm.copyValues(queryBean);
		return zonghechaxunService.getYishengKaiyaolist(queryBean);
//		return keshiweihuService.queryList(queryBean);
	}
	
}
