/*
 * @(#)IDemoService.java
 * Copyright (c) 2007-2008 goldcow
 * All rights reserved.
 */
package com.neusoft.emanage.system.service;

import java.util.List;

import com.neusoft.emanage.system.vo.SysPermissionQueryBean;
import com.neusoft.emanage.util.gen.entity.SysPermissionBean;

/**
 * 服务层接口
 * 
 * @author chengrongchang
 * @version 1.0
 * @time 2014-5-27
 * @description 
 */
public interface ISysPermissionService {
	public List<SysPermissionBean> queryList(SysPermissionQueryBean queryBean);
	public String save(SysPermissionBean bean);
	public SysPermissionBean getById(Integer id);
	public void delete(Integer id);
	public List<SysPermissionBean> getUserPermission();
}