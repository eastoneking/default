/*
 * Copyright (c) 2007-2008 neusoft
 * All rights reserved.
 */
package com.neusoft.emanage.guahao.service;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.guahao.vo.GuaHaoQueryBean;
import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.util.gen.entity.GuaHaoBean;
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
public interface IGuahaoService {
	public  Map<String, Object>  queryList(GuaHaoQueryBean queryBean);
	public String save(GuaHaoBean bean);
	public GuaHaoBean getParameterById(Integer id);
	public void delete(Integer id);
	public List<GuaHaoBean> getByTypeCode(String typeCode);
}
