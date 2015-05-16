package com.neusoft.emanage.system.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.emanage.system.service.ISysRoleService;
import com.neusoft.emanage.system.vo.SysRoleQueryBean;
import com.neusoft.emanage.util.gen.entity.SysRoleBean;
import com.neusoft.emanage.util.gen.entity.SysRolePermissionBean;
import com.neusoft.sframe.util.DataGridModel;

@Controller
@RequestMapping(value = "/system/role")
public class SysRoleController {
	private static Logger log = LoggerFactory.getLogger(SysRoleController.class);

	@Autowired
	protected ISysRoleService sysRoleService;

	/**
	 * 树型查询
	 * @param SysRoleBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public Map<String, Object> list(SysRoleQueryBean queryBean, DataGridModel dgm) {
//		dgm.copyValues(queryBean);
		return sysRoleService.queryList(queryBean);
	}
	/**
	 * 获得角色表中的名称
	 * @return
	 */
	@RequestMapping(value = "searchrole")
	@ResponseBody
	public List<SysRoleBean> searchRole(){
		return sysRoleService.searchRole();
		
	}
	/**
	 * 根据ID取得记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getById")
	@ResponseBody
	public SysRoleBean getById(Integer id) {
		return sysRoleService.getById(id);
	}

	/**
	 * 根据ID取得记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getPermissionsByRoleId")
	@ResponseBody
	public List<SysRolePermissionBean> getPermissionsByRoleId(Integer id) {
		return sysRoleService.getPermissionsByRoleId(id);
	}

	/**
	 * 保存数据
	 * @param bean 实体
	 * @return
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public String doSave(SysRoleBean bean, Integer[] permission_ids) {
		String result = "";
		try {
			result = sysRoleService.save(bean, permission_ids);
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
			result=sysRoleService.roleDelete(id);
			if("roleerr".equals(result)){
				return result;
			}
			result = "success";
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "error";
		}

		return result;
	}

	/**
	 * 分页查询
	 * @param SysRoleBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "getUserRole")
	@ResponseBody
	public List<SysRoleBean> getUserRole() {
		return sysRoleService.getUserRole();
	}
}