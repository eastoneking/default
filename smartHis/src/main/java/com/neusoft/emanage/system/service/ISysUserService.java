/*
 * @(#)IDemoService.java
 * Copyright (c) 2007-2008 goldcow
 * All rights reserved.
 */
package com.neusoft.emanage.system.service;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.system.vo.SysUserQueryBean;
import com.neusoft.emanage.util.gen.entity.SysUserBean;
import com.neusoft.emanage.util.gen.entity.SysUserRoleBean;

/**
 * 服务层接口
 * 
 * @author chengrongchang
 * @version 1.0
 * @time 2014-5-27
 * @description 
 */
public interface ISysUserService {
	public Map<String, Object> queryList(SysUserQueryBean queryBean);
	public String save(SysUserBean bean, Integer[] role_ids);
	public SysUserBean getById(Integer id);
	public List<SysUserRoleBean> getRolesByUserId(Integer id);
	public void delete(Integer id);
	String savePassword(Integer user_id, String orgin_password, String new_password);
	public String login(SysUserBean bean);

}