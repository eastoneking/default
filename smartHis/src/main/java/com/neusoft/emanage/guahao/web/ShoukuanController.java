package com.neusoft.emanage.guahao.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.emanage.guahao.service.IGuahaoService;
import com.neusoft.emanage.guahao.service.IShoukuanService;
import com.neusoft.emanage.guahao.vo.GuaHaoQueryBean;
import com.neusoft.emanage.guahao.vo.ShoukuanQueryBean;
import com.neusoft.emanage.kaiyao.service.IZhenduanService;
import com.neusoft.emanage.kaiyao.vo.ZhenduanQueryBean;
import com.neusoft.emanage.keshi.service.IKeshiweihuService;
import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.util.gen.entity.GuaHaoBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.ShoukuanBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.SysUserBean;
import com.neusoft.sframe.util.DataGridModel;
import com.neusoft.sframe.util.SysUtil;

@Controller
@RequestMapping(value = "/guahao/shoukuan")
public class ShoukuanController {
	private static Logger log = LoggerFactory.getLogger(GuahaoController.class);

	@Autowired
	protected IShoukuanService shoukuanService;
	@Autowired
	protected IZhenduanService zhenduanService;
	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public Map<String, Object>  list(ZhenduanQueryBean queryBean, DataGridModel dgm) {
//		dgm.copyValues(queryBean);
		return zhenduanService.queryList(queryBean);
//		return shoukuanService.queryList(queryBean);
//		return keshiweihuService.queryList(queryBean);
	}
	
	/**
	 * 按类别查询
	 * @param typeCode 查询条件
	 * @return 查询结果
	 */
	@RequestMapping(value = "get")
	@ResponseBody
	public List<ShoukuanBean> getByTypeCode(String typeCode) {
	
		return shoukuanService.getByTypeCode(typeCode);
	}

	/**
	 * 根据ID取得记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getById")
	@ResponseBody
	public ShoukuanBean getById(Integer id) {
		return shoukuanService.getParameterById(id);
	}

	/**
	 * 保存数据
	 * @param bean 实体
	 * @return
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public String doSave(ShoukuanBean bean,HttpServletRequest req) {
		SysUserBean user = SysUtil.getLoginUser(req);
		bean.setGhsf_skperson(user.getDisplay_name());
		bean.setGhsf_skpersonid(user.getId().toString());
		String result = "";
		try {
			result = shoukuanService.save(bean);
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
			shoukuanService.delete(id);
			result = "success";
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "error";
		}
		return result;
	}
}
