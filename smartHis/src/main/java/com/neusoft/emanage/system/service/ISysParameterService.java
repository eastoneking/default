/*
 * Copyright (c) 2007-2008 goldcow
 * All rights reserved.
 */
package com.neusoft.emanage.system.service;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.system.vo.SysParameterQueryBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;

/**
 * 基本增删改查模板
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description 
 */
public interface ISysParameterService {
	public List<SysParameterBean> queryList(SysParameterQueryBean queryBean);
	public String save(SysParameterBean bean);
	public SysParameterBean getParameterById(Integer id);
	public void delete(Integer id);
	public List<SysParameterBean> getByTypeCode(String typeCode);
}
