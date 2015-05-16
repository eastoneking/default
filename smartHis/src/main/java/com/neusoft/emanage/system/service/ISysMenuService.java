/*
 * @(#)IDemoService.java
 * Copyright (c) 2007-2008 goldcow
 * All rights reserved.
 */
package com.neusoft.emanage.system.service;

import java.util.List;

import com.neusoft.emanage.system.vo.SysMenuQueryBean;
import com.neusoft.emanage.util.gen.entity.SysMenuBean;

/**
 * 服务层接口
 * 
 * @author chengrongchang
 * @version 1.0
 * @time 2014-5-27
 * @description 
 */
public interface ISysMenuService {
	public List<SysMenuBean> queryList(SysMenuQueryBean queryBean);
	public String save(SysMenuBean bean);
	public SysMenuBean getById(Integer id);
	public void delete(Integer id);
	public List<SysMenuBean> getUserMenu(Integer user_id);
}