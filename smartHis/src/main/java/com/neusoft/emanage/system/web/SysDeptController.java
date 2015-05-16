package com.neusoft.emanage.system.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.emanage.system.service.ISysDeptService;
import com.neusoft.emanage.system.vo.SysDeptQueryBean;
import com.neusoft.emanage.util.gen.entity.SysDeptBean;
import com.neusoft.sframe.util.DataGridModel;

@Controller
@RequestMapping(value = "/system/dept")
public class SysDeptController {
	private static Logger log = LoggerFactory.getLogger(SysDeptController.class);

	@Autowired
	protected ISysDeptService sysDeptService;

	/**
	 * 树型查询
	 * @param SysDeptBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public List<SysDeptBean> list(SysDeptQueryBean queryBean, DataGridModel dgm) {
		dgm.copyValues(queryBean);
		return sysDeptService.queryList(queryBean);
	}

	/**
	 * 根据ID取得记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getById")
	@ResponseBody
	public SysDeptBean getById(Integer id) {
		return sysDeptService.getById(id);
	}

	/**
	 * 保存数据
	 * @param bean 实体
	 * @return
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public String doSave(SysDeptBean bean) {
		String result = "";
		try {
			result = sysDeptService.save(bean);
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
			sysDeptService.delete(id);
			result = "success";
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "error";
		}

		return result;
	}
}