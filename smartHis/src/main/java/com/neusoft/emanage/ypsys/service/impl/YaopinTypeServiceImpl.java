package com.neusoft.emanage.ypsys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.YaopinBianmaBean;
import com.neusoft.emanage.util.gen.entity.YaopinTypeBean;
import com.neusoft.emanage.ypsys.persist.YaopinTypeDao;
import com.neusoft.emanage.ypsys.service.IYaopinTypeService;
import com.neusoft.emanage.ypsys.vo.YaopinTypeQueryBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;

@Service("yaopinTypeServiceImpl")
public class YaopinTypeServiceImpl implements IYaopinTypeService {
	@Autowired
	private YaopinTypeDao yaopinTypeDao;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public Map<String, Object> queryList(YaopinTypeQueryBean queryBean) {
		
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		// 执行查询
		List<YaopinTypeBean> list = yaopinTypeDao.list(paramMap);
		return EasyUIQueryUtil.retParam(list, yaopinTypeDao.findCount(paramMap));
	}

	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<YaopinTypeBean> getByTypeCode(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//执行查询
		List<YaopinTypeBean> list = yaopinTypeDao.getByTypeCode(typeCode);
		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	public String save(YaopinTypeBean bean) {
			// ID为空时为新增，否则为修改
		if (bean.getId() == null) {
			yaopinTypeDao.save(bean);
		} else {
			yaopinTypeDao.update(bean);
		}
		return "success";
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public YaopinTypeBean getParameterById(Integer id) {
		return yaopinTypeDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		yaopinTypeDao.delete(id);
	}
}
