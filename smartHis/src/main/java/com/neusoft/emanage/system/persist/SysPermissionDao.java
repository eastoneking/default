package com.neusoft.emanage.system.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.SysPermissionBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface SysPermissionDao extends BaseDao<SysPermissionBean> {

	List<SysPermissionBean> list(Map<String, Object> paramMap);

	int checkSave(SysPermissionBean bean);
	
}