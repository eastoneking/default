/*
 * @(#)IDemoService.java
 * Copyright (c) 2007-2008 goldcow
 * All rights reserved.
 */
package com.neusoft.emanage.system.service;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.system.vo.SysRoleQueryBean;
import com.neusoft.emanage.util.gen.entity.SysRoleBean;
import com.neusoft.emanage.util.gen.entity.SysRolePermissionBean;

/**
 * 服务层接口
 * 
 * @author chengrongchang
 * @version 1.0
 * @time 2014-5-27
 * @description 
 */
public interface ISysRoleService {
	public Map<String, Object> queryList(SysRoleQueryBean queryBean);
	public String save(SysRoleBean bean, Integer[] permission_ids);
	public SysRoleBean getById(Integer id);
	public void delete(Integer id);
	public String roleDelete(Integer id);
	public List<SysRoleBean> getUserRole();
	public List<SysRolePermissionBean> getPermissionsByRoleId(Integer id);
	public List<SysRoleBean> searchRole();
}