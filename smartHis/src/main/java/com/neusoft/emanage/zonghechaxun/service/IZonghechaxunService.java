/*
 * Copyright (c) 2007-2008 goldcow
 * All rights reserved.
 */
package com.neusoft.emanage.zonghechaxun.service;

import java.util.Map;

import com.neusoft.emanage.zonghechaxun.vo.CXKaiyaoQueryBean;

/**
 * 基本增删改查模板
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description 
 */
public interface IZonghechaxunService {
	public Map<String, Object> getYishengKaiyaolist(CXKaiyaoQueryBean queryBean);
}
