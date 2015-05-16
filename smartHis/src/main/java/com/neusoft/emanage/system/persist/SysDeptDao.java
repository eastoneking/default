package com.neusoft.emanage.system.persist;

import java.util.List;
import java.util.Map;

import com.neusoft.emanage.util.gen.entity.SysDeptBean;
import com.neusoft.sframe.util.mybatis.BaseDao;
import com.neusoft.sframe.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface SysDeptDao extends BaseDao<SysDeptBean> {

	List<SysDeptBean> list(Map<String, Object> paramMap);

	int checkSave(SysDeptBean bean);
	
}