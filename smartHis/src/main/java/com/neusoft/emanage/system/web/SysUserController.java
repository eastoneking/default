package com.neusoft.emanage.system.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.emanage.system.service.ISysUserService;
import com.neusoft.emanage.system.vo.SysUserQueryBean;
import com.neusoft.emanage.util.gen.entity.SysUserBean;
import com.neusoft.emanage.util.gen.entity.SysUserRoleBean;
import com.neusoft.sframe.util.DataGridModel;
import com.neusoft.sframe.util.EasyUIQueryUtil;

@Controller
@RequestMapping(value = "/system/user")
public class SysUserController {
	private static Logger log = LoggerFactory.getLogger(SysUserController.class);

	@Autowired
	protected ISysUserService sysUserService;

	/**
	 * 树型查询
	 * @param SysUserBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public Map<String,Object> list(SysUserQueryBean queryBean, DataGridModel dgm) {
		//dgm.copyValues(queryBean);
		return sysUserService.queryList(queryBean);
	}

	/**
	 * 根据ID取得记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getById")
	@ResponseBody
	public SysUserBean getById(Integer id) {
		return sysUserService.getById(id);
	}
	
	/**
	 * 根据ID取得记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getRolesByUserId")
	@ResponseBody
	public List<SysUserRoleBean> getRolesByUserId(Integer id) {
		return sysUserService.getRolesByUserId(id);
	}

	/**
	 * 保存数据
	 * @param bean 实体
	 * @return
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public String doSave(SysUserBean bean, Integer[] role_ids) {
		String result = "";
		try {
			System.out.println(role_ids);
			result = sysUserService.save(bean, role_ids);
			
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
			sysUserService.delete(id);
			result = "success";
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "error";
		}

		return result;
	}

}