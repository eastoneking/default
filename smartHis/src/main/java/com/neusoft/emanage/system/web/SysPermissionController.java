package com.neusoft.emanage.system.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.emanage.system.service.ISysPermissionService;
import com.neusoft.emanage.system.vo.SysPermissionQueryBean;
import com.neusoft.emanage.util.gen.entity.SysPermissionBean;
import com.neusoft.sframe.util.DataGridModel;

@Controller
@RequestMapping(value = "/system/permission")
public class SysPermissionController {
	private static Logger log = LoggerFactory.getLogger(SysPermissionController.class);

	@Autowired
	protected ISysPermissionService sysPermissionService;

	/**
	 * 树型查询
	 * @param SysPermissionBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public List<SysPermissionBean> list(SysPermissionQueryBean queryBean, DataGridModel dgm) {
		dgm.copyValues(queryBean);
		return sysPermissionService.queryList(queryBean);
	}

	/**
	 * 根据ID取得记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getById")
	@ResponseBody
	public SysPermissionBean getById(Integer id) {
		return sysPermissionService.getById(id);
	}

	/**
	 * 保存数据
	 * @param bean 实体
	 * @return
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public String doSave(SysPermissionBean bean) {
		String result = "";
		try {
			result = sysPermissionService.save(bean);
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "100012";
		}
		return result;
	}

	@RequestMapping(value = "delete")
	@ResponseBody
	public String doDelete(Integer id) {
		String result = "";
		try {
			sysPermissionService.delete(id);
			result = "success";
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "error";
		}

		return result;
	}

	/**
	 * 分页查询
	 * @param SysPermissionBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "getUserPermission")
	@ResponseBody
	public List<SysPermissionBean> getUserPermission() {
		return sysPermissionService.getUserPermission();
	}
}