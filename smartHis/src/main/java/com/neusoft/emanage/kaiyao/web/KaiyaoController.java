package com.neusoft.emanage.kaiyao.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.emanage.kaiyao.service.IKaiyaoService;
import com.neusoft.emanage.kaiyao.service.IZhenduanService;
import com.neusoft.emanage.kaiyao.vo.KaiyaoQueryBean;
import com.neusoft.emanage.kaiyao.vo.ZhenduanQueryBean;
import com.neusoft.emanage.util.gen.entity.KaiyaoBean;
import com.neusoft.emanage.util.gen.entity.SysUserBean;
import com.neusoft.emanage.util.gen.entity.ZhenduanBean;
import com.neusoft.sframe.util.DataGridModel;
import com.neusoft.sframe.util.SysUtil;

@Controller
@RequestMapping(value = "/kaiyao/kaiyao")
public class KaiyaoController {
	private static Logger log = LoggerFactory.getLogger(KaiyaoController.class);

	@Autowired
	protected IKaiyaoService kaiyaoService;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public Map<String, Object>  list(KaiyaoQueryBean queryBean, DataGridModel dgm,HttpServletRequest req) {
//		SysUserBean user = SysUtil.getLoginUser(req);
//		queryBean.setZd_yishengid(user.getId());
//		dgm.copyValues(queryBean);
		return kaiyaoService.queryList(queryBean);
//		return keshiweihuService.queryList(queryBean);
	}
	
	/**
	 * 按类别查询
	 * @param typeCode 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "get")
	@ResponseBody
	public List<KaiyaoBean> getByTypeCode(String typeCode) {
	
		return kaiyaoService.getByTypeCode(typeCode);
	}
	/**
	 * 按类别查询
	 * @param typeCode 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "getcount")
	@ResponseBody
	public String getCount(String zdid) {
	
		return kaiyaoService.getCount(zdid);
	}
	/**
	 * 根据ID取得记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getById")
	@ResponseBody
	public KaiyaoBean getById(Integer id) {
		return kaiyaoService.getParameterById(id);
	}

	/**
	 * 保存数据
	 * @param bean 实体
	 * @return
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public String doSave(KaiyaoBean bean,HttpServletRequest req) {
		String result = "";
		try {
//			SysUserBean user = SysUtil.getLoginUser(req);
//			bean.setZd_yishengid(user.getId());
//			bean.setZd_yishengname(user.getDisplay_name());
//			bean.setZd_status("0");
			result = kaiyaoService.save(bean);
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
			kaiyaoService.delete(id);
			result = "success";
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "error";
		}
		return result;
	}
}
