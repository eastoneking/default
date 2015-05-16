/*
 * Copyright (c) 2007-2008 goldcow
 * All rights reserved.
 */
package com.neusoft.emanage.commonSelect.service;

import java.util.List;

import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.util.gen.entity.GuaHaoBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.YaopinBianmaBean;
import com.neusoft.emanage.util.gen.entity.YaopinCKBean;
import com.neusoft.emanage.util.gen.entity.YaopinTypeBean;

/**
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description 
 */
public interface ICSelectService {
	public List<YaopinTypeBean> getYaopinTypeByTypeCode(String typeCode);
	public List<YaopinBianmaBean> getYaopinBianMa(String typeCode);
	public List<YaopinCKBean> getYaopinKuCun(String typeCode);
	public List<KeshiBean> getKeshilist(String typeCode);
	public List<GuaHaoBean> getGuaHaolist(String typeCode);
	
	
}
