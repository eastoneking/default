package com.neusoft.emanage.liruntongji.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.emanage.kaiyao.service.IZhenduanService;
import com.neusoft.emanage.kaiyao.vo.ZhenduanQueryBean;
import com.neusoft.emanage.liruntongji.service.ILirunService;
import com.neusoft.emanage.util.gen.entity.ChukuBean;
import com.neusoft.emanage.util.gen.entity.SysUserBean;
import com.neusoft.emanage.util.gen.entity.ZhenduanBean;
import com.neusoft.emanage.yaoju.service.IChukuService;
import com.neusoft.emanage.yaoju.vo.ChukuQueryBean;
import com.neusoft.emanage.yaoju.vo.LirunQueryBean;
import com.neusoft.emanage.yaoju.vo.YaopinCKQueryBean;
import com.neusoft.sframe.util.DataGridModel;
import com.neusoft.sframe.util.SysUtil;

@Controller
@RequestMapping(value = "/lirun/lirun")
public class LirunController {
	private static Logger log = LoggerFactory.getLogger(LirunController.class);

	@Autowired
	protected ILirunService lirunService;

	/**
	 * 药品出库利润统计列表
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "yjlrlist")
	@ResponseBody
	public Map<String, Object>  lrlist(LirunQueryBean queryBean, DataGridModel dgm,HttpServletRequest req) {
		SysUserBean user = SysUtil.getLoginUser(req);
		return lirunService.queryLrlist(queryBean);
	}
	/**
	 * 药品出库利润明细列表
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "yjlrinfolist")
	@ResponseBody
	public Map<String, Object>  lrinfolist(ChukuQueryBean queryBean, DataGridModel dgm) {
		return lirunService.queryLrinfolist(queryBean);
	}
	/**
	 * 药品出库利润统计列表
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "sylrlist")
	@ResponseBody
	public Map<String, Object>  yslrlist(LirunQueryBean queryBean, DataGridModel dgm,HttpServletRequest req) {
		SysUserBean user = SysUtil.getLoginUser(req);
		queryBean.setZd_yishengid(user.getId().toString());
		return lirunService.queryLrlist(queryBean);
	}
}
