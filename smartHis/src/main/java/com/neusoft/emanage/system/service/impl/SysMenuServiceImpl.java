package com.neusoft.emanage.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.system.persist.SysMenuDao;
import com.neusoft.emanage.system.service.ISysMenuService;
import com.neusoft.emanage.system.vo.SysMenuQueryBean;
import com.neusoft.emanage.util.gen.entity.SysMenuBean;
import com.neusoft.sframe.util.SysUtil;

@Service("sysMenuService")
public class SysMenuServiceImpl implements ISysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public List<SysMenuBean> queryList(SysMenuQueryBean queryBean) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 添加查询条件
		SysUtil.putInMapWhenExists(paramMap, "text", queryBean.getText(), true);
		SysUtil.putInMapWhenExists(paramMap, "status", queryBean.getStatus(), false);

		// 添加分页查询条件
		paramMap.put("sortname", queryBean.getSortname());
		paramMap.put("sortorder", queryBean.getSortorder());

		// 执行查询
		List<SysMenuBean> list = sysMenuDao.list(paramMap);

		return list;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 操作结果
	 */
	@Override
	public String save(SysMenuBean bean) {
		// 保存前检验
		String result = checkSave(bean);
		if (result.equals("success")) {
			// ID为空时为新增，否则为修改
			if (bean.getId() == null) {
				sysMenuDao.save(bean);
			} else {
				sysMenuDao.update(bean);
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
	public SysMenuBean getById(Integer id) {
		return sysMenuDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public void delete(Integer id) {
		sysMenuDao.delete(id);
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 检验结果
	 */
	private String checkSave(SysMenuBean bean) {
		if (sysMenuDao.checkSave(bean) > 0) {
			return "S99901";
		} else {
			return "success";
		}
	}

	/**
	 * 获取用户菜单
	 * @param user_id 用户ID TODO 加入权限
	 * @return 检验结果
	 */
	@Override
	public List<SysMenuBean> getUserMenu(Integer user_id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 执行查询
		List<SysMenuBean> list = sysMenuDao.getUserMenu(user_id);

		return list;
	}
}
