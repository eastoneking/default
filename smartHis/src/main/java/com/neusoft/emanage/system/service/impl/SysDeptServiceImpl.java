package com.neusoft.emanage.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.system.persist.SysDeptDao;
import com.neusoft.emanage.system.service.ISysDeptService;
import com.neusoft.emanage.system.vo.SysDeptQueryBean;
import com.neusoft.emanage.util.gen.entity.SysDeptBean;
import com.neusoft.sframe.util.SysUtil;

@Service("sysDeptService")
public class SysDeptServiceImpl implements ISysDeptService {
	@Autowired
	private SysDeptDao sysDeptDao;

	/**
	 * 查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public List<SysDeptBean> queryList(SysDeptQueryBean queryBean) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 添加查询条件
		SysUtil.putInMapWhenExists(paramMap, "name", queryBean.getName(), false);

		// 添加分页查询条件
		paramMap.put("sortname", queryBean.getSortname());
		paramMap.put("sortorder", queryBean.getSortorder());

		// 执行查询
		List<SysDeptBean> list = sysDeptDao.list(paramMap);

		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	public String save(SysDeptBean bean) {
		// 保存前检验
		String result = checkSave(bean);
		if (result.equals("success")) {
			// ID为空时为新增，否则为修改
			if (bean.getId() == null) {
				sysDeptDao.save(bean);
			} else {
				sysDeptDao.update(bean);
			}
		}
		return result;
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public SysDeptBean getById(Integer id) {
		return sysDeptDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		sysDeptDao.delete(id);
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 检验结果
	 */
	private String checkSave(SysDeptBean bean) {
		if (sysDeptDao.checkSave(bean) > 0) {
			return "S99901";
		} else {
			return "success";
		}
	}
}
