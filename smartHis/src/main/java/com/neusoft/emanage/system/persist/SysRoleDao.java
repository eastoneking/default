package com.neusoft.emanage.system.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.SysRoleBean;
import com.neusoft.emanage.util.gen.entity.SysRolePermissionBean;
import com.neusoft.emanage.util.gen.entity.SysUserRoleBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface SysRoleDao extends BaseDao<SysRoleBean> {

	List<SysRoleBean> list(Map<String, Object> paramMap);

	int checkSave(SysRoleBean bean);

	void deletePermissionByRoleId(Integer role_id);

	void insertRolePermission(SysRolePermissionBean rolePermission);

	void deleteRolePermissions(Integer role_id);

	void saveRolePermission(SysRolePermissionBean rp);

	List<SysRolePermissionBean> getPermissionsByRoleId(Integer role_id);
	/**检查用户角色是否使用 */
	public  SysUserRoleBean searchRole(Integer id);
	/**
	 * 查询总条数
	 */
	public int findCount(Map<String, Object> paramMaps);
	
}