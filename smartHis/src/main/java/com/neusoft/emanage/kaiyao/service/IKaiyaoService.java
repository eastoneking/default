/*
 * Copyright (c) 2007-2008 neusoft
 * All rights reserved.
 */
package com.neusoft.emanage.kaiyao.service;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.guahao.vo.GuaHaoQueryBean;
import com.neusoft.emanage.kaiyao.vo.KaiyaoQueryBean;
import com.neusoft.emanage.kaiyao.vo.ZhenduanQueryBean;
import com.neusoft.emanage.keshi.vo.KeshiQueryBean;
import com.neusoft.emanage.util.gen.entity.GuaHaoBean;
import com.neusoft.emanage.util.gen.entity.KaiyaoBean;
import com.neusoft.emanage.util.gen.entity.KeshiBean;
import com.neusoft.emanage.util.gen.entity.SysParameterBean;
import com.neusoft.emanage.util.gen.entity.ZhenduanBean;

/**
 * 基本增删改查模板
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description  Bean
 */
public interface IKaiyaoService {
	public  Map<String, Object>  queryList(KaiyaoQueryBean queryBean);
	public String save(KaiyaoBean bean);
	public KaiyaoBean getParameterById(Integer id);
	public void delete(Integer id);
	public List<KaiyaoBean> getByTypeCode(String typeCode);
	public String getCount(String zdid);
}
