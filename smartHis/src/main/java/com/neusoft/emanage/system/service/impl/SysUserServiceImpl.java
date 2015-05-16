package com.neusoft.emanage.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.emanage.system.persist.SysUserDao;
import com.neusoft.emanage.system.service.ISysUserService;
import com.neusoft.emanage.system.vo.SysUserQueryBean;
import com.neusoft.emanage.util.gen.entity.SysUserBean;
import com.neusoft.emanage.util.gen.entity.SysUserRoleBean;
import com.neusoft.emanage.util.gen.entity.UserRegsistBean;
import com.neusoft.platform.syscontext.util.MD5Util;
import com.neusoft.sframe.util.EasyUIQueryUtil;
import com.neusoft.sframe.util.SysUtil;

@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {
	@Autowired
	private SysUserDao sysUserDao;
//	@Autowired
//	private UserRegsistDao regsistdao;
//	@Autowired
//	private RegsistDao regsist;
//	@Autowired
//	private AccountManagementSaveDao accountmanagementsave;
	/**
	 * 分页查询
	 * @param queryBean 查询条件
	 * @return 查询结果
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public Map<String, Object> queryList(SysUserQueryBean queryBean) {
		Map<String, Object> paramMap = EasyUIQueryUtil.easyUIparamToMap(queryBean);
		
		// 添加查询条件
		SysUtil.putInMapWhenExists(paramMap, "display_name", queryBean.getDisplay_name(), true);
		SysUtil.putInMapWhenExists(paramMap, "user_name", queryBean.getUser_name(), true);
		

		// 执行查询
		List<SysUserBean> list = sysUserDao.list(paramMap);
		Map<String, Object> result = EasyUIQueryUtil.retParam(list, sysUserDao.findCount(paramMap));
		return result;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @param role_ids 角色id
	 * @return 操作结果
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public String save(SysUserBean bean, Integer[] role_ids) {
		// 保存前检验
		
 		String result = checkSave(bean);
		if (result.equals("success")) {
			// ID为空时为新增，否则为修改
			if (bean.getId() == null) {
				// 新增时密码使用MD5加密
//				String user=regsist.regsistFriend(bean.getUser_name());
				String psw = MD5Util.get32BitMd5EncString(bean.getPassword());
				bean.setPassword(psw);
				for (Integer role_id : role_ids) {
				bean.setDeptid(role_id);
				}
				sysUserDao.save(bean);
				UserRegsistBean userregsistbean=loadingUserRegsist(bean);
//				regsistdao.regsistInsert(userregsistbean);
			} else {
				if(bean.getPassword()!=null){
					if(!bean.getPassword().equals("")){
						String psw = MD5Util.get32BitMd5EncString(bean.getPassword());
						bean.setPassword(psw);
					}
				}
				sysUserDao.update(bean);
//				accountmanagementsave.updateUser(bean);
				sysUserDao.deleteUserRoles(bean.getId());
				result="updatesuccess";
			}
			
			for (Integer role_id : role_ids) {
				SysUserRoleBean ur = new SysUserRoleBean();
				ur.setUser_id(bean.getId());
				ur.setRole_id(role_id);
				sysUserDao.saveUserRole(ur);
			}
		}
		return result;
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @param role_ids 角色id
	 * @return 操作结果
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public String savePassword(Integer user_id, String orgin_password, String new_password) {
		String result = "";
		// 获取用户
		SysUserBean bean = sysUserDao.get(user_id);
		orgin_password = MD5Util.get32BitMd5EncString(orgin_password);
		// 验证原始密码
		if (orgin_password.equals(bean.getPassword())) {
			// 保存新密码
			bean.setPassword(MD5Util.get32BitMd5EncString(new_password));
			result = "success";
		} else {
			result = "原始密码错误";
		}
		return result;
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return 查询结果
	 */
	@Override
	public SysUserBean getById(Integer id) {
	
		return sysUserDao.get(id);
	}

	/**
	 * 根据ID删除
	 * @param id ID
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public void delete(Integer id) {
		sysUserDao.delete(id);
		sysUserDao.deleteUserAccess(id);
	}

	/**
	 * 保存前校验
	 * @param bean 实体
	 * @return 检验结果
	 */
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	private String checkSave(SysUserBean bean) {
		if (sysUserDao.checkSave(bean) > 0) {
			return "S99901";
		} else {
			return "success";
		}
	}

	/**
	 * 获取用户角色
	 * @param ID 用户id
	 * @return 检验结果
	 */
	@Override
	public List<SysUserRoleBean> getRolesByUserId(Integer id) {
		return sysUserDao.getRolesByUserId(id);
	}

	/**
	 * 登录操作
	 * @param bean 存储用户名、密码
	 * @return 登录结果
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public String login(SysUserBean bean) {
		String result = "";
		String user_name = bean.getUser_name();
		String password = MD5Util.get32BitMd5EncString(bean.getPassword());
		List<SysUserBean> list = sysUserDao.getByUsername(user_name);
		if (list.size() == 1) {
			SysUserBean userBean = list.get(0);
			if (password.equals(userBean.getPassword())) {
				result = "success";
				BeanUtils.copyProperties(userBean, bean);
			} else {
				result = "100100";
			}
		} else {
			result = "100100";
		}
		return result;
	}
	public UserRegsistBean loadingUserRegsist(SysUserBean sysuserbean){
		UserRegsistBean userregsistbean =new UserRegsistBean();
		userregsistbean.setRMB(0.0);
		userregsistbean.setGSC(0.0);
		userregsistbean.setUserid(sysuserbean.getId());
		userregsistbean.setStatus("1");
		userregsistbean.setPhone(sysuserbean.getPhone_number());
		userregsistbean.setEmail(sysuserbean.getEmail());
		userregsistbean.setUser_code(sysuserbean.getUser_name());
		userregsistbean.setVersionNum(0);
		userregsistbean.setIdCard(sysuserbean.getIdcard());
		return userregsistbean;
	}
}
