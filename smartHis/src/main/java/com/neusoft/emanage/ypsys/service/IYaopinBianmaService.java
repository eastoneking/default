/*
 * Copyright (c) 2007-2008 goldcow
 * All rights reserved.
 */
package com.neusoft.emanage.ypsys.service;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.YaopinBianmaBean;
import com.neusoft.emanage.ypsys.vo.YaopinBianmaQueryBean;

/**
 * 基本增删改查模板
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description 
 */
public interface IYaopinBianmaService {
	public   Map<String, Object> queryList(YaopinBianmaQueryBean queryBean);
	public String save(YaopinBianmaBean bean);
	public YaopinBianmaBean getById(Integer id);
	public void delete(Integer id);
}
