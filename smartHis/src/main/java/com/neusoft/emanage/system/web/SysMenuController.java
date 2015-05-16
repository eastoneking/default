package com.neusoft.emanage.system.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.emanage.system.service.ISysMenuService;
import com.neusoft.emanage.system.vo.SysMenuQueryBean;
import com.neusoft.emanage.util.gen.entity.SysMenuBean;
import com.neusoft.emanage.util.gen.entity.SysUserBean;
import com.neusoft.sframe.util.DataGridModel;
import com.neusoft.sframe.util.GlobalVal;
import com.google.common.collect.Lists;

@Controller
@RequestMapping(value = "/system/menu")
public class SysMenuController {
	private static Logger log = LoggerFactory.getLogger(SysMenuController.class);

	@Autowired
	protected ISysMenuService sysMenuService;

	/**
	 * 树型查询
	 * @param SysMenuBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public List<SysMenuBean> list(SysMenuQueryBean queryBean, DataGridModel dgm) {
		dgm.copyValues(queryBean);
		return sysMenuService.queryList(queryBean);
	}

	/**
	 * 根据ID取得记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getById")
	@ResponseBody
	public SysMenuBean getById(Integer id) {
		return sysMenuService.getById(id);
	}

	/**
	 * 保存数据
	 * @param bean 实体
	 * @return
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public String doSave(SysMenuBean bean) {
		String result = "";
		try {
			result = sysMenuService.save(bean);
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
			sysMenuService.delete(id);
			result = "success";
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "error";
		}

		return result;
	}

	@RequestMapping(value = "getIcons")
	@ResponseBody
	public List<String> getIcons(HttpServletRequest request) {
		List<String> iconList = Lists.newArrayList();
		File file = new File(request.getSession().getServletContext().getRealPath("/"), "resources/css/icon.css");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String content = null;
			while ((content = br.readLine()) != null) {
				if (content.matches("^\\s*\\..*\\s*\\{")) {
					int s = content.indexOf(".");
					int e = content.indexOf("{");
					String name = content.substring(s + 1, e).trim();
					iconList.add(name);
				}
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return iconList;
	}
	
	/**
	 * 查询用户菜单
	 * @param user_id 用户ID
	 * @return 查询结果
	 */
	@RequestMapping(value = "getUserMenu")
	@ResponseBody
	public List<SysMenuBean> getUserMenu(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SysUserBean bean = (SysUserBean) session.getAttribute(GlobalVal.USER_SESSION);
		return sysMenuService.getUserMenu(bean.getId());
	}
}