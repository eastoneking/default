package com.neusoft.emanage.yaoju.web;

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
@RequestMapping(value = "/yaoju/chuku")
public class ChukuController {
	private static Logger log = LoggerFactory.getLogger(ChukuController.class);

	@Autowired
	protected IChukuService chukuService;

	@Autowired
	protected IZhenduanService zhenduanService;
	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public Map<String, Object>  list(ZhenduanQueryBean queryBean, DataGridModel dgm,HttpServletRequest req) {
		SysUserBean user = SysUtil.getLoginUser(req);
//		queryBean.setZd_yishengid(user.getId());
//		dgm.copyValues(queryBean);
		return zhenduanService.queryList(queryBean);
		
	}
	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "listinfo")
	@ResponseBody
	public Map<String, Object>  listinfo(ChukuQueryBean queryBean, DataGridModel dgm,HttpServletRequest req) {
		return chukuService.listinfo(queryBean);
		
	}
	/**
	 * 药品出库利润统计列表
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "lrlist")
	@ResponseBody
	public Map<String, Object>  lrlist(LirunQueryBean queryBean, DataGridModel dgm,HttpServletRequest req) {
		SysUserBean user = SysUtil.getLoginUser(req);
		return chukuService.queryLrlist(queryBean);
	}
	/**
	 * 药品出库利润明细列表
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "lrinfolist")
	@ResponseBody
	public Map<String, Object>  lrinfolist(ChukuQueryBean queryBean, DataGridModel dgm) {
		return chukuService.queryLrinfolist(queryBean);
	}
	/**
	 * 按类别查询
	 * @param typeCode 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "get")
	@ResponseBody
	public List<ChukuBean> getByTypeCode(String typeCode) {
	
		return chukuService.getByTypeCode(typeCode);
	}

	/**
	 * 根据ID取得记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getById")
	@ResponseBody
	public ChukuBean getById(Integer id) {
		return chukuService.getParameterById(id);
	}

	/**
	 * 保存数据
	 * @param bean 实体
	 * @return
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public String doSave(ChukuBean bean,HttpServletRequest req) {
		String result = "";
		try {
//			SysUserBean user = SysUtil.getLoginUser(req);
//			bean.setZd_yishengid(user.getId());
//			bean.setZd_yishengname(user.getDisplay_name());
//			bean.setZd_status("0");
			result = chukuService.save(bean);
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "100012";
		}
		return result;
	}
	/**
	 * 删除数据
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String doDelete(Integer id) {
		String result = "";
		try {
			chukuService.delete(id);
			result = "success";
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "error";
		}
		return result;
	}
}
