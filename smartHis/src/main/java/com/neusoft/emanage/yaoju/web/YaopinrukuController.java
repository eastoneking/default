package com.neusoft.emanage.yaoju.web;

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
import com.neusoft.emanage.util.gen.entity.YaopinCKBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKRKBean;
import com.neusoft.emanage.yaoju.service.IYaopinrukuService;
import com.neusoft.emanage.yaoju.vo.YaopinCKRKQueryBean;
import com.neusoft.sframe.util.DataGridModel;

@Controller
@RequestMapping(value = "/yaoju/ruku")
public class YaopinrukuController {
	private static Logger log = LoggerFactory.getLogger(YaopinrukuController.class);

	@Autowired
	protected IYaopinrukuService yaopinrukuService;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public  Map<String, Object>  list(YaopinCKRKQueryBean queryBean, DataGridModel dgm) {
//		dgm.copyValues(queryBean);
		return yaopinrukuService.queryList(queryBean);
	}
	
	/**
	 * 按类别查询
	 * @param typeCode 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "get")
	@ResponseBody
	public List<YaopinCKRKBean> getByTypeCode(String typeCode) {
	
		return yaopinrukuService.getByTypeCode(typeCode);
	}

	/**
	 * 根据ID取得记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getById")
	@ResponseBody
	public YaopinCKRKBean getById(Integer id) {
		return yaopinrukuService.getParameterById(id);
	}

	/**
	 * 保存数据
	 * @param bean 实体
	 * @return
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public String doSave(YaopinCKRKBean bean) {
		String result = "";
		try {
			result = yaopinrukuService.save(bean);
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
			yaopinrukuService.delete(id);
			result = "success";
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "error";
		}
		return result;
	}
}
