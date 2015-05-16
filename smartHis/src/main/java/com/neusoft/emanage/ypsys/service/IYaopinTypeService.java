/*
 * Copyright (c) 2007-2008 goldcow
 * All rights reserved.
 */
package com.neusoft.emanage.ypsys.service;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.YaopinTypeBean;
import com.neusoft.emanage.ypsys.vo.YaopinTypeQueryBean;

/**
 * 基本增删改查模板
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description 
 */
public interface IYaopinTypeService {
	public Map<String, Object> queryList(YaopinTypeQueryBean queryBean);
	public String save(YaopinTypeBean bean);
	public YaopinTypeBean getParameterById(Integer id);
	public void delete(Integer id);
	public List<YaopinTypeBean> getByTypeCode(String typeCode);
}
