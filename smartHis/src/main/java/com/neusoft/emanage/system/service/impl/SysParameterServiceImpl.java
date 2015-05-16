package com.neusoft.emanage.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.system.persist.SysParameterDao;
import com.neusoft.emanage.system.service.ISysParameterService;
import com.neusoft.emanage.system.vo.SysParameterQueryBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.sframe.util.SysUtil;

@Service("parameterService")
public class SysParameterServiceImpl implements ISysParameterService {
	@Autowired
	private SysParameterDao parameterDao;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public List<SysParameterBean> queryList(SysParameterQueryBean queryBean) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 添加查询条件
//		paramMap.put("name", queryBean.getName());
//		paramMap.put("number_property", queryBean.getNumber_property());
//		paramMap.put("string_property", queryBean.getString_property());

		// 添加查询条件
		SysUtil.putInMapWhenExists(paramMap, "type", queryBean.getType(), true);
	   SysUtil.putInMapWhenExists(paramMap, "typeCode", queryBean.getTypeCode(), true);

		
		// 添加分页查询条件
		paramMap.put("sortname", queryBean.getSortname());
		paramMap.put("sortorder", queryBean.getSortorder());

		// 执行分页查询
		List<SysParameterBean> list = parameterDao.list(paramMap);
		// 构建前台需要数据结构
//		GridDataBean<Map<String, Object>> bean = new GridDataBean<Map<String, Object>>(queryBean.getPage(),
//				parameterDao.findCount(paramMap), list);

		return list;
	}

	/**
	 * 按类别查询
	 * @param typeCode 类别
	 * @return 查询结果
	 */
	@Override
	public List<SysParameterBean> getByTypeCode(String typeCode) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		//执行查询
		List<SysParameterBean> list = parameterDao.getByTypeCode(typeCode);
		
		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	public String save(SysParameterBean bean) {
			// ID为空时为新增，否则为修改
		if (bean.getId() == null) {
			parameterDao.save(bean);
		} else {
			parameterDao.update(bean);
		}
		return "success";
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public SysParameterBean getParameterById(Integer id) {
		return parameterDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		parameterDao.delete(id);
	}
}
