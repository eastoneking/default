package com.neusoft.emanage.commonSelect.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.emanage.commonSelect.service.ICSelectService;
import com.neusoft.emanage.keshi.service.IKeshiweihuService;
import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.util.gen.entity.GuaHaoBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.YaopinBianmaBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKBean;
import com.neusoft.emanage.util.gen.entity.YaopinTypeBean;
import com.neusoft.sframe.util.DataGridModel;

@Controller
@RequestMapping(value = "/select/getByCode")
public class CSelectController {
	private static Logger log = LoggerFactory.getLogger(CSelectController.class);

	@Autowired
	protected ICSelectService cselectService;

	/**
	 * 按类别查询
	 * @param typeCode 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "getYaopinType")
	@ResponseBody
	public List<YaopinTypeBean> getYaopinTypeByTypeCode(String typeCode) {
		return cselectService.getYaopinTypeByTypeCode(typeCode);
	}
	/**
	 * 获取药品编码
	 * @param typeCode 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "getyaopinbianma")
	@ResponseBody
	public List<YaopinBianmaBean> getYaopinBianMa(String typeCode) {
		return cselectService.getYaopinBianMa(typeCode);
	}
	/**
	 * 获取药品库存
	 * @param typeCode 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "getyaopinkucun")
	@ResponseBody
	public List<YaopinCKBean> getYaopinKuCun(String typeCode) {
		return cselectService.getYaopinKuCun(typeCode);
	}
	/**
	 * 获取科室列表
	 * @param typeCode 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "getkeshilist")
	@ResponseBody
	public List<KeshiBean> getKeshilist(String typeCode) {
		return cselectService.getKeshilist(typeCode);
	}
	/**
	 * 获取科室列表
	 * @param typeCode 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "getguahaolist")
	@ResponseBody
	public List<GuaHaoBean> getGuaHaolist(String typeCode) {
		return cselectService.getGuaHaolist(typeCode);
	}
}
