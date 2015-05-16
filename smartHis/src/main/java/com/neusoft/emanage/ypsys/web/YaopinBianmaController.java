package com.neusoft.emanage.ypsys.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.emanage.keshi.service.IKeshiweihuService;
import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.YaopinBianmaBean;
import com.neusoft.emanage.util.gen.entity.YaopinTypeBean;
import com.neusoft.emanage.ypsys.service.IYaopinBianmaService;
import com.neusoft.emanage.ypsys.service.IYaopinTypeService;
import com.neusoft.emanage.ypsys.vo.YaopinBianmaQueryBean;
import com.neusoft.emanage.ypsys.vo.YaopinTypeQueryBean;
import com.neusoft.sframe.util.DataGridModel;

@Controller
@RequestMapping(value = "/ypsys/yaopinbianma")
public class YaopinBianmaController {
	private static Logger log = LoggerFactory.getLogger(YaopinBianmaController.class);

	@Autowired
	protected IYaopinBianmaService yaopinBianmaServiceImpl;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public Map<String, Object> list(YaopinBianmaQueryBean queryBean, DataGridModel dgm) {
//		dgm.copyValues(queryBean);
//		return keshiweihuService.queryList(queryBean);
		return yaopinBianmaServiceImpl.queryList(queryBean);
	}

	/**
	 * 根据ID取得记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getById")
	@ResponseBody
	public YaopinBianmaBean getById(Integer id) {
		return yaopinBianmaServiceImpl.getById(id);
	}

	/**
	 * 保存数据
	 * @param bean 实体
	 * @return
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public String doSave(YaopinBianmaBean bean) {
		String result = "";
		try {
			result = yaopinBianmaServiceImpl.save(bean);
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
			yaopinBianmaServiceImpl.delete(id);
			result = "success";
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "error";
		}
		return result;
	}
}
