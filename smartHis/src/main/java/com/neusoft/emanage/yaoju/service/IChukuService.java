/*
 * Copyright (c) 2007-2008 neusoft
 * All rights reserved.
 */
package com.neusoft.emanage.yaoju.service;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.util.gen.entity.ChukuBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKRKBean;
import com.neusoft.emanage.yaoju.vo.ChukuQueryBean;
import com.neusoft.emanage.yaoju.vo.LirunQueryBean;
import com.neusoft.emanage.yaoju.vo.YaopinCKQueryBean;
import com.neusoft.emanage.yaoju.vo.YaopinCKRKQueryBean;

/**
 * 基本增删改查模板
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description 
 */
public interface IChukuService {
	public  Map<String, Object> queryList(ChukuQueryBean queryBean);
	public String save(ChukuBean bean);
	public ChukuBean getParameterById(Integer id);
	public void delete(Integer id);
	public List<ChukuBean> getByTypeCode(String typeCode);
	public Map<String, Object> listinfo(ChukuQueryBean queryBean);
	public Map<String, Object> queryLrlist(LirunQueryBean queryBean);
	public Map<String, Object> queryLrinfolist(ChukuQueryBean queryBean);
}
