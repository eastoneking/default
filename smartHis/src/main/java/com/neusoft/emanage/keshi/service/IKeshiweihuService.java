/*
 * Copyright (c) 2007-2008 goldcow
 * All rights reserved.
 */
package com.neusoft.emanage.keshi.service;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;

/**
 * 基本增删改查模板
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description 
 */
public interface IKeshiweihuService {
	public  Map<String, Object>  queryList(KeshiQueryBean queryBean);
	public String save(KeshiBean bean);
	public KeshiBean getParameterById(Integer id);
	public void delete(Integer id);
	public List<KeshiBean> getByTypeCode(String typeCode);
}
