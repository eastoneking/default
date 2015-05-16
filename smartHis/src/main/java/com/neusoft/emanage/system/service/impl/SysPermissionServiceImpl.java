package com.neusoft.emanage.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.system.persist.SysPermissionDao;
import com.neusoft.emanage.system.service.ISysPermissionService;
import com.neusoft.emanage.system.vo.SysPermissionQueryBean;
import com.neusoft.emanage.util.gen.entity.SysPermissionBean;
import com.neusoft.sframe.util.SysUtil;

@Service("sysPermissionService")
public class SysPermissionServiceImpl implements ISysPermissionService {
	@Autowired
	private SysPermissionDao sysPermissionDao;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public List<SysPermissionBean> queryList(SysPermissionQueryBean queryBean) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 添加查询条件
		SysUtil.putInMapWhenExists(paramMap, "status", queryBean.getStatus(), false);

		// 添加分页查询条件
		paramMap.put("sortname", queryBean.getSortname());
		paramMap.put("sortorder", queryBean.getSortorder());

		// 执行查询
		List<SysPermissionBean> list = sysPermissionDao.list(paramMap);

		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	public String save(SysPermissionBean bean) {
		// 保存前检验
		String result = checkSave(bean);
		if (result.equals("success")) {
			// ID为空时为新增，否则为修改
			if (bean.getId() == null) {
				sysPermissionDao.save(bean);
			} else {
				sysPermissionDao.update(bean);
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
	public SysPermissionBean getById(Integer id) {
		return sysPermissionDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		sysPermissionDao.delete(id);
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 检验结果
	 */
	private String checkSave(SysPermissionBean bean) {
		if (sysPermissionDao.checkSave(bean) > 0) {
			return "S99901";
		} else {
			return "success";
		}
	}

	/**
	 * 获取用户菜单
	 * @param user_id 用户ID TODO 加入权限
	 * @return 查询结果
	 */
	@Override
	public List<SysPermissionBean> getUserPermission() {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 添加查询条件
//		SysUtil.putInMapWhenExists(paramMap, "text", queryBean.getText(), true);
//		SysUtil.putInMapWhenExists(paramMap, "status", queryBean.getStatus(), false);

		// 添加分页查询条件
//		paramMap.put("sortname", "orders");
//		paramMap.put("sortorder", "asc");

		// 执行查询
		List<SysPermissionBean> list = sysPermissionDao.list(paramMap);

		return list;
	}
}
