package com.neusoft.emanage.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.emanage.system.persist.SysRoleDao;
import com.neusoft.emanage.system.service.ISysRoleService;
import com.neusoft.emanage.system.vo.SysRoleQueryBean;
import com.neusoft.emanage.util.gen.entity.SysRoleBean;
import com.neusoft.emanage.util.gen.entity.SysRolePermissionBean;
import com.neusoft.emanage.util.gen.entity.SysUserRoleBean;
import com.neusoft.sframe.util.EasyUIQueryUtil;
import com.neusoft.sframe.util.SysUtil;

@Service("sysRoleService")
public class SysRoleServiceImpl implements ISysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;

	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	public Map<String, Object> queryList(SysRoleQueryBean queryBean) {
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);

		// 添加查询条件
		SysUtil.putInMapWhenExists(paramMap, "name", queryBean.getName(), false);
		
		// 执行查询
		List<SysRoleBean> list = sysRoleDao.list(paramMap);
		
		return EasyUIQueryUtil.retParam(list, sysRoleDao.findCount(paramMap));
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @param permission_ids 权限ID
	 * @return 操作结果
	 */
	@Override
	public String save(SysRoleBean bean, Integer[] permission_ids) {
		// 保存前检验
		String result = checkSave(bean);
		if (result.equals("success")) {
			// ID为空时为新增，否则为修改
			if (bean.getId() == null) {
				sysRoleDao.save(bean);
			} else {
				sysRoleDao.update(bean);
				sysRoleDao.deleteRolePermissions(bean.getId());
			}
			for (Integer permission_id : permission_ids) {
				SysRolePermissionBean rp = new SysRolePermissionBean();
				rp.setRole_id(bean.getId());
				rp.setPermission_id(permission_id);
				sysRoleDao.saveRolePermission(rp);
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
	public SysRoleBean getById(Integer id) {
		return sysRoleDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	public String roleDelete(Integer id) {

		SysUserRoleBean sys_user_role=sysRoleDao.searchRole(id);
		if(sys_user_role.getRole_id()>0){
			return "roleerr";
		}
		sysRoleDao.delete(id);
		return null;
		
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 检验结果
	 */
	private String checkSave(SysRoleBean bean) {
		if (sysRoleDao.checkSave(bean) > 0) {
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
	public List<SysRoleBean> getUserRole() {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 添加查询条件
//		SysUtil.putInMapWhenExists(paramMap, "text", queryBean.getText(), true);
//		SysUtil.putInMapWhenExists(paramMap, "status", queryBean.getStatus(), false);

		// 添加分页查询条件
		paramMap.put("sortname", "orders");
		paramMap.put("sortorder", "asc");

		// 执行查询
		List<SysRoleBean> list = sysRoleDao.list(paramMap);

		return list;
	}

	@Override
	public List<SysRolePermissionBean> getPermissionsByRoleId(Integer id) {
		return sysRoleDao.getPermissionsByRoleId(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SysRoleBean> searchRole() {
		Map<String, Object> paramMap=new HashMap<String,Object>();
		List<SysRoleBean> list = sysRoleDao.list(paramMap);
		return list;
	}
}
