/*
 * @(#)IDemoService.java
 * Copyright (c) 2007-2008 goldcow
 * All rights reserved.
 */
package com.neusoft.emanage.system.service;

import java.util.List;

import com.neusoft.emanage.system.vo.SysDeptQueryBean;
import com.neusoft.emanage.util.gen.entity.SysDeptBean;

/**
 * 服务层接口
 * 
 * @author chengrongchang
 * @version 1.0
 * @time 2014-5-27
 * @description 
 */
public interface ISysDeptService {
	public List<SysDeptBean> queryList(SysDeptQueryBean queryBean);
	public String save(SysDeptBean bean);
	public SysDeptBean getById(Integer id);
	public void delete(Integer id);
}