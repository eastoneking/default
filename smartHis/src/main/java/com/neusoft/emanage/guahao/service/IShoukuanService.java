/*
 * Copyright (c) 2007-2008 neusoft
 * All rights reserved.
 */
package com.neusoft.emanage.guahao.service;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.guahao.vo.ShoukuanQueryBean;
import com.neusoft.emanage.util.gen.entity.ShoukuanBean;

/**
 * 基本增删改查模板
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description 
 */
public interface IShoukuanService {
	public  Map<String, Object>  queryList(ShoukuanQueryBean queryBean);
	public String save(ShoukuanBean bean);
	public ShoukuanBean getParameterById(Integer id);
	public void delete(Integer id);
	public List<ShoukuanBean> getByTypeCode(String typeCode);
}
