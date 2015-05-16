package com.neusoft.emanage.system.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.SysUserBean;
import com.neusoft.emanage.util.gen.entity.SysUserRoleBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface SysUserDao extends BaseDao<SysUserBean> {
	List<SysUserBean> list(Map<String, Object> paramMap);
	int checkSave(SysUserBean bean);
	List<SysUserBean> getByUsername(String user_name);
	void deleteUserRoles(Integer user_id);
	void saveUserRole(SysUserRoleBean ur);
	List<SysUserRoleBean> getRolesByUserId(Integer user_id);
	public void deleteUserAccess(Integer id);
}