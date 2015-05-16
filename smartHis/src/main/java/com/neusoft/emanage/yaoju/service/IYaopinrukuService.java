/*
 * Copyright (c) 2007-2008 neusoft
 * All rights reserved.
 */
package com.neusoft.emanage.yaoju.service;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKRKBean;
import com.neusoft.emanage.yaoju.vo.YaopinCKRKQueryBean;

/**
 * 基本增删改查模板
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description 
 */
public interface IYaopinrukuService {
	public Map<String, Object>   queryList(YaopinCKRKQueryBean queryBean);
	public String save(YaopinCKRKBean bean);
	public YaopinCKRKBean getParameterById(Integer id);
	public void delete(Integer id);
	public List<YaopinCKRKBean> getByTypeCode(String typeCode);
}
