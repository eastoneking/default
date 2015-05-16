package com.neusoft.emanage.ypsys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.YaopinBianmaBean;
import com.neusoft.emanage.util.gen.entity.YaopinTypeBean;
import com.neusoft.emanage.ypsys.persist.YaopinBianmaDao;
import com.neusoft.emanage.ypsys.persist.YaopinTypeDao;
import com.neusoft.emanage.ypsys.service.IYaopinBianmaService;
import com.neusoft.emanage.ypsys.service.IYaopinTypeService;
import com.neusoft.emanage.ypsys.vo.YaopinBianmaQueryBean;
import com.neusoft.emanage.ypsys.vo.YaopinTypeQueryBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;

@Service("yaopinBianmaServiceImpl")
public class YaopinBianmaServiceImpl implements IYaopinBianmaService {
	@Autowired
	private YaopinBianmaDao yaopinBianmaDao;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public  Map<String, Object>   queryList(YaopinBianmaQueryBean queryBean) {
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<YaopinBianmaBean> list = yaopinBianmaDao.list(paramMap);
		return EasyUIQueryUtil.retParam(list, yaopinBianmaDao.findCount(paramMap));
//		
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//
//		// 添加查询条件
//		paramMap.put("ypbmname", queryBean.getYpbmname());
//		paramMap.put("ypbmnumber", queryBean.getYpbmnumber());
////		paramMap.put("string_property", queryBean.getString_property());
//
//		// 添加查询条件
////		SysUtil.putInMapWhenExists(paramMap, "type", queryBean.getType(), true);
////	   SysUtil.putInMapWhenExists(paramMap, "typeCode", queryBean.getTypeCode(), true);
//
//		
//		// 添加分页查询条件
//		paramMap.put("sortname", queryBean.getSortname());
//		paramMap.put("sortorder", queryBean.getSortorder());
//
//		// 执行分页查询
//		List<YaopinBianmaBean> list = yaopinBianmaDao.list(paramMap);
//		// 构建前台需要数据结构
////		GridDataBean<Map<String, Object>> bean = new GridDataBean<Map<String, Object>>(queryBean.getPage(),
////				parameterDao.findCount(paramMap), list);
//
//		return list;
	}


	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	public String save(YaopinBianmaBean bean) {
			// ID为空时为新增，否则为修改
		if (bean.getId() == null) {
			yaopinBianmaDao.save(bean);
		} else {
			yaopinBianmaDao.update(bean);
		}
		return "success";
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public YaopinBianmaBean getById(Integer id) {
		return yaopinBianmaDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		yaopinBianmaDao.delete(id);
	}
}
